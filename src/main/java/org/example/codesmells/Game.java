package org.example.codesmells;

public class Game {
    private char _lastSymbol = ' ';
    private Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        Play(symbol, new Position(x, y));
    }

    private void Play(char symbol, Position position) throws Exception {
        //if first move
        if (_lastSymbol == ' ') {
            //if player is X
            if (symbol == 'O') {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.getSymbolAt(position) != ' ') {
            throw new Exception("Invalid position");
        }

        // update game state
        _lastSymbol = symbol;
        _board.setSymbolAt(position, symbol);
    }

    public char Winner() {
        //if the positions in first row are taken
        if (_board.checkNthRowSame(0)) {
            //if first row is full with same symbol
            return _board.getSymbolAt(new Position(0, 0));
        }

        //if the positions in first row are taken
        if (_board.checkNthRowSame(1)) {
            //if middle row is full with same symbol
            return _board.getSymbolAt(new Position(1, 0));
        }

        //if the positions in first row are taken
        if (_board.checkNthRowSame(2)) {
            //if middle row is full with same symbol
            return _board.getSymbolAt(new Position(2, 0));
        }

        return ' ';
    }


}

