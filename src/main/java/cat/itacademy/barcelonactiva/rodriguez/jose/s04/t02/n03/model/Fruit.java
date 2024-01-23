package cat.itacademy.barcelonactiva.rodriguez.jose.s04.t02.n03.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fruit")
public class Fruit {
    @Id
    private String id;
    private String name;
    private String tree;
    private boolean eatable;


    public Fruit(String title, String description, boolean published) {
        this.name = title;
        this.tree = description;
        this.eatable = published;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTree() {
        return tree;
    }

    public void setTree(String tree) {
        this.tree = tree;
    }

    public boolean isEatable() {
        return eatable;
    }

    public void setEatable(boolean isPublished) {
        this.eatable = isPublished;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + name + ", desc=" + tree + ", published=" + eatable + "]";
    }
}