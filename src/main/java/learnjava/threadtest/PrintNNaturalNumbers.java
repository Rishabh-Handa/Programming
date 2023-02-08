package learnjava.threadtest;

public class PrintNNaturalNumbers {
    final Object lock = new Object();
    int times;
    int count = 1;

    PrintNNaturalNumbers(int times) {
        this.times = times;
    }

    public static void main(String[] args) throws InterruptedException {
        PrintNNaturalNumbers printNNaturalNumbers = new PrintNNaturalNumbers(5);

        Thread t1 = new Thread(() -> printNNaturalNumbers.printOdd());
        Thread t2 = new Thread(() -> printNNaturalNumbers.printEven());

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    void printOdd() {
        synchronized (lock) {
            try {
                while(count < times) {
                    // use while here so that when thread awakes, it checks again
                    if (count % 2 == 0) {
                        lock.wait();
                    }
                    System.out.println(Thread.currentThread().getName() + " :" + count);
                    count++;
                    lock.notifyAll();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    void printEven() {
        try {
            synchronized (lock) {
                while(count < times) {
                    if (!(count % 2 == 0)) {
                        lock.wait();
                    }
                    System.out.println(Thread.currentThread().getName() + " :" + count);
                    count++;
                    lock.notifyAll();
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

