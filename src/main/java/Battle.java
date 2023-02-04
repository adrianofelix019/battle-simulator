import java.util.ArrayList;
import java.util.List;

public class Battle {
    private List<Monster> monsters;
    private List<Hero> heroes;
    private boolean turn = true;
    private String winners;

    public Battle() {
        monsters = new ArrayList<>();
        heroes = new ArrayList<>();
    }

    public Battle(List<Hero> heroes, List<Monster> monsters) {
        this.monsters = monsters;
        this.heroes = heroes;
    }

    public void startBattle() {
        System.out.println("===\tSTARTING BATTLE\t===");
        int turnCount = 1;

        while (checkIfTheBattleIsNotOver()) {
            System.out.println("===\tTURN " + turnCount + " \t===");

            if (turn) {
                heroesAttack();
            } else {
                monstersAttack();
            }
            removeDeadCharacter();
            turn = !turn;
            turnCount++;
        }

        if (getHeroes().size() > 0) {
            winners = "HEROES";
        } else {
            winners = "MONSTERS";
        }

        System.out.println("===\t" + winners + " ARE WINNERS!\t===");
    }

    private void removeDeadCharacter() {
        List<Hero> heroesAlive = heroes.stream().filter(hero -> hero.getHp() > 0).toList();
        setHeroes(heroesAlive);

        List<Monster> monstersAlive = monsters.stream().filter(monster -> monster.getHp() > 0).toList();
        setMonsters(monstersAlive);
    }

    private void showInformation() {

    }

    private boolean checkIfTheBattleIsNotOver() {
        return getMonsters().size() > 0 && getHeroes().size() > 0;
    }

    private void heroesAttack() {
        for (Character attacker : getHeroes()) {
            for (Character defender : getMonsters()) {
                attacker.attackOpponent(defender);
            }
        }
    }

    private void monstersAttack() {
        for (Character attacker : getMonsters()) {
            for (Character defender : getHeroes()) {
                attacker.attackOpponent(defender);
            }
        }
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    @Override
    public String toString() {
        return "Battle{" +
                "monsters=" + monsters.toString() +
                ", heroes=" + heroes.toString() +
                '}';
    }
}
