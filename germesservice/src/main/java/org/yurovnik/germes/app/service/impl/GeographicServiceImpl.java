package org.yurovnik.germes.app.service.impl;



import org.apache.commons.lang3.StringUtils;
import org.yurovnik.germes.app.infra.util.CommonUtil;
import org.yurovnik.germes.app.model.entity.geography.City;
import org.yurovnik.germes.app.model.entity.geography.Station;
import org.yurovnik.germes.app.model.search.criteria.StationCriteria;
import org.yurovnik.germes.app.model.search.criteria.range.RangeCriteria;
import org.yurovnik.germes.app.service.GeographicService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Override
    public Optional<City> findCityById(int id) {
        return cities.stream().filter(city -> city.getId() == id).findFirst();
    }

    @Override
    public List<Station> searchStations(final StationCriteria criteria, final RangeCriteria rangeCriteria) {
        Stream<City> stream = cities.stream().filter(
                city -> StringUtils.isEmpty(criteria.getName()) || city.getName().equals(criteria.getName()));

        Optional<Set<Station>> stations = stream.map(city -> city.getStations()).reduce((stations1, stations2) -> {
           Set<Station> newStations = new HashSet<>(stations2);
           newStations.addAll(stations1);
           return newStations;
        });

        if (!stations.isPresent()) {
            return Collections.emptyList();
        }
        return stations.get()
                        .stream()
                        .filter(station -> criteria.getTransportType() == null
                            || station.getTransportType() == criteria.getTransportType()).collect(Collectors.toList());
    }
}
