package openproject;

import lombok.SneakyThrows;

import lombok.val;
import org.testng.annotations.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;

public class TestProjectsApi extends AbstractTest{

    @Test
    @SneakyThrows
    public void testGetProjectById() {
        val response = openProjectApi.projects.projects("my-new-project").execute();
        System.out.println(response.body());
        assertThat(response.code()).isEqualTo(200);
        assertThatJson(response.body()).node("identifier").isEqualTo("my-new-project");

    }

    @Test
    @SneakyThrows
    public void testGetProjects() {
        val response = openProjectApi.projects.projects().execute();
        assertThatJson(response.body()).node("count").isEqualTo(4);
        assertThat(response.code()).isEqualTo(200);
        System.out.println(response.body());
    }

}
