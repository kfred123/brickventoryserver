package de.pb.bv.rest;

import de.pb.bv.data.entity.brickset.BrickSetEntity;
import de.pb.bv.data.entity.brickset.BrickSetRepository;
import de.pb.bv.rest.contracts.ApiBrickSet;
import de.pb.bv.rest.mapper.BrickSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("brickset")
public class BrickSetController {
    @Autowired
    private BrickSetRepository brickSetRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ApiBrickSet>> query() {
        var all = brickSetRepository.findAll();
        var result = new LinkedList<ApiBrickSet>();
        for(var entity : all) {
            result.add(BrickSetMapper.createContractFromDb(entity));
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiBrickSet> create(@RequestBody final ApiBrickSet apiBrickSet) {
        BrickSetEntity brickSetEntity = new BrickSetEntity();
        BrickSetMapper.updateEntityFromContract(apiBrickSet, brickSetEntity);
        brickSetRepository.save(brickSetEntity);
        return ResponseEntity.ok(BrickSetMapper.createContractFromDb(brickSetEntity));
    }
}
