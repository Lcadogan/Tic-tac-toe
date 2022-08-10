public class Medium extends AI {

    public Medium(String name, char fishkaPl) {
        super(name, fishkaPl);
    }

    @Override
    public void makeMove(char [][] field) {
        if (potentialWin(field)) {
            print();
        } else if (blockWin(field)) {
            print();
        } else {
            String[] tmp = moveRandom();
            field[Integer.parseInt(tmp[0]) - 1][Integer.parseInt(tmp[1]) - 1] = super.getFishkaPl();
            print();
        }
    }

    public boolean potentialWin(char[][] field) {
        return (row(field, super.getFishkaPl()) || colum(field, super.getFishkaPl()) || diagonal(field,super.getFishkaPl()));
    }

    public boolean blockWin(char[][] field) {
        char fishka;
        if (super.getFishkaPl() == Game.fishkaX) {
            fishka = Game.fishkaO;
        } else {
            fishka = Game.fishkaX;
        }
        return (row(field, fishka) || colum(field, fishka) || diagonal(field, fishka));
    }

    public boolean row(char [][] field, char fishka) {
        for (int i = 0; i < field.length; i++) {
            int count = 0;
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == fishka) {
                    count++;
                }
                if(count == 2) {
                    for (int k = 0; k < field[i].length; k++) {
                        if (field[i][k] == Game.space) {
                            field[i][k] = super.getFishkaPl();
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean colum(char [][] field, char fishka) {
        for (int i = 0; i < field.length; i++) {
            int count = 0;
            for (int j = 0; j < field.length; j++) {
                if(field[j][i] == fishka) {
                   count++;
                }
                if (count == 2) {
                    for (int k = 0; k < field.length; k++) {
                        if (field[k][i] == Game.space) {
                            field[k][i] = super.getFishkaPl();
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean diagonal(char[][] field, char fishka) {
        int count = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[i][i] == fishka) {
                count++;
            }
            if (count == 2) {
                for (int j = 0; j < field.length; j++) {
                    if (field[j][j] == Game.space) {
                        field[j][j] = super.getFishkaPl();
                        return true;
                    }
                }
            }
        }
        count = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][(field.length - 1) - j] == fishka) {
                count++;
            }
            if (count == 2) {
                for (int k = 0; k < field.length; k++) {
                    if (field[k][(field.length - 1) - k] == Game.space) {
                        field[k][(field.length - 1) - k] = super.getFishkaPl();
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

