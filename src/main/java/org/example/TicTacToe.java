package org.example;

public class TicTacToe {
    private char[][] board;
    private int turnCount;
    private boolean turnForX;

    public TicTacToe() {
        this.turnForX = true;
        this.turnCount = 1;
        this.board = new char[3][3];
        this.board[0] = new char[]{' ', ' ', ' '};
        this.board[1] = new char[]{' ', ' ', ' '};
        this.board[2] = new char[]{' ', ' ', ' '};
        printBoard();
    }

    public String play(int x, int y) {
        char token = turnForX ? 'X' : 'O';

        checkPositionAvailability(x, y);
        makeMove(x, y, token);
        printBoard();
        return checkGameStatus();
    }

    private void makeMove(int x, int y, char token) {
        board[x][y] = token;
        turnForX = !turnForX;
    }

    private String checkGameStatus() {
        char c = checkWinning();
        if (c != ' ') {
            System.out.println(c + " won the game!! Congrats!!!");
            return String.valueOf(c);
        }

        if (turnCount == 9) {
            return "DRAW";
        }
        turnCount++;
        return "CONTINUE";
    }

    public char checkWinning() {
        String line = "";
        for (int i = 0; i < 3; i++) {
            line = String.format("%c%c%c", board[i][0], board[i][1], board[i][2]);
            if (gameWon(line)) {
                return line.charAt(0);
            }
        }

        for (int j = 0; j < 3; j++) {
            line = String.format("%c%c%c", board[0][j], board[1][j], board[2][j]);
            if (gameWon(line)) {
                return line.charAt(0);
            }
        }

        line = String.format("%c%c%c", board[0][0], board[1][1], board[2][2]);
        if (gameWon(line)) {
            return line.charAt(0);
        }

        line = String.format("%c%c%c", board[0][2], board[1][1], board[2][0]);
        if (gameWon(line)) {
            return line.charAt(0);
        }

        return ' ';
    }

    private boolean gameWon(String line) {
        return line.equals("OOO") || line.equals("XXX");
    }

    private void checkPositionAvailability(int x, int y) {
        if (x < 0 || x > 8 || y < 0 || y > 8) {
            throw new IndexOutOfBoundsException();
        }
        if (board[x][y] != ' ') {
            throw new IllegalArgumentException();
        }
    }

    private void printBoard() {
        System.out.printf("""
                 _ _ _ _ _ _ _ _ _
                |     |     |     |
                |  %c  |  %c  |  %c  |
                |_ _ _|_ _ _|_ _ _|
                |     |     |     |
                |  %c  |  %c  |  %c  |
                |_ _ _|_ _ _|_ _ _|
                |     |     |     |
                |  %c  |  %c  |  %c  |
                |_ _ _|_ _ _|_ _ _|%n""", board[0][0], board[0][1], board[0][2], board[1][0], board[1][1], board[1][2], board[2][0], board[2][1], board[2][2]);
    }

    public char[][] getBoard() {
        return board;
    }
}
