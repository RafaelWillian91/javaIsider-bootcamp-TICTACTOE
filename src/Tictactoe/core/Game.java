package Tictactoe.core;

import Tictactoe.io.Input;
import Tictactoe.io.Output;

public class Game {

    //Jgo da velha tem um Board e os Players
    private final Board board = new Board();
    private final Players players = new Players();

    public void start() {
        System.out.println("Jogo Iniciado");

        //Todas as vezes que tem uma jogada a variável winner é atualizada
        Symbol winner =  null;

        //Equanto não houver um ganhador winner ficará execultando
        while (winner == null && !board.isFull()) {
            Output.writeNewLine();
            Output.write(board);
            winner = play(players.next());
        }

            Output.write(board);

        if (board.isFull()){

            Output.write("No Winner!");
        }else {
            Output.write(String.format("%s Is the winner! ", winner ));
        }

    }

    private Symbol play(Symbol symbol) {
        while (true) {
            try {
                String play = Input.read(String.format("'%s' Play =>", symbol));
                Coord coord = Coord.parse(play);
                return board.update(symbol, coord);
            } catch (RuntimeException e) {
                Output.write("\nError: " + e.getMessage() + "\n");
            }
        }

    }
}