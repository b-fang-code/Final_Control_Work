package ControlWork;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();

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

        List<Animal> allAnimals = registry.getAnimals();
        for (Animal animal : allAnimals) {
            System.out.println(animal);
        }
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Завести новое животное");
            System.out.println("2. Просмотреть список животных");
            System.out.println("3. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Чтение символа новой строки после выбора

            switch (choice) {
                case 1:
                    // Завести новое животное
                    System.out.print("Введите имя животного: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите команду животного: ");
                    String command = scanner.nextLine();
                    System.out.print("Введите дату рождения животного (гггг-мм-дд): ");
                    String birthDate = scanner.nextLine();

                    // Определить класс животного
                    Animal animal;
                    System.out.print("Это домашнее или вьючное животное? (д/в): ");
                    String type = scanner.nextLine();

                    if (type.equalsIgnoreCase("д")) {
                        animal = new HomeAnimal(name, command, birthDate);
                    } else if (type.equalsIgnoreCase("в")) {
                        animal = new PackAnimal(name, command, birthDate);
                    } else {
                        System.out.println("Некорректный выбор типа животного. Попробуйте снова.");
                        continue; // Перезапускаем цикл, чтобы снова ввести данные
                    }


                    // Добавить животное в реестр
                    registry.addAnimal(animal);
                    System.out.println("Животное добавлено в реестр.");
                    break;
                case 2:
                    // Просмотреть список животных
                    List<Animal> allAnimal = registry.getAnimals();
                    for (Animal a : allAnimals) {
                        System.out.println(a);
                    }
                    break;
                case 3:
                    // Выход из программы
                    System.out.println("Программа завершена.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                    break;
            }
        }
    }
}
