package example.Monpoke;

import example.Monpoke.model.Monpoke;
import example.Monpoke.model.Team;

public class Battle {
    private static Team red,blue;
    private static boolean turn = true;

    public static void create(String teamName, Monpoke monpoke) {
        if (red == null) {
            red = new Team(teamName);
            red.addMonpoke(monpoke);
            return;
        } else if(red.teamName.equalsIgnoreCase(teamName)) {
            red.addMonpoke(monpoke);
            return;
        }

        if (blue == null) {
            blue = new Team(teamName);
            blue.addMonpoke(monpoke);
            return;
        } else if(blue.teamName.equalsIgnoreCase(teamName)) {
            blue.addMonpoke(monpoke);
            return;
        }

        System.out.println("You cannot have more than two teams!");
        System.exit(1);
    }

    public static boolean haveTeamsBeenCreated() {
        return red == null || blue == null;
    }

    public static boolean battleIsActive(){
        return red.isActive() && blue.isActive();
    }

    public static void attack() {
        if (haveTeamsBeenCreated()) {
            System.out.println("There must be two teams to begin battle!");
            System.exit(1);
            return;
        }

        if (haveTeamsChosenTheirMonpoke()) {
            System.out.println("A team has not chosen this Monpoke!");
            return;
        }
        Monpoke teamRedMonpoke = red.getChosenMonpoke();
        Monpoke teamBlueMonpoke = blue.getChosenMonpoke();

        if (turn) {
            int attackPoints = teamRedMonpoke.getAttackPoints();
            teamBlueMonpoke.setHitPoints(attackPoints);
            System.out.println(retrieveBattleDetails(teamRedMonpoke, teamBlueMonpoke));
            blue.chosenMonpokeStatus();
        } else {
            int attackPoints = teamBlueMonpoke.getAttackPoints();
            teamRedMonpoke.setHitPoints(attackPoints);
            System.out.println(retrieveBattleDetails(teamBlueMonpoke, teamRedMonpoke));
            red.chosenMonpokeStatus();
        }
        changeTurn();
    }

    private static boolean haveTeamsChosenTheirMonpoke() {
        return red.isChooseRequired() || blue.isChooseRequired();
    }

    private static String retrieveBattleDetails(Monpoke attack, Monpoke defend) {
        return String.format("%s attacked %s for %d points", attack.getName(), defend.getName(), attack.getAttackPoints());
    }

    public static void chooseMonpoke(String monpoke) {
        if (haveTeamsBeenCreated()) {
            System.out.println("You must create teams before you choose your Monpoke!");
            return;
        }
        if (turn) {
            red.setChosenMonpoke(monpoke);

            if (red.isChooseRequired()) return;
        } else {
            blue.setChosenMonpoke(monpoke);

            if (blue.isChooseRequired()) return;
        }
        changeTurn();
    }

    private static void changeTurn() {
        turn = !turn;
    }

    public static String retrieveWinner() {
        String teamName = (red.isActive())? red.teamName : blue.teamName;
        return String.format("%s is the Winner!", teamName);
    }
}
