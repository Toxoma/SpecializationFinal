package org.example;

import org.example.command.Command;
import org.example.kind.Animal;
import org.jfree.ui.RefineryUtilities;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws Exception {
        HumanFriends humanFriends = new HumanFriends();
        Animal animal;
        humanFriends.addAnimal("cat", "Marik", "30.07.2023");
        humanFriends.addAnimal("dog", "Marik2", "30.07.2023");
        humanFriends.addAnimal("cat", "Marik3", "30.07.2023");

        String str = "";
        do {
            System.out.println("\nВеберите действие");
            System.out.println("1. Новое животное\n" +
                    "2. Обучить новой команде\n" +
                    "3. Список команд животного\n" +
                    "0. Выход");
            str = Input.getInput("");
            switch (str){
                case "1":
                    humanFriends.addAnimal();
                    break;
                case "2":
                    animal = humanFriends.chooseAnimal();
                    if (animal == null){
                        break;
                    }
                    String command = humanFriends.chooseCommand();
                    if (command == null){
                        break;
                    }
                    animal.addCommand(command);
                    break;
                case "3":
                    animal = humanFriends.chooseAnimal();
                    if (animal == null){
                        break;
                    }
                    animal.getCommands();
                    break;
                case "0":
                    System.out.println("Пока пока");
                    break;
                default:
                    System.out.println("Такой команды нет!\n");
                    break;
            }
        } while(!str.equals("0"));
    }
}
