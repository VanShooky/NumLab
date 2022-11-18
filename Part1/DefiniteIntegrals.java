package Part1;

import static java.lang.Math.*;

public class DefiniteIntegrals {

    public static Double func(double x){
        return (sin(x) + cos(x))/(3 + sin(2 * x));
    }

    public static Double func(double x, double y){
        return x * x + 2 * y;
    }

    public static Double trapezoidalIntegration(double a, double b, int n, double EPS){
        double integral = 0.0, prev_integral = 0.0;
        do{
            prev_integral = integral;
            integral = trapezoidRule(a, b, n); 
            n *= 2;
        } while(abs(integral - prev_integral) > 3 * EPS);
        return integral;
    }

    private static double trapezoidRule(double a, double b, int n) {
        double h = (b - a) / n;
        double sum = 0.0;
        sum += func(a) + func(b);
        for(int i = 1; i < n; i++){
            sum += 2 * func(a + i * h);
        }
        sum *= h / 2;
        return sum;
    } 

    public static Double SimpsonIntegration(double a, double b, int n, double EPS){
        double integral = 0.0, prev_integral = 0.0;
        do{
            prev_integral = integral;
            integral = SimpsonRule(a, b, n); 
            n *= 2;
        } while(abs(integral - prev_integral) > 15 * EPS);
        return integral;
    }

    private static double SimpsonRule(double a, double b, int n) {
        double h = (b - a) / n;
        double sum = 0.0;
        sum += func(a) + func(b);
        for(int i = 1; i < n; i++){
            if(i % 2 != 0){
                sum += 4 * func(a + i * h);
            }
            else 
                sum += 2 * func(a + i * h);
        }
        sum *= h / 3;
        return sum;
    } 

    public static Double cubatureSimpsonIntegration(double a, double b, double c, double d, int n, double EPS){
        double integral = 0.0, prev_integral = 0.0;
        // do{
        //     prev_integral = integral;
        //     integral = SimpsonRule(a, b, n); 
        //     n *= 2;
        // } while(abs(integral - prev_integral) > 15 * EPS);
        return integral;
    }

    private static double cubatureSimpsonRule(double a, double b, double c, double d, int n) {
        double hX = (b - a) / n;
        double hY = (d - a)/ n;
        double sum = 0.0;
        return sum;
    } 



    
}
