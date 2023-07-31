package org.example.kind;

import org.example.command.Command;
import org.example.command.Jump;
import org.example.command.Run;
import org.example.command.Sit;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private Integer id;
    private String KIND_NAME = "";
    private String name = "";
    private String dateB = "";
    private List <Command> commands = new ArrayList<>();

    public Animal() {
    }
    public Animal(String name) {
        this.KIND_NAME = name;
        commands.add(new Run());
    }

    public String getKindName() {
        return KIND_NAME;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateB() {
        return dateB;
    }

    public void setDateB(String dateB) {
        this.dateB = dateB;
    }

    public void getCommands() {
        System.out.println("Команды "+this.name+":");
        for (Command command : this.commands) {
            System.out.println(command.getName());
        }
    }

    public void setCommand(Command command) {
        this.commands.add(command);
    }

    public void addCommand(String name){
        Command newCommand = switch (name) {
            case "бежать" -> new Run();
            case "сидеть" -> new Sit();
            case "прыгать" -> new Jump();
            default -> null;
        };
        if (newCommand == null){
            System.out.println("Такой команды не нашлось...");
        } else {
            for (Command command: this.commands) {
                if (newCommand.getName().equals(command.getName())) {
                    System.out.println("Такая команда уже есть...");
                    return;
                }
            }
            this.commands.add(newCommand);
        }
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
