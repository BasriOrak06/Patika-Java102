package adventuregame;

public abstract class NormalLacation extends Location{

    public NormalLacation(Player player, String name) {

        super(player, name);
    }
    @Override
    public boolean onLocation() {

        return true;
    }

}
