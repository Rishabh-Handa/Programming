package learnjava.innerclasses;

public class TestInnerClasses {
    public static void main(String[] args) {
        OuterClass.Inner inner = new OuterClass().new Inner();
        inner.outer();

        System.out.println(Integer.compare(4, 2));
    }
}

class OuterClass {
    void outer() {
        System.out.println("outer");
    }

    class Inner {
        // if this method is commented line 6 will throw error
        void outer() {
            OuterClass.this.outer();
        }
    }
}
