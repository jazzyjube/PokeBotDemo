package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonStatCellTest {

    PokemonInfosCell cell = new PokemonInfosCell();

    @Test
    public void testStatLevel() {
    	Tweet tweet = new Tweet("maitre_peter", "@sala_meche #stat #level ?");
        assertEquals("@maitre_peter #level=1 #PokeBattle", cell.ask(tweet));
    }

    @Ignore
    @Test
    public void testStatXp() {
    	Tweet tweet = new Tweet("maitre_peter", "@sala_meche #stat #xp ?");
        assertEquals("@maitre_peter #XP=0 #PokeBattle", cell.ask(tweet));
    }
    
    @Ignore
    @Test
    public void testStatPv() {
    	Tweet tweet = new Tweet("maitre_peter", "@sala_meche #stat #pv ?");
        assertEquals("@maitre_peter #PV=100/100", cell.ask(tweet));
    }

}