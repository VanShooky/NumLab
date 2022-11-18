package Part1;
// import java.util.Arrays;
// import java.util.function.Function;
import static java.lang.Math.*;
public class Main {


    public static void main(String[] args) {

        final double a = 0;
        final double b = PI / 4;
        final int n = 1000;
        final double eps1 = 1E-4;
        final double eps2 = 1E-5;
        double trapezoidIntegral = DefiniteIntegrals.trapezoidalIntegration(a, b, n, eps1);
        System.out.printf("%.4f", trapezoidIntegral);
        double SimpsonIntegral = DefiniteIntegrals.SimpsonIntegration(a, b, n, eps1);
        System.out.printf("%.4f", SimpsonIntegral);

        
        
        // SLAE();    
        // SNonLE();
        // MLS.leastSquareMethod();
    }

    // private static void SNonLE() {
    //     Double[] init = {1.0, 1.0};
    //     Function<Double[], Double>[] functions = new Function[init.length];
    //     functions[0] = Main::funk1;
    //     functions[1] = Main::funk2;
    //     Function<Double[], Double>[][] dFunctions = new Function[init.length][init.length];
    //     dFunctions[0][0] = Main::dFunk1dx1;
    //     dFunctions[0][1] = Main::dFunk1dx2;
    //     dFunctions[1][0] = Main::dFunk2dx1;
    //     dFunctions[1][1] = Main::dFunk2dx2;
    //     Double[] x = SNonLE.NewtonMethod(init, functions, dFunctions);
    //     System.out.println("Ответ: "+ Arrays.toString(x));
    // }

    // private static void SLAE() {
    //     Double[][] matrixA = {
    //         {2.5, -3.0, 4.6}, 
    //         {-3.5, 2.6, 1.5,}, 
    //         {-6.5, -3.5, 7.3,} 
    //     };
    //     Double[][] matrixA1 = {
    //         {2.5, -3.0, 4.6}, 
    //         {-3.5, 2.6, 1.5,}, 
    //         {-6.5, -3.5, 7.3,} 
    //     };
    //     Double[][] matrixA2 = {
    //         {2.5, -3.0, 4.6}, 
    //         {-3.5, 2.6, 1.5,}, 
    //         {-6.5, -3.5, 7.3,} 
    //     };
    //     Double[] matrixB = {-1.05, -14.46, -17.73};
    //     Double[] matrixB1 = {-1.05, -14.46, -17.73};
        
    //     Double[] matrixX = SLAE.gaussMethod(matrixA, matrixB);
    //     System.out.println("Ответ:");
    //     for (int i = 0; i < matrixX.length; i++) {
    //         System.out.print("x" + ++i + " = " + matrixX[--i] + "  ");
    //         System.out.println();
    //     }
        
    //     Double[] residualVector = SLAE.residualVector(matrixA1, matrixB1, matrixX);
    //     System.out.print("Вектор невязки: ");
    //     System.out.println(Arrays.toString(residualVector));
    //     System.out.println("Норма: " + SLAE.getNorm(residualVector));
    //     System.out.println();
    //     SLAE.RelativeError(matrixA2, matrixX);
    //     System.out.println("Относительная погрешность: " + SLAE.RelativeError(matrixA2, matrixX));
    //     System.out.println();

    //     double l1 = 1, l2 = 10, l3 = 15;
    //     Double[][] matrixALDL = {
    //         {2 * l1 + 4 * l2, 2 * (l1 - l2), 2 * (l1 - l2)}, 
    //         {2 * (l1 - l2), 2 * l1 + l2 + 3 * l3, 2 * l1 + l2 - 3 * l3}, 
    //         {2 * (l1 - l2), 2 * l1 + l2 - 3 * l3, 2 * l1 + l2 + 3 * l3}
    //     };
    //     Double[] matrixBLDL = {-4 * l1 - 2 * l2, -4 * l1 + l2 + 9 * l3, -4 * l1 + l2 - 9 * l3};
    //     if (SLAE.isSymmetric(matrixALDL)) {
    //         Double[] matrixXLDL = SLAE.FactorizationMethod(matrixALDL, matrixBLDL);
    //         System.out.print("Ответ: ");
    //         System.out.println(Arrays.toString(matrixXLDL));
    //     } else {
    //         throw new ArithmeticException("Матрица не симметричная.");
    //     }
    // }

    // public static Double funk1(Double[] x) {
    //     return Math.tan(x[0] * x[1] + 0.2) - x[0] * x[0];
    // }

    // public static Double dFunk1dx1(Double[] x) throws ArithmeticException {
    //     double value = Math.cos(x[0] * x[1] + 0.2) * Math.cos(x[0] * x[1] + 0.2);
    //     if (value == 0) {
    //         throw new ArithmeticException("Деление на 0.");
    //     } else {
    //         return x[1] / value - 2 * x[0];
    //     }
    // }

    // public static Double dFunk1dx2(Double[] x) throws ArithmeticException {
    //     double value = Math.cos(x[0] * x[1] + 0.2) * Math.cos(x[0] * x[1] + 0.2);
    //     if (value == 0) {
    //         throw new ArithmeticException("Деление на 0.");
    //     } else {
    //     return x[0] / (value);
    //     }
    // }
    // public static Double funk2(Double[] x) {
    //     return 0.5 * x[0] * x[0] + 2 * x[1] * x[1] - 1;
    // }

    // public static Double dFunk2dx1(Double[] x) {
    //     return x[0];
    // }

    // public static Double dFunk2dx2(Double[] x) {
    //     return 4 * x[1];
    // }
}