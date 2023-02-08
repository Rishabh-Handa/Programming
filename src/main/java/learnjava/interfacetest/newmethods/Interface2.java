package learnjava.interfacetest.newmethods;

public interface Interface2 {
    default void print() {
        System.out.println("interface 2: print");
    }

    static void log() {
        System.out.println("Interface2: log method");
    }
}
