import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class LocalVariablesClass {
    public static void main(String[] args) {
        System.out.println("Effective Final: ");
        int x = 10;
        Runnable runnableFinal =
                () -> System.out.println(x); // Это валидный код, т.к. x фактически final
                                            // не изменяется внутри вызова, а остальное не важно =)

        runnableFinal.run();

        System.out.println("\r\nInside consumer: ");
        int z = 30;
        Consumer<Integer> consumer = (number) -> System.out.println(number + z);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        numbers.forEach(consumer);

        System.out.println("\r\nInside loop: ");
        List<Runnable> runnableList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            runnableList.add(() -> System.out.println(finalI));
        }

        runnableList.forEach(Runnable::run);

        /*
        int count = 0;
        Runnable runnable = () -> {
            count++;
            System.out.println(count);
        };
        */

        Callable<String> callable = () -> {
            throw new IOException("IO Error");
        };

        //callable.call();
    }
}
