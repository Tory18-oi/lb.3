package Main;

import droids.BattleDroid;
import droids.Droid;
import droids.Weapon;


import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static ArrayList<Droid> droids = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Створити дроїда");
            System.out.println("2. Показати список дроїдів");
            System.out.println("3. Запустити бій 1 на 1");
            System.out.println("4. Вийти");
            System.out.print("Виберіть команду: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очищаємо буфер

            switch (choice) {
                case 1:
                    createDroid();
                    break;
                case 2:
                    showDroids();
                    break;
                case 3:
                    battleOneOnOne();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Невірний вибір, спробуйте ще раз.");
            }
        }
    }

    private static void createDroid() {
        System.out.print("Введіть ім'я дроїда: ");
        String name = scanner.nextLine();
        System.out.print("Введіть здоров'я дроїда: ");
        int health = scanner.nextInt();
        System.out.print("Введіть шкоду дроїда: ");
        int damage = scanner.nextInt();
        scanner.nextLine(); // Очищаємо буфер

        System.out.print("Введіть назву зброї: ");
        String weaponName = scanner.nextLine();
        System.out.print("Введіть шкоду зброї: ");
        int weaponDamage = scanner.nextInt();
        scanner.nextLine(); // Очищаємо буфер

        Weapon weapon = new Weapon(weaponName, weaponDamage);

        droids.add(new BattleDroid(name, health, damage, weapon)); // Додаємо зброю до дроїда
        System.out.println("Дроїд створений!");
    }

    private static void showDroids() {
        for (Droid droid : droids) {
            System.out.println(droid);
        }
    }

    private static void battleOneOnOne() {
        System.out.print("Введіть номер першого дроїда: ");
        int firstDroidIndex = scanner.nextInt() - 1;
        System.out.print("Введіть номер другого дроїда: ");
        int secondDroidIndex = scanner.nextInt() - 1;

        Droid droid1 = droids.get(firstDroidIndex);
        Droid droid2 = droids.get(secondDroidIndex);

        System.out.println("Бій між " + droid1.getName() + " та " + droid2.getName() + " починається!");

        while (droid1.isAlive() && droid2.isAlive()) {
            // Дроїд 1 атакує Дроїда 2
            int damageToDroid2 = droid1.getDamage();
            droid2.takeDamage(damageToDroid2);

            if (droid1 instanceof BattleDroid) {
                System.out.println(droid1.getName() + " атакує " + droid2.getName() + " зі зброєю " + ((BattleDroid) droid1).getWeapon().getName() + " і забирає " + damageToDroid2 + " здоров'я.");
            } else {
                System.out.println(droid1.getName() + " атакує " + droid2.getName() + " і забирає " + damageToDroid2 + " здоров'я.");
            }

            // Перевірка ультимативної здатності Дроїда 2
            if (droid2 instanceof BattleDroid && droid2.getDamageReceived() >= 200) {
                ((BattleDroid) droid2).activateUltimate();
            }

            if (droid2.isAlive()) {
                // Дроїд 2 атакує Дроїда 1
                int damageToDroid1 = droid2.getDamage();
                droid1.takeDamage(damageToDroid1);

                if (droid2 instanceof BattleDroid) {
                    System.out.println(droid2.getName() + " атакує " + droid1.getName() + " зі зброєю " + ((BattleDroid) droid2).getWeapon().getName() + " і забирає " + damageToDroid1 + " здоров'я.");
                } else {
                    System.out.println(droid2.getName() + " атакує " + droid1.getName() + " і забирає " + damageToDroid1 + " здоров'я.");
                }

                // Перевірка ультимативної здатності Дроїда 1
                if (droid1 instanceof BattleDroid && droid1.getDamageReceived() >= 200) {
                    ((BattleDroid) droid1).activateUltimate();
                }
            }
        }

        if (droid1.isAlive()) {
            System.out.println(droid1.getName() + " переміг!");
        } else {
            System.out.println(droid2.getName() + " переміг!");
        }
    }
}
