import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Battle {
    private Monster[] monsters;
    private Hero[] heroes;
    private boolean turn = true;
    private String winners;

    public Battle(Hero[] heroes, Monster[] monsters) {
        this.monsters = monsters;
        this.heroes = heroes;
    }

    public void startBattle() {
        System.out.println("===\tSTARTING BATTLE\t===");
        int turnCount = 1;
        boolean isTheBattleNotOver = checkIfTheBattleIsOver();

        while (isTheBattleNotOver) {
            System.out.println("===\tTURN " + turnCount + " \t===");

            if (turn) {
                heroesAttack();
            } else {
                monstersAttack();
            }
            removeDeadCharacter();
            isTheBattleNotOver = checkIfTheBattleIsOver();
            turn = !turn;
            turnCount++;
        }

        if (getHeroes().length > 0) {
            winners = "HEROES";
        } else {
            winners = "MONSTERS";
        }

        System.out.println("===\t" + winners + " ARE WINNERS!\t===");
    }

    private void removeDeadCharacter() {
        Stream<Hero> heroStream = Arrays.stream(getHeroes()).filter(hero -> hero.getHp() > 0);
        Hero[] aliveHeroes = heroStream.toArray(Hero[]::new);
        setHeroes(aliveHeroes);

        Stream<Monster> monsterStream = Arrays.stream(monsters).filter(monster -> monster.getHp() > 0);
        Monster[] aliveMonsters = monsterStream.toArray(Monster[]::new);
        setMonsters(aliveMonsters);
    }

    private void showInformation() {

    }

    private boolean checkIfTheBattleIsOver() {
        return getMonsters().length > 0 && getHeroes().length > 0;
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

    public Monster[] getMonsters() {
        return monsters;
    }

    public void setMonsters(Monster[] monsters) {
        this.monsters = monsters;
    }

    public Hero[] getHeroes() {
        return heroes;
    }

    public void setHeroes(Hero[] heroes) {
        this.heroes = heroes;
    }

    @Override
    public String toString() {
        return "Battle{" +
                "monsters=" + Arrays.toString(monsters) +
                ", heroes=" + Arrays.toString(heroes) +
                '}';
    }
}
