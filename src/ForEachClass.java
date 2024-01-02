import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("ALL")
public class ForEachClass {
    public static void main(String[] args) {

        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");
        fruits.forEach(fruit -> System.out.println(fruit));

        fruits.forEach(new Consumer<String>() {
            @Override
            public void accept(String fruit) {
                System.out.println(fruit);
            }
        });

        fruits.forEach(fruit -> System.out.println(fruit));

        fruits.forEach(System.out::println);
    }
}
