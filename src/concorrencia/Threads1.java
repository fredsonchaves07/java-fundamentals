package concorrencia;

public class Threads1 {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());

        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(() -> System.out.println("Thread 2 em execucao"));
        thread1.start();
        System.out.println("Hello World");
        thread2.start();
    }
}
