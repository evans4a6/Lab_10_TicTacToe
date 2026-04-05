import java.util.Scanner;


public class Main {

    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board[][] = new String[ROWS][COLS];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean playAgain;

        // game starts; clear board
        do {
            clearBoard();
            String player = "X";
            boolean gameOver = false;

            while (!gameOver) {
                display();
                System.out.println("It is Player " + player + "'s turn.");

                int row = SafeInput.getRangedInt(in, "Enter row [1-3]", 1, 3);
                int col = SafeInput.getRangedInt(in, "Enter column [1-3]", 1, 3);
                row--;
                col--;

                if (!isValidMove(row, col)) {
                    System.out.println("That spot is already taken! Try again.");
                    continue;
                }

                board[row][col] = player;

                if (isWin(player)) {
                    display();
                    System.out.println("Player " + player + " WINS!!");
                    gameOver = true;
                } else if (isTie()) {
                    display();
                    System.out.println("It's a TIE!");
                    gameOver = true;
                } else
                    player = player.equals("X") ? "O" : "X";
            }

                playAgain = SafeInput.getYNConfirm(in, "Would you like to play again? Y/N");


        }while (playAgain);

        System.out.println("Thank you for playing Tic Tac Toe!");
    }

    // methods

    private static void clearBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = " ";
            }
        }
    }

    private static void display() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print(" " + board[row][col] + " ");
                if (col < COLS - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row < ROWS - 1) {
                System.out.println("-----------");
            }
        }
    }

    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        if (isColWin(player) || isRowWin(player) || isDiagonalWin(player)) {
            return true;
        }
        return false;
    }

    private static boolean isRowWin(String player) {
        for (int row = 0; row < ROWS; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int col = 0; col < COLS; col++) {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player) || (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))) {
            return true;
        }
        return false;
    }

    private static boolean isTie() {
        if (isWin("X") || isWin("O")) {
            return false;
        }

        boolean full = true;
        boolean[] eliminated = new boolean[8];
        int index = 0;

        // rows
        for (int row = 0; row < ROWS; row++) {
            boolean hasX = false, hasO = false;

            for (int col = 0; col < COLS; col++) {
                String cell = board[row][col];
                if (cell.equals(" ")) full = false;
                if (cell.equals("X")) hasX = true;
                if (cell.equals("O")) hasO = true;
            }
            eliminated[index++] = hasX && hasO;
        }

        // columns
        for (int col = 0; col < COLS; col++) {
            boolean hasX = false, hasO = false;
            for (int row = 0; row < ROWS; row++) {
                String cell = board[row][col];
                if (cell.equals("X")) hasX = true;
                if (cell.equals("O")) hasO = true;
            }
            eliminated[index++] = hasX && hasO;
        }

        // diagonal numero uno
        {
            boolean hasX = false, hasO = false;
            String cells[] = {board[0][0], board[1][1], board[2][2]};
            for (String cell : cells) {
                if (cell.equals("X")) hasX = true;
                if (cell.equals("O")) hasO = true;
            }
            eliminated[index++] = hasX && hasO;
        }

        // diagonal numero dos
        {
            boolean hasX = false, hasO = false;
            String cells[] = {board[0][2], board[1][1], board[2][0]};
            for (String cell : cells) {
                if (cell.equals("X")) hasX = true;
                if (cell.equals("O")) hasO = true;
            }
            eliminated[index++] = hasX && hasO;
        }

        if (full) return true;
        for (boolean e : eliminated) {
            if (!e) return false;
        }

        return true;

    }
}

