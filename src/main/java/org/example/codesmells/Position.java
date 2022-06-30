package org.example.codesmells;

public class Position {
    public int X;
    public int Y;

    public Position(int x, int y) {
        X = x;
        Y = y;
    }
    public boolean equals(Position position){
        return this.X == position.X && this.Y == position.Y;
    }
}
