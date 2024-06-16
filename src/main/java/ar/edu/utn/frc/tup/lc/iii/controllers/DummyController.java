package ar.edu.utn.frc.tup.lc.iii.controllers;

import ar.edu.utn.frc.tup.lc.iii.dtos.DummyDto;
import ar.edu.utn.frc.tup.lc.iii.models.Dummy;
import ar.edu.utn.frc.tup.lc.iii.services.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dummy")
public class DummyController {

    @Autowired
    private DummyService service;

    @GetMapping("")
    public ResponseEntity<DummyDto> getDummyList() {
        List<Dummy> dummies = service.getDummies();
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DummyDto> getDummyById(@PathVariable Long id) {
        Dummy dummy = service.getDummy(id);
        return null;
    }

    @PostMapping("")
    public ResponseEntity<DummyDto> postDummy() {
        Dummy dummy = service.createDummy(null);
        return null;
    }

    @PutMapping("")
    public ResponseEntity<DummyDto> putDummy() {
        Dummy dummy = service.updateDummy(null);
        return null;
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteDummy(DummyDto dummyDto) {
        service.deleteDummy(dummyDto);
        return null;
    }

}
