package adventuregame;

public class Forest extends BattleLocation{
    public Forest(Player player) {
        super(player, "Forest", new Vampire(), "fireWood", 3);
    }
}
