import java.util.List;

public class MyFirstClass {

    public static void main(String[] args) {

        int a = 8, b = 24, c = 100;
        int division = b / a;
        System.out.println(division);
        int multiplication = b * c;
        System.out.println(multiplication);
        int subtraction = c - a;
        System.out.println(subtraction);
        int sum = c + b + a;
        System.out.println(sum);

        double tt = 8.16;
        double uu = 31.1;
        double rr = ((c * tt) + (b / a) - b + tt);
        double ii = uu - tt + sum;
        System.out.println(rr);
        System.out.println(ii);

        if ( sum > ii ) {
            System.out.println("Всё правильно " +  sum + " больше чем " + ii);
        } else {
            System.out.println("Ты ошибся " + ii + " оказалось больше чем " + sum);
        }
        boolean f = rr < c;
        System.out.println(f);
        boolean d = uu >= b;
        System.out.println(d);
        boolean q = ii <= rr;
        System.out.println(q);
        double p = Double.MAX_VALUE;

        System.out.println(p * c);


    }

}