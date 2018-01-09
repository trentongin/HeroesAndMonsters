import java.io.*;
import java.util.*;
public class Driver{
    public static void main(String args[]){
        Scanner inputName = new Scanner(System.in);
        String name;
        while(true){
            System.out.println("What's your name? (Max of 8 characters)");
            name = inputName.nextLine();
            if(name.length() <= 8){
                break;
            }
        }
        Map map = new Map(name, 10, 10);
        System.out.println("\f");
        drive(map);
    }

    public static void drive(Map map){
        map.feed = "";
        Scanner moveInput = new Scanner(System.in);
        while(true){
            System.out.println("\f\n" + map);
            System.out.println(map.getHero() + "'s Health: " + (map.getHero()).getHealth() + "\t\tKills: " + map.deadMonsters);
            System.out.println("\nSURROUNDINGS:" + map.checkSurroundings() + "\n\nDIRECTIONS:\n\t\t\t(W) North\t\t(E) Potion\n(A) West\t\t(S) South\t\t(D) East");
            if((map.getHero()).getHealth() <= 0){
                System.out.println("\nYou are dead!\n");
                break;
            }
            if(map.deadMonsters == 6){
                break;
            }
            String move = moveInput.nextLine();
            move = move.toLowerCase();
            if(move.equals("w")){
                if(map.moveHeroNorth() == true){
                    attackMenu(map, map.getHero(), (Monster)(map.place[map.getHero().getX() - 1][map.getHero().getY()]));
                }
            }else if(move.equals("d")){
                if(map.moveHeroEast() == true){
                    attackMenu(map, map.getHero(), (Monster)(map.place[map.getHero().getX()][map.getHero().getY() + 1]));
                }
            }else if(move.equals("s")){
                if(map.moveHeroSouth() == true){
                    attackMenu(map, map.getHero(), (Monster)(map.place[map.getHero().getX() + 1][map.getHero().getY()]));
                }
            }else if(move.equals("a")){
                if(map.moveHeroWest() == true){
                    attackMenu(map, map.getHero(), (Monster)(map.place[map.getHero().getX()][map.getHero().getY() - 1]));
                }
            }else if(move.equals("suicide")){
                (map.getHero()).setHealth(0);
            }else if(move.equals("e")){
                potionMenu(map);
            }
        }
        if((map.getHero()).getHealth() == 0){
            System.out.println("\fYou have died...");
        }else{
            System.out.println("\f\nYou have defeated all the monsters and have rid this world of its evils." +
                "\n\nCongratulations on finishing this game!");
        }
    }

    public static void potionMenu(Map map){
        int use[] = new int[3];
        Scanner kbInput = new Scanner(System.in);
        while(true){
            System.out.println("\f\nPotion Bag (\"Back\" to return): ");
            for(int i = 1; i <= map.getHero().potions.size(); i++){
                System.out.println("(" + i + ") " + map.getHero().potions.get(i-1).getType());
                use[i-1] = i - 1;
            }
            String input = kbInput.next();
            if(input.toLowerCase().equals("back")){
                break;
            }else if(Integer.parseInt(input) == 1){
                if(map.getHero().potions.size() == 1){
                    map.getHero().usePotion(use[0]);
                    break;
                }
            }else if(Integer.parseInt(input) == 2){
                if(map.getHero().potions.size() == 2){
                    map.getHero().usePotion(use[1]);
                    break;
                }
            }else if(Integer.parseInt(input) == 3){
                if(map.getHero().potions.size() == 3){
                    map.getHero().usePotion(use[2]);
                    break;
                }
            }else{
                continue;
            }
        }
        drive(map);
    }

    public static void attackMenu(Map map, Hero hero, Monster monster){
        System.out.println("\f");
        System.out.println(monster.getName() + " Encountered!\n");
        int turn = 1;
        while(monster.getHealth() > 0 && hero.getHealth() > 0){
            System.out.println("\n----------------- TURN " + turn + " -----------------");
            Scanner kbInput = new Scanner(System.in);
            System.out.println(monster.getName() + "\t\t\t" + hero.getName());
            System.out.println("HP: " + monster.getHealth() + "\t\t\tHP: " + hero.getHealth());
            System.out.println("Atk: " + monster.minDmg + "-" + monster.maxDmg + "\t\tAtk: " + (hero.getWeapon()).getDmgMin() + "-" + (hero.getWeapon()).getDmgMax());
            System.out.println("Speed: " + monster.getSpeed() + "\t\tArmor: " + hero.armor.getName() + " (" + ((hero.armor).getReduction() * 100) + "% Damage Reduction)");

            System.out.println("\n(1) Attack\t(2) Run " + "(" + ((monster.getRunChance() * 100.0)) + "% to run)");
            String input = kbInput.nextLine();

            if(input.equals("1")){
                hero.takeDmg(monster.getAttack());
                monster.takeDmg(hero.dealDmg());
                turn++;
            }else if(input.equals("2")){
                double run = Math.random();
                if(run > monster.getRunChance()){
                    hero.takeDmg(monster.getAttack());
                    System.out.println("You could not run away!");
                    turn++;
                }else{
                    break;
                }
            }
        }
        if(monster.getHealth() <= 0){
            map.place[monster.getX()][monster.getY()] = null;
            map.deadMonsters++;
        }
        if(hero.getHealth() < 0){
            hero.setHealth(0);
        }

        drive(map);
    }
}