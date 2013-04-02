package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAttakCellTest {

    PokemonAttakCell cell = new PokemonAttakCell();

    @Test
    public void testAttakAnswer() {
    	Tweet tweet = new Tweet("maitre_peter", "@sala_meche #attack #griffe @kai_minus /cc @topdresseur_red");
        assertEquals("@kai_minus #attack #griffe! /cc @topdresseur_red @maitre_peter", cell.ask(tweet));
    }
    @Test
    public void testAttackFail() {
    	Tweet tweet = new Tweet("maitre_peter", "@sala_meche #attack #UMAD @kai_minus /cc @topdresseur_red");
        assertEquals("@kai_minus o_O ? /cc @topdresseur_red @maitre_peter", cell.ask(tweet));
    }
}
