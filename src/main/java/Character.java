import java.util.Random;

public class Character {
    private String name;
    private int hp;
    private int attack;
    private int defense;
    private float criticalChance;

    public Character() {

    }

    public void attackOpponent(Character opponent) {
        Random random = new Random();
        boolean isCritic = random.nextFloat(0, 1) < criticalChance;
        int damage;

        if (isCritic)
            damage = (this.getAttack() * 2) - opponent.getDefense();
        else
            damage = this.getAttack() - opponent.getDefense();

        opponent.takeDamage(damage);
        showDamageInformation(opponent, damage, isCritic);
    }

    private void showDamageInformation(Character opponent, int damage, boolean isCritic) {
        if (isCritic) {
            System.out.println(this.getName() + " DEALT " + damage + " CRITICAL DAMAGE TO " + opponent.getName());
        } else {
            System.out.println(this.getName() + " DEALT " + damage + " DAMAGE TO " + opponent.getName());
        }
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
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
        return "Character{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", criticalChance=" + criticalChance +
                '}';
    }
}
