import java.util.Scanner;

public class Hubbard extends Location{
    
    public Hubbard(){
        super("Hubbard", 
        "Welcome to Hubbard Kitchen", null);
    }

    @Override
    public void enter(Player player, Scanner scanner){

        System.out.println("There's a beautiful workstation if you are ready to bake");
        System.out.println("Are you ready?");
        System.out.println("Enter yes or no");
        String choice = scanner.nextLine();

        while (!choice.equalsIgnoreCase("yes") &&
                !choice.equalsIgnoreCase("no")) {
            if (super.commands(player, choice, scanner) == true) {
                choice = scanner.nextLine();
            } else {
                System.out.println("Try again. yes or no");
                choice = scanner.nextLine();
            }
        }

        switch (choice) {
            case "yes":
                System.out.println("\nLets check if you have all the ingredients in the recipe");
                int num = 0;
                for(Item b : player.getBackpack()){
                    for (Item r : player.getRecipe()){
                        if (b.getName().equals(r.getName())){
                            num++;
                        } 
                    }
                }
                if (num == 3){
                    System.out.println("Nice job collecting all the needed ingredients");
                    System.out.println("Over the next 5 hours, you poured you heart into the recipe");
                    System.out.println("You made a delicous Sin Cake saving Julia Child Day!!!");
                    System.out.println("\n");
                    System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣞⠋⠉⠀⠀⠀⠀\n" + //
                                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡏⠀⠋⠘⡇⠀⠀⠀⠀⠀\n" + //
                                                "⠀⠀⠀⠀⠀⠀⠀⣠⡴⢿⡻⠦⠤⢞⣉⡷⢦⣀⠀⠀\n" + //
                                                "⠀⠀⠀⠀⢀⡴⠚⠁⠀⠀⣧⡤⠤⠾⠀⠀⣀⣈⣷⣦\n" + //
                                                "⠀⢀⡴⠞⣁⣀⣀⣠⡤⠤⠤⠶⠒⠛⠉⠉⠉⠀⠀⢸\n" + //
                                                "⡾⠛⠛⠉⠉⠉⠁⠀⠀⠀⠀⠀⢀⣠⣄⡀⣴⠖⠢⣼\n" + //
                                                "⡇⣠⣤⡀⢠⠴⠲⠤⠴⠋⢹⡆⡟⠀⣸⣇⣇⣤⡤⣼\n" + //
                                                "⡿⠁⠀⣇⣼⣀⣠⡤⠴⠶⠞⠧⠟⠉⠉⠉⠀⠀⠀⢸\n" + //
                                                "⡟⠛⠉⠉⠀⠀⠀⠀⠀⢀⣀⣠⣤⡤⠴⠖⠒⠚⠛⠉\n" + //
                                                "⣧⡤⠤⠴⠶⠒⠛⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
                return;
                } else {
                    System.out.println("You realize you DONT have the right ingredients");
                    System.out.println("You make your way back to the CC");
                    GameMain.currentLocation = GameMain.CC;
                    GameMain.CC.enter(player, scanner);
                }
                break;
        
            case "no":
                System.out.println("You head back to the CC");
                GameMain.currentLocation = GameMain.CC;
                GameMain.CC.enter(player, scanner);
                break;
        }
    }
}
