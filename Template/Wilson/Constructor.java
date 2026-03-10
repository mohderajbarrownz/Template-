
class myApp {

    int x = 10, y = 20, z;

    // Method no Argument
    void sum() {
        z = x + y;
        System.out.println(z);
    }

    // Method With Parameter
    void min(int x, int y) {
        z = x + y;
        System.out.println(z);
    }

    // function No Argument 
    int multi() {
        z = x * y;
        return z;
    }

    int Divide(int x, int y) {
        z = x / y;
        return z;
    }
}

public class Constructor {

    public static void main(String args[]) {
        myApp app = new myApp();
        app.sum();
        app.min(10, 20);
        System.out.println(app.multi());
        System.out.println(app.Divide(10, 20));
    }
}
