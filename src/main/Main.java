package main;

public class Main {
    public static double epsilon = 0.000001;
    public static double beta = 0.5;
    public static double alpha = 1;
    public static int a = 2;
    public static int b = 3;
    public static int x = 1;
    public static int y = 1;

    public static void main(String[] args) {
        if (Calc.nablaFunc(a, b, x, y) <= epsilon) {
            System.out.println("No decisions. THE END.");
        }

        double derX = Calc.derX(a, x, y);
        double derY = Calc.derY(b, x, y);
        System.out.println("derX = " + derX);
        System.out.println("derY = " + derY + "\n");

        boolean stop;
        int i = 0;
        alpha *= 2;

        do {
            alpha /= 2;
            double tempX = -1 * alpha * derX + x;
            double tempY = -1 * alpha * derY + y;

            double Fz = Calc.mainFunc(a, b, tempX, tempY);
            double Fx = Calc.mainFunc(a, b, x, y);

            stop = (Fz - Fx) <= -1 * beta * alpha * Calc.sqr(Calc.nablaFunc(a, b, x, y));

            if (stop) System.out.println("Final result: ");
            System.out.println("Z(" + i + ")X = " + tempX);
            System.out.println("Z(" + i + ")Y = " + tempY);
            System.out.println("F(z) = " + Fz);
            System.out.println("F(x) = " + Fx);
            System.out.println("F(z) - F(x) | IF " + (Fz - Fx) + " <= " + (-1 * beta * alpha * Calc.sqr(Calc.nablaFunc(a, b, x, y))));
            System.out.println();
            i++;

        } while (!stop);
    }
}
