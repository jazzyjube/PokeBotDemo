package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonHealCellTest {

    PokemonHealCell cell = new PokemonHealCell();
    PokemonEndOfHealCell cell1 = new PokemonEndOfHealCell();
    
    
    @Test
    public void testFirstHeal() {
    	Tweet tweet = new Tweet("maitre_peter", "@heal_joelle #heal @sala_meche");
        assertEquals("@sala_meche #stat #PV ?", cell.ask(tweet));
    }
    @Ignore
    @Test
    public void testSecondHeal() {
    	Tweet tweet = new Tweet("sala_meche", "@heal_joelle #PV=50/100");
        assertEquals("@sala_meche come in the #pokecenter / @PokeTimer #WakeMeUp 5 Min #Jazz #sala_meche", cell.ask(tweet));
    }
    @Ignore
    @Test
    public void testStatPv() {
    	Tweet tweet = new Tweet("PokeTimer", "@heal_joelle #DringDring #Jazz #sala_meche");
        assertEquals("@maitre_peter @sala_meche is restored to full health", cell1.ask(tweet));
    }

}