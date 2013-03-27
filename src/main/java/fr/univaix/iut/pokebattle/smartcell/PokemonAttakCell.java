package fr.univaix.iut.pokebattle.smartcell;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.Pokemon;
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
    	
    	String attack = str[2];
    	String pokemon = str[0].substring(1);	
    	String owner;
    	
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
        EntityManager em = emf.createEntityManager();

        Pokemon poke = em.find(Pokemon.class, pokemon);
        owner = poke.getNomD();
    		
    		if (Name.contains(owner)) { return adversaire + " #attack " + attack + "! /cc " + DressAdversaire + " @" + Name + " @juge_otte"; }
    		
    		return "@" + Name + " @" + owner + " is my owner !";  
    	}
    	
    	return null ;
    	}
}
