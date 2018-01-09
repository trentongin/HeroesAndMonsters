public class Potion{
    private String potionName;
    int potency;
    int healValue;
    int placeX, placeY;
    int map_width, map_length;

    public Potion(int potency, int map_width, int map_length){
        this.potency = potency;
        potionName = "";
        healValue = 0;
        switch(potency){
            case 0:
                potionName = "Lesser Potion";
                healValue = 25;
                break;
            case 1:
                potionName = "Mild Potion";
                healValue = 50;
                break;
            case 2:
                potionName = "Great Potion";
                healValue = 75;
                break;
        }
        this.map_width = map_width;
        this.map_length = map_length;
        
        placeX = ((int)(Math.random() * map_width));
        placeY = ((int)(Math.random() * map_length));
    }
    
    public Potion(int potency){
        this.potency = potency;
    }
    
    public void resetCoord(){
        placeX = ((int)(Math.random() * map_width));
        placeY = ((int)(Math.random() * map_length));
    }

    public int getX(){
        return placeX;
    }

    public int getY(){
        return placeY;
    }
    
    public String getType(){
        if(potency == 0){
            return "Lesser Potion";
        }else if(potency == 1){
            return "Medium Potion";
        }else if(potency == 2){
            return "Greater Potion";
        }else{
            return "";
        }
    }
    
    public String toString(){
        return "Potion";
    }
}