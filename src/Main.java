import java.util.Scanner;


public class Main {

    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board [][] = new String[ROWS][COLS];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

    }

     private static void clearBoard()
        {
            for (int row = 0; row < ROWS; row++)
            {
                for (int col = 0; col < COLS; col++)
                {
                    board[row][col] = " ";
                }
            }
        }

     private static void display()
        {
            for (int row = 0; row < ROWS; row++)
            {
                for (int col = 0; col < COLS; col++)
                {
                    System.out.print(" " + board[row][col] + " ");
                    if (col < COLS - 1)
                    {
                        System.out.print("|");
                    }
                }
                System.out.println();
                if (row < ROWS - 1)
                {
                    System.out.println("-----------");
                }
            }
        }

        private static boolean isValidMove(int row, int col)
        {
            return board[row][col].equals(" ");
        }

        private static boolean isWin(String player)
        {
            if (isColWin(player) || isRowWin(player) || isDiagonalWin(player))
            {
                return true;
            }
            return false;
        }

        private static boolean isRowWin(String player)
        {
            for(int row = 0; row < ROWS; row++)
            {
                if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
                {
                    return true;
                }
            }
            return false;
        }

        private static boolean isColWin(String player)
        {
            for(int col = 0; col < COLS; col++)
            {
                if(board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player))
                {
                    return true;
                }
            }
            return false;
        }

        private static boolean isDiagonalWin(String player)
        {
                if(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player) || (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)))
                {
                    return true;
                }
            return false;
        }

        private static boolean isTie()
        {
            for(int row = 0; row < ROWS; row++)
            {
                boolean hasX = false;
                boolean hasO = false;

                for(int col = 0; col < COLS; col++)
                {
                    if (board[row][col].equals("X")) hasX = true;
                    if (board[row][col].equals("O")) hasO = true;
                }
                if (!hasX && hasO) return false;
            }

            for(int col = 0; col < COLS; col++)
            {
                boolean hasX = false;
                boolean hasO = false;

                for(int row = 0; row < ROWS; row++)
                {
                    if (board[row][col].equals("X")) hasX = true;
                    if (board[row][col].equals("O")) hasO = true;
                }
                if (!hasX && hasO) return false;
            }

        }


}