import java.util.Random;

public class Character {
    private String name;
    private int hp;
    private int attack;
    private int defense;
    private float criticalChance;

    public Character() {

    }

    public Character(String name, int hp, int attack, int defense, float criticalChance) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.criticalChance = criticalChance;
    }

    public void attackOpponent(Character opponent) {
        Random random = new Random();
        float randomNumber = random.nextFloat(0, 1);
        boolean isCritic = randomNumber < (criticalChance / 100);
        int damage;

        if (isCritic) {
            damage = (this.getAttack() * 2) - opponent.getDefense();
        }
        else {
            damage = this.getAttack() - opponent.getDefense();
        }

        damage = Math.max(damage, 0);
        opponent.takeDamage(damage);
        showDamageInformation(opponent, damage, isCritic);
    }

    private void showDamageInformation(Character opponent, int damage, boolean isCritic) {
        if (isCritic) {
            System.out.println(this.getName() + " DEALT " + damage + " CRITICAL DAMAGE TO " + opponent.getName());
        } else {
            System.out.println(this.getName() + " DEALT " + damage + " DAMAGE TO " + opponent.getName());
        }
        System.out.println(opponent.getName() + "'S HP IS NOW " + opponent.getHp());
    }

    public void takeDamage(int damage) {
        this.hp = Math.max(this.hp -= damage, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public float getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(float criticalChance) {
        this.criticalChance = criticalChance;
    }

    @Override
    public String toString() {
        return "NAME: " + name + "\n" +
                "HP: " + hp + "\n" +
                "ATTACK: " + attack + "\n" +
                "DEFENSE: " + defense + "\n" +
                "CRITICAL CHANCE: " + criticalChance + "\n";
    }
}
