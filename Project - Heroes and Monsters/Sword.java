public class Sword{
    private String swordName;
    int dmgMin, dmgMax;
    int placeX, placeY;
    int map_width, map_length;
    
    public Sword(int map_width, int map_length, String swordName, int dmgMin, int dmgMax){
        this.swordName = swordName;
        this.map_width = map_width;
        this.map_length = map_length;
        this.dmgMin = dmgMin;
        this.dmgMax = dmgMax;
        
        placeX = ((int)(Math.random() * map_width));
        placeY = ((int)(Math.random() * map_length));
    }
    
    public Sword(String swordName, int dmgMin, int dmgMax){
        this.swordName = swordName;
        this.dmgMin = dmgMin;
        this.dmgMax = dmgMax;
    }
    
    public int getDmgMin(){
        return dmgMin;
    }
    
    public int getDmgMax(){
        return dmgMax;
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
    
    public String getName(){
        return swordName + " (" + dmgMin + "-" + dmgMax + ")";
    }
    
    public String toString(){
        return "Weapon";
    }
}