package learnjava.interfacetest.newmethods;

public interface Interface1 {
    int x = 0;
    default void print() {
        System.out.println("print method");
    }

    static void log() {
        System.out.println("log method");
    }
}
