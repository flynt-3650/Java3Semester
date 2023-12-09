package genericloophole;

public class Calculator {

    public static <T extends Number> T sum(T a, T b) {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() + b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
        } else {
            throw new IllegalArgumentException("Unsupported number type");
        }
    }

    public static <T extends Number> T multiply(T a, T b) {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() * b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() * b.doubleValue());
        } else {
            throw new IllegalArgumentException("Unsupported number type");
        }
    }

    public static <T extends Number> T divide(T a, T b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() / b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() / b.doubleValue());
        } else {
            throw new IllegalArgumentException("Unsupported number type");
        }
    }

    public static <T extends Number> T subtraction(T a, T b) {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() - b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() - b.doubleValue());
        } else {
            throw new IllegalArgumentException("Unsupported number type");
        }
    }

    public static void main(String[] args) {
        Integer intResult = sum(5, 3);
        System.out.println("Sum of integers: " + intResult);

        Double doubleResult = multiply(2.5, 4.0);
        System.out.println("Multiplication of doubles: " + doubleResult);

        try {
            Double divisionResult = divide(10.0, 2.0);
            System.out.println("Division of doubles: " + divisionResult);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero");
        }

        Integer subtractionResult = subtraction(8, 4);
        System.out.println("Subtraction of integers: " + subtractionResult);
    }
}
