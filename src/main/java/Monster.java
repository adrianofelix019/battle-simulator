public class Monster extends Character {
    Monster() {
        this.setName(NameGenerator.generateName(4));
        this.setHp(100);
        this.setAttack(25);
        this.setDefense(25);
        this.setCriticalChance(0.15f);
    }
}
