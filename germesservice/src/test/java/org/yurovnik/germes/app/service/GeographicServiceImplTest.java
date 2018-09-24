package org.yurovnik.germes.app.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.yurovnik.germes.app.model.entity.geography.City;
import org.yurovnik.germes.app.service.impl.GeographicServiceImpl;

import java.util.List;
import java.util.Optional;

/**
 * Contain unit-tests for {@link GeographicServiceImpl}
 * @author YurovnikMV
 */

public class GeographicServiceImplTest {
    private static final int DEFAULT_ID = 1;

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

    @Test
    public void testFindCityByIdSuccess(){
        City city = new City("Moscow");
        service.saveCity(city);

        Optional<City> foundCity = service.findCityById(DEFAULT_ID);
        Assert.assertTrue(foundCity.isPresent());
        Assert.assertEquals(foundCity.get().getId(), DEFAULT_ID);
    }
}
