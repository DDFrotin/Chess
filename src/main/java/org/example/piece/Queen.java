package org.example.piece;

import org.example.Color;
import org.example.Coordinates;

import java.util.HashSet;
import java.util.Set;

public class Queen extends LongRangePiece implements InterfaceRook, InterfaceBishop {
    public Queen(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> moves = getRookMoves();
        moves.addAll(getBishopMoves());

        return moves;
    }
}
