public class Item {
    
    private String name;
    private Boolean inRecipe;

    public Item(String name, Boolean inRecipe){
        this.name = name;
        this.inRecipe = true;
    }

    public String getName(){
        return name;
    }
}
