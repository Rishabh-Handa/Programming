package learnjava.testmethods;

//final class cannot be inherited
// outer class cannot be static
public class FinalMethods {
    String hello() {
        return "hello from FinalMethods";
    }

    final String hi() {
        return "hi from FinalMethods";
    }

    static String bye() {
        return "bye from FinalMethods";
    }

    public static void main(String[] args) {
        FinalMethods finalMethods = new Subclass();
        System.out.println(finalMethods.hello());
        System.out.println(finalMethods.hi());
        System.out.println(finalMethods.bye());


        System.out.println("---------------");
        Subclass subclass = new Subclass();
        System.out.println(subclass.hello());
        System.out.println(subclass.hi());
        System.out.println(subclass.bye());
    }
}

class Subclass extends FinalMethods{
    String hello() {
        return "hello from Subclass";
    }

    static String bye() {
        return "bye from Subclass";
    }

    //compile time error: final methods cannot be overridden
//    String hi() {
//        return "hi from Subclass";
//    }
}