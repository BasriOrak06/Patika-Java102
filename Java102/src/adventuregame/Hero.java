package adventuregame;

public abstract class Hero {
    private String name;
    private int ID;
    private int damage;
    private int health;
    private int gold;

    public Hero(int ID, String name, int damage, int health, int gold) {
        this.ID = ID;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.gold = gold;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
