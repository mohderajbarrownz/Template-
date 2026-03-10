
class A {

    void sayHello() {
        System.out.println("Hello.............A");
    }
}

public class second {

    public static void main(String agrs[]) {
        A obj = new A() {
            void sayHello() {
                System.out.println("Hello .........Again!!!");
            }
        };
        obj.sayHello();
    }
}
