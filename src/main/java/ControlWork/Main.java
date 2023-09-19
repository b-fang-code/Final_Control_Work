package ControlWork;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();

        // Создаем и добавляем животных в реестр
        Dog dog1 = new Dog("Рекс", "Сидеть", "2019-04-15");
        Dog dog2 = new Dog("Барон", "Апорт", "2020-07-20");

        Cat cat1 = new Cat("Вася", "Ловить мышей", "2021-06-10");
        Cat cat2 = new Cat("Мурка", "Мурлыкать", "2019-02-28");

        Hamster hamster1 = new Hamster("Чарли", "Крутиться в колесе", "2020-03-02");
        Hamster hamster2 = new Hamster("Барсик", "Бегать по лабиринту", "2022-11-15");

        Horse horse1 = new Horse("Маркус", "Тянуть плуг", "2023-08-01");
        Horse horse2 = new Horse("Айва", "Скачки", "2016-05-18");

        Camel camel1 = new Camel("Амина", "Переносить грузы", "2020-12-10");
        Camel camel2 = new Camel("Саид", "Сопровождение", "2015-10-25");

        Donkey donkey1 = new Donkey("Бенедикт", "Тянуть плуг", "2017-04-08");
        Donkey donkey2 = new Donkey("Луна", "Тянуть плуг", "2021-01-14");

        registry.addAnimal(dog1);
        registry.addAnimal(dog2);
        registry.addAnimal(cat1);
        registry.addAnimal(cat2);
        registry.addAnimal(hamster1);
        registry.addAnimal(hamster2);
        registry.addAnimal(horse1);
        registry.addAnimal(horse2);
        registry.addAnimal(camel1);
        registry.addAnimal(camel2);
        registry.addAnimal(donkey1);
        registry.addAnimal(donkey2);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Завести новое животное");
            System.out.println("2. Посмотреть список всех животных");
            System.out.println("3. Определить класс животного");
            System.out.println("4. Увидеть список команд животного");
            System.out.println("5. Обучить животное новым командам");
            System.out.println("6. Выйти из программы");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Чтение символа новой строки после ввода числа

            switch (choice) {
                case 1:
                    // Завести новое животное
                    System.out.print("Введите имя животного: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите команду для животного: ");
                    String command = scanner.nextLine();
                    System.out.print("Введите дату рождения животного (гггг-мм-дд): ");
                    String birthDate = scanner.nextLine();

                    // Определение класса животного (можно реализовать на основе введенных данных)
                    Animal newAnimal = new Animal(name, command, birthDate);
                    registry.addAnimal(newAnimal);
                    System.out.println("Животное успешно добавлено в реестр!");
                    break;
                case 2:
                    // Посмотреть список всех животных
                    List<Animal> allAnimals = registry.getAnimals();
                    for (Animal animal : allAnimals) {
                        System.out.println(animal);
                    }
                    break;
                case 3:
                    // Определить класс животного
                    System.out.print("Введите имя животного: ");
                    String animalName = scanner.nextLine();
                    Animal foundAnimal = findAnimalByName(registry, animalName);
                    if (foundAnimal != null) {
                        if (foundAnimal instanceof HomeAnimal) {
                            System.out.println("Это домашнее животное.");
                        } else if (foundAnimal instanceof PackAnimal) {
                            System.out.println("Это вьючное животное.");
                        } else {
                            System.out.println("Класс животного не определен.");
                        }
                    } else {
                        System.out.println("Животное не найдено.");
                    }
                    break;
                case 4:
                    // Увидеть список команд животного
                    System.out.print("Введите имя животного: ");
                    String animalName2 = scanner.nextLine();
                    Animal foundAnimal2 = findAnimalByName(registry, animalName2);
                    if (foundAnimal2 != null) {
                        List<String> commands = foundAnimal2.getCommands();
                        System.out.println("Список команд, которые выполняет животное:");
                        for (String cmd : commands) {
                            System.out.println(cmd);
                        }
                    } else {
                        System.out.println("Животное не найдено.");
                    }
                    break;
                case 5:
                    // Обучить животное новым командам
                    System.out.print("Введите имя животного: ");
                    String animalName3 = scanner.nextLine();
                    Animal foundAnimal3 = findAnimalByName(registry, animalName3);
                    if (foundAnimal3 != null) {
                        System.out.print("Введите новую команду для обучения животному: ");
                        String newCommand = scanner.nextLine();
                        foundAnimal3.addCommand(newCommand);
                        System.out.println("Команда успешно добавлена!");
                    } else {
                        System.out.println("Животное не найдено.");
                    }
                    break;
                case 6:
                    // Выход из программы
                    System.out.println("Программа завершена.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неправильный выбор. Попробуйте снова.");
            }
        }
    }

    // Метод для поиска животного по имени в реестре
    private static Animal findAnimalByName(AnimalRegistry registry, String name) {
        List<Animal> allAnimals = registry.getAnimals();
        for (Animal animal : allAnimals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }
}
