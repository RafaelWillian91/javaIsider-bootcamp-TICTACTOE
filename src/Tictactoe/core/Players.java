package Tictactoe.core;

import java.util.ArrayList;
import java.util.List;

public class Players {

    //Como são sempre dois jogadores a lista foi criada com tamanho 2 para economia de memória
    private final List<Symbol> players = new ArrayList<>(2);
    //Controle para saber que é vez de jogar
    private int currentPlayerindex = -1;

    public Players(){
        players.add(Symbol.X);
        players.add(Symbol.O);
    }

    //Metódo para percorrer uma lista circularmente, ou seja, ao chegar no fim volta ao início.
    public Symbol next(){
        //Se o currentPlayerindex for 0 muda para 1 se for 1 muda para 0.
        currentPlayerindex = (currentPlayerindex + 1) % players.size();
        return players.get(currentPlayerindex);
    }
}
