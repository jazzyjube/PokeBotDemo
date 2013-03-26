package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCatchCellTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattle");
    EntityManager em = emf.createEntityManager();
	
    PokemonCatchCell cell = new PokemonCatchCell();

    @Test
    public void testCatchAnswer() throws TwitterException {
    	Tweet tweet = new Tweet("maitre_peter", "@sala_meche Pokeball !!");
        assertEquals("@maitre_peter @maitre_peter is my owner", cell.ask(tweet));
    }

}