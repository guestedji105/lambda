import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("Convert2MethodRef")
public class MethodReferencingClass {
    public static void main(String[] args) {
        List<String> stringNumbers = Arrays.asList("1", "2", "3");

        // Lambda expression
        Function<String, Integer> parseInt = s -> Integer.parseInt(s);

        // Method reference
        Function<String, Integer> parseIntReference = Integer::parseInt;

        List<Integer> mappedStringNumbers = stringNumbers.stream()
                .map(Integer::parseInt)
                .toList();

        System.out.println("\r\n" + mappedStringNumbers);

        Person person = new Person("John Doe", 30);

        // Lambda expression printing details
        Runnable printDetailsLambda = () -> person.printDetails();

        // Method reference to the instance method printDetails
        Runnable printDetailsReference = person::printDetails;

        // Execute both runnables
        System.out.println("\r\nUsing Lambda Expression:");
        printDetailsLambda.run();

        System.out.println("\r\nUsing Method Reference:");
        printDetailsReference.run();

        List<String> words = Arrays.asList("apple", "banana", "orange");

        // Lambda expression
        List<Integer> lengths = words.stream()
                .map(word -> word.length())
                .toList();

        // Method reference
        List<Integer> lengthsMR = words.stream()
                .map(String::length)
                .toList();

        System.out.println("\r\n" + lengthsMR);

        // Lambda expression
        Supplier<StringBuilder> stringBuilderSupplier = () -> new StringBuilder();

        // Method reference
        Supplier<StringBuilder> stringBuilderSupplierReference = StringBuilder::new;

        System.out.println("\r\n" + stringBuilderSupplierReference.get().append("Something "));
        System.out.println("\r\n" + stringBuilderSupplierReference.get().append("Else "));
    }
}
