package learnjava.interfacetest.staticclass;

public class Main {
    public static void main(String[] args) {
        MyUpper.Inner inner = new MyUpper.Inner();

        //UpperClass.InnerClass innerClass = new UpperClass.InnerClass();
        System.out.println(inner.hello());
    }
}
