package org.example.piece;

import org.example.Coordinates;

import java.util.HashSet;
import java.util.Set;

public interface InterfaceBishop {


    default Set<CoordinatesShift> getBishopMoves() {

        Set<CoordinatesShift> result = new HashSet<>();



        //bottom left to top right
        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;

            result.add(new CoordinatesShift(i, i));
        }

        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;

            result.add(new CoordinatesShift(i, -i));
        }

        return result;

    }

}
