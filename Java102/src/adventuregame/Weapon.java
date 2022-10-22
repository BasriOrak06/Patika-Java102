package adventuregame;

import java.net.IDN;

public class Weapon {
    private int ID;
    private String name;
    private int demage;
    private int price;

    public Weapon(int ID, String name, int demage, int price) {
        this.ID = ID;
        this.name = name;
        this.demage = demage;
        this.price = price;
    }

    public static Weapon[] weapons() {
        Weapon[] weaponList = new Weapon[3];
        weaponList[0] = new Weapon(1, "Pistol", 2,15);
        weaponList[1] = new Weapon(2, "Sword", 3,35);
        weaponList[2] = new Weapon(3, "Rifle", 7,45);
        return  weaponList;
    }
    public  static Weapon getWeaponObjByID(int ID) {
        Weapon weapon = null;
        for (Weapon w: Weapon.weapons()) {
            if (w.getID() == ID) {
                return w;
            }
        }
        return null;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDemage() {
        return demage;
    }

    public void setDemage(int demage) {
        this.demage = demage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
