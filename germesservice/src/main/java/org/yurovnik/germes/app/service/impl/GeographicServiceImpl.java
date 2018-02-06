package org.yurovnik.germes.app.service.impl;



import org.yurovnik.germes.app.infra.util.CommonUtil;
import org.yurovnik.germes.app.model.entity.geography.City;
import org.yurovnik.germes.app.service.GeographicService;

import java.util.ArrayList;
import java.util.List;

/**
 * Default implementation of the {@link GeographicService}
 * @author YurovnikMV
 */

public class GeographicServiceImpl implements GeographicService {
    /**
     * Internal list of cities
     */
    private final List<City> cities;

    public GeographicServiceImpl() {
        cities = new ArrayList<City>();
    }

    @Override
    public List<City> findCities() {
        return CommonUtil.getSafeList(cities);
    }

    @Override
    public void saveCity(City city) {
        if (!cities.contains(city)){
            cities.add(city);
        }
    }
}
