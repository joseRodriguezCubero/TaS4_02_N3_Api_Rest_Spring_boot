package cat.itacademy.barcelonactiva.rodriguez.jose.s04.t02.n03.controllers;

import cat.itacademy.barcelonactiva.rodriguez.jose.s04.t02.n03.model.entity.Fruit;
import cat.itacademy.barcelonactiva.rodriguez.jose.s04.t02.n03.model.services.FruitServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class FruitController {

    private final FruitServices fruitServices;


    @GetMapping(path = "/fruita/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        return ResponseEntity.ok().body(fruitServices.getAllFruits());
    }


    @GetMapping(path = "/fruita/getOne/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable String id) {
        return ResponseEntity.ok().body(fruitServices.getFruitById(id));
    }


    @GetMapping(path = "/fruita/getOne/{name}")
    public ResponseEntity<List<Fruit>> getFruitsByNameContaining(@PathVariable String name) {
        return ResponseEntity.ok().body(fruitServices.getFruitContaining(name));
    }


    @PostMapping(path = "/fruita/add",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Fruit> saveFruit(@RequestBody Fruit fruitDto){
        Fruit newFruit = fruitServices.createFruit(fruitDto);
        return new ResponseEntity<>(newFruit, HttpStatus.CREATED);
    }


    @PutMapping(path = "/fruita/update{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable(value = "id") String id,
                                             @RequestBody Fruit fruitDto) {
        return ResponseEntity.ok().body(fruitServices.updateFruit(id,fruitDto));
    }


    @DeleteMapping(value = "/fruita/delete/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable String id) {
        fruitServices.deleteFruitById(id);
        return new ResponseEntity<>(("Fruit deleted successfully- Fruit ID:" + id), HttpStatus.OK);
    }
}