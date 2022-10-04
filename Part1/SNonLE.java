package Part1;
import java.util.Scanner;
import java.util.function.Function;

public class SNonLE {

    static double M = 0.000000001;

    public static Double[] NewtonMethod(Double[] x, Function<Double[], Double>[] functions, Function<Double[], Double>[][] dFunctions) throws ArithmeticException {
        int k = 1;
        int numIt = 100;
        double eps1=1e-9;
        double eps2=1e-9;
        Double[] residualVector = new Double[x.length];
        Double[][] J;
        Double[] tempX = new Double[x.length];
        double delta1, delta2;
        Double[] dx;
        int value;
        System.out.println("Варианты нахождения матрицы Якоби :)");
        System.out.println("1. Аналитический метод \n2. Разностный метод");
        Scanner in = new Scanner(System.in);
        do {
            value = in.nextInt();
        } while (value != 1 && value != 2);
        in.close();
        do {
            for (int i = 0; i < residualVector.length; i++) {
                residualVector[i] = -functions[i].apply(x);
            }
            if (value == 1) {
                J = Jacobean(x, dFunctions);
            } else {
                J = Jacobean(x, functions, M);
            }
            dx = SLAE.GaussMethod(J, residualVector);
            for (int i = 0; i < x.length; i++) {
                tempX[i] = x[i] + dx[i];
            }
            delta1 = Math.max(Math.abs(functions[0].apply(x)), Math.abs(functions[1].apply(x)));
            delta2 = 0;// что здесь должно быть я без понятиииияяяяяяяяяяяя
            System.arraycopy(tempX, 0, x, 0, x.length);
            System.out.println("k: " + k + "\tdelta1 = " + delta1 + "\tdelta2 = " + delta2);
            if (k >= numIt) {
                throw new ArithmeticException("Итераций необходимо больше, чем задано");
            }
            k++;
        } while (delta1 > eps1 && delta2 > eps2);
        return x;
    }

    public static Double[][] Jacobean(Double[] x, Function<Double[], Double>[][] dFunctions) {
        Double[][] J = new Double[x.length][x.length];
        for (int i = 0; i < J.length; i++) {
            for (int j = 0; j < x.length; j++) {
                J[i][j] = dFunctions[i][j].apply(x);
            }
        }
        return J;
    }

    public static Double[][] Jacobean(Double[] x, Function<Double[], Double>[] functions, double M) {
        Double[][] J = new Double[x.length][x.length];
        //здесь должно быть что-то слишком умное
        return J;
    }
}
