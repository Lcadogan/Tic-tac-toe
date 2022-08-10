import java.util.Scanner;

public class Game {
    final static char fishkaX = 'X';
    final static char fishkaO = 'O';
    final static char space = '_';

    private final Field field;
    private final InputCommand command;

    Game () {
        this.field = new Field();
        this.command = new InputCommand();
    }

    public void start() {
        Player player1 = command.getPlayer1();
        Player player2 = command.getPlayer2();
        if (player1.getName().equals("human")) {
            field.print();
        }
        while(true) {
            player1.makeMove(Field.getPlayingField());
            field.print();
            if (!Field.checkStep()){
                printWinner();
                break;
            }
            player2.makeMove(Field.getPlayingField());
            field.print();
            if (!Field.checkStep()) {
                printWinner();
                break;
            }
        }
    }

    public void printWinner() {
        if (!Field.winner.equals("Draw")) {
            System.out.println(Field.winner + " wins");
        } else {
            System.out.println(Field.winner);
        }
    }

    static class InputCommand {
        private Player player1;
        private Player player2;
        private final String [] inputCommand;
        Scanner scanner;

        public InputCommand () {
            this.inputCommand = new String[3];
            this.scanner = new Scanner(System.in);
            parsePlayer();
        }

        public Player getPlayer1() {
            return player1;
        }

        public Player getPlayer2() {
            return player2;
        }

        public void createPlayer(String pl) {
            if (pl != null && pl.equals("easy")) {
                if (player1 == null) {
                    this.player1 = new Easy("easy", fishkaX);
                } else {
                    this.player2 = new Easy("easy", fishkaO);
                }
            } else if (pl != null && pl.equals("medium")) {
                    if (player1 == null) {
                        this.player1 = new Medium("medium", fishkaX);
                    } else {
                        this.player2 = new Medium("medium", fishkaO);
                    }
            } else if (pl != null && pl.equals("hard")) {
                        if (player1 == null) {
                            this.player1 = new Hard("hard", fishkaX);
                        } else {
                            this.player2 = new Hard("hard", fishkaO);
                        }
            } else {
                if (player1 == null) {
                    this.player1 = new Human("human", fishkaX);
                } else {
                    this.player2 = new Human("human", fishkaO);
                }
            }
        }

        private boolean checkCommand() {
            if (inputCommand[0].equals("start")) {
                for (int i = 1; i < inputCommand.length; i++) {
                    if (inputCommand[i].equals("user") || inputCommand[i].equals("easy")
                            || inputCommand[i].equals("medium") || inputCommand[i].equals("hard")) {
                        if (i == 1) {
                            createPlayer(inputCommand[i]);
                        } else {
                            createPlayer(inputCommand[i]);
                        }
                    } else
                        return false;
                }
            } else
                return false;
            return true;
        }

        public void parsePlayer() {
            while(true) {
                System.out.print("Input command: > ");
                if (parseInput()) {
                    return;
                }
                System.out.println("Bad parameters!");
            }
        }

        private boolean parseInput() {
            this.scanner = new Scanner(System.in);
            String input = this.scanner.nextLine();
            this.scanner = new Scanner(input);
            int count = -1;
            String tmp;
            while (scanner.hasNext() && count < 2) {
                tmp = scanner.next();
                if(tmp.equals("exit") ) {
                    this.scanner.close();
                    System.exit(0);
                }
                this.inputCommand[++count] = tmp;
            }
            if (count != 2) {
                this.scanner.close();
                return false;
            }
            if(checkCommand()) {
                this.scanner.close();
                return true;
            }
            return false;
        }
    }
}
