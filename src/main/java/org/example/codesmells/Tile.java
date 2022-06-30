package org.example.codesmells;

public class Tile
{
    private Position position;
    private char Symbol;

    public Tile() {
    }

    public Tile(Position position, char symbol) {
        this.position = position;
        Symbol = symbol;
    }

    public Tile(Position position) {
        this.position = position;
    }

    public char getSymbol() {
        return Symbol;
    }

    public boolean isFound(Position position, Tile t) {
        return position.equals(t.position);
    }

    public void setSymbol(char Symbol){
        this.Symbol = Symbol;
    }
}