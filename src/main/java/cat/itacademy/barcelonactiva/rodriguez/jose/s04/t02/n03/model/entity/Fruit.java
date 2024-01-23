package cat.itacademy.barcelonactiva.rodriguez.jose.s04.t02.n03.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "fruit")
public class Fruit {
    @Id
    private Long id;
    @Setter
    private String name;
    @Setter
    private String tree;
    @Setter
    private boolean eatable;


    public Fruit(String title, String description, boolean published) {
        this.name = title;
        this.tree = description;
        this.eatable = published;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + name + ", desc=" + tree + ", published=" + eatable + "]";
    }
}