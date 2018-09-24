package org.yurovnik.germes.app.service;

import org.yurovnik.germes.app.model.entity.geography.City;
import org.yurovnik.germes.app.model.entity.geography.Station;
import org.yurovnik.germes.app.model.search.criteria.StationCriteria;
import org.yurovnik.germes.app.model.search.criteria.range.RangeCriteria;

import java.util.List;
import java.util.Optional;

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

    Optional<City> findCityById(int id);

    List<Station> searchStations(StationCriteria criteria, RangeCriteria rangeCriteria);
}
