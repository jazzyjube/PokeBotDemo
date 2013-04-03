package fr.univaix.iut.pokebattle.bot;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.smartcell.JudgeSoustraitCell;
import fr.univaix.iut.pokebattle.smartcell.JudgeStartFightCell;
import fr.univaix.iut.pokebattle.smartcell.JudgeWinCell;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class JudgeBot implements Bot {
    /**
     * List of smartcell the questions go through to
     * find an answer.
     */
	final SmartCell[] smartCells = new SmartCell[]{
            new JudgeSoustraitCell(),
            new JudgeWinCell(),
            new JudgeStartFightCell()

    };

    /**
     * Ask something to Bot, it will respond to you.
     *
     * @param question The question you ask.
     * @return An answer... or null if it doesn't get it.
     * @throws TwitterException 
     */
    @Override
    public String ask(Tweet question) throws TwitterException {
        for (SmartCell cell : smartCells) {
            String answer = cell.ask(question);
            if (answer != null)
                return answer;
        }
        return null;
    }

}
