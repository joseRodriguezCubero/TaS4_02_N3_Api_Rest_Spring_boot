package cat.itacademy.barcelonactiva.rodriguez.jose.s04.t02.n03.model.services;

import cat.itacademy.barcelonactiva.rodriguez.jose.s04.t02.n03.model.entity.Fruit;
import cat.itacademy.barcelonactiva.rodriguez.jose.s04.t02.n03.model.exceptions.FruitNotFoundException;

import java.util.List;

public interface FruitServices {
    List<Fruit> getAllFruits();

    Fruit getFruitById(String id);

    List<Fruit> getFruitContaining(String name);

    Fruit createFruit(Fruit fruitDto);

    Fruit updateFruit(String id, Fruit updatedFruit);


    void deleteFruitById(String id) throws FruitNotFoundException;
}

