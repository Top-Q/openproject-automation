package openproject;

import com.jayway.jsonpath.JsonPath;
import lombok.SneakyThrows;
import lombok.val;
import org.testng.annotations.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;


public class TestWorkPackages extends AbstractTest {

         @Test
         @SneakyThrows
         public void testGetWorkPackages() {
             val response = openProjectApi.workPackages.workPackages().execute();
             assertThat(response.code()).isEqualTo(200);
             final int totalWorkPackages = JsonPath.read(response.body(), "$.total");
             System.out.println("Total work packages: " + totalWorkPackages);
             assertThat(totalWorkPackages).isGreaterThan(100);
         }
}
