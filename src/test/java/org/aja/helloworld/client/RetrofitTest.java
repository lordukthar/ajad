package org.aja.helloworld.client;

import com.example.helloworld.HelloWorldApplication;
import com.example.helloworld.HelloWorldConfiguration;
import com.example.helloworld.api.Demo;
import com.example.helloworld.client.DemoResourceService;
import io.dropwizard.testing.ConfigOverride;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.File;
import java.io.IOException;

public class RetrofitTest {

    private static final String TMP_FILE = createTempFile();
    private static final String CONFIG_PATH = ResourceHelpers.resourceFilePath("test-example.yml");

    @ClassRule
    public static final DropwizardAppRule<HelloWorldConfiguration> RULE = new DropwizardAppRule<>(
            HelloWorldApplication.class, CONFIG_PATH,
            ConfigOverride.config("database.url", "jdbc:h2:" + TMP_FILE));

    @BeforeClass
    public static void migrateDb() throws Exception {
        RULE.getApplication().run("db", "migrate", CONFIG_PATH);
    }

    private static String createTempFile() {
        try {
            return File.createTempFile("test-example", null).getAbsolutePath();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static final String URI_BOOK = "http://localhost:8080";

    @Test
    public void testHelloWorld() throws Exception {

            //Create retrofit, set the API base URL and GSonConverterFactory
            Retrofit retrofit = new Retrofit.Builder().baseUrl(URI_BOOK)
                    .addConverterFactory(GsonConverterFactory.create()).build();
            //Create service
            DemoResourceService bookResource =
                    retrofit.create(DemoResourceService.class);
            Call<Demo> demo = bookResource.getDemoFuture();
        System.out.println(demo.execute().body());



    }

}
