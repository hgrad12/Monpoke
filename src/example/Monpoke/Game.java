package example.Monpoke;

import example.Monpoke.model.Monpoke;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        System.out.println("The game has started!");
        if (args.length == 0) {
            createTeams();
        } else {
            File file = new File(args[0]);
            extractFile(file);
        }
    }

    private static void createTeams() {
        while (Battle.haveTeamsBeenCreated() || Battle.battleIsActive()) {
            Scanner scanner = new Scanner(System.in);

            initiateCommand(scanner.nextLine());

            if (Battle.haveTeamsBeenCreated()) continue;

            if (!Battle.battleIsActive()) {
                System.out.println(Battle.retrieveWinner());
                break;
            }
        }
    }

    private static void extractFile(File file) {
        String command;
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
            System.exit(1);
        }
        while(scanner.hasNextLine()) {
            command = scanner.nextLine();

            initiateCommand(command);

            if (Battle.haveTeamsBeenCreated()) continue;

            if (!Battle.battleIsActive()) {
                System.out.println(Battle.retrieveWinner());
                break;
            }
        }
    }

    private static void initiateCommand(String command) {
        String[] commandSplit = command.split("\\s+");

        switch (commandSplit[0].toUpperCase()) {
            case "CREATE":
                String teamName = commandSplit[1].trim();
                Monpoke monpoke = new Monpoke(commandSplit[2].trim(), Integer.parseInt(commandSplit[3]), Integer.parseInt(commandSplit[4]));
                Battle.create(teamName, monpoke);
                break;
            case "ATTACK":
                Battle.attack();
                break;
            case "ICHOOSEYOU":
                Battle.chooseMonpoke(commandSplit[1].trim());
                break;
            default:
                System.out.println("Command not recognized!");
        }
    }
}
