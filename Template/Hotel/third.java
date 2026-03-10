
class A {

    void sayHello() {
        System.out.println("Hello....class A.....!");
    }
}

public class third {

    public static void main(String args[]) {
        A obj = new A() {
            void sayHello() {
                System.out.println("Hello...........Again!!!! ");

            }
        };
        obj.sayHello();
        (new A() {
            void sayHello() {
                System.out.println("Hello...........Doing Again..! ");
            }
        }).sayHello();
    }
}
