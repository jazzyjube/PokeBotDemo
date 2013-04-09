package fr.univaix.iut.pokebattle.smartcell;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public interface SmartCell {
    /**
     * Ask a question... get an answer!
     *
     * @param question
     * @return the answer when the Cell can reply to the question
     *         or null.
     * @throws TwitterException 
     */
    abstract String ask(Tweet question) throws TwitterException;
}
