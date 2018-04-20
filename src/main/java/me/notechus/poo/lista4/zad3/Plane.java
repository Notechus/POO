package me.notechus.poo.lista4.zad3;

import java.util.UUID;

/**
 * @author Sebastian Paulus
 */
public class Plane {

    private UUID id;
    private String name;

    public Plane(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Plane{" + "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
