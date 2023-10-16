package org.example.piece;

import org.example.Color;
import org.example.Coordinates;

import java.util.Set;

public class Bishop extends LongRangePiece implements InterfaceBishop {
    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return getBishopMoves();
    }
}
