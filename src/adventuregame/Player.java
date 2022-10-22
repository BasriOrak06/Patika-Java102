package adventuregame;

import java.util.Scanner;

public class Player {
    private Scanner input = new Scanner(System.in);
    private  int health;
    private  int orginalhealth;
    private  int damage;
    private int gold;
    private String name;
    private String heroName;
    private Inventory inventory;


    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public  void selectCharacter() {
        Hero[] heroes = {new Samurai(), new Archer(), new Knight()};

        System.out.println("HEROES");
        System.out.println("---------------------------------------------------------");
        for (Hero hero : heroes) {
            System.out.println("ID: " + hero.getID() +
                    "\tHero: " + hero.getName() +
                    "\tDamage : " + hero.getDamage() +
                    "\tHealth: " + hero.getHealth() +
                    "\tGold: " + hero.getGold());
        }
        System.out.println("---------------------------------------------------------");
        System.out.print("MAKE YOUR CHOOSE: ");
        int selectHero = input.nextInt();
        switch (selectHero) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Hero :" + this.getHeroName() +
                " Damage: " + this.getDamage() +
                " Health: " + this.getHealth() +
                " Gold: " + this.getGold());

    }

    public void initPlayer(Hero hero) {
        this.setDamage(hero.getDamage());
        this.setHealth(hero.getHealth());
        this.setOrginalhealth(this.health);
        this.setGold(hero.getGold());
        this.setHeroName(hero.getName());
    }

    public void printInfo() {
        System.out.println(
                "Weapon: " + this.getInventory().getWeapon().getName() +
                ", Armor: " + this.getInventory().getArmor().getName() +
                ", Blocking: " + this.getInventory().getArmor().getBlock() +
                ", Damage: " + this.getTotalDamage() +
                ", Health: " + this.getHealth() +
                ", Gold: " + this.getGold());
    }

    public boolean saveTheWorld() {
        if(this.getInventory().getFood().equals("food")  &&
                this.getInventory().getWater().equals("water") &&
                this.getInventory().getFirewood().equals("firewood") &&
                this.getInventory().getSnake().equals("snakeKiller")) {
            return true;
        } else {
            return false;
        }
    }
    public int getTotalDamage() {
       return damage + this.getInventory().getWeapon().getDemage();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrginalhealth() {
        return orginalhealth;
    }

    public void setOrginalhealth(int orginalhealth) {
        this.orginalhealth = orginalhealth;
    }


}
