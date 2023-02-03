import java.util.Scanner;

public class Application {
    private Battle battle = new Battle();

    public void showMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("===\tBATTLE SIMULATOR MENU\t===");
        System.out.println("[1] - CREATE A HERO");
        System.out.println("[2] - CREATE A MONSTER");
        System.out.println("[3] - LIST CHARACTERS CREATED");
        System.out.println("[4] - START BATTLE");
        System.out.println("[4] - EXIT");
        System.out.print("OPTION: ");
        String stringOption = in.next();

        try {
            int option = Integer.parseInt(stringOption);

            switch (option) {
                case 1:
                    createHero();
                    break;
                case 2:
                    createMonster();
                    break;
                case 3:
                    listCharacters();
            }

        } catch (NumberFormatException e) {
            cleanConsole();
            System.out.println("INVALID OPTION, PLEASE TRY AGAIN.");
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
        battle.getHeroes().add(newHero);
        showMenu();
    }

    private void createMonster() {
        Monster newMonster = (Monster) getCharacterInformation("MONSTER");
        battle.getMonsters().add(newMonster);
        showMenu();
    }

    private Character getCharacterInformation(String kind) {
        Scanner in = new Scanner(System.in);
        System.out.print(kind + "'S NAME: ");
        String name = in.next();
        System.out.println("SET " + kind + "'S HP: ");
        int hp = in.nextInt();
        System.out.println("SET " + kind + "'S ATTACK: ");
        int attack = in.nextInt();
        System.out.println("SET " + kind + "'S DEFENSE: ");
        int defense = in.nextInt();
        System.out.println("SET " + kind + "'S CRITICAL CHANCE (BETWEEN 0 AND 100): ");
        int criticalChance = in.nextInt();

        if (kind.equalsIgnoreCase("monster"))
            return new Monster(name, hp, attack, defense, criticalChance);
        else
            return new Hero(name, hp, attack, defense, criticalChance);
    }

    private void cleanConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
