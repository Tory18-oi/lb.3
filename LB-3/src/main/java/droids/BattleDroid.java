package droids;

public class BattleDroid extends Droid {
    private Weapon weapon;

    public BattleDroid(String name, int health, int damage, Weapon weapon) {
        super(name, health, damage);
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }


    public int getDamage() {
        return super.getDamage() + weapon.getDamage();
    }

    // Метод для активації ультимативної здатності
    public void activateUltimate() {
        System.out.println(name + " активує ульту! Отримавши понад 200 шкоди, дрон стає сильнішим.");
        this.damage += 50;  // Наприклад, збільшення шкоди на 50
        resetDamageReceived();  // Обнуляємо отриману шкоду після активації ульти
    }


    public String toString() {
        return super.toString() + ", Зброя: " + weapon.getName() + " (Шкода: " + weapon.getDamage() + ")";
    }
}
