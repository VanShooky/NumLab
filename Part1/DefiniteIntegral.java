package Part1;

import static java.lang.Math.*;

public class DefiniteIntegral {

    public double a;
    public double b;
    public double c;
    public double d;

    public DefiniteIntegral(double a, double b){
        this.a = a;
        this.b = b;
    }
    
    public DefiniteIntegral(double a, double b, double c, double d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Double func(double x){
        return (sin(x) + cos(x))/(3 + sin(2 * x));
    }

    public Double func(double x, double y){
        return x * x + 2 * y;
    }

    public Double trapezoidalIntegration(int n, double EPS){
        double integral = 0.0, prev_integral = 0.0;
        do{
            prev_integral = integral;
            integral = trapezoidRule( n); 
            n *= 2;
        } while(abs(integral - prev_integral) > 3 * EPS);
        return integral;
    }

    public Double trapezoidRule(int n) {
        double h = (this.b - this.a) / n;
        double sum = 0.0;
        sum += func(this.a) + func(this.b);
        for(int i = 1; i < n; i++){
            sum += 2 * func(this.a + i * h);
        }
        sum *= h / 2;
        return sum;
    } 

    public Double SimpsonIntegration(int n, double EPS){
        double integral = 0.0, prev_integral = 0.0;
        do{
            prev_integral = integral;
            integral = SimpsonRule(n); 
            n *= 2;
        } while(abs(integral - prev_integral) > 15 * EPS);
        return integral;
    }

    public Double SimpsonRule(int n) {
        double h = (this.b - this.a) / n;
        double sum = 0.0;
        sum += func(this.a) + func(this.b);
        for(int i = 1; i < n; i++){
            if(i % 2 != 0){
                sum += 4 * func(this.a + i * h);
            }
            else 
                sum += 2 * func(this.a + i * h);
        }
        sum *= h / 3;
        return sum;
    } 

    public Double cubatureSimpsonRule(int n, int m) {   
        double integral = 0.0;  
        double hX = (this.b - this.a) / n;
        double hY = (this.d - this.c) / m;
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i % 2 == 0 && j % 2 ==0){
                    integral += func(this.a + j * hX, this.c + i * hY);
                }
                else if(i % 2 != 0 && j % 2 !=0){
                    integral += 16 * func(this.a + j * hX, this.c + i * hY);
                }
                else{
                    integral += 4 * func(this.a + j * hX, this.c + i * hY);
                }
            }
        }
        integral *= hX * hY / 9;
        return integral;
    } 
}