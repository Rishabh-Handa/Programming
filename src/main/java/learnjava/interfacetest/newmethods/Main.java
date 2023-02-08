package learnjava.interfacetest.newmethods;

public class Main {
    public static void main(String[] args) {
        Implementer implementer = new Implementer();
        implementer.print();



        System.out.println(Interface1.x);
    }
}


class Implementer implements Interface2, Interface1 {

    @Override
    public void print() {
        Interface2.super.print();
    }
}
