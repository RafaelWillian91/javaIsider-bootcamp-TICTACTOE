package Tictactoe.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
public class Board {

    public static final int SIZE = 3;
    private final Symbol[][] matriz = new Symbol[SIZE][SIZE];

    //Construcao do Tabuleiro
    public Board(){
        for(Symbol[] simbols : matriz){
            //preenche um array com um valor específico.
            Arrays.fill(simbols, Symbol.NONE);
        }
    }

    @Override
    public String toString() {
        /*
         * X | X | X
         * ---------
         * X | X | X
         * ---------
         * X | X | X
         */

        //subclasse de Writer, que implementa um buffer interno para armazenar os caracteres escritos em uma string.
        //Isso permite a manipulação da string gerada antes de finalmente usá-la.
        StringWriter sw = new StringWriter();
        PrintWriter out = new PrintWriter(sw);

        for(int i = 0; i < SIZE; i++){

            boolean first = true;
            for(int j = 0; j < SIZE; j++){
                //Para não imprimir o PIPE antes do primeiro X
                if(!first) {
                    out.print(" | ");
                }
                //Escrevendo no Buffer de StringWriter com PrintWriter antes de chamar o toString de StringWriter.
                out.print(matriz[i][j]);
                first = false;
            }

            out.println();
            //Verificacao se está na última linha do Tabuleiro, para não imprimir ("------") em baixo do tabuleiro
            if(i + 1 < SIZE){
            out.println("----------");
        }
         }
        return sw.toString();
    }

    //Se o retorno for null não há ganhador, se for x ou o temos um ganhador.
    public Symbol update(Symbol symbol, Coord coord){
        //symbol e coord não podem ser nulos
        requireNonNull(symbol);
        requireNonNull(coord);

        //symbol não pode ser com espaço em branco
        if (symbol == Symbol.NONE){
            throw new IllegalArgumentException("None cannot be added to board");
        }

        if(matriz[coord.i()][coord.j()] != Symbol.NONE){
            throw new IllegalArgumentException("Play is not possible");
        }

        matriz[coord.i()][coord.j()] = symbol;
        return findSequence();
    }

    //Verificacao se o tabuleiro está cheio, identificando o empate do jogo.
    public boolean isFull(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (matriz[i][j] == Symbol.NONE){
                    return false;
                }
            }
        }
        return true;
    }


    private Symbol findSequence(){
        Symbol symbol = findSequenceInRows();

        if(symbol != null){
            return symbol;
        }

         symbol = findSequenceInColumns();
        if(symbol != null){
            return symbol;
        }

        return findSequenceInDiagonals();
    }

    private Symbol findSequenceInRows(){
        for (int i = 0; i < SIZE; i++) {
            Symbol symbol = findSequenceInRows(i);{
                if(symbol != null){
                    return symbol;
                }
            }
        }
        return null;
    }
    //variável i representa a Linha e compara com a casa ao lado.
    private Symbol findSequenceInRows(int i){
        return matriz[i][0] == matriz[i][1] &&
               matriz[i][1] == matriz[i][2] &&
               matriz[i][0] != Symbol.NONE
               ? matriz[i][0]
               : null;
    }
    private Symbol findSequenceInColumns(){
        for (int j = 0; j < SIZE; j++) {
            Symbol symbol = findSequenceInColumns(j);{
                if(symbol != null){
                    return symbol;
                }
            }
        }
        return null;
    }

    //variável j representa a coluna e compara com a casa abaixo.
    private Symbol findSequenceInColumns(int j){
        return matriz[0][j] == matriz[1][j] &&
                matriz[1][j] == matriz[2][j] &&
                matriz[1][j] != Symbol.NONE
                ? matriz[0][j]
                : null;
    }

    private Symbol findSequenceInDiagonals() {
        if (matriz[0][0] == matriz[1][1] &&
                matriz[1][1] == matriz[2][2] &&
                matriz[1][1] != Symbol.NONE) {
            return matriz[0][0];
        }

        if (matriz[0][2] == matriz[1][1] &&
                matriz[1][1] == matriz[2][0] &&
                matriz[1][1] != Symbol.NONE) {
            return matriz[0][2];
        }
        return null;
    }

}















