package de.pb.bv.data.entity.bricksetdatasource;

import de.pb.bv.common.DataSource;
import de.pb.bv.common.DbEnum;
import de.pb.bv.data.entity.brickset.BrickSetEntityId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class BrickSetDataSourceEntity {
    @Id
    private UUID id;
    private String externalId;
    private int dataSource;
    private UUID brickSet;

    public void setId(BrickSetDataSourceEntityId id) {
        this.id = id.getId();
    }

    public BrickSetDataSourceEntityId getId() {
        return new BrickSetDataSourceEntityId(id);
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource.getDbKey();
    }

    public DataSource getDataSource() {
        return DbEnum.fromDbKey(DataSource.class, dataSource);
    }

    public void setBrickSet(BrickSetEntityId brickSet) {
        this.brickSet = brickSet.getId();
    }

    public BrickSetEntityId getBrickSet() {
        return new BrickSetEntityId(brickSet);
    }
}
