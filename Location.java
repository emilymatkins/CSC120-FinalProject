import java.util.Scanner;

public class Location {
    
    private String name; 
    private String description;
    private Item item;
    private boolean itemStatus;


    public Location(String name, String description, Item item){
        this.name = name;
        this.description = description;
        this.item = item;
        this.itemStatus = true;
    }
    

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public Item getItem(){
        return item;
    }

    public void enter(Player player, Scanner scanner){

    }

    public boolean commands(Player player, String commands, Scanner scanner){
    

        switch (commands) {
            case "help":
                System.out.println("----------------");
                System.out.println("Command Options:");
                System.out.println("----------------");
                System.out.println("'drop' - then specific which item");
                System.out.println("'check recipe'");
                System.out.println("'open backpack'");
                System.out.println("\nReturn to game and follow previous prompts");
                return true;

            case "drop":
                System.out.println("Which item?");
                String item = scanner.nextLine();
                player.drop(item);
                System.out.println("\nReturn to game and follow previous prompts");
                return true;


            case "check recipe":
            player.checkRecipe();
            System.out.println("\nReturn to game and follow previous prompts");
            return true;

            case "open backpack":
            player.openBackpack();
            System.out.println("\nReturn to game and follow previous prompts");
            return true;
        }
        return false;
    }

    public void itemStatus(){
        itemStatus = false;
    }

    public boolean getItemStatus(){
        return itemStatus;
    }
}
