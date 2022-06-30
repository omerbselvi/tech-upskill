package org.example.codesmells;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Tile> _plays = new ArrayList<>();

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile(new Position(i, j), ' ');
                _plays.add(tile);
            }
        }
    }

    public char getSymbolAt(Position position) {
        for (Tile t : _plays) {
            if (t.isFound(position, t)) {
                return t.getSymbol();
            }
        }
        return ' ';
    }

    public void setSymbolAt(Position position, char symbol) {
        for (Tile t : _plays) {
            if (t.isFound(position, t)) {
                t.setSymbol(symbol);
            }
        }
    }

    public boolean checkNthRowSame(int x) {
        return checkNthRowTilesNotEmpty(x) && getSymbolAt(new Position(x, 0)) ==
                getSymbolAt(new Position(x, 1)) &&
                getSymbolAt(new Position(x, 2)) == getSymbolAt(new Position(x, 1));
    }

    private boolean checkNthRowTilesNotEmpty(int x) {
        return getSymbolAt(new Position(x, 0)) != ' ' &&
                getSymbolAt(new Position(x, 1)) != ' ' &&
                getSymbolAt(new Position(x, 2)) != ' ';
    }
}