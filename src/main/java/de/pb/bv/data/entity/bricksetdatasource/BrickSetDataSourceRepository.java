package de.pb.bv.data.entity.bricksetdatasource;

import de.pb.bv.common.DataSource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BrickSetDataSourceRepository extends CrudRepository<BrickSetDataSourceEntity, UUID> {

    @Query("SELECT b FROM BrickSetDataSourceEntity b WHERE b.dataSource = ?1 AND b.externalId = ?2")
    List<BrickSetDataSourceEntity> findByExternalIdAndDataSource(int dataSource, String externalId, Pageable pageable);

    default Optional<BrickSetDataSourceEntity> findDistinctByExternalId(DataSource dataSource, String externalId) {
        return findByExternalIdAndDataSource(dataSource.getDbKey(), externalId, Pageable.ofSize(1)).stream().findFirst();
    }

    @Query("SELECT b FROM BrickSetDataSourceEntity b WHERE b.externalId = ?1")
    List<BrickSetDataSourceEntity> findByExternalId(String externalId);
}
