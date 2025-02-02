package de.pb.bv.data.entity.brickset;

import de.pb.bv.common.DataSource;
import de.pb.bv.data.entity.bricksetdatasource.BrickSetDataSourceEntity;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BrickSetRepository extends CrudRepository<BrickSetEntity, UUID> {
    @Override
    @Query("SELECT b FROM BrickSetEntity b WHERE b.id = ?1")
    Optional<BrickSetEntity> findById(UUID id);

    default Optional<BrickSetEntity> findById(BrickSetEntityId id) {
        return findById(id.getId());
    }
}
