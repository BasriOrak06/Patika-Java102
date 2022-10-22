package adventuregame;


public class Store extends NormalLacation{
    public Store(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("----- Welcome To The Store -----");
        boolean showMenu = true;
        while(showMenu) {
            System.out.println("1 - Weapons");
            System.out.println("2 - Armors");
            System.out.println("3 - Quit");
            System.out.print("Make a selection from menu: ");
            int selectCase = Location.input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Invalid value, select again: ");
                selectCase = Location.input.nextInt();
            }
            switch (selectCase) {
                case 1 :
                    printWeapons();
                    buyWeapon();
                    break;
                case 2:
                    printArmors();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Shopping completed");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapons() {
        System.out.println("----- Weapons -----");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getID() + " - " + w.getName() + " < Price: " + w.getPrice() + " Damage: " + w.getDemage() + ">");
        }
        System.out.println("0 - Exit");
    }

    public void buyWeapon() {
        System.out.print("Select which weapon you want to buy: ");

        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Invalid value, select again: ");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getGold()) {
                    System.out.println("You don't have enough Gold");
                } else {
                    System.out.println("You bought the " + selectedWeapon.getName() );
                    int balance = this.getPlayer().getGold() - selectedWeapon.getPrice();
                    this.getPlayer().setGold(balance);
                    System.out.println("Remaining Gold: " + this.getPlayer().getGold());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }
    }

    public void printArmors() {
        System.out.println("----- Armors -----");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getID() + " - " + a.getName() + " < Price: " + a.getPrice() + " Engelleme: " + a.getBlock() + ">");
        }
        System.out.println("0 - Exit");

    }

    public void buyArmor() {
        System.out.print("Select which armor you want to buy: ");

        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Invalid value, select again: ");
            selectArmorID = input.nextInt();
        }

        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getGold()) {
                    System.out.println("You don't have enough Gold");
                } else {
                    System.out.println("You bought the " + selectedArmor.getName() );
                    int balance = this.getPlayer().getGold() - selectedArmor.getPrice();
                    this.getPlayer().setGold(balance);
                    System.out.println("Remaining Gold: " + this.getPlayer().getGold());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }
    }
}
