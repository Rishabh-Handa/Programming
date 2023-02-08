package learnjava.staticmethod.overridestatic;

public class MainRunner {
    public static void main(String[] args) {
        ClassB classB = new ClassB();

        ClassA classA = new ClassB();

        System.out.println(classB.staticMethod());

        System.out.println(classA.staticMethod());
    }
}

class ClassA {
    static String staticMethod() {
        return "hello: A";
    }
}

class ClassB extends ClassA{
    static String staticMethod() {
        return "hello: B";
    }
}
