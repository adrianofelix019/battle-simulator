public class Main {
    public static void main(String[] args) {
        Hero[] heroes =  { new Hero(), new Hero() };
        Monster[] monsters = { new Monster(), new Monster() };
        Battle battle = new Battle(heroes, monsters);
        battle.startBattle();
        System.out.println(battle);
    }
}
