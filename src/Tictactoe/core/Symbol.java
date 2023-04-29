package Tictactoe.core;

public enum Symbol {

    //São 3 possibilidades para atribuicao ao tabuleiro: X, O e NONE(espaco em branco).
    X('X'),
    O('O'),
    NONE(' ');

    private final char charSimbol;
    Symbol(char simbol) {
        this.charSimbol = simbol;
    }

    //Por padrão o método toString() de um objeto enum retorna o nome do membro(X,O,NONE) em vez do valor correspondente.
    //Foi sobrescrito para retorno do espaço em branco do Tabuleiro.
    @Override
    public String toString() {
        //Conversão de enum para String
        return String.valueOf(charSimbol);
    }
}
