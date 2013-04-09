package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.Possede;
import fr.univaix.iut.pokebattle.PossedeID;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAttakInfoCell implements SmartCell {
	
    public String ask(Tweet question) {
    	
    	String Tweet = question.getText();
    	String Name = question.getScreenName();

    	if (Tweet.contains("statAttack"))
    	{
    		String str[] = Tweet.split(" ");
    		String nompoke = str[0].substring(1);
    		String nomAttaque = str[3].substring(1);
    		
    		
    		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
            EntityManager em = emf.createEntityManager();
     
            PossedeID ID = new PossedeID(nompoke, nomAttaque);
            Possede poke = em.find(Possede.class, ID);

            em.close();
            emf.close();
            
    		return "@" + Name + " #" + nomAttaque + " #PPrestant="+ poke.getPpRestant() + " #PokeBattle";
    	}
    	return null ;
    	}
}