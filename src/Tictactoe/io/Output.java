package Tictactoe.io;

//Classe declarada com Final para não poder ser extendida
public final class Output {

    //Para impedir a construção de Objetos desta classe que servirá apenas para chamadas Static
    private Output(){}

    public static void writeNewLine() {
        write(null);
    }

    public static void write(Object obj){
        write(obj, true);
    }

    public static void write(Object obj, boolean addNewLine) {
        if (obj == null) {
            System.out.println();
        } else {
            if(addNewLine) {
                System.out.println(obj);
            }else {
                System.out.print(obj);
            }
        }
    }

}
