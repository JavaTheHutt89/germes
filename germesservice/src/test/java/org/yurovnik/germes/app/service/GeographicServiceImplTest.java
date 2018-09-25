package org.yurovnik.germes.app.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.yurovnik.germes.app.model.entity.geography.City;
import org.yurovnik.germes.app.model.entity.geography.Station;
import org.yurovnik.germes.app.model.entity.transport.TransportType;
import org.yurovnik.germes.app.model.search.criteria.StationCriteria;
import org.yurovnik.germes.app.model.search.criteria.range.RangeCriteria;
import org.yurovnik.germes.app.service.impl.GeographicServiceImpl;

import java.util.List;
import java.util.Optional;

/**
 * Contain unit-tests for {@link GeographicServiceImpl}
 * @author YurovnikMV
 */

public class GeographicServiceImplTest {
    private static final int DEFAULT_ID = 0;

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

    @Test
    public void testFindCityByIdNotFound(){
        Optional<City> foundCity = service.findCityById(DEFAULT_ID);
        Assert.assertFalse(foundCity.isPresent());
    }

    @Test
    public void testSearchStationsByNameSuccess(){
        City city = new City("Moscow");
        city.setId(DEFAULT_ID);
        city.addStation(TransportType.AUTO);
        city.addStation(TransportType.RAILWAY);
        service.saveCity(city);

        List<Station> stations = service.searchStations(StationCriteria.byName("Moscow"), new RangeCriteria(1,5));
        Assert.assertNotNull(stations);
        Assert.assertEquals(stations.size(),2);
        Assert.assertEquals(stations.get(0).getCity(), city);
    }

    @Test
    public void testSearchStationsByNameNotFound(){
        List<Station> stations = service.searchStations(StationCriteria.byName("Moscow"), new RangeCriteria(1,5));
        Assert.assertNotNull(stations);
        Assert.assertTrue(stations.isEmpty());

    }

    @Test
    public void testSearchStationsByTypeSuccess(){
        City city = new City("Moscow");
        city.addStation(TransportType.AUTO);
        service.saveCity(city);
        City city2 = new City("Vladivostok");
        city2.setId(2);
        city2.addStation(TransportType.RAILWAY);
        service.saveCity(city2);

        List<Station> stations = service.searchStations(new StationCriteria(TransportType.AUTO), new RangeCriteria(1, 5));
        Assert.assertNotNull(stations);
        Assert.assertEquals(stations.size(), 1);
    }
}
