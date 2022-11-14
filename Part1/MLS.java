package Part1;
import java.util.Arrays;
import static java.lang.Math.*;

public class MLS {

    public static final int N = 10;
    public static final int m = 1;
    public static final Double[] data_x = {1.2, 1.82, 3.31, 7.24, 8.92, 9.12, 10.97, 14.45, 22.91, 36.31};
    public static final Double[] data_y = {630.0, 890.0, 2350.0, 3810.0, 4630.0, 4820.0, 5230.0, 7500.0, 11800.0, 19600.0};

    public static void leastSquareMethod(){
        System.out.println("x: " + Arrays.toString(data_x));
        System.out.println("y: " + Arrays.toString(data_y));

        Double[] powerX = powerX();
        Double[][] sumX = formSumX(powerX);
        Double[] praw = formPraw();
        Double[] coefficients = SLAE.gaussMethod(sumX, praw);
        Double standardDeviation = standardDeviation(coefficients);
        Double[] approximationFunc = approximationFunc(coefficients);

        System.out.println("v: " + Arrays.toString(approximationFunc));
        System.out.println("\ncoefficients:" + Arrays.toString(coefficients));
        System.out.println("\ndeviation:" + standardDeviation);
    }

    public static Double[] powerX() {
        Double[] powerX = new Double[2 * m];
        Arrays.fill(powerX, (double) 0);

        for(int i = 0; i < 2 * m; i++){
            for(int j = 0; j < N; j++){
                powerX[i] += pow(data_x[j], i + 1);
            }
        }
        return powerX;
    }

    public static Double [][] formSumX(Double[] powerX){
        Double[][] sumX = new Double [m + 1][m + 1];
        for(int i = 0; i < sumX.length; i++){
            for(int j = 0; j < sumX.length; j++){
                if(i == 0 && j == 0){
                    sumX[i][j] = (double) N;
                }
                else{
                    sumX[i][j] = powerX[i + j - 1];
                }
            }
        }
        return sumX;
    }

    public static Double[] formPraw(){
        Double[] praw = new Double [m + 1];
        Arrays.fill(praw, (double) 0);
        for(int i = 0; i < praw.length; i++){
            for(int j = 0; j < N; j++){
                praw[i] += data_y[j] * pow(data_x[j], i);
            }
        }
        return praw;
    } 

    public static Double dispersion(Double[] coefficients){
        Double S = (double) 0, temp;
        for(int i = 0; i < N; i++){
            temp = data_y[i];
            for(int j = 0; j < m + 1; j++){
                temp -= coefficients[j] * pow(data_x[i], j);
            }
            S += temp * temp;
        }
        S /= (N * m - 1);
        return S;
    }
    
    public static Double standardDeviation( Double[] coefficients) {
        Double standardDeviation = sqrt(dispersion(coefficients));
        return standardDeviation;
    }    
    
    public static Double[] approximationFunc(Double[] coefficient){
        Double[] funk = new Double[N];
        for(int i = 0; i < N; i++){
            funk[i] = Math.ceil((coefficient[0] + coefficient[1] * data_x[i]) * 10) / 10;
        }
        return funk;
    }
}    