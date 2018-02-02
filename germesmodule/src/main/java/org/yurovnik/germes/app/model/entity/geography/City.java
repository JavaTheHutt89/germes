package org.yurovnik.germes.app.model.entity.geography;

import org.yurovnik.germes.app.infra.util.CommonUtil;
import org.yurovnik.germes.app.model.entity.base.AbstractEntity;
import org.yurovnik.germes.app.model.entity.transport.TransportType;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Any locality that contains transport stations
 * @author YurovnikMV
 *
 */

public class City extends AbstractEntity {
    private String name;

    /**
     * name district where city place
     */
    private String district;

    /**
     * name of region where district is located
     * Region is a top-level area in the country
     */
    private String region;

    private Set<Station> stations;

    public City(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Set<Station> getStations() {
        return CommonUtil.getSafeSet(stations);
    }

    public void setStations(Set<Station> stations) {
        this.stations = stations;
    }

    /**
     * Add specify station to the city station list
     */

    public Station addStation(final TransportType transportType){
        if (stations == null){
            stations = new HashSet<>();
        }
        Station station = new Station(this,transportType);
        stations.add(station);

        return station;
    }

    /**
     * Remove specify station from city station list
     * @param station
     */

    public void removeStation(Station station){
        Objects.requireNonNull(station,"station parameter is not initialized");
        if (stations == null){
            return;
        }
        stations.remove(station);
    }
}
