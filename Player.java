import java.util.ArrayList;

public class Player {
    
    private ArrayList<Item> backpack;
    private String name;
    private static ArrayList<Item> recipe;

    public Player(String name){
        this.name = name;
        this.backpack = new ArrayList<>();
        this.recipe = new ArrayList<>();
        recipe.add(new Item("Sugar", true));
        recipe.add(new Item("Dark Chocolate", true));
        recipe.add(new Item("Milk", true));
    }

    public void pickUp(Item i){
        if (backpack.size() == recipe.size()){
            System.out.println("\nBackpack is bursting from the seams. There is no more room for " + i.getName());
        } else {
            backpack.add(i);
            GameMain.currentLocation.itemStatus();
            System.out.println("\n" + i.getName() + " was put in backpack!!");
        }
    }

public ArrayList<Item> getBackpack(){
    return backpack;
}

public ArrayList<Item> getRecipe(){
    return recipe;
}

    public void drop(String name){
        boolean inB = false;
        for(int i = 0 ; i < backpack.size() ; i++){
            Item item = backpack.get(i);
            
            if(name.equalsIgnoreCase(item.getName())){
                inB = true;
                for(Item r: recipe){
                    if(name.equalsIgnoreCase(r.getName())){
                        System.out.println("Cant drop item because its in the recipe");
                        return;
                    } 
                }
                backpack.remove(i);
                System.out.println(name + " was removed");
                return;
                }
            }  
        if (!inB){
            System.out.println(name + " is not in backpack");
        }
    }

    public void openBackpack(){
        if (backpack.isEmpty()){
            System.out.println("\nYour backpack is empty! You must find the ingredients to save Julia Child Day.");
        } 
        else {
            System.out.println("\nBackpack:");
            for (Item i : backpack){
                System.out.println((i.getName()));
            }
        } 
    }

    public void checkRecipe(){
        System.out.println("\nChoclate Sin Cake Recipe:");
        for (Item i : recipe){
            System.out.println(i.getName());
        }
    }
}
