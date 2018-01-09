import java.util.*;
public class Hero{
    private String name;
    private int health, damageMin, damageMax;
    Sword weapon;
    Armor armor;
    boolean hasWeapon = false, hasArmor = false;
    ArrayList<Potion> potions = new ArrayList<Potion>(3);
    int map_width, map_length;
    int placeX, placeY;
    private int deadMonsters;

    public Hero(String name, int map_width, int map_length, int deadMonsters){
        health = 100;
        this.map_width = map_width;
        this.map_length = map_length;
        this.name = name;
        this.deadMonsters = deadMonsters;
        equipSword(new Sword("Dagger", 10, 30));
        equipArmor(new Armor("Leather Armor", 0));

        placeX = ((int)(Math.random() * map_width));
        placeY = ((int)(Math.random() * map_length));
    }

    public Armor getArmor(){
        return armor;
    }

    public Sword getWeapon(){
        return weapon;
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int newHealth){
        health = newHealth;
    }

    public int getX(){
        return placeX;
    }

    public int getY(){
        return placeY;
    }

    public void moveEast(){
        placeY += 1;
    }

    public void moveNorth(){
        placeX -= 1;
    }

    public void moveSouth(){
        placeX += 1;
    }

    public void moveWest(){
        placeY -= 1;
    }

    public void resetCoord(){
        placeX = ((int)(Math.random() * map_width));
        placeY = ((int)(Math.random() * map_length));
    }

    public int dealDmg(){
        // Determines dmg value to deal
        int dmgDealt;
        dmgDealt = (int)(Math.random() * (weapon.dmgMax - weapon.dmgMin)) + weapon.dmgMin;
        return dmgDealt;
    }

    public void interact(Object item, int deadmonsters){
        if(item.getClass().isInstance(new Sword(0, 0, null, 0, 0)) || item.getClass().isInstance(new Sword(null, 0, 0))){
            equipSword((Sword)item);
        }else if(item.getClass().isInstance(new Armor(null, 0)) || item.getClass().isInstance(new Armor(null, 0, 0, 0))){
            equipArmor((Armor)item);
        }else if(item.getClass().isInstance(new Potion(0, 0, 0))){
            takePotion((Potion)item);
        }else if(item.getClass().isInstance(new Townsperson(null, null, 0, 0, 0, 0, null))){
            if(deadmonsters >= ((Townsperson)item).getThreshold()){
                fromNPC((Townsperson)item);
            }
        }
    }

    public void takeDmg(int dmg){
        int newDmg = (int)(dmg - armor.reducedDmg(dmg));
        health -= newDmg;
    }

    public void equipSword(Sword weapon){
        this.weapon = weapon;
        hasWeapon = true;
    }

    public void takePotion(Potion potion){
        if(potions.size() < 3){
            potions.add(potion);
        }
    }

    public void equipArmor(Armor armor){
        this.armor = armor;
        hasArmor = true;
    }

    public void usePotion(int num){
        health += potions.get(num).healValue;
        if(health > 100){
            health = 100;
        }
        potions.remove(num);
    }

    public void fromNPC(Townsperson npc){
        if(((npc.itemHeld).getClass()).isInstance(new Sword(0, 0, null, 0, 0)) || ((npc.itemHeld).getClass()).isInstance(new Sword(null, 0, 0))){
            Sword newWeapon = (Sword)npc.itemHeld;
            equipSword(newWeapon);
        }
        if(((npc.itemHeld).getClass()).isInstance(new Armor(null, 0)) || ((npc.itemHeld).getClass()).isInstance(new Armor(null, 0, 0, 0))){
            Armor newArmor = (Armor)npc.itemHeld;
            equipArmor(newArmor);
        }
    }

    public String toString(){
        return name;
    }
}