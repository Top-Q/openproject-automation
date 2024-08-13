package openproject;

import lombok.SneakyThrows;
import org.config.AutoConfig;
import org.openproject.OpenProjectApi;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTest {

    protected OpenProjectApi openProjectApi;
    protected AutoConfig cfg = org.aeonbits.owner.ConfigFactory.create(AutoConfig.class);

    @BeforeMethod
    @SneakyThrows
    public void setup() {
        openProjectApi = new OpenProjectApi(cfg.baseUrl(), cfg.apiKey());
    }

}
