package otherTopics;

public class StringFunctions {
    
    public static void main(String[] args) {
        
        String originalString = "abcde ABCDE DFa ";

        /* Converte para letras minusculas */
        String newString = originalString.toLowerCase();
        System.out.println(newString);

        /* Converte para letras maiusculas */
        newString = originalString.toUpperCase();
        System.out.println(newString);

        /* Retira os espaços final */
        newString = originalString.trim();
        System.out.println(newString);

        /* Monta um novo string com base no index */
        /* Essa função aceita varios argumentos, onde começar e o limite */
        newString = originalString.substring(2);
        System.out.println(newString);

        /* Altera um caracter por um outro caractere */
        newString = originalString.replace("a", "x");
        System.out.println(newString);

        /* Operação split */
        String s = "potato apple lemon";
        String[] vect = s.split(" ");
        System.out.println(vect[0]);
    }
}
