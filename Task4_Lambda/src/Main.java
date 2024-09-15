import java.util.*;
import java.util.stream.Collectors;

/**
 * Из коллеции объектов Person необходимо:
 * Найти количество несовершеннолетних (т.е. людей младше 18 лет).
 * Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).
 * Получить отсортированный по фамилии список потенциально работоспособных людей с высшим образованием в выборке
 * (т.е. людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин).
 */

public class Main {
    public static void main(String[] args) {

        // Генерация исходного набора людей
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        // Test
        //System.out.println(persons);

        // 1. Для поиска несовершеннолетних используйте промежуточный метод filter() и терминальный метод count().
        long count = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println(count);

        // 2. Для получения списка призывников
        List<String> toArmy = persons.stream()
                .filter(x -> x.getAge() >= 18 && x.getAge() < 27)
                .filter(x -> x.getSex() == Sex.MAN)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println(toArmy);

        // 3. Для получения отсортированного по фамилии списка потенциально работоспособных людей с высшим образованием
        List<Person> workers = persons.stream()
                .filter(x -> x.getEducation() == Education.HIGHER)
                .filter(x -> x.getAge() >= 18)
                .filter(x -> (x.getSex() == Sex.MAN && x.getAge() < 65) || (x.getSex() == Sex.WOMAN && x.getAge() < 60))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(workers);

    }
}