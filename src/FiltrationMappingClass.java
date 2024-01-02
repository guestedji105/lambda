import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SuppressWarnings({"SimplifyStreamApiCallChains", "Convert2MethodRef"})
public class FiltrationMappingClass {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> evenNumbers = numbers.stream()
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer number) {
                        return number % 2 == 0;
                    }
                })
                .collect(Collectors.toList());

        //SELECT * FROM numbers
        List<Integer> evenNumbersLambda = numbers.stream()
                // WHERE value % 2 = 0;
                .filter(number -> number % 2 == 0)
                .toList();

        System.out.println(evenNumbersLambda);

        List<String> names = Arrays.asList("John", "Jane", "Doe");

        List<Integer> nameLengths = names.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String name) {
                        return name.length();
                    }
                })
                .collect(Collectors.toList());

        List<Integer> nameLengthsLambda = names.stream()
                .map(name -> name.length())
                .toList();

        System.out.println(nameLengthsLambda);

        Map<String, Integer> nameLengthMap = names.stream()
                .collect(Collectors.toMap(
                        new Function<String, String>() {
                            @Override
                            public String apply(String name) {
                                return name;
                            }
                        },
                        new Function<String, Integer>() {
                            @Override
                            public Integer apply(String name) {
                                return name.length();
                            }
                        }
                ));

        Map<String, Integer> nameLengthMapLambda = names.stream()
                .collect(Collectors.toMap(
                        name -> name,
                        name -> name.length()
                ));

        System.out.println(nameLengthMapLambda);
    }
}
