package learnjava.genericstest;

import java.io.FileReader;

public class TestGenerics {
    public static void main(String[] args) {
        GenericsDemo demo = new GenericsDemo();
        demo.myMethod(23);
        demo.myMethod("hello");
    }

    static class GenericsDemo {
        public <T> void myMethod(T input) {
            System.out.println("type of input = " + input.getClass());
            System.out.println("value = " + input);
        }
    }
}
