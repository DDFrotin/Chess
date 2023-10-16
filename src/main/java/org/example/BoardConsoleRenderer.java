package org.example;

import org.example.board.Board;
import org.example.piece.Piece;

import java.util.Set;

import static java.util.Collections.emptySet;

public class BoardConsoleRenderer {

    public final String ANSI_RESET = "\u001B[0m";
    public final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";
    public final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";
    public final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";

    public final String ANSI_HIGHLIGHTED_SQUARE_BACKGROUND = "\u001B[42m";
    public void render(Board board, Piece pieceToMove) { //Отрисовка доски
        Set<Coordinates> availableMoveSquares = emptySet();
        if(pieceToMove != null) {
            availableMoveSquares = pieceToMove.getAvailableMoveSquares(board);
        }


        for(int rank = 8; rank >=1; rank--) {
            String line = "";
            for(File file : File.values()) {
                Coordinates coordinates = new Coordinates(file, rank);
                boolean isHighlight = availableMoveSquares.contains(coordinates);

                if(board.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmptySquare(coordinates, isHighlight); // Добавляет в вывод пустую клетку
                } else {
                    line += getPieceSprite(board.getPiece(coordinates), isHighlight);// Добавляет в вывод клетку с фигурой
                }
            }
            line+= ANSI_RESET;
            System.out.println(line);
        }
    }

    public void render(Board board) {
        render(board, null);
    }

    private String colorizeSprite(String sprite,
                                  Color pieceColor,
                                  boolean isSquareDark,
                                  boolean isHighLight) { // Устанавливает цвет фигуры и клетки
        // format = bg color + font color + text

        String result = sprite;

        if(pieceColor == Color.WHITE) { // Установка цвета для фигуры
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }

        if(isHighLight) {
            result = ANSI_HIGHLIGHTED_SQUARE_BACKGROUND + result;
        }
        else if(isSquareDark) { // Установка цвета для клетки
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        } else {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;

        }

        return result;
    }

    private String getSpriteForEmptySquare(
            Coordinates coordinates,
            boolean isHighlight) {//Возвращает раскрашенную пустую клетку
        return colorizeSprite(
                "   ",
                Color.WHITE,
                Board.isSquareDark(coordinates),
                isHighlight
        );
    }

    private String selectSpriteForPiece(Piece piece) {
        switch (piece.getClass().getSimpleName()) {
            case "Pawn":
                return "P";

            case "Bishop":
                return "B";

            case "Knight":
                return "N";

            case "King":
                return "K";

            case "Queen":
                return "Q";

            case "Rook":
                return "R";
        }
        return "";
    }
    private String getPieceSprite(Piece piece, boolean isHighlight) { // Возвращает клетку с фигурой
        return colorizeSprite(
                " " + selectSpriteForPiece(piece) + " ",
                piece.color,
                Board.isSquareDark(piece.coordinates),
                isHighlight
        );
    }
}
