public class Main {
    public static void main(String[] args) {

        // Создаем экземпляр класса Calculator через вызов статической переменной instance
        Calculator calc = Calculator.instance.get();

        // Проверм работу калькулятора
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        // Код не будет работать из-за: ошибки деления на ноль ("/ by zero").
        // Для устранения ошибки сделаю так (хотя я совсем еще не профи в этом):
        // перед делением вызвать проверку делитля на равенскто нулю:
        // -- если делитель равен нулю,
        // 1. вернём результат например null,
        // 2. при попытке вставить результат null в тип int возникнет исключение,
        // 3. вставим обработку возникающего исключения;
        // -- иначе, делаем деление как обычно.
        // * Можно сразу отлавливать "/ by zero", но мне хотелось создать и применть Предикат.
        try {
            int c = calc.devide.apply(a, b);
            calc.println.accept(c);
        } catch (NullPointerException e) {
            System.out.println("Делитель равен нулю.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}