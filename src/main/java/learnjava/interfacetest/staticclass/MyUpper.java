package learnjava.interfacetest.staticclass;

public interface MyUpper {
    int x = 5;

    class Inner {
        String hello() {
            return "MyUpper.Inner interface: inner hello";
        }
    }
}
