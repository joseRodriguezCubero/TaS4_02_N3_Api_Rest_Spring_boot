package cat.itacademy.barcelonactiva.rodriguez.jose.s04.t02.n03.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "fruit")
public class Fruit {
    @Id
    private String id;
    @Setter
    private String name;
    @Setter
    private String tree;
    @Setter
    private boolean eatable;


    public Fruit(String name, String tree, boolean eatable) {
        this.name = name;
        this.tree = tree;
        this.eatable = eatable;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", name=" + name + ", tree=" + tree + ", eatable=" + eatable + "]";
    }
}