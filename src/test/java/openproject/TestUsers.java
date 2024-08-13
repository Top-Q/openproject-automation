package openproject;

import com.jayway.jsonpath.JsonPath;
import lombok.SneakyThrows;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.payloadRepo.PayloadRepository.getPayloadAsJsonObject;
import static org.report.Steps.*;

public class TestUsers extends AbstractTest {

    @Test
    @SneakyThrows
    public void testListUsers() {
        int count = when("we list the number of users in the system", () -> {
            var response = openProjectApi.users.listUsers().execute();
            assertThat(response.code()).isEqualTo(200);
            return JsonPath.read(response.body(), "$.count");
        });
        then("the number of users is greater than 0", () -> {
            assertThat(count).isGreaterThan(0);
        });
    }


    @Test
    @SneakyThrows
    public void testAddUser() {
        int initialUsersCount = given("we know the number of users in the system ", () -> {
            var response = openProjectApi.users.listUsers().execute();
            return JsonPath.read(response.body(), "$.count");
        });
        when("a new user is added", () -> {
            var newUser = getPayloadAsJsonObject("userRequest");
            final String login = "user" + System.currentTimeMillis();
            newUser.put("login", login);
            newUser.put("firstName", "Itai");
            newUser.put("lastName", "Smith");
            newUser.put("email", login + "@gmail.com");
            var response = openProjectApi.users.createUser(newUser.toString()).execute();
            assertThat(response.code()).isEqualTo(201);
            assertThat(response.message()).isEqualTo("Created");
        });
        then("then number of users is incremented by one", () -> {
            var response = openProjectApi.users.listUsers().execute();
            final int usersCount = JsonPath.read(response.body(), "$.count");
            assertThat(usersCount).isEqualTo(initialUsersCount + 1);
        });


    }


}
