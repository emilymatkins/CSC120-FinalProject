import java.util.Scanner;

public class Nogi extends Location{
    
    public Nogi(){
        super("Nogi", 
        "\n" + "Welcome to Nogi", 
        new Item("Sugar", true));
    }

@Override
    public void enter(Player player, Scanner scanner){

    if (GameMain.Nogi.getItemStatus() == true){
        System.out.println(getDescription());
        System.out.println("All the lights are out except for a spotlight luminating an old safe");
        System.out.println("1. Take a closer look at the safe");
        System.out.println("2. Head back to the CC because its too spooky");

        System.out.println("Enter 1 or 2");
        String choice = scanner.nextLine();

        while (!choice.equals("1") &&
                !choice.equals("2")) {
            if (super.commands(player, choice, scanner) == true) {
                choice = scanner.nextLine();
            } else {
                System.out.println("Try again. 1 or 2");
                choice = scanner.nextLine();
            }
        }

        switch (choice) {
            case "1":
                System.out.println("\nIt seems the only way to open the safe is with a 4-digit code");
                System.out.println("You notice theres a hint that reads:");
                System.out.println("What year did Julia Child graduate Smith College?");
                System.out.println("\n");
                System.out.println("Enter a 4-digit number to see what the safe holds");
                String combo = scanner.nextLine();

                while(!combo.equals("1934")){
                    System.out.println("\nThe safe doesn't open");
                    System.out.println("Here's another hint: - - 3 4");
                    combo = scanner.nextLine();
                }

                System.out.println("\nThe safe creaks open and reveals a bag of sugar");
                System.out.println("This must've been the sugar Julia used herself!");
                player.pickUp(GameMain.Nogi.getItem());

                System.out.println("There doesn't seem to be anything else in Nogi");
                System.out.println("1. Head back to CC");
                String cc = scanner.nextLine();

                while (!cc.equals("1")) {
                    if (super.commands(player, cc, scanner) == true) {
                        cc = scanner.nextLine();
                    } else {
                        System.out.println("Try again. 1");
                        cc = scanner.nextLine();
                    }
                }
                
                GameMain.currentLocation = GameMain.CC;
                GameMain.CC.enter(player, scanner);
                break;
        
            case "2":
                GameMain.currentLocation = GameMain.CC;
                GameMain.CC.enter(player, scanner);
                break;
        }
    } else {
        System.out.println("There doesn't seem to be anything else in Nogi");
        System.out.println("1. Head back to CC");
        String cc = scanner.nextLine();

        while (!cc.equals("1")) {
            if (super.commands(player, cc, scanner) == true) {
                cc = scanner.nextLine();
            } else {
                System.out.println("Try again. 1");
                cc = scanner.nextLine();
            }
        }

        GameMain.currentLocation = GameMain.CC;
        GameMain.CC.enter(player, scanner);
    }
    
    }
}