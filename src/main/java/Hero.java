public class Hero extends Character {
    Hero() {
        this.setName(NameGenerator.generateName(6));
        this.setHp(100);
        this.setAttack(25);
        this.setDefense(25);
        this.setCriticalChance(0.25f);
    }
}
