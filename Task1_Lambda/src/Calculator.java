import java.util.function.*;

public class Calculator {
    // Статическая переменная типа Supplier.
    // Это функциональный интерфейс, реализующий метод get().
    // С помощью данной переменной можно будет получить экземпляр класса Calculator.
    // Реализуйте ссылку на вызов конструктора класса Calculator() { }.
    protected static Supplier<Calculator> instance = Calculator::new;

    // Переменная типа Consumer для вывода числа в консоль.
    // Используйте для этого ссылку на статический метод println()
    protected Consumer<Integer> println = System.out::println;

    // Переменная для проверки числа на положителтность и равенство нулю.
    Predicate<Integer> isPositive = x -> x > 0;
    Predicate<Integer> isZero = x -> x == 0;

    // Переменные для реализации математических операций калькулятора.
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> isZero.test(y) ? null : x / y;
    //BinaryOperator<Integer> devide = (x, y) ->  x / y;
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

}
