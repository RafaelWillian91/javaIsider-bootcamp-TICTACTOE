package Tictactoe.util;

public final class ValidarionUtils {

    private ValidarionUtils(){}

    //Chegagem de validacao
    public static void require(boolean condition, String errorMessage){
        if (!condition){
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
