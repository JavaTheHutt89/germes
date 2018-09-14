package org.yurovnik.germes.app.rest.service;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;
import org.yurovnik.germes.app.rest.service.config.JerseyConfig;

import javax.ws.rs.core.Application;
import java.util.List;

public class CityResourceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new JerseyConfig();
    }

    @Test
    public void testFindCitiesSuccess(){
        List<?> cities = target("cities").request().get(List.class);
        Assert.assertNotNull(cities);
        Assert.assertTrue(cities.contains("Vladivostok"));
        Assert.assertTrue(cities.contains("Moscow"));
    }
}
