package Tictactoe.core;

import Tictactoe.util.ValidarionUtils;

import java.util.Objects;

/*Explicacao do record: Em um record o compilador Java gera automaticamente um construtor,
métodos de acesso e uma implementação padrão dos métodos equals, hashCode e toString.
Uma vez que os atributos de um record são finais, os objetos record são imutáveis e não podem ser modificados
após a sua criação. Isso os torna seguros para uso em threads concorrentes e em situações em que a imutabilidade
é importante. */
public record Coord(int i, int j) {

    //Verificacao adicional de seguranca da aplicacao. Verificando se i e j estao dentro do intervalo permitido
    public Coord{
        ValidarionUtils.require((i >= 0) && (i < Board.SIZE), "i is out of range");
        ValidarionUtils.require((j >= 0) && (j < Board.SIZE), "j is out of range");
    }

    public static Coord parse(String text) {
        //Exemplo de digitação: 1,1. Objects.requireNonNull para verificar se o objeto é nulo. Se for nulo lanca um excecao
        Objects.requireNonNull(text);
        //A String é quebrada em tokens de acordo com o método split.
        String[] tokens = text.split(",");
        if (tokens.length != 2) {
            //se entrar neste if é que tem algo diferente que o usuário digitou
            throw new IllegalArgumentException("Invalid format");
        }

        //Esse Construtor pode capturar uma NumberFormatException devido a String digitada não poder ser convertida
        try {

            return new Coord(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid Number");
        }
    }


}
