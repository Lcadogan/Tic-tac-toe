import java.util.Scanner;

public class Human extends Player {

    final String [] inputUser;

    public Human( String name, char fishksPl) {
        super(name, fishksPl);
        this.inputUser = new String[2];
    }

    @Override
    public void makeMove(char [][] field) {
        boolean inputIsCorrect = false;
        while(!inputIsCorrect) {
            System.out.print("Enter the coordinates: > ");
            Scanner scanner = new Scanner(System.in);
            parseInput(scanner);
            if (checkUserInput(inputUser)) {
                if (Field.checkEmptyCell(inputUser)) {
                    inputIsCorrect = true;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            }
        }
        Field.getPlayingField()[Integer.parseInt(inputUser[0]) - 1][Integer.parseInt(inputUser[1]) - 1] = super.getFishkaPl();
    }

    private void parseInput(Scanner scanner) {
        for (int i = 0; i < 2; i++) {
            inputUser [i] = scanner.next();
        }
    }

    private static boolean checkUserInput(String [] inputUser) {
        int count = 0;
        for (String s : inputUser) {
            if (!s.equals("") && s.charAt(0) > 48 && s.charAt(0) < 57) {
                if (s.equals("1") || s.equals("2") || s.equals("3")) {
                    count++;
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } else {
                System.out.println("You should enter numbers!");
                break;
            }
        }
        return (count == inputUser.length);
    }
}
