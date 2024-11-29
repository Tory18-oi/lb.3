package droids;

public class Droid {
    protected String name;
    protected int health;
    protected int damage;
    protected int damageReceived;  // поле для відстеження отриманої шкоди

    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.damageReceived = 0;  // Ініціалізація отриманої шкоди
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
        damageReceived += damage;  // Збільшуємо кількість отриманої шкоди
        if (health < 0) health = 0;
    }

    public int getDamage() {
        return damage;
    }

    public void resetDamageReceived() {
        this.damageReceived = 0;  // Очищення шкоди після активації ульти
    }

    public int getDamageReceived() {
        return damageReceived;
    }

    public String toString() {
        return name + " [Здоров'я: " + health + ", Шкода: " + damage + "]";
    }
}
