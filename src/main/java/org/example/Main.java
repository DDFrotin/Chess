package org.example;

import org.example.board.Board;
import org.example.board.BoardFactory;

public class Main {
    public static void main(String[] args) {

        Board board = (new BoardFactory()).fromFEN
                (
                        "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"
                );
        BoardConsoleRenderer render = new BoardConsoleRenderer();

        Game game = new Game(board);
        game.gameLoop();
    }
}