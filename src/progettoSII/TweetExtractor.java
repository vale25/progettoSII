package progettoSII;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import java.util.Set;
import java.util.TreeSet;


public class TweetExtractor {
	
	public Set<String> getTweets(long id) throws TwitterException {
		Twitter twitter = TwitterFactory.getSingleton();
		ResponseList<Status> lista = twitter.getUserTimeline(id);
		
		Set<String> tweets = new TreeSet<String>();
		for (Status s: lista) {
			if (!s.isRetweet())
				tweets.add(s.getText());
		}
		
		// fa la chiamata altre 4 volte per un totale di 100 tweet
		for (int i=2; i<=5; i++) {
			Paging page = new Paging (i, 20);
			ResponseList<Status> temp = twitter.getUserTimeline(id, page);
			for (Status s: temp) {
				if (!s.isRetweet())
					tweets.add(s.getText());
			}
			temp.clear();
		}
		
		return cleanTweets(tweets);
	}
	
	public Set<String> cleanTweets(Set<String> set) {
		
		String spacePattern = "[\\s]+";
		
		Set<String> noSpace = new TreeSet<String>();
		
		// sostituisce lo spazio con +
        for (String s: set) {
        	String temp = s.replaceAll(spacePattern, "+");
        	String temp2 = temp.replace("%", "");
        	String edited = temp2.replace("#", "");
        	noSpace.add(edited);
     	}
		return noSpace;
	}	
}