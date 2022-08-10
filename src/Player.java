public abstract class Player {
    private final String name;
    private final char fishkaPl;

    public Player(String name, char fishkaPl) {
        this.name = name;
        this.fishkaPl = fishkaPl;
    }

    public char getFishkaPl() {
        return fishkaPl;
    }

    public String getName() {
        return name;
    }

    public abstract void makeMove(char [][] field);

}
