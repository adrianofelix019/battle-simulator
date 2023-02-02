public class Hero extends Character {
    Hero() {
        this.setName(NameGenerator.generateName(6));
        this.setHp(100);
        this.setAttack(25);
        this.setDefense(25);
        this.setCriticalChance(0.25f);
    }

    public Hero(String name, int hp, int attack, int defense, float criticalChance) {
        this.setName(name);
        this.setHp(hp);
        this.setAttack(attack);
        this.setDefense(defense);
        this.setCriticalChance(criticalChance);
    }
}
