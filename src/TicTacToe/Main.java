package TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        byte size;
        String turn;

        do {
            System.out.print("Size of the field (3-9, 0 to exit): ");
            size = s.nextByte();

            if (size == 0) {
                return;
            } else if (size < 3 || size > 10) {
                System.out.println("Please enter only numbers between 3 and 9!");
            }
        } while (size < 3 || size > 9);

        TicTacToe t = new TicTacToe(size);

        while (!t.checkHasWon() && !t.isPar()) {
            System.out.print("Field: ");
            turn = s.next();
            t.makeTurn((byte) turn.charAt(0), (byte) (turn.charAt(1) - '0'));
        }
        if (t.checkHasWon()) {
            System.out.println(t.getPlayer() + " won!");
        } else {
            System.out.println("Par!");
        }
    }
}
