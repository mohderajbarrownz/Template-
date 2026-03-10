
class Bank {

    String bankName;

    Bank(String name) {
        bankName = name;
    }
}

class Account extends Bank {

    int balance;

    Account(String name, int bal) {
        super(name);
        balance = bal;
    }

    void show() {
        System.out.println(bankName + " Balance: " + balance);
    }
}

public class fourth {

    public static void main(String args[]) {
        Account obj = new Account("SBI", 49999);
        obj.show();
    }
}
