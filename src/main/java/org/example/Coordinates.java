package org.example;

import org.example.piece.CoordinatesShift;

public class Coordinates {
    public final File file; // Координаты по горизонатли
    public final Integer rank; // Координаты по вертекали

    public Coordinates(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }

    public Coordinates shift(CoordinatesShift shift) { //Новые коордианты фигуры после хода
        return new Coordinates(File.values()[this.file.ordinal() + shift.fileShift], this.rank + shift.rankShift);
    }

    public boolean canShift(CoordinatesShift shift) {  // Проверка не выходит ли фигура за пределы доски
        int f = file.ordinal() + shift.fileShift;
        int r = rank + shift.rankShift;

        if((f < 0) || (f > 7)) return false;
        if((r < 1) || (r > 8)) return false;

        return true;
    }

    @Override
    public boolean equals(Object o) { //Equals&hashCode нужны для хранения координаты в hashMap'e
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (file != that.file) return false;
        return rank.equals(that.rank);
    }

    @Override
    public int hashCode() {
        int result = file.hashCode();
        result = 31 * result + rank.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "file=" + file +
                ", rank=" + rank +
                '}';
    }
}
