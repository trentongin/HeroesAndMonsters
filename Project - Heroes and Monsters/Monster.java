public class Monster{
    private int health, attack, speed;
    int minDmg = 1, maxDmg = 30;
    private String monsterName;
    int map_width, map_length;
    int placeX, placeY;

    public Monster(String monsterName, int map_width, int map_length){
        this.monsterName = monsterName;
        this.health = (int)((Math.random() * 100) + 1);
        this.speed = (int)(Math.random() * 4);
        this.map_width = map_width;
        this.map_length = map_length;

        placeX = ((int)(Math.random() * map_width));
        placeY = ((int)(Math.random() * map_length));
    }

    public String getName(){
        return monsterName;
    }

    public int getHealth(){
        return health;
    }

    public int getAttack(){
        return (int)((Math.random() * 30) + 1);
    }
    
    public void takeDmg(int dmgTaken){
        health -= dmgTaken;
    }

    public int getSpeed(){
        return speed;
    }
    
    public double getRunChance(){
        double runChance = 1;
        switch(speed){
            case 0:
                runChance = 0.75;
                break;
            case 1:
                runChance = 0.5;
                break;
            case 2:
                runChance = 0.25;
                break;
            case 3:
                runChance = 0;
                break;
        }
        return runChance;
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

    public String getType(){
        return monsterName + " (" + health + ")";
    }

    public String toString(){
        return "Monster";
    }
}