public class Easy extends AI {

    public Easy(String name, char fishkaPl) {
        super(name, fishkaPl);
    }

    @Override
    public void makeMove(char [][] field) {
        String [] tmp = moveRandom();
        field[Integer.parseInt(tmp[0]) - 1][Integer.parseInt(tmp[1]) - 1] = super.getFishkaPl();
        print();
    }

}
