package de.pb.bv.data.entity;

import de.pb.bv.data.entity.brickset.BrickSetEntityId;

import java.util.Objects;
import java.util.UUID;

public class EntityId {
    private final UUID id;

    public EntityId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityId that = (BrickSetEntityId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
