package org.example.piece;

import org.example.Color;
import org.example.Coordinates;

import java.util.Set;

public class Rook extends LongRangePiece implements InterfaceRook{
    public Rook(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return getRookMoves();
    }
}
