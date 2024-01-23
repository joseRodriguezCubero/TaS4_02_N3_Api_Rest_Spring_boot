package cat.itacademy.barcelonactiva.rodriguez.jose.s04.t02.n03.controllers;

import cat.itacademy.barcelonactiva.rodriguez.jose.s04.t02.n03.model.repository.IFruitRepository;
import cat.itacademy.barcelonactiva.rodriguez.jose.s04.t02.n03.model.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:8083")
@RestController
@RequestMapping("/api/v1")
public class FruitController {

    @Autowired
    IFruitRepository iFruitRepository;

    @GetMapping("/fruita/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits(@RequestParam(required = false) String title) {
        try {
            List<Fruit> fruits = new ArrayList<>();

            if (title == null)
                iFruitRepository.findAll().forEach(fruits::add);
            else
                iFruitRepository.findByNameContaining(title).forEach(fruits::add);

            if (fruits.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(fruits, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fruita/getOne/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable("id") String id) {
        Optional<Fruit> fruitData = iFruitRepository.findById(id);

        if (fruitData.isPresent()) {
            return new ResponseEntity<>(fruitData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tutorials")
    public ResponseEntity<Fruit> createFruit(@RequestBody Fruit fruit) {
        try {
            Fruit _fruit = iFruitRepository.save(new Fruit(fruit.getName(), fruit.getTree(), false));
            return new ResponseEntity<>(_fruit, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/fruites/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable("id") String id, @RequestBody Fruit fruit) {
        Optional<Fruit> fruitData = iFruitRepository.findById(id);

        if (fruitData.isPresent()) {
            Fruit _fruit = fruitData.get();
            _fruit.setName(fruit.getName());
            _fruit.setTree(fruit.getTree());
            _fruit.setEatable(fruit.isEatable());
            return new ResponseEntity<>(iFruitRepository.save(_fruit), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteFruit(@PathVariable("id") String id) {
        try {
            iFruitRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllFruits() {
        try {
            iFruitRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fruit/eatable")
    public ResponseEntity<List<Fruit>> findByPublished() {
        try {
            List<Fruit> tutorials = iFruitRepository.findByEatable(true);

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
