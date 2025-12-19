import java.util.Scanner;

public class CC extends Location {
    
public CC(){
    super("CC",
    "Welcome to the Julia Child Campus Center", 
    new Item("Pecans", false));
}

@Override
public void enter(Player player, Scanner scanner){

    if (GameMain.CC.getItemStatus() == true){
        System.out.println("\n" + getDescription() + "\nYou look around and see pecans scattered across the floor");
        System.out.println("1. Head down Green St. to Tyler ");
        System.out.println("2. Crawl around and collect the pecans");
        System.out.println("3. Hike over to Mountain Neighborhood to explore Nogi");
        System.out.println("4. Go bake in Hubbard");

        System.out.println("Enter 1, 2, 3, or 4 ");
        String choice = scanner.nextLine();

        while (!choice.equals("1") &&
                !choice.equals("2") &&
                !choice.equals("3") &&
                !choice.equals("4")) {
                    if (super.commands(player, choice, scanner) == true) {
                        choice = scanner.nextLine();
                    } else {
                        System.out.println("Try again. 1, 2, 3, or 4");
                        choice = scanner.nextLine();
                    }
        }

        switch (choice) {
            case "1":
                GameMain.currentLocation = GameMain.Tyler;
                GameMain.Tyler.enter(player, scanner);
                break;

            case "2":
                player.pickUp(GameMain.CC.getItem());
                System.out.println("Where to now?");
                System.out.println("1. Explore Tyler");
                System.out.println("2. Explore Nogi");

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
                        GameMain.currentLocation = GameMain.Tyler;
                        GameMain.Tyler.enter(player, scanner);
                        break;

                    case "2":
                        GameMain.currentLocation = GameMain.Nogi;
                        GameMain.Nogi.enter(player, scanner);
                }
                break;

            case "3":
                GameMain.currentLocation = GameMain.Nogi;
                GameMain.Nogi.enter(player, scanner);
                break;

            case "4":
                GameMain.currentLocation = GameMain.Hubbard;
                GameMain.Hubbard.enter(player, scanner);
                break;

        }
    } else {
        System.out.println("\n" + getDescription());
        System.out.println("1. Head down Green St. to Tyler ");
        System.out.println("2. Hike over to Mountain Neighborhood to explore Nogi");
        System.out.println("3. Go bake at Hubbard");

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
                GameMain.currentLocation = GameMain.Tyler;
                GameMain.Tyler.enter(player, scanner);
                break;

            case "2":
                GameMain.currentLocation = GameMain.Nogi;
                GameMain.Nogi.enter(player, scanner);
                break;

            case "3":
                GameMain.currentLocation = GameMain.Hubbard;
                GameMain.Hubbard.enter(player, scanner);
                break;
        }
}

}

}
