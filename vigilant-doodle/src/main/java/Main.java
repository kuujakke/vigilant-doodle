package logiikka;

/**
 * Created by kuujakke on 22.12.2016.
 */
public class Main {
    public static void main(String[]args) {
        System.out.println("Hurraa!");
        Task test = new Task("TestTask", "Testing", new Supervisor("TestSupervisor", new User("TestUser")));
        System.out.println(test);
    }
    public static void testi(int i) {
        System.out.println(i);
    }
}

