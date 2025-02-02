package de.pb.bv.rest.mapper;

import de.pb.bv.data.entity.brickset.BrickSetEntity;
import de.pb.bv.rest.contracts.ApiBrickSet;

public class BrickSetMapper {
    public static ApiBrickSet createContractFromDb(BrickSetEntity entity) {
        var contract = new ApiBrickSet();
        contract.setInternalId(entity.getId().getId());
        contract.setName(entity.getName());
        return contract;
    }

    public static void updateEntityFromContract(ApiBrickSet contract, BrickSetEntity entity) {
        entity.setName(contract.getName());
    }
}
