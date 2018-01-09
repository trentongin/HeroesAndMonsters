public class Armor{
    private String armorName;
    double armorReduction;
    int newDmg;
    int placeX, placeY;
    int map_width, map_length;

    public Armor(String name, double armorReduction, int map_width, int map_length){
        armorName = name;
        this.armorReduction = armorReduction;
        this.map_width = map_width;
        this.map_length = map_length;

        placeX = ((int)(Math.random() * map_width));
        placeY = ((int)(Math.random() * map_length));
    }
    
    public Armor(String name, double armorReduction){
        armorName = armorName;
        this.armorReduction = armorReduction;
    }
    
    public double getReduction(){
        return armorReduction;
    }

    public Armor(String name, int armorReduction){
        armorName = name;
        this.armorReduction = armorReduction;
    }
    
    public double reducedDmg(int dmg){
        return (dmg * armorReduction);
    }

    public int getX(){
        return placeX;
    }

    public int getY(){
        return placeY;
    }

    public void resetCoord(){
        placeX = ((int)(Math.random() * map_width));
        placeY = ((int)(Math.random() * map_length));
    }

    public String getName(){
        return armorName;
    }

    public String toString(){
        return "Armor";
    }
}