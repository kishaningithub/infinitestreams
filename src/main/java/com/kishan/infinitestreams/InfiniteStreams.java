package com.kishan.infinitestreams;

import com.kishan.infinitestreams.health.InfiniteStreamsHealthCheck;
import com.kishan.infinitestreams.resource.EvenNosResource;
import com.kishan.infinitestreams.resource.ExampleResource;
import com.kishan.infinitestreams.resource.FibonacciResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class InfiniteStreams extends Application<InfiniteStreamsConfiguration> {
    public static void main(String[] args) throws Exception {
        new InfiniteStreams().run(args);
    }

    @Override
    public void run(InfiniteStreamsConfiguration configuration, Environment environment) throws Exception {
        registerResources(environment);
        registerHealthChecks(environment);
    }

    private void registerResources(Environment environment) {
        environment.jersey().register(EvenNosResource.class);
        environment.jersey().register(ExampleResource.class);
        environment.jersey().register(FibonacciResource.class);

    }

    private void registerHealthChecks(Environment environment) {
        environment.healthChecks().register("inifinitestreams", new InfiniteStreamsHealthCheck());
    }
}
