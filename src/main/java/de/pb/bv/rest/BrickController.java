package de.pb.bv.rest;

import de.pb.bv.data.entity.brick.BrickEntity;
import de.pb.bv.data.entity.brick.BrickRepository;
import de.pb.bv.rest.contracts.ApiBrickContract;
import de.pb.bv.rest.mapper.BrickMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("brick")
public class BrickController {
    @Autowired
    private BrickRepository brickRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ApiBrickContract>> query() {
        var all = brickRepository.findAll();
        var result = new LinkedList<ApiBrickContract>();
        for(var entity : all) {
            result.add(BrickMapper.createContractFromDb(entity));
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiBrickContract> create(@RequestBody final ApiBrickContract apiBrickContract) {
        BrickEntity brickEntity = new BrickEntity();
        BrickMapper.updateEntityFromContract(apiBrickContract, brickEntity);
        brickRepository.save(brickEntity);
        return ResponseEntity.ok(BrickMapper.createContractFromDb(brickEntity));
    }
}
