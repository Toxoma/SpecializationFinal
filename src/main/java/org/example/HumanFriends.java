package org.example;

import org.example.command.Command;
import org.example.command.Jump;
import org.example.command.Run;
import org.example.command.Sit;
import org.example.kind.Animal;
import org.example.kind.Cat;
import org.example.kind.Dog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.RecursiveTask;
import java.util.regex.Pattern;

public class HumanFriends {
    public Counter counter = new Counter();
    private Animal[] SPECIES = new Animal[] {
        new Cat(),
        new Dog(),
    };

    private Command[] COMMANDS = new Command[] {
        new Run(),
        new Sit(),
        new Jump(),
    };

    private List<Animal> MAS = new ArrayList<>(){};

    public HumanFriends() {

    }

    public Animal addAnimal() throws Exception {
        try {
            System.out.println("Введите тип животного");
            for (Animal animal : SPECIES) {
                System.out.println(animal.getKindName());
            }
            String kind = Input.getInput ("");
            for (Animal animal : SPECIES) {
                if (kind.equals(animal.getKindName())){
                    Animal newAnimal = switch (animal.getKindName()) {
                        case "cat" -> new Cat();
                        case "dog" -> new Dog();
                        default -> new Animal();
                    };
                    String name = Input.getInput ("Введите имя животного");
                    if (name == null || !name.matches("[A-zА-яёЁ]+")){
                        System.out.println("Введено некорректное имя!");
                        return null;
                    }
                    newAnimal.setName(name);
                    String dateB = Input.getInput ("Введите дату рождения животного (25.02.2000)");
                    if (dateB == null || !dateB.matches("^[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}$")){
                        System.out.println("Введена некорректная дата!");
                        return null;
                    }
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

    public Animal chooseAnimal() {
        System.out.println("\nСписок всех животных");
        for (Animal animal : this.MAS) {
            System.out.println(animal.getId()+". "+animal.getName()+" - "+animal.getKindName());
        }
        Integer id = Input.getInteger("Веберите id животного\n");
        return this.getAnimalById(id);
    }

    public Animal getAnimalById (Integer id) {
        if (id != null){
            for (Animal animal : this.MAS) {
                if (animal.getId().equals(id)){
                    return animal;
                }
            }
        }
        System.out.println("Введён некоректный id");
        return null;
    }

    public String chooseCommand() {
        System.out.println("\nСписок всех команд");
        int n = 0;
        for (Command command : this.COMMANDS) {
            n++;
            System.out.println(n+". "+command.getName());
        }
        Integer id = Input.getInteger("Веберите id команды\n");
        return this.getCommandById(id);
    }

    public String getCommandById (Integer id) {
        if (id != null && id > 0 && id <= this.COMMANDS.length){
            return this.COMMANDS[id-1].getName();
        }
        System.out.println("Введён некоректный id");
        return null;
    }
}
