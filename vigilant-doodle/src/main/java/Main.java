package logiikka;

/**
 * Created by kuujakke on 22.12.2016.
 */
public class Main {
    public static void main(String[]args) {
        System.out.println("Hurraa!");
        Task test = new Task("TestTask", new Supervisor(new User("TestUser", "password")));
        System.out.println(test);
    }
    public static void testi(int i) {
        System.out.println(i);
    }
}

