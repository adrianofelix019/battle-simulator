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
            createHero();
        } catch (NumberFormatException e) {
            cleanConsole();
            System.out.println("INVALID OPTION, PLEASE TRY AGAIN.");
            showMenu();
        }
    }

    private void createHero() {
        Scanner in = new Scanner(System.in);
        System.out.print("HERO'S NAME: ");
        String name = in.next();
        System.out.println("SET HERO'S HP: ");
        int hp = in.nextInt();
        System.out.println("SET HERO'S ATTACK: ");
        int attack = in.nextInt();
        System.out.println("SET HERO'S DEFENSE: ");
        int defense = in.nextInt();
        System.out.println("SET HERO'S CRITICAL CHANCE (BETWEEN 0 AND 100): ");
        int criticalChance = in.nextInt();
        Hero hero = new Hero(name, hp, attack, defense, criticalChance);
        battle.addHero(hero);
        in.close();
        showMenu();
    }

    private void cleanConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
