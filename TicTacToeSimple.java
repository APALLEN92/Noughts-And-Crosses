import java.util.Scanner;

public class TicTacToeSimple {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nLet's play tic tac toe.");

        char[][] board = createBoard();

        char currentPlayer = 'X';
        int moves = 0;

        while (true) {
            printBoard(board);
            int[] move = getMove(board, currentPlayer);
            board[move[0]][move[1]] = currentPlayer;
            moves++;

            if (checkWin(board, currentPlayer)) {
                printBoard(board);
                System.out.println(currentPlayer + " WINS!");
                break;
            }

            if (moves == 9) {
                printBoard(board);
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    public static char[][] createBoard() {
        char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '_';
            }
        }
        return board;
    }

    public static void printBoard(char[][] board) {
        System.out.println();
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static int[] getMove(char[][] board, char currentPlayer) {
        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row column):");
            int row = scan.nextInt();
            int col = scan.nextInt();
            if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '_') {
                System.out.println("Invalid move, try again.");
            } else {
                return new int[]{row, col};
            }
        }
    }

    public static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // Horizontal win
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; // Vertical win
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; // Diagonal win (top-left to bottom-right)
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true; // Diagonal win (top-right to bottom-left)
        }
        return false;
    }
  
    }

