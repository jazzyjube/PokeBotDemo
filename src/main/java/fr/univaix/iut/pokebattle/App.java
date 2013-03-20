package fr.univaix.iut.pokebattle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App 
{
    public static void main( String[] args )
    {
        // Initializes the Entity manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
        EntityManager em = emf.createEntityManager();

        Pokemon pika = em.find(Pokemon.class, "sala_meche");
        System.out.println("\n" + pika.getNomP() + " appartient a " + pika.getNomD());
        em.close();
        emf.close();
    }
}