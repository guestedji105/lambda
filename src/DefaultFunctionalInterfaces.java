import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SuppressWarnings("Convert2MethodRef")
public class DefaultFunctionalInterfaces {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Predicate<Integer> isEven = number -> number % 2 == 0;
        List<Integer> evenNumbers = numbers.stream()
                .filter(isEven)
                .toList();

        System.out.println(evenNumbers);

        List<String> names = Arrays.asList("John", "Jane", "Doe");
        Consumer<String> printName = name -> System.out.println("Hello, " + name);
        names.forEach(printName);

        Function<String, Integer> lengthMapper = name -> name.length();
        List<Integer> nameLengths = names.stream()
                .map(lengthMapper)
                .toList();

        System.out.println(nameLengths);
    }
}
