package org.example;

import org.example.kind.Animal;
import org.example.kind.Cat;
import org.example.kind.Dog;

import java.util.ArrayList;
import java.util.List;

public class HumanFriends {
    public Counter counter = new Counter();
    private Animal[] SPECIES = new Animal[] {
        new Cat(),
        new Dog(),
    };

    private List<Animal> MAS = new ArrayList<>(){};

    public HumanFriends() {

    }

    public Animal addAnimal(String kind, String name, String dateB) throws Exception {
        try {
            for (Animal animal : SPECIES) {
                if (kind.equals(animal.getKindName())){
                    Animal newAnimal = switch (animal.getKindName()) {
                        case "cat" -> new Cat();
                        case "dog" -> new Dog();
                        default -> new Animal();
                    };
                    newAnimal.setName(name);
                    newAnimal.setDateB(dateB);
                    this.MAS.add(newAnimal);
                    counter.add();
                    newAnimal.setId(counter.getCount());
                    return newAnimal;
                }
            }
            System.out.println("Такого типа животного не нашлось...");
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
