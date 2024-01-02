public class AnonymousClasses {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Lambda inside runnable");
        for (int i = 0; i < 5; i++) {
            runnable.run();
        }
    }
}
