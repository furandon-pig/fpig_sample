/* MyException.java */

import java.lang.Exception;

public class MyException {

    MyException() throws MyDefinedException {
        throw new MyDefinedException();
    }

    public static void main(String... args) {
        try {
            new MyException();
        } catch (MyDefinedException e) {
            System.out.println(e.toString());
        }
    }

    public class MyDefinedException extends Exception {
        MyDefinedException() {
            super("This is MyDefinedException.");
        }
    }
}

