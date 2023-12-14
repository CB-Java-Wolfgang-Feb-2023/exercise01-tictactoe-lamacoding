package TicTacToe;

public class TicTacToe {
    private char[][] field;
    private final byte SIZE;
    private final char emptyCharacter = '_';
    private char player;
    private byte row, col;
    private boolean hasWon = false, isPar = false;
    private int turn = 0;

    public TicTacToe() {
        this((byte) 3);
    }

    public TicTacToe(byte size) {
        this.SIZE = size;
        player = 'x';
        createField();
        renderField();
    }

    public void makeTurn(byte row, byte col) {
        if (row >= 'a' && row <= 'z') {
            row -= 'a' - 'A';
        }
        this.row = row;
        this.col = col;
        if (field[this.row - 65][this.col - 1] == emptyCharacter) {
            turn++;
            field[this.row - 65][this.col - 1] = player;
            renderField();
            if (checkForWinner()) {
                hasWon = true;
            } else {
                if(turn == SIZE * SIZE) {
                    isPar = true;
                }
                switchPlayer();
            }
        } else {
            System.out.println("Illegal turn. Try again.");
        }
    }

    public boolean checkHasWon() {
        return hasWon;
    }

    public char getPlayer() {
        return player;
    }

    private boolean checkForWinner() {
        if(isPar) {
            return isPar;
        }
        boolean winRow = true;
        boolean winCol = true;
        boolean winDiagLtoR = true;
        boolean winDiagRtoL = true;
        //Check row
        for (int i = 0; i < SIZE; i++) {
            if (field[this.row - 65][i] != player) {
                winRow = false;
                break;
            }
        }
        //Check col
        for (int i = 0; i < SIZE; i++) {
            if (field[i][this.col - 1] != player) {
                winCol = false;
                break;
            }
        }
        //Check diagonal
        for (int i = 0; i < SIZE; i++) {
            if (field[i][i] != player) {
                winDiagLtoR = false;
            }
            if (field[i][SIZE - i - 1] != player) {
                winDiagRtoL = false;
            }
            if(!winDiagLtoR && !winDiagRtoL) {
                break;
            }
        }

        return winRow || winCol || winDiagLtoR || winDiagRtoL;
    }

    private void switchPlayer() {
        if (player == 'x') {
            player = 'o';
        } else {
            player = 'x';
        }
    }

    private void createField() {
        field = new char[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                field[row][col] = emptyCharacter;
            }
        }
    }

    private void renderField() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1);
            if (i < SIZE - 1) {
                System.out.print("|");
            }
        }
        System.out.println();
        for (int row = 0; row < SIZE; row++) {
            System.out.print((char) (65 + row) + "|");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(field[row][col]);
                if (col < SIZE - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    public boolean isPar() {
        return isPar;
    }
}
