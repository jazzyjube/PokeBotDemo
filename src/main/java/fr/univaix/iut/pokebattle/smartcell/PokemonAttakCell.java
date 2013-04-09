package fr.univaix.iut.pokebattle.smartcell;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.univaix.iut.pokebattle.Attaque;
import fr.univaix.iut.pokebattle.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.Possede;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokemonAttakCell implements SmartCell {
	
	static final int INDEXATTACK = 2;
	static final int INDEXADV = 3;
	static final int INDEXDRESSADV = 5;
	static final int INDEXJUDGE = 6;
	
    public String ask(Tweet question) {   	
    	
    	String tweet = question.getText();
    	String name = question.getScreenName();
    	
    	String str[] = tweet.split(" ");

    	String attack = str[INDEXATTACK];
    	String pokemon = str[0].substring(1);	
    	String owner;
    	
    	
    	EntityManager em = DAOFactoryJPA.getEntityManager();

        Pokemon poke = em.find(Pokemon.class, pokemon);
        Attaque atkBD = em.find(Attaque.class, attack.substring(1));
        owner = poke.getNomD();
        

    	if (tweet.contains("attack") && owner.equals(name))
    	{
    		
        	String adversaire = str[INDEXADV];
        	String dressAdversaire = str[INDEXDRESSADV];
        	String judge = str[INDEXJUDGE];
	   		
	    	TypedQuery<Attaque> poss = em.createNamedQuery(Possede.FIND_ALL_BY_POKE, Attaque.class);
	        poss.setParameter ("pokemon", poke);
	        List<Attaque> results = poss.getResultList();
	        
	        if(!results.contains(atkBD))
	        {
	        	em.close();
	        	return adversaire +  " o_O ? /cc " + dressAdversaire + " @" + name + " #PokeBattle";
	        }
	        
    		if (name.contains(owner)) { 
    			em.close();
    			return adversaire + " #attack " + attack + " /cc " + dressAdversaire 
    				   + " @" + name + " " + judge + " #PokeBattle"; 
    		}
    		em.close();
    		return "@" + name + " @" + owner + " is my owner !" + " #PokeBattle";  
    	}
    	
    	return null ;
    	}
}