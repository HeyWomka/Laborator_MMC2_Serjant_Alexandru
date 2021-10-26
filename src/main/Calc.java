package main;

public final class Calc {

    private Calc() {
        throw new IllegalStateException("Calculations utility class");
    }

    public static double mainFunc(double a, double b, double x, double y) {
        // f(x,y) = a * x^2 + 2 * x * y + b * y^2 - 2 * x - 3 * y
        return a * sqr(x) + 2 * x * y +
               b * sqr(y) - 2 * x - 3 * y;
    }

    // Derivative | function X
    public static double derX(double a, double x, double y) {
        return (2 * a) * x + (y * 2) - 2;
    }

    // Derivative | function Y
    public static double derY(double b, double x, double y) {
        return 2 * x + (2 * b) * y - 3;
    }

    public static double nablaFunc(double a, double b, double x, double y) {
        return Math.sqrt(sqr(derX(a, x, y)) + sqr(derY(b, x, y)));
    }

    public static double sqr(double number) {
        return Math.pow(number, 2);
    }
}
