import java.util.Scanner;

public class Application {
    private final Battle battle = new Battle();

    public void showMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("===\tBATTLE SIMULATOR MENU\t===");
        System.out.println("[1] - CREATE A HERO");
        System.out.println("[2] - CREATE A MONSTER");
        System.out.println("[3] - LIST CHARACTERS CREATED");
        System.out.println("[4] - START BATTLE");
        System.out.println("[5] - EXIT");
        System.out.print("OPTION: ");
        String stringOption = in.next();

        try {
            int option = Integer.parseInt(stringOption);

            switch (option) {
                case 1 -> createHero();
                case 2 -> createMonster();
                case 3 -> listCharacters();
                case 4 -> startBattle();
                case 5 -> endApplication();
            }

        } catch (NumberFormatException e) {
            System.out.println("INVALID OPTION, PLEASE TRY AGAIN.");
            showMenu();
        }
    }

    private void endApplication() {
        System.out.println("===\tEXITING\t===");
    }

    private void startBattle() {
        boolean isPossibleToStart =
                battle.getHeroes().size() > 0 && battle.getMonsters().size() > 0;

        if (isPossibleToStart) {
            battle.startBattle();
        } else {
            System.out.println("IS NOT POSSIBLE TO START THE BATTLE.");
            showMenu();
        }
    }

    private void listCharacters() {
        System.out.println("===\tHEROES\t===");
        for (Hero hero : battle.getHeroes()) {
            System.out.println(hero);
        }

        System.out.println("===\tMONSTERS\t===");
        for (Monster monster : battle.getMonsters()) {
            System.out.println(monster);
        }

        showMenu();
    }

    private void createHero() {
        Hero newHero = (Hero) getCharacterInformation("HERO");
        battle.addHero(newHero);
        showMenu();
    }

    private void createMonster() {
        Monster newMonster = (Monster) getCharacterInformation("MONSTER");
        battle.addMonster(newMonster);
        showMenu();
    }

    private Character getCharacterInformation(String kind) {
        Scanner in = new Scanner(System.in);
        int hp;
        int attack;
        int defense;
        int criticalChance;
        System.out.print(kind + "'S NAME: ");
        String name = in.next();

        do {
            System.out.print("SET " + kind + "'S HP: ");
            hp = in.nextInt();

            if (hp <= 0) {
                System.out.println("INVALID HP, TRY AGAIN!");
            }
        } while (hp <= 0);

        do {
            System.out.print("SET " + kind + "'S ATTACK: ");
            attack = in.nextInt();

            if (attack <= 0) {
                System.out.println("INVALID ATTACK, TRY AGAIN!");
            }
        } while (attack <= 0);

        do {
            System.out.print("SET " + kind + "'S DEFENSE: ");
            defense = in.nextInt();

            if (defense <= 0) {
                System.out.println("INVALID DEFENSE, TRY AGAIN!");
            }
        } while (defense <= 0);

        do {
            System.out.print("SET " + kind + "'S CRITICAL CHANCE (BETWEEN 0 AND 100): ");
            criticalChance = in.nextInt();

            if (criticalChance < 0 || criticalChance > 100) {
                System.out.println("INVALID CRITICAL CHANCE, TRY AGAIN!");
            }
        } while (criticalChance < 0 || criticalChance > 100);

        if (kind.equalsIgnoreCase("monster"))
            return new Monster(name, hp, attack, defense, criticalChance);
        else
            return new Hero(name, hp, attack, defense, criticalChance);
    }
}
