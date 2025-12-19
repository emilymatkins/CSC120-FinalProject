import java.util.Scanner;

public class Barn extends Location{
    
public Barn(){
    super("Barn", 
    "\nWelcome to the Barn", 
    new Item("Milk", true));
}

@Override
public void enter(Player player, Scanner scanner){

    if (GameMain.Barn.getItemStatus() ==  true){

        System.out.println(getDescription());
        System.out.println("It smells a little stinky in here");
        System.out.println("You spot some cows and it all makes sense now");
        System.out.println("In the corner of the barn you see an odd looking farmer");

        System.out.println("\n1. Talk to the odd looking farmer");
        System.out.println("2. Head back to Tyler");
        
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
                System.out.println("\nThe farmer speaks:");
                System.out.println("'My cows are award winners!!");
                System.out.println("Its the best milk in town...");
                System.out.println("Actually in the whole world 🐮'");

                System.out.println("I'll give you a free jug if you can answer this question:");
                System.out.println("A baby cow is called?");
                String calf = scanner.nextLine();
                calf = calf.toLowerCase();

                while (!calf.equals("calf")) {
                    System.out.println("Come on! Julia Child Day is depending on you!");
                    calf = scanner.nextLine();
                }

                System.out.println("\nThe farmer speaks:");
                System.out.println("Correct! You must be udderly obsessed with cows!");
                System.out.println("As promised heres that jug of milk!");
                player.pickUp(GameMain.Barn.getItem());

                System.out.println("\nThere doesn't seem to be anything else in the Barn");
                System.out.println("1. Head back to Tyler");
                String c = scanner.nextLine();

                while (!c.equals("1")) {
                    if (super.commands(player, c, scanner) == true) {
                c = scanner.nextLine();
                    } else {
                System.out.println("Try again. 1 ");
                c = scanner.nextLine();
                    } 
                }

                GameMain.currentLocation = GameMain.Tyler;
                GameMain.Tyler.enter(player, scanner);
                break;
        
            case "2": 
                GameMain.currentLocation = GameMain.Tyler;
                GameMain.Tyler.enter(player, scanner);
                break;
        }
    } else {
        System.out.println("\nThere doesn't seem to be anything else in the Barn");
        System.out.println("1. Head back to Tyler");
        String cc = scanner.nextLine();

        while (!cc.equals("1")) {
            if (super.commands(player, cc, scanner) == true) {
                cc = scanner.nextLine();
            } else {
                System.out.println("Try again. 1 ");
                cc = scanner.nextLine();
            }
        }

        GameMain.currentLocation = GameMain.Tyler;
        GameMain.Tyler.enter(player, scanner);

    }
}
}
