public class Main {
    public static void main(String[] args) {

        // Определите переменную listener типа OnTaskDoneListener через лямбда-выражение
        OnTaskDoneListener listener = System.out::println;

        // Создание экземпляра класса Worker, передаём в конструктор класса listener
        Worker worker = new Worker(listener);
        worker.start();
    }
}

