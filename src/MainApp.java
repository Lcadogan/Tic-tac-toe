public class MainApp {
    public static void main(String[] args) {
        intro();
        while (true) {
            Game game = new Game();
            game.start();
        }
    }
    public static void intro() {
        System.out.println("\n****** HELLO!!! This is TIC-TAC-TOE GAME!!! *******\n");
        System.out.println("""
                    To start the game, enter the command "start"
                followed by a space, enter the player who will play first (X).
                You can play with user or artificial intelligence.
                AI has 3 difficulty levels:
                  easy
                  medium
                  hard
                  AI can also play with each other.
                      
                input command exemple:
                   Input command: start user medium
                   or
                   Input command: start hard user
                   
                input coordinates exemple:
                   Enter the coordinates (row, column): 2 1
                   
                To exit, enter the "exit" command.
                
                Let's start =)!!!
                """);
    }
}
