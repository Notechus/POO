package me.notechus.poo.lista5.zad5;

import java.util.Objects;
import java.util.UUID;

/**
 * @author notechus.
 */
public class Person {

    private UUID id;
    private String name;
    private String surname;

    public Person(String name, String surname) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, surname);
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
