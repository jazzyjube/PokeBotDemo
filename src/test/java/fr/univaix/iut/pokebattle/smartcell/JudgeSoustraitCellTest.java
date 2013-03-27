package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class JudgeSoustraitCellTest {

    JudgeSoustraitCell cell = new JudgeSoustraitCell();

    @Test
    public void testJudgeAttakAnswer() throws TwitterException {
    	Tweet tweet = new Tweet("Kai_minus", "@sala_meche #attack #griffe /cc @maitre_peter @topdresseur_red @juge_otte");
        assertEquals("@sala_meche -10pv /cc @maitre_peter", cell.ask(tweet)); 
    }
}
