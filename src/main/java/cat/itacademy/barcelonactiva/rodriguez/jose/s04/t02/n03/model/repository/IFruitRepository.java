package cat.itacademy.barcelonactiva.rodriguez.jose.s04.t02.n03.model.repository;

import cat.itacademy.barcelonactiva.rodriguez.jose.s04.t02.n03.model.Fruit;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IFruitRepository extends MongoRepository<Fruit, String> {
    List<Fruit> findByNameContaining(String name);
    List<Fruit> findByEatable(boolean published);
}