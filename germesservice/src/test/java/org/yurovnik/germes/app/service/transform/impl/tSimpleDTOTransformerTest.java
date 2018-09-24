package org.yurovnik.germes.app.service.transform.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.yurovnik.germes.app.infra.exception.flow.InvalidParameterException;
import org.yurovnik.germes.app.model.entity.geography.City;
import org.yurovnik.germes.app.rest.dto.CityDTO;
import org.yurovnik.germes.app.rest.service.transform.Transformer;
import org.yurovnik.germes.app.rest.service.transform.impl.SimpleDTOTransformer;

public class tSimpleDTOTransformerTest {
    private Transformer transformer;

    @Before
    public void setup(){
        transformer = new SimpleDTOTransformer();
    }

    @Test
    public void testTransformCitySuccess(){
        City city = new City("Moscow");
        city.setId(1);
        city.setRegion("Mo");
        city.setDistrict("None");

        CityDTO dto = transformer.transform(city, CityDTO.class);
        Assert.assertNotNull(dto);
        Assert.assertEquals(dto.getId(), city.getId());
        Assert.assertEquals(dto.getName(), city.getName());
        Assert.assertEquals(dto.getDistrict(), city.getDistrict());
        Assert.assertEquals(dto.getRegion(), city.getRegion());
    }

    @Test(expected = InvalidParameterException.class)
    public void testTransformNullCityFailure(){
       transformer.transform(null, CityDTO.class);
    }

    @Test(expected= InvalidParameterException.class)
    public void testTransformNullDTOClassFailure() {
        transformer.transform(new City("Moscow"), null);
    }

    @Test
    public void testUnTransformCitySuccess(){
        CityDTO dto = new CityDTO();
        dto.setId(1);
        dto.setRegion("Mo");
        dto.setDistrict("None");
        dto.setName("Moscow");

        City city = transformer.unTransform(dto, City.class);
        Assert.assertNotNull(city);
        Assert.assertEquals(dto.getId(), city.getId());
        Assert.assertEquals(dto.getName(), city.getName());
        Assert.assertEquals(dto.getDistrict(), city.getDistrict());
        Assert.assertEquals(dto.getRegion(), city.getRegion());
    }

    @Test(expected = InvalidParameterException.class)
    public void testUnTransformNullCityFailure(){
        transformer.unTransform(null, City.class);
    }

    @Test(expected=InvalidParameterException.class)
    public void testUnTransformNullEntityClassFailure() {
        transformer.unTransform(new CityDTO(), null);
    }
}
