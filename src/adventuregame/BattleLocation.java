package adventuregame;

import java.util.Random;

public abstract class BattleLocation extends Location {
    private Monster monster;
    private int maxMonster;
    private String award;


    public BattleLocation(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.maxMonster = maxMonster;
        this.award = award;
    }

    @Override
    public boolean onLocation() {

        int mnstrNum = this.randomMonsterNumber();
        System.out.println("You are in: " + this.getName());
        System.out.println("Be careful. " + mnstrNum + " " + this.monster.getName() + " lives here");
        System.out.println("<W>ar or <E>scape");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("W") && combat(mnstrNum)) {
            System.out.println("You killed all the monsters in the " + this.getName());
            locationAward();
            return true;
        }

        if (this.getPlayer().getHealth() <= 0) {
            this.getPlayer().setHealth(0);
            afterHit();
            System.out.println("You died!!!");
            return false;
        }

        return true;
    }

    public boolean combat(int mnstrNumber) {
        for (int i = 1; i <= mnstrNumber; i++) {
            this.getMonster().setHealth(this.getMonster().getOriginalHealth());
            int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
            if (monsterDamage < 0) {
                monsterDamage = 0;
                playerStats();
                monsterStats(i);
            }
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                Random priority = new Random();
                int a = priority.nextInt(2);
                if (a == 1) {
                    if (this.getPlayer().getHealth() > 0) {
                        System.out.println("You hit");
                        this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                    }
                    if (this.getMonster().getHealth() > 0) {
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        afterHit();
                        System.out.println("---------------------------------------------------------");

                    }
                }

                if (a == 0) {
                    if (this.getMonster().getHealth() > 0) {
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        afterHit();
                    }
                    if (this.getPlayer().getHealth() > 0) {
                        System.out.println("You hit");
                        this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                    }
                }
            }

            if (this.getMonster().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("***You beat the monster!!!***");
                if (this.getMonster().getName().equals("Snake")) {
                    snakeAward();
                }
                System.out.println("You earned: " + this.getMonster().getAward() + " gold");
                this.getPlayer().setGold(this.getPlayer().getGold() + this.monster.getAward());
                System.out.println("Your current gold: " + this.getPlayer().getGold());
            } else {
                return false;
            }
        }
        return true;
    }


    private void afterHit() {
        System.out.println("Your Health: " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + "'s Health: " + this.getMonster().getHealth());
    }

    private void playerStats() {
        System.out.println("---------------------------------------------------------");
        System.out.println("Player stats");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Blocking: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Gold: " + this.getPlayer().getGold());

    }

    private void monsterStats(int i) {
        System.out.println("---------------------------------------------------------");
        System.out.println(i + ". " + this.getMonster().getName() + " Stats:");
        System.out.println("Health: " + this.getMonster().getHealth());
        System.out.println("Damage: " + this.getMonster().getDamage());
        System.out.println("Damage: " + this.getMonster().getAward());

    }

    public int randomMonsterNumber() {
        Random r = new Random();
        return r.nextInt(this.maxMonster) + 1;
    }

    public void snakeAward() {
        int random1 = (int) (Math.random() * 101);
        int random2 = (int) (Math.random() * 101);

        if (random1 <= 15) {
            if (random2 <= 50) {
                System.out.println("You won a pistol");
                if (this.getPlayer().getInventory().getWeapon().getDemage() >= 2) {
                    System.out.println("Your weapon is better, you don't need this weapon");
                } else {
                    this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(1));
                }
            }
            if (random2 <= 70 && random2 > 50) {
                System.out.println("You won a riffle");
                if (this.getPlayer().getInventory().getWeapon().getDemage() >= 3) {
                    System.out.println("Your weapon is better, you don't need this weapon");
                } else {
                    this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(2));
                }
            } else {
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(3));
            }
        }

        if (random1 > 15 && random1 <= 30) {
            if (random2 <= 50) {
                System.out.println("You won a light armor");
                if (this.getPlayer().getInventory().getArmor().getBlock() >= 1) {
                    System.out.println("Your armor is better, you don't need this armor");
                } else {
                    this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(1));
                }
            }
            if (random2 <= 70 && random2 > 50) {
                System.out.println("You won a riffle");
                if (this.getPlayer().getInventory().getArmor().getBlock() >= 3) {
                    System.out.println("Your armor is better, you don't need this armor");
                } else {
                    this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(2));
                }
            } else {
                this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(3));
            }
        }
        if (random1 > 30 && random1 <= 55) {
            if (random2 <= 50) {
                System.out.println("You earned 1 gold");
                this.getPlayer().setGold(this.getPlayer().getGold() + 1);
            }
            if (random2 > 50 && random2 <= 80) {
                System.out.println("You earned 5 gold");
                this.getPlayer().setGold(this.getPlayer().getGold() + 5);
            }
            if (random2 > 80) {
                System.out.println("You earned 10 gold");
                this.getPlayer().setGold(this.getPlayer().getGold() + 10);
            }
        }
        if (random1 > 55) {
            System.out.println("Sorry, snake was empty you couldn't win anything");
        }
    }

    public void locationAward() {
        if (this.getName().equals("Cave")) {
            System.out.println("Your award is food");
            this.getPlayer().getInventory().setFood("food");
        }

        if (this.getName().equals("Forest")) {
            System.out.println("Your award is firewood");
            this.getPlayer().getInventory().setFirewood("firewood");
        }

        if (this.name.equals("River")) {
            this.getPlayer().getInventory().setWater("water");
        }
        if (this.name.equals("Mine")) {
            System.out.println("Your award is named snakeKiller");
            this.getPlayer().getInventory().setSnake("snakeKiller");
        }
    }



    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }


    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

}
