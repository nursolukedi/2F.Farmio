package src.source.model;

public abstract class PowerUp extends Item
{

    public PowerUp() {
        super();
    }

    public abstract void applyPowerUp(Seed a);
}