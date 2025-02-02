package de.pb.bv.data.entity.brickset;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class BrickSetEntity {
    @Id
    private UUID id;
    private String name;

    public void setId(BrickSetEntityId id) {
        this.id = id.getId();
    }

    public BrickSetEntityId getId() {
        return new BrickSetEntityId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
