import java.util.*;
public class Map{
    int map_width, map_length;
    ArrayList<Object> objects = new ArrayList<Object>();
    Object place[][];
    private Hero player;
    String feed;
    int deadMonsters = 0;

    public Map(String playerName, int map_width, int map_length){
        this.map_width = map_width;
        this.map_length = map_length;
        place = new Object[map_width][map_length];

        // Adds Hero player to index 0
        player = new Hero(playerName, map_width, map_length, deadMonsters);
        objects.add(player);
        while(true){
            if(check(player.getX(), player.getY()) == false){
                player.resetCoord();
            }else{
                break;
            }
        }
        place[player.placeX][player.placeY] = (Hero)player;

        // Adds monster #1 (Zombie) to index 1
        Monster zombie = new Monster("Zombie", map_width, map_length);
        objects.add(zombie);
        while(true){
            if(check(zombie.getX(), zombie.getY()) == false){
                zombie.resetCoord();
            }else{
                break;
            }
        }
        place[zombie.placeX][zombie.placeY] = (Monster)zombie;

        // Adds monster #2 (Vampire) to index 2
        Monster vampire = new Monster("Vampire", map_width, map_length);
        objects.add(vampire);
        while(true){
            if(check(vampire.getX(), vampire.getY()) == false){
                vampire.resetCoord();
            }else{
                break;
            }
        }
        place[vampire.placeX][vampire.placeY] = (Monster)vampire;

        // Adds monster #3 (Skeleton) to index 3
        Monster alien = new Monster("Alien", map_width, map_length);
        objects.add(alien);
        while(true){
            if(check(alien.getX(), alien.getY()) == false){
                alien.resetCoord();
            }else{
                break;
            }
        }
        place[alien.getX()][alien.getY()] = (Monster)alien;

        // Adds monster #4 (Goomba™) to index 4
        Monster goomba = new Monster("Goomba™", map_width, map_length);
        objects.add(goomba);
        while(true){
            if(check(goomba.getX(), goomba.getY()) == false){
                goomba.resetCoord();
            }else{
                break;
            }
        }
        place[goomba.placeX][goomba.placeY] = (Monster)goomba;

        // Adds monster #5 (Slime) to index 5
        Monster slime = new Monster("Slime", map_width, map_length);
        objects.add(slime);
        while(true){
            if(check(slime.getX(), slime.getY()) == false){
                slime.resetCoord();
            }else{
                break;
            }
        }
        place[slime.placeX][slime.placeY] = (Monster)slime;

        // Adds monster #6 (Dragon) to index 6
        Monster dragon = new Monster("Dragon", map_width, map_length);
        objects.add(dragon);
        while(true){
            if(check(dragon.getX(), dragon.getY()) == false){
                dragon.resetCoord();
            }else{
                break;
            }
        }
        place[dragon.placeX][dragon.placeY] = (Monster)dragon;

        // Adds Sword broadsword to index 7
        Sword broadsword = new Sword(map_width, map_length, "Broadsword", 20, 40);
        objects.add(broadsword);
        while(true){
            if(check(broadsword.getX(), broadsword.getY()) == false){
                broadsword.resetCoord();
            }else{
                break;
            }
        }
        place[broadsword.placeX][broadsword.placeY] = (Sword)broadsword;

        // Adds Armor bronzeArmor to index 8
        Armor bronzeArmor = new Armor("Bronze Armor", 1/3, map_width, map_length);
        objects.add(bronzeArmor);
        while(true){
            if(check(bronzeArmor.getX(), bronzeArmor.getY()) == false){
                bronzeArmor.resetCoord();
            }else{
                break;
            }
        }
        place[bronzeArmor.placeX][bronzeArmor.placeY] = (Armor)bronzeArmor;

        // Adds Potion healthPotion1 to index 9
        Potion healthPotion1 = new Potion(0, map_width, map_length);
        objects.add(healthPotion1);
        while(true){
            if(check(healthPotion1.getX(), healthPotion1.getY()) == false){
                healthPotion1.resetCoord();
            }else{
                break;
            }
        }
        place[healthPotion1.getX()][healthPotion1.getY()] = (Potion)healthPotion1;

        // Adds Potion healthPotion2 to index 10
        Potion healthPotion2 = new Potion(1, map_width, map_length);
        objects.add(healthPotion2);
        while(true){
            if(check(healthPotion2.getX(), healthPotion2.getY()) == false){
                healthPotion2.resetCoord();
            }else{
                break;
            }
        }
        place[healthPotion2.getX()][healthPotion2.getY()] = (Potion)healthPotion2;

        // Adds Potion healthPotion3 to index 11
        Potion healthPotion3 = new Potion(2, map_width, map_length);
        objects.add(healthPotion3);
        while(true){
            if(check(healthPotion3.getX(), healthPotion3.getY()) == false){
                healthPotion3.resetCoord();
            }else{
                break;
            }
        }
        place[healthPotion3.getX()][healthPotion3.getY()] = (Potion)healthPotion3;

        // Adds Townsperson villager1 to index 12
        Townsperson villager1 = new Townsperson("I swear I saw some bronze scrap lying 'round here somewhere!\n\tPoor adventurers, if you ask me!",
                "Here, take this armor!", map_width, map_length, 2, deadMonsters, new Armor("Royal Guard's Plate", 1/2));
        objects.add(villager1);
        while(true){
            if(check(villager1.getX(), villager1.getY()) == false){
                villager1.resetCoord();
            }else{
                break;
            }
        }
        place[villager1.getX()][villager1.getY()] = (Townsperson)villager1;

        // Adds Townsperson villager2 to index 13
        Townsperson villager2 = new Townsperson("My family had lost a treasured sword here, but it was generations ago.", 
                "You're a formidable warrior! Here, take this sword. It's too dangerous to go alone.", map_width, map_length, 4, 
                deadMonsters, new Sword("Spiteblade", 50, 60));
        objects.add(villager2);
        while(true){
            if(check(villager2.getX(), villager2.getY()) == false){
                villager2.resetCoord();
            }else{
                break;
            }
        }
        place[villager2.getX()][villager2.getY()] = (Townsperson)villager2;
    }

    public boolean check(int Xpos, int Ypos){
        if(place[Xpos][Ypos] != null){
            return false;
        }else{
            return true;
        }
    }

    public String checkSurroundings(){
        String n = "", e = "", s = "", w = "";
        Object northObj, eastObj, southObj, westObj;
        // North Object
        if(player.getX() - 1 >= 0){
            northObj = place[player.getX() - 1][player.getY()];
            if(northObj == (Integer)0){
                n = "None";
            }else{
                if(northObj.getClass().isInstance(new Monster(null, 0, 0))){
                    n = "" + ((Monster)northObj).getType();
                }else if(northObj.getClass().isInstance(new Potion(0, 0, 0))){
                    n = "" + ((Potion)northObj).getType();
                }else{
                    n = "" + northObj;
                }
            }
        }else{
            n = "Wall";
        }
        // East Object
        if(player.getY() + 1 < map_length){
            eastObj = place[player.getX()][player.getY() + 1];
            if(eastObj == (Integer)0){
                e = "None";
            }else{
                if(eastObj.getClass().isInstance(new Monster(null, 0, 0))){
                    e = "" + ((Monster)eastObj).getType();
                }else if(eastObj.getClass().isInstance(new Potion(0, 0, 0))){
                    e = "" + ((Potion)eastObj).getType();
                }else{
                    e = "" + eastObj;
                }
            }
        }else{
            e = "Wall";
        }
        // South Object
        if(player.getX() + 1 < map_width){
            southObj = place[player.getX() + 1][player.getY()];
            if(southObj == (Integer)0){
                s = "None";
            }else{
                if(southObj.getClass().isInstance(new Monster(null, 0, 0))){
                    s = "" + ((Monster)southObj).getType();
                }else if(southObj.getClass().isInstance(new Potion(0, 0, 0))){
                    s = "" + ((Potion)southObj).getType();
                }else{
                    s = "" + southObj;
                }
            }
        }else{
            s = "Wall";
        }
        // West Object
        if(player.getY() - 1 >= 0){
            westObj = place[player.getX()][player.getY() - 1];
            if(westObj == (Integer)0){
                w = "None";
            }else{
                if(westObj.getClass().isInstance(new Monster(null, 0, 0))){
                    w = "" + ((Monster)westObj).getType();
                }else if(westObj.getClass().isInstance(new Potion(0, 0, 0))){
                    w = "" + ((Potion)westObj).getType();
                }else{
                    w = "" + westObj;
                }
            }
        }else{
            w = "Wall";
        }

        return "\n\t\t\tNorth: " + n + "\nWest: " + w + "\t\tSouth: " + s + "\t\tEast: " + e;
    }

    public Hero getHero(){
        return (Hero)player;
    }

    public boolean moveHeroNorth(){
        boolean isMonster = false;
        if(player.placeX - 1 >= 0){
            for(int i = 0; i < map_width; i++){
                for(int r = 0; r < map_length; r++){
                    if(place[i][r] == player){
                        place[i][r] = null;
                    }
                }
            }
            if((place[player.getX() - 1][player.getY()].getClass()).isInstance(new Monster(null, 0, 0))){
                isMonster = true;
            }else{
                player.moveNorth();
                player.interact(place[player.getX()][player.getY()], deadMonsters);
                setFeed(place[player.getX()][player.getY()]);
            }
        }
        place[player.getX()][player.getY()] = (Hero)player;
        return isMonster;
    }

    public boolean moveHeroEast(){
        boolean isMonster = false;
        if(player.placeY + 1 < map_length){
            for(int i = 0; i < map_width; i++){
                for(int r = 0; r < map_length; r++){
                    if(place[i][r] == player){
                        place[i][r] = null;
                    }
                }
            }
            if((place[player.getX()][player.getY() + 1].getClass()).isInstance(new Monster(null, 0, 0))){
                isMonster = true;
            }else{
                player.moveEast();
                player.interact(place[player.getX()][player.getY()], deadMonsters);
                setFeed(place[player.getX()][player.getY()]);
            }
        }
        place[player.getX()][player.getY()] = (Hero)player;
        return isMonster;
    }

    public boolean moveHeroSouth(){
        boolean isMonster = false;
        if(player.placeX + 1 < map_width){
            for(int i = 0; i < map_width; i++){
                for(int r = 0; r < map_length; r++){
                    if(place[i][r] == player){
                        place[i][r] = null;
                    }
                }
            }
            if((place[player.getX() + 1][player.getY()].getClass()).isInstance(new Monster(null, 0, 0))){
                isMonster = true;
            }else{
                player.moveSouth();
                player.interact(place[player.getX()][player.getY()], deadMonsters);
                setFeed(place[player.getX()][player.getY()]);
            }
        }
        place[player.getX()][player.getY()] = (Hero)player;
        return isMonster;
    }

    public boolean moveHeroWest(){
        boolean isMonster = false;
        if(player.placeY - 1 >= 0){
            for(int i = 0; i < map_width; i++){
                for(int r = 0; r < map_length; r++){
                    if(place[i][r] == player){
                        place[i][r] = null;
                    }
                }
            }
            if((place[player.getX()][player.getY() - 1].getClass()).isInstance(new Monster(null, 0, 0))){
                isMonster = true;
            }else{
                player.moveWest();
                player.interact(place[player.getX()][player.getY()], deadMonsters);
                setFeed(place[player.getX()][player.getY()]);
            }
        }
        place[player.getX()][player.getY()] = (Hero)player;
        return isMonster;
    }

    public void setFeed(Object item){
        if(item.getClass().isInstance(new Monster(null, 0, 0))){
            feed = "Attacked Monster!";
        }else if(item.getClass().isInstance(new Sword(0, 0, null, 0, 0)) || item.getClass().isInstance(new Sword(null, 0, 0))){
            feed = "Picked up Unknown Weapon!";
        }else if(item.getClass().isInstance(new Armor(null, 0)) || item.getClass().isInstance(new Armor(null, 0, 0, 0))){
            feed = "Picked up Unknown Armor";
        }else if(item.getClass().isInstance(new Potion(0, 0, 0))){
            feed = "Picked up Unknown Potion";
        }else if(item.getClass().isInstance(new Townsperson(null, null, 0, 0, 0, 0, null))){
            feed = ((Townsperson)item).getQuote(deadMonsters);
        }else{
            feed = "";
        }
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < map_width; i++){
            for(int r = 0; r < map_length; r++){
                if(place[i][r] == null){
                    place[i][r] = 0;
                }
            }
        }
        for(int x = 0; x < map_width; x++){
            for(int y = 0; y < map_length; y++){
                s = s + place[x][y] + "\t";
            }
            if(x == 0){
                s = s + "\tInventory";
            }
            if(x == 1){
                s = s + "\tArmor: " + player.armor.getName();
            }
            if(x == 2){
                s = s + "\tSword: " + player.weapon.getName();
            }
            if(x == 3 && player.potions.size() > 0){
                s = s + "\t" + player.potions.get(0).getType();
            }
            if(x == 4 && player.potions.size() > 1){
                s = s + "\t" + player.potions.get(1).getType();
            }
            if(x == 5 && player.potions.size() > 2){
                s = s + "\t" + player.potions.get(2).getType();
            }
            s = s + "\n";
        }
        s = s + "\nFeed: " + feed;
        return s;
    }
}