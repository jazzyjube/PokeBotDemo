package fr.univaix.iut.pokebattle;
import javax.persistence.EntityManager;



public class DAOFactoryJPA {

	 private static EntityManager entityManager;

     public static synchronized void setEntityManager(EntityManager entityManager){
         DAOFactoryJPA.entityManager = entityManager;
     }

     public static synchronized EntityManager getEntityManager(){
         return DAOFactoryJPA.entityManager;
     }
     
     
     public static DAOPokemon createDAOPokemon(){
             return new DAOPokemonJPA(entityManager);
     }



     public static DAOCombat createDAOCombat(){
             return new DAOCombatJpa(entityManager);
     }
	
	
}
