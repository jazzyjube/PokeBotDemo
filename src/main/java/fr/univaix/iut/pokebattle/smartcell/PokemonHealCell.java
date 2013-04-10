package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;

import fr.univaix.iut.pokebattle.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonHealCell implements SmartCell {
	
    public String ask(Tweet question) {
    	
    	String tweet = question.getText();
    	String name = question.getScreenName();
    	String str[] = tweet.split(" ");
    	String healPoke = str[0];
    	
    	
    	if (tweet.contains("#heal"))
    	{	
    		
    		String nomPoke = question.getSubstring(2);
            
            return "@" + nomPoke + " #stat #PV ?" + " #PokeBattle"; 
    	}
    	
    	if (tweet.contains("PV=") && healPoke.contains("heal_joelle"))
    	{
    		
    		EntityManager em = DAOFactoryJPA.getEntityManager();
            Pokemon poke = em.find(Pokemon.class, name);
            
            int pvRest = poke.getPvRestant();
            int pvMax = poke.getPvMax();
            String dresseur = poke.getNomD();
            
            if (pvRest == pvMax){

            	
            	return "@" + dresseur + " @" + name + " is already full of health !" + " #PokeBattle";
            }
            
            
         	int minutes = 0;
        	int j = 10;
        	int i = 2;
        	int k = 1;
        	final int divdix = 10;
        	
        	for (;;)
        	{
        		if (pvRest < pvMax/divdix)
        		{
        			minutes = j;
        			break;
        		}
        		
        		--j;
        		
        		if (pvRest >= (pvMax/divdix) * k  &&  pvRest < ( (pvMax/divdix) * i)){
        			minutes = j;
        			break;
        		}
        		
        		++i;
        		++k;
        	}
 		          

    		return "@" + name + " come in the #pokecenter / @PokeTimer #WakeMeUp " 
    				+ minutes + " Min #Jazz #" + name + " #PokeBattle";

    	}
 	
    	return null ;
    	}
}
