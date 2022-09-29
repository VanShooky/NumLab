package Part1;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        
                    Double[][] matrixA = {
                        {2.5, -3.0, 4.6}, 
                        {-3.5, 2.6, 1.5,}, 
                        {-6.5, -3.5, 7.3,} 
                    };
                    Double[][] matrixA1 = {
                        {2.5, -3.0, 4.6}, 
                        {-3.5, 2.6, 1.5,}, 
                        {-6.5, -3.5, 7.3,} 
                    };
                    Double[][] matrixA2 = {
                        {2.5, -3.0, 4.6}, 
                        {-3.5, 2.6, 1.5,}, 
                        {-6.5, -3.5, 7.3,} 
                    };
                    Double[] matrixB = {-1.05, -14.46, -17.73};
                    Double[] matrixB1 = {-1.05, -14.46, -17.73};
                    
                    Double[] matrixX = SLAE.GaussMethod(matrixA, matrixB);
                    System.out.println("Ответ:");
                    for (int i = 0; i < matrixX.length; i++) {
                        System.out.print("x" + ++i + " = " + matrixX[--i] + "  ");
                        System.out.println();
                    }
                    
                    Double[] residualVector = SLAE.residualVector(matrixA1, matrixB1, matrixX);
                    System.out.print("Вектор невязки: ");
                    System.out.println(Arrays.toString(residualVector));
                    System.out.println("Норма: " + SLAE.getNorm(residualVector));
                    System.out.println();
                    SLAE.RelativeError(matrixA2, matrixX);
                    System.out.println("Относительная погрешность: " + SLAE.RelativeError(matrixA2, matrixX));
                    System.out.println();

                    double l1 = 1, l2 = 10, l3 = 15;
                    Double[][] matrixALDL = {
                        {2 * l1 + 4 * l2, 2 * (l1 - l2), 2 * (l1 - l2)}, 
                        {2 * (l1 - l2), 2 * l1 + l2 + 3 * l3, 2 * l1 + l2 - 3 * l3}, 
                        {2 * (l1 - l2), 2 * l1 + l2 - 3 * l3, 2 * l1 + l2 + 3 * l3}
                    };
                    Double[] matrixBLDL = {-4 * l1 - 2 * l2, -4 * l1 + l2 + 9 * l3, -4 * l1 + l2 - 9 * l3};
                    if (SLAE.isSymmetric(matrixALDL)) {
                        Double[] matrixXLDL = SLAE.FactorizationMethod(matrixALDL, matrixBLDL);
                        System.out.print("Ответ: ");
                        System.out.println(Arrays.toString(matrixXLDL));
                    } else {
                        throw new ArithmeticException("Матрица не симметричная.");
                    }

                }
}