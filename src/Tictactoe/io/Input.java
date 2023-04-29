package Tictactoe.io;

import java.util.Scanner;

public final class Input {

    private Input(){}

    //Ler a informacao do Teclado. Preciso
    public static String read(String message){
        if(message != null){
            //Metodo verifica se tem mensagem para mostrar ao usuário
            Output.write(message + " ", false);
        }
        return new Scanner(System.in).nextLine();
    }




}
