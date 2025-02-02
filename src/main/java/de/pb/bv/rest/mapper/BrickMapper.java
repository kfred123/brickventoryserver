package de.pb.bv.rest.mapper;

import de.pb.bv.data.entity.brick.BrickEntity;
import de.pb.bv.rest.contracts.ApiBrickContract;

public class BrickMapper {
    public static ApiBrickContract createContractFromDb(BrickEntity entity) {
        var contract = new ApiBrickContract();
        contract.setInternalId(entity.getId());
        return contract;
    }

    public static void updateEntityFromContract(ApiBrickContract contract, BrickEntity entity) {
       // entity.setName(contract.getName());
    }
}
