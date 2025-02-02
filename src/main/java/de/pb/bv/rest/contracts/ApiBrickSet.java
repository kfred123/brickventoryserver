package de.pb.bv.rest.contracts;

import java.util.UUID;

public class ApiBrickSet {
    private UUID internalId;
    private String name;

    public UUID getInternalId() {
        return internalId;
    }

    public void setInternalId(UUID internalId) {
        this.internalId = internalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
