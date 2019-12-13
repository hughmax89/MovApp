package com.hgs.data.repository;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class DBRepository {
    private ModelMapper mapper;

    public ModelMapper getMapper() {
        mapper = new ModelMapper();
        //mapper.createTypeMap(StoreEntity.class, Store.class);
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE)
                .setFieldMatchingEnabled(true)  // Enables field matching
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        return mapper;
    }
}
