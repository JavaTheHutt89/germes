package org.yurovnik.germes.app.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.yurovnik.germes.app.model.entity.geography.City;
import org.yurovnik.germes.app.service.impl.GeographicServiceImpl;

import java.util.List;

/**
 * Contain unit-tests for {@link GeographicServiceImpl}
 * @author YurovnikMV
 */

public class GeographicServiceImplTest {
    private GeographicService service;

    @Before
    public void setup(){
        service = new GeographicServiceImpl();
    }

    @Test
    public void testNoDataReturnedAtStart(){
        List<City> cities = service.findCities();
        Assert.assertTrue(cities.isEmpty());
    }

    @Test
    public void testSaveNewCitySuccess(){
        City city = new City("Odessa");
        service.saveCity(city);

        List<City> cities = service.findCities();
        Assert.assertEquals(cities.size(),1);
        Assert.assertEquals(cities.get(0).getName(),"Odessa");
    }
}
