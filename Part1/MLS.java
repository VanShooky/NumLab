package Part1;
import java.util.Arrays;
import static java.lang.Math.*;

public class MLS {

    public static final int N = 10;
    public static final int m = 2;
    public static final Double[] data_x = {1.2, 1.82, 3.31, 7.24, 8.92, 9.12, 10.97, 14.45, 22.91, 36.31};
    public static final int[] data_y = {630, 890, 2350, 3810, 4630, 4820, 5230, 7500, 11800, 19600};

    public static void leastSquareMethod(){
        System.out.println("x: " + Arrays.toString(data_x));
        System.out.println("y: " + Arrays.toString(data_y));
        Double[] powerX = calculatePowerX();
        //System.out.println(Arrays.toString(powerX));
        Double[][] sumX = formSumX(powerX);

        // for(int i = 0; i < sumX.length; i++){
        //     System.out.println(Arrays.toString(sumX[i]));
        // }
        Double[] praw = formPraw();
        // System.out.println(Arrays.toString(praw));
        Double[] coefficients = SLAE.gaussMethod(sumX, praw);
        Double standardDeviation = calculateStandardDeviation(coefficients);



    }

    public static Double[] calculatePowerX() {
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

    public static Double calculateDispersion(Double[] coefficients){
        Double S = (double) 0, temp;
        for(int i = 0; i < N; i++){
            temp = (double)data_y[i];
            for(int j = 0; j < m + 1; j++){
                temp -= coefficients[i] * pow(data_x[i], j);
            }
            S += temp * temp;
        }
        return S;
    }
    
    public static Double calculateStandardDeviation( Double[] coefficients) {
        Double standardDeviation = sqrt(calculateDispersion(coefficients));
        return standardDeviation;
    }


}
