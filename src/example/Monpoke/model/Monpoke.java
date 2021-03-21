package example.Monpoke.model;

public class Monpoke {
    private final String name;
    private int hitPoints;
    private final int attackPoints;

    public Monpoke(String name, int hitPoints, int attackPoints) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.attackPoints = attackPoints;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return hitPoints > 0;
    }

    public void setHitPoints(int attackPoints) {
        hitPoints -= attackPoints;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Monpoke)) return false;

        Monpoke other = (Monpoke) o;
        return this.name.equals(other.name);
    }
}
