package ControlWork;

import java.util.*;

// Базовый класс Животное
class Animal {
    private String name;
    private List<String> commands;
    private String birthDate;

    public Animal(String name, String command, String birthDate) {
        this.name = name;
        this.commands = new ArrayList<>();
        this.commands.add(command);
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public List<String> getCommands() {
        return commands;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void addCommand(String newCommand) {
        commands.add(newCommand);
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Команды: " + commands + ", Дата рождения: " + birthDate;
    }
}