package introduction;

public class MathFunction {

    public static void main(String[] args) {
        double x = 3.0;
        double y = 4.0;
        double z = -5.0;
        double A, B, C;

        A = Math.sqrt(x);
        B = Math.sqrt(y);
        C = Math.sqrt(25.0);

        System.out.println("Raiz quadrada de " + x + " = " + A);
        System.out.println("Raiz quadrada de " + x + " = " + B);
        System.out.println("Raiz quadrada de 25 = " + C);
        System.out.println(Math.pow(z, x));
    }
}
