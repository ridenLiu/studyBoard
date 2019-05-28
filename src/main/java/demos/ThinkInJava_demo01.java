package demos;

public class ThinkInJava_demo01 {
    // finalize()


}

class Book {
    boolean checkedOut = false;

    Book(boolean checkOut) {

        checkedOut = checkOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    @Override
    protected void finalize() throws Throwable {
        if (checkedOut) {
            System.out.println("Error: check out");
            // Normally you will also do this;
            super.finalize(); //Call the base-class version
        }
    }
}

class TerminalCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
        //
        novel.checkIn();
        new Book(true);
        System.gc();
    }
}
