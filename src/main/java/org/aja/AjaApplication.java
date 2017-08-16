package org.aja;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class AjaApplication extends Application<AjaConfiguration> {

    public static void main(final String[] args) throws Exception {
        new AjaApplication().run(args);
    }

    @Override
    public String getName() {
        return "aja";
    }

    @Override
    public void initialize(final Bootstrap<AjaConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final AjaConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
