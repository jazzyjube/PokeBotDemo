package fr.univaix.iut.pokebattle.smartcell;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.univaix.iut.pokebattle.Attaque;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.Possede;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokemonAttakCell implements SmartCell {
	
    public String ask(Tweet question) {   	
    	
    	String Tweet = question.getText();
    	String Name = question.getScreenName();
    	
    	

    	if (Tweet.contains("attack"))
    	{
    		
    		
	   		String str[] = Tweet.split(" ");
	    	String adversaire = str[3];
	    	String DressAdversaire = str[5];
	    	String Judge = str[6];
	    	String attack = str[2];
	    	String pokemon = str[0].substring(1);	
	    	String owner;
	    	
	    	
	    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
	        EntityManager em = emf.createEntityManager();
	
	        Pokemon poke = em.find(Pokemon.class, pokemon);
	        Attaque atkBD = em.find(Attaque.class, attack.substring(1));
	        owner = poke.getNomD();
	        
	    	TypedQuery<Attaque> poss = em.createNamedQuery(Possede.FIND_ALL_BY_POKE, Attaque.class);
	        poss.setParameter ("pokemon", poke);
	        List<Attaque> results = poss.getResultList();
	        
	        if(!results.contains(atkBD))
	        {
	        	return adversaire +  " o_O ? /cc " + DressAdversaire + " @" + Name;
	        }
	        
    		if (Name.contains(owner)) { 
    			return adversaire + " #attack " + attack + "! /cc " + DressAdversaire + " @" + Name + " " + Judge; 
    		}
    		
    		return "@" + Name + " @" + owner + " is my owner !";  
    	}
    	
    	return null ;
    	}
}