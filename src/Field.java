public class Field {
    private static char [][] playingField;
    static String winner = null;

    public Field() {
        playingField = new char[3][3];
        createArray();
    }

    public static char[][] getPlayingField() {
        return playingField;
    }


    public void print() {
        System.out.println("---------");
        for (char[] chars : playingField) {
            System.out.print("| ");
            for (char aChar : chars) {
                System.out.print(aChar);
                System.out.print(" ");
            }
            System.out.println("| ");
        }
        System.out.println("---------");
    }

    public void createArray() {
        String field = "_________";
        int k = 0;
        for (int i = 0; i < playingField.length; i++) {
            for (int j = 0; j < playingField[i].length; j++) {
                playingField[i][j] = field.charAt(k++);
            }
        }
    }

    public static boolean checkEmptyCell(String [] input) {
        return (Field.playingField[Integer.parseInt(input[0]) - 1][Integer.parseInt(input[1]) - 1] == '_' );
    }

    public static boolean checkStep() {
        if (checkImpossible(playingField) || checkHorizon(playingField, Game.fishkaX) || checkVertical(playingField, Game.fishkaX)
                || checkDiagonal(playingField, Game.fishkaX)) {
            winner = String.valueOf(Game.fishkaX);
            return false;
        } else if (checkImpossible(playingField) || checkHorizon(playingField, Game.fishkaO) || checkVertical(playingField, Game.fishkaO)
                || checkDiagonal(playingField, Game.fishkaO)) {
            winner = String.valueOf(Game.fishkaO);
            return false;
        } else if (!checkFinishGame(playingField)) {
            return false;
        }
        return true;
    }

    private static boolean checkImpossible(char[][] array) {
        int countX = 0;
        int countY = 0;
        for (char[] chars : array) {
            for (char aChar : chars) {
                if (aChar == Game.fishkaX) {
                    countX++;
                } else if (aChar == Game.fishkaO) {
                    countY++;
                }
            }
        }
        if ((countX > countY && (countX - countY) != 1) || (countY > countX && (countY - countX) != 1)) {
            System.out.println("Impossible");
            return true;
        }
        return false;
    }

    private static boolean checkFinishGame(char[][] array) {
        for (char[] chars : array) {
            for (char aChar : chars) {
                if (aChar == '_') {
//                    System.out.println("Game not finished");
                    return true;
                }
            }
        }
        winner = "Draw";
        return false;
    }

    private static boolean checkDiagonal(char[][] array, char fishkaPl) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][i] != fishkaPl) {
                break;
            }
            if (i == array.length - 1) {
                winner = String.valueOf(fishkaPl);
                return true;
            }
        }
        for (int j = 0; j < array.length; j++) {
            if (array[j][(array.length - 1) - j] != fishkaPl) {
                break;
            }
            if (j == array.length - 1) {
                winner = String.valueOf(fishkaPl);
                return true;
            }
        }
        return false;
    }

    private static boolean checkVertical(char[][] array, char fishkaPl) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[j][i] != fishkaPl) {
                    break;
                }
                if (j == array.length - 1) {
                    winner = String.valueOf(fishkaPl);
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkHorizon(char[][] array, char fishkaPl) {
        for (char[] chars : array) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != fishkaPl) {
                    break;
                }
                if (j == array.length - 1) {
                    winner = String.valueOf(fishkaPl);
                    return true;
                }
            }
        }
        return false;
    }
}
