package adventuregame;

import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.print("=====Welcome to Adventure Game=====\n");
        System.out.print("Enter Player Name: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " Welcome to This Dark and Foggy Island!!!");
        System.out.println("Everything Is Real What Is Happening Here!!!\n");
        System.out.println(player.getName().toUpperCase() + " Choose Your Hero".toUpperCase());
        player.selectCharacter();



        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println("\n-----  LOCATIONS  -----\n");
            System.out.println("1 - Safe House --> This is your safe House, no enemy here");
            System.out.println("2 - Store --> You can buy weapons or armors from this store");
            System.out.println("3 - Cave --> Award is food, be careful zombies lives here");
            System.out.println("4 - Forest --> Award is fire wood, be careful vampires lives here");
            System.out.println("5 - River --> Award is water , be careful bears lives here");
            System.out.println("6 - Mine --> Be careful snakes lives here, you have chance to earn items per killed snakes");
            System.out.println("0 - Exit --> Close the game");
            System.out.print("Choose the location that you want to go: ");
            int selectLocation = input.nextInt();
            switch (selectLocation) {
                case 0:
                location = null;
                break;
                case 1:
                location = new SafeHouse(player);
                break;
                case 2:
                location = new Store(player);
                break;
                case 3:
                if (!player.getInventory().getFood().equals("food") ) {
                    location = new Cave(player);
                } else {
                    System.out.println("You cleared the Cave already, You can not go there again");
                    System.out.println("You are sent to Safe House");
                    location = new SafeHouse(player);
                }
                break;
                case 4:
                if (!player.getInventory().getFirewood().equals("firewood")){
                    location = new Forest(player);
                } else {
                    System.out.println("You cleared the Forest already, You can not go there again");
                    System.out.println("You are sent to Safe House");
                    location = new SafeHouse(player);
                }
                break;
                case 5:
                if (!player.getInventory().getWater().equals("water")) {
                    location = new River(player);
                } else {
                    System.out.println("You cleared the River already, You can not go there again");
                    System.out.println("You are sent to Safe House");
                    location = new SafeHouse(player);
                }
                break;
                case 6:
                if (!player.getInventory().getSnake().equals("snakeKiller")) {
                    location = new Mine(player);
                } else {
                    System.out.println("You cleared the Mine already, You can not go there again");
                    System.out.println("You are sent to Safe House");
                    location = new SafeHouse(player);
                }
                break;
                default:
                System.out.println("Please select a valid choose");
            }


            if (location == null) {
                if (player.saveTheWorld()) {
                    System.out.println("Congratulations You Killed All The Monsters. You Saved The Island and YOU ARE A REAL HERO".toUpperCase());
                } else {
                    System.out.println("You run away from this dark and foggy island like a coward!!!".toUpperCase());
                }
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER!!!");
                break;
            }
        }


    }

}
