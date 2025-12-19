import java.util.Scanner;

public class GameMain {

public static CC CC;
public static Tyler Tyler;
public static Nogi Nogi;
public static Barn Barn;
public static Hubbard Hubbard;
public static Location currentLocation;

    public static void main(String[] args) {
        Player player = new Player("Emily");
        Scanner userInput = new Scanner(System.in);
        
        System.out.println(" ----------------------------------------");
        System.out.println("|                                        |");
        System.out.println("|         Saving Julia Child Day         |");
        System.out.println("|                                        |");
        System.out.println(" ----------------------------------------");

        System.out.println("\n");
        System.out.println("You're a student at Smith College. \nTOMORROW is the long awaited Julia Child Day celebration");
        System.out.println("As you excitedly examine the menu to plan your moves, \nyou notice a terrible problem:");
        System.out.println("Julia Child's signature Sin Cake is missing from the menu.");
        System.out.println("\n");
        System.out.println("Knowing the great uproar this error would cause amongst students,\nyou decide to take matters into your own hands");
        System.out.println("\n");
        System.out.println("Your Task: Traverse campus to FIND INGREDIENTS for Julia's signature dish\nTo save the day, rendezvous at Hubbard and assemble the cake");
        System.out.println("\nIf you're ever stuck, just call for 'help'\n");

        CC = new CC();
        Tyler = new Tyler();
        Nogi = new Nogi();
        Barn = new Barn();
        Hubbard = new Hubbard();

        currentLocation = CC;
        CC.enter(player, userInput); 

        

    }
}