package giannibussoletti;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bes3g5exampu");

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
