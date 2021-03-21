package example.Monpoke.model;

import java.util.HashMap;
import java.util.Map;

public class Team {
    public String teamName;
    private final Map<String, Monpoke> mapOfMonpokes;
    private Monpoke chosenMonpoke;

    public Team(String teamName) {
        this.teamName = teamName;
        mapOfMonpokes = new HashMap<>();
    }

    public Monpoke getChosenMonpoke() {
        return chosenMonpoke;
    }

    public boolean isChooseRequired() {
        return chosenMonpoke == null;
    }

    public void setChosenMonpoke(String monpoke) {
        if (chosenMonpoke != null)
            mapOfMonpokes.put(chosenMonpoke.getName(), chosenMonpoke);

        Monpoke m = (Monpoke) mapOfMonpokes.get(monpoke);

        if (m == null || !m.isActive()) {
            System.out.println("Monpoke is cannot be used in battle!");
            return;
        }

        chosenMonpoke = m;
        System.out.printf("%s has entered the battle!%n", monpoke);
    }

    public void addMonpoke(Monpoke monpoke) {
        if (!isValidMonpoke(monpoke)) {
            System.out.println("Monpoke must have a hit and attack point that is greater than 0!");
            return;
        }
        mapOfMonpokes.put(monpoke.getName(), monpoke);
        System.out.printf("%s has been assigned to team %s!%n", monpoke.getName(), teamName);
    }

    private boolean isValidMonpoke(Monpoke monpoke) {
        return monpoke.getHitPoints() > 0 && monpoke.getAttackPoints() > 0;
    }

    public void chosenMonpokeStatus() {
        if (chosenMonpoke.isActive()) return;

        System.out.printf("%s has been defeated!%n", chosenMonpoke.getName());
        chosenMonpoke = null;
    }

    public boolean isActive() {
        return mapOfMonpokes.values().stream().anyMatch(Monpoke::isActive);
    }
}
