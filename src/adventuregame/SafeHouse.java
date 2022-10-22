package adventuregame;

public class SafeHouse extends NormalLacation{

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You're at the Safe House");
        System.out.println("Your health refilled");
        this.getPlayer().setHealth(this.getPlayer().getOrginalhealth());
        return true;
    }
}
