import java.util.Scanner;

public class Tyler extends Location {
    
public Tyler(){
    super("Tyler", 
    "\nWelcome to Tyler.", 
    new Item("Dark Chocolate", true));
}

@Override
public void enter(Player player, Scanner scanner){

if (GameMain.Tyler.getItemStatus() == true){
    System.out.println(getDescription() + " What's that delicious chocolately aroma??\nThere seems to be 3 heaping piles of chocolate on the table!");
    System.out.println("1. Trek across the fields to the Barn");
    System.out.println("2. Take a closer look at the table");
    System.out.println("3. Head back to the CC");

    System.out.println("Enter 1, 2, or 3");
    String choice = scanner.nextLine();
    
    while (!choice.equals("1") &&
            !choice.equals("2") &&
            !choice.equals("3")) {
        if (super.commands(player, choice, scanner) == true) {
            choice = scanner.nextLine();
        } else {
            System.out.println("Try again. 1, 2, or 3");
            choice = scanner.nextLine();
        }
    }

    switch (choice) {
        case "1":
            GameMain.currentLocation = GameMain.Barn;
            GameMain.Barn.enter(player, scanner);
            break;

        case "2":
            System.out.println("\nThere is chocolate galore! Which one was in the recipe?");
            System.out.println("1. White Chocolate");
            System.out.println("2. Dark Chocolate");
            System.out.println("3. Milk Chocolate");

            System.out.println("Enter 1, 2, or 3");
            String chocolate = scanner.nextLine();

            while (!chocolate.equals("1") &&
                    !chocolate.equals("2") &&
                    !chocolate.equals("3")) {
                System.out.println("Try again. 1, 2, or 3");
                chocolate = scanner.nextLine();
            }

            while (!chocolate.equals("2")) {
                System.out.println("Yuck! Not that chocolate!");
                chocolate = scanner.nextLine();
            }

            System.out.println("Yess that one!");
            player.pickUp(GameMain.Tyler.getItem());

            System.out.println("Where to now?");
            System.out.println("1. Explore the barn");
            System.out.println("2. Head back to the CC");

            System.out.println("Enter 1 or 2");
            String choice2 = scanner.nextLine();

            while (!choice2.equals("1") &&
                !choice2.equals("2")) {
                if (super.commands(player, choice2, scanner) == true) {
                    choice2 = scanner.nextLine();
                } else {
                    System.out.println("Try again. 1 or 2");
                    choice2 = scanner.nextLine();
                }
            }

            switch (choice2) {
                case "1":
                    GameMain.currentLocation = GameMain.Barn;
                    GameMain.Barn.enter(player, scanner);
                    break;

                case "2":
                    GameMain.currentLocation = GameMain.CC;
                    GameMain.CC.enter(player, scanner);
            }

        case "3":
            GameMain.currentLocation = GameMain.CC;
            GameMain.CC.enter(player, scanner);
            break;
    }

} else { 
    System.out.println(getDescription());
    System.out.println("1. Trek across the fields to the Barn");
    System.out.println("2. Head back to the CC");

    System.out.println("Enter 1 or 2");
    String c = scanner.nextLine();

    while (!c.equals("1") &&
            !c.equals("2")) {
        if (super.commands(player, c, scanner) == true) {
            c = scanner.nextLine();
        } else {
            System.out.println("Try again. 1 or 2");
            c = scanner.nextLine();
        }
    }

    switch (c) {
        case "1":
            GameMain.currentLocation = GameMain.Barn;
            GameMain.Barn.enter(player, scanner);
            break;
        case "2":
            GameMain.currentLocation = GameMain.CC;
            GameMain.CC.enter(player, scanner);
            break;
    }

}

}

}
