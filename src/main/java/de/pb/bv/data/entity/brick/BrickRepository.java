package de.pb.bv.data.entity.brick;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BrickRepository extends CrudRepository<BrickEntity, UUID> {
}
