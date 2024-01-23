package cat.itacademy.barcelonactiva.rodriguez.jose.s04.t02.n03.model.repository;

import cat.itacademy.barcelonactiva.rodriguez.jose.s04.t02.n03.model.entity.Fruit;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FruitRepository extends MongoRepository<Fruit, Long> {

        List<Fruit> findByEatable(boolean eatable);

        List<Fruit> findAllByOrderById();


        Optional<Fruit> findByNameIgnoreCase (String name);

        List<Fruit> findByNameContainingIgnoreCaseOrderById(String name);
    }