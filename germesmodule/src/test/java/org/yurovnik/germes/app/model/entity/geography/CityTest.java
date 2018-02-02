package org.yurovnik.germes.app.model.entity.geography;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.yurovnik.germes.app.model.entity.transport.TransportType;

/**
 * Contains unit-tests to check functionality of {@link City} class
 * @author YurovnikMV
 *
 */

public class CityTest {
    private City city;

    @Before
    public void setup(){
        city = new City("Odessa");
    }

    @Test
    public void testAddValidStationSuccess(){
        Station station = city.addStation(TransportType.RAILWAY);
        Assert.assertTrue(containsStation(city,station));
        Assert.assertEquals(city, station.getCity());
    }

    @Test(expected=NullPointerException.class)
    public void testAddNullStationFailure(){
        city.addStation(null);

        Assert.assertTrue(false);
    }

    @Test
    public void testAddDuplicateStationFailure(){
        city.addStation(TransportType.RAILWAY);
        city.addStation(TransportType.RAILWAY);

        Assert.assertEquals(city.getStations().size(),1);
    }

    @Test
    public void testRemoveStationSuccess(){
        Station station = city.addStation(TransportType.RAILWAY);
        city.removeStation(station);

        Assert.assertTrue(city.getStations().isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNullStationFailure(){
        city.removeStation(null);

        Assert.assertTrue(false);
    }

    private boolean containsStation(City city, Station station){
        return city.getStations().contains(station);
    }
}
