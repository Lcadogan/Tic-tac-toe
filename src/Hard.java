public class Hard extends AI{

    private char minFishka;

    public Hard(String name, char fishkaPl) {
        super(name, fishkaPl);
    }

    @Override
    public void makeMove(char [][] field) {
        setMinFishka();
        int bestScore = -10;
        int [] move = new int[2];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == Game.space) {
                    field[i][j] = super.getFishkaPl();
                    int score = minimax(field, false);
                    field[i][j] = Game.space;
                    if (score > bestScore) {
                        bestScore = score;
                        move[0] = i;
                        move[1] = j;
                    }
                }
            }
        }
        field[move[0]][move[1]] = super.getFishkaPl();
        print();
    }

    void setMinFishka() {
        if (super.getFishkaPl() == Game.fishkaX) {
            this.minFishka = Game.fishkaO;
        } else {
            this.minFishka = Game.fishkaX;
        }
    }

    public int minimax(char [][] field, boolean isMaximazing) {
        int result = 0;
        int bestScore;
        Field.checkStep();
        if (Field.winner != null) {
            if (Field.winner.equals(String.valueOf(super.getFishkaPl()))) {
                result = 10;
            } else if (Field.winner.equals(String.valueOf(minFishka))) {
                result = -10;
            }
            Field.winner = null;
            return result;
        }
        if (isMaximazing) {
            bestScore = -10;
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (field[i][j] == Game.space) {
                        field[i][j] = super.getFishkaPl();
                        int score = minimax(field, false);
                        field[i][j] = Game.space;
                        if (score > bestScore) {
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
        } else {
            bestScore = 10;
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (field[i][j] == Game.space) {
                        field[i][j] = minFishka;
                        int score = minimax(field, true);
                        field[i][j] = Game.space;
                        if (score < bestScore) {
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
        }
    }
}
