package com.renault.services;

import com.renault.entities.Country;
import com.renault.entities.Region;

import java.util.Optional;

public interface RegionService {

    Optional<Region> getRegion(int id);

    void saveCountryRegion(Country country, Region region);

    void saveCountryRegionWithTransaction(Country country, Region region);

}
