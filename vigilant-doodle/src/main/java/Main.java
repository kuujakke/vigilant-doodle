package logiikka;

/**
 * Created by kuujakke on 22.12.2016.
 */
public class Main {
    public static void main(String[]args) {
        System.out.println("Hurraa!");
        User user = new User("TestUser", "password");
        Task task = new Task("TestTask");
        Supervisor supervisor = new Supervisor(user, task);
        System.out.println(supervisor);
    }
    public static void testi(int i) {
        System.out.println(i);
    }
}

