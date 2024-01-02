@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

@SuppressWarnings("Convert2MethodRef")
public class Main {
    public static void main(String[] args) {
        Calculator classicAddition = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a+b;
            }
        };

        System.out.println(classicAddition.calculate(5, 3));

        Calculator lambdaAddition = (a, b) -> a + b;

        System.out.println(lambdaAddition.calculate(5,3));
    }
}