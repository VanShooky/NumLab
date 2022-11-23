package Part1;

import static java.lang.Math.*;

public class DefiniteIntegral {

    public static Double func(double x){
        return (sin(x) + cos(x))/(3 + sin(2 * x));
    }

    public static Double func(double x, double y){
        return x * x + 2 * y;
    }

    public static Double trapezoidalIntegration(Double[] interval, int n, double EPS){
        double integral = 0.0, prev_integral = 0.0;
        do{
            prev_integral = integral;
            integral = trapezoidRule(interval, n); 
            n *= 2;
        } while(abs(integral - prev_integral) > 3 * EPS);
        return integral;
    }

    public static Double trapezoidRule(Double[] interval, int n) {
        double h = (interval[1] - interval[0]) / n;
        double sum = 0.0;
        sum += func(interval[0]) + func(interval[1]);
        for(int i = 1; i < n; i++){
            sum += 2 * func(interval[0] + i * h);
        }
        sum *= h / 2;
        return sum;
    } 

    public static Double SimpsonIntegration(Double[] interval, int n, double EPS){
        double integral = 0.0, prev_integral = 0.0;
        do{
            prev_integral = integral;
            integral = SimpsonRule(interval, n); 
            n *= 2;
        } while(abs(integral - prev_integral) > 15 * EPS);
        return integral;
    }

    public static Double SimpsonRule(Double[] interval, int n) {
        double h = (interval[1] - interval[0]) / n;
        double sum = 0.0;
        sum += func(interval[0]) + func(interval[1]);
        for(int i = 1; i < n; i++){
            if(i % 2 != 0){
                sum += 4 * func(interval[0] + i * h);
            }
            else 
                sum += 2 * func(interval[0] + i * h);
        }
        sum *= h / 3;
        return sum;
    } 

    public static Double cubatureSimpsonRule(Double[] intervalX, Double[] intervalY, int n, int m) {   
        double integral = 0.0;  
        double hX = (intervalX[1] - intervalX[0]) / n;
        double hY = (intervalY[1] - intervalY[0]) / m;
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i % 2 == 0 && j % 2 ==0){
                    integral += func(intervalX[0] + j * hX, intervalY[0] + i * hY);
                }
                else if(i % 2 != 0 && j % 2 !=0){
                    integral += 16 * func(intervalX[0] + j * hX, intervalY[0] + i * hY);
                }
                else{
                    integral += 4 * func(intervalX[0] + j * hX, intervalY[0] + i * hY);
                }
            }
        }
        integral *= hX * hY / 9;
        return integral;
    } 
}