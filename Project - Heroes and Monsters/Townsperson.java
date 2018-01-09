public class Townsperson{
    private String quote1, quote2;
    private int entityType = 2;
    int map_width, map_length;
    int placeX, placeY;
    private int deadMonsters, threshold;
    Object itemHeld;

    public Townsperson(String quote1, String quote2, int map_width, int map_length, int threshold, int deadMonsters, Object itemHeld){
        this.quote1 = quote1;
        this.quote2 = quote2;
        this.threshold = threshold;
        this.deadMonsters = deadMonsters;
        this.itemHeld = itemHeld;

        this.map_width = map_width;
        this.map_length = map_length;

        placeX = ((int)(Math.random() * map_width));
        placeY = ((int)(Math.random() * map_length));
    }

    public String getQuote(int deadMonsters){
        if(deadMonsters >= threshold){
            return quote2;
        }else{
            return quote1;
        }
    }

    public int getThreshold(){
        return threshold;
    }

    public Object getItem(){
        return itemHeld;
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

    public String toString(){
        return "NPC";
    }
}