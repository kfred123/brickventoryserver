package de.pb.bv.data;

import de.pb.bv.contracts.BrickSetContract;
import de.pb.bv.data.entity.brickset.BrickSetEntityId;
import de.pb.bv.data.entity.bricksetdatasource.BrickSetDataSourceEntity;
import de.pb.bv.data.entity.brickset.BrickSetEntity;
import de.pb.bv.data.entity.bricksetdatasource.BrickSetDataSourceEntityId;
import de.pb.bv.data.entity.bricksetdatasource.BrickSetDataSourceRepository;
import de.pb.bv.data.entity.brickset.BrickSetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BrickSetWriter {
    private static final Logger logger = LoggerFactory.getLogger(BrickSetWriter.class);
    @Autowired
    private BrickSetRepository brickRepository;
    @Autowired
    private BrickSetDataSourceRepository brickSetDataSourceRepository;

    public void insertOrUpdate(BrickSetContract brickSet) {
        // Todo: create a brickset for the datasource and link it, otherwise update it
        var existingDataSource = brickSetDataSourceRepository.findDistinctByExternalId(brickSet.getDataSource(), brickSet.getExternalId());
        if(existingDataSource.isEmpty()) {
            var matchingDataSources = brickSetDataSourceRepository.findByExternalId(brickSet.getExternalId());
            if(matchingDataSources.isEmpty()) {
                var newBrickSetDataSource = new BrickSetDataSourceEntity();
                newBrickSetDataSource.setExternalId(brickSet.getExternalId());
                newBrickSetDataSource.setDataSource(brickSet.getDataSource());
                newBrickSetDataSource.setBrickSet(new BrickSetEntityId(UUID.randomUUID()));
                newBrickSetDataSource.setId(new BrickSetDataSourceEntityId(UUID.randomUUID()));
                brickSetDataSourceRepository.save(newBrickSetDataSource);
                insertOrUpdateForDataSource(brickSet, newBrickSetDataSource.getBrickSet());
            } else {
                if(matchingDataSources.size() > 1) {
                    logger.error("Multiple data sources found for external id, needs to be solved somehow somwewhen {}", brickSet.getExternalId());
                }
                insertOrUpdateForDataSource(brickSet, matchingDataSources.getFirst().getBrickSet());
                }
        } else {
            insertOrUpdateForDataSource(brickSet, existingDataSource.get().getBrickSet());
        }
    }

    private void insertBrickSet(BrickSetContract brickSetContract, BrickSetEntityId id) {
        var brickSet = new BrickSetEntity();
        brickSet.setId(id);
        updateBrickSet(brickSetContract, brickSet);
    }

    private void insertOrUpdateForDataSource(BrickSetContract brickSetContract, BrickSetEntityId id) {
        var brickSet = brickRepository.findById(id);
        if(brickSet.isEmpty()) {
            insertBrickSet(brickSetContract, id);
        } else {
            updateBrickSet(brickSetContract, brickSet.get());
        }
    }

    private void updateBrickSet(BrickSetContract brickSetContract, BrickSetEntity brickSet) {
        brickSet.setName(brickSetContract.getName());
        brickRepository.save(brickSet);
    }
}
