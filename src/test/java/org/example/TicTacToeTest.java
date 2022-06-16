package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    private TicTacToe ticTacToe;

    @BeforeEach
    void setUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    void it_should_start_game_with_empty_board() {
        char[][] board = new char[3][3];
        board[0] = new char[]{' ', ' ', ' '};
        board[1] = new char[]{' ', ' ', ' '};
        board[2] = new char[]{' ', ' ', ' '};
        assertTrue(Arrays.deepEquals(board, ticTacToe.getBoard()));
    }

    @Test
    void it_should_play_with_x_first() {
        char[][] board = new char[3][3];
        board[0] = new char[]{'X', ' ', ' '};
        board[1] = new char[]{' ', ' ', ' '};
        board[2] = new char[]{' ', ' ', ' '};
        ticTacToe.play(0, 0);
        assertTrue(Arrays.deepEquals(board, ticTacToe.getBoard()));
    }

    @Test
    void it_should_play_with_X_first_then_O() {
        char[][] board = new char[3][3];
        board[0] = new char[]{'X', 'O', ' '};
        board[1] = new char[]{' ', ' ', ' '};
        board[2] = new char[]{' ', ' ', ' '};
        ticTacToe.play(0, 0);
        ticTacToe.play(0, 1);
        assertTrue(Arrays.deepEquals(board, ticTacToe.getBoard()));
    }

    @Test
    void it_should_throw_exception_when_selected_index_is_full() {
        ticTacToe.play(0, 0);
        assertThrows(IllegalArgumentException.class, () -> ticTacToe.play(0, 0));
    }

    @Test
    void it_should_win_the_game() {
        ticTacToe.play(0, 0);
        ticTacToe.play(1, 0);
        ticTacToe.play(0, 1);
        ticTacToe.play(2, 0);

        assertEquals("X", ticTacToe.play(0, 2));
    }

    @Test
    void it_should_return_empty_character_when_game_not_finished() {
        ticTacToe.play(0, 0);
        ticTacToe.play(1, 0);
        ticTacToe.play(0, 1);
        assertEquals("CONTINUE", ticTacToe.play(2, 0));
    }

    @Test
    void it_should_win_the_game_second_row() {
        ticTacToe.play(1, 0);
        ticTacToe.play(0, 0);
        ticTacToe.play(1, 1);
        ticTacToe.play(0, 1);
        assertEquals("X", ticTacToe.play(1, 2));
    }

    @Test
    void it_should_win_the_game_third_row() {
        ticTacToe.play(2, 0);
        ticTacToe.play(0, 0);
        ticTacToe.play(2, 1);
        ticTacToe.play(0, 1);
        assertEquals("X", ticTacToe.play(2, 2));
    }

    @Test
    void it_should_win_the_game_first_column() {
        ticTacToe.play(0, 0);
        ticTacToe.play(1, 1);
        ticTacToe.play(1, 0);
        ticTacToe.play(2, 2);
        assertEquals("X", ticTacToe.play(2, 0));
    }

    @Test
    void it_should_win_the_game_second_column() {
        ticTacToe.play(0, 1);
        ticTacToe.play(0, 0);
        ticTacToe.play(1, 1);
        ticTacToe.play(0, 2);
        assertEquals("X", ticTacToe.play(2, 1));
    }

    @Test
    void it_should_win_the_game_third_column() {
        ticTacToe.play(0, 2);
        ticTacToe.play(0, 0);
        ticTacToe.play(1, 2);
        ticTacToe.play(0, 1);
        assertEquals("X", ticTacToe.play(2, 2));
    }

    @Test
    void it_should_win_the_game_first_diagonal() {
        ticTacToe.play(0, 0);
        ticTacToe.play(0, 1);
        ticTacToe.play(1, 1);
        ticTacToe.play(0, 2);
        assertEquals("X", ticTacToe.play(2, 2));
    }

    @Test
    void it_should_win_the_game_second_diagonal() {
        ticTacToe.play(0, 2);
        ticTacToe.play(0, 1);
        ticTacToe.play(1, 1);
        ticTacToe.play(0, 0);
        assertEquals("X", ticTacToe.play(2, 0));
    }

    @Test
    void it_should_return_draw_when_game_is_draw() {
        ticTacToe.play(0, 0);
        ticTacToe.play(0, 2);
        ticTacToe.play(0, 1);
        ticTacToe.play(1, 0);
        ticTacToe.play(1, 2);
        ticTacToe.play(1, 1);
        ticTacToe.play(2, 0);
        ticTacToe.play(2, 1);
        assertEquals("DRAW", ticTacToe.play(2, 2));
    }

    @Test
    void it_should_throw_index_out_of_bounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> ticTacToe.play(10, 0));
    }
}
