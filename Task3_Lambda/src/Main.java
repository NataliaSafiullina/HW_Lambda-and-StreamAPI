import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        // 1. Отфильтруйте положительные числа.
        Predicate<Integer> isPositive = x -> x > 0;
        List<Integer> intListTmp1 = new ArrayList<>();
        for(int i : intList){
            if(isPositive.test(i)){
                intListTmp1.add(i);
            }
        };
        intList = intListTmp1;

        // 2. Найдите среди этих положительных чисел четные.
        Predicate<Integer> isEvenNumber = x -> x % 2 == 0;
        List<Integer> intListTmp2 = new ArrayList<>();
        for(int i : intList){
            if(isEvenNumber.test(i)){
                intListTmp2.add(i);
            }
        };
        intList = intListTmp2;

        // 3. Отсортируйте отфильтрованные числа в порядке возрастания.
        // 4. Выведите результат на экран.
        Collections.sort(intList);
        System.out.println(intList);


    }
}