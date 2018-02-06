package org.yurovnik.germes.app.service;

import org.yurovnik.germes.app.model.entity.geography.City;

import java.util.List;

/**
 * entry point to perform operations
 * with geographic entities
 * @author YurovnikMV
 */

public interface GeographicService {
    /**
     * Return list of existing cities
     * @return
     */
    List<City> findCities();

    /**
     * save specify city instance
     * @param city
     */
    void saveCity(City city);
}
