package progettoSII;


import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("enter a Twitter username or user id:");
		String username = keyboard.nextLine();
		keyboard.close();
		
		Long id = null;
		boolean isId = true;
		
		try {
			id = Long.valueOf(username);
		}
		catch  (NumberFormatException e) {
			isId = false;
		}
		
		Twitter twitter = TwitterFactory.getSingleton();
		
		User u;
		if (isId) {
			try {
				u = twitter.showUser(id);
			}
			catch (TwitterException e) {
				System.out.println("This user does not exist! Run again and try another one.");
				return;
			}
		}
			
		else {
			try {
				u = twitter.showUser(username);
				id = u.getId();
			}
			catch (TwitterException e) {
				System.out.println("This user does not exist! Run again and try another one.");
				return;
			}
		}
		
		boolean isPrivate = u.isProtected();
		
		if (isPrivate) {
			System.out.println("This user profile is private! Run again and try another one.");
			return;
		}
		
		else {
		
			TweetExtractor tweetExtractor = new TweetExtractor();
			Tagme tagme = new Tagme();
			WekaPrediction weka = new WekaPrediction();
			WeightedBig5 weighted = new WeightedBig5();
			ResetFile reset = new ResetFile();
			CreateJavascript create = new CreateJavascript();
			Browser browser = new Browser();
			
			Set<String> tweets = tweetExtractor.getTweets(id);
			
			if (tweets.size()<10) {
				System.out.println("This user profile does not have enough (or no) tweets to predict his personality!Run again and try another one.");
				return;
			}
			else {
				System.out.println("Loading prediction...");
				Map<String, Integer> wordFrequency = tagme.wordFrequency(tagme.tweets2keywords(tweets));
				String[] keywords = tagme.list2array(tagme.uniqueKeywords(tagme.tweets2keywords(tweets)));
				weka.createPrediction(keywords);
				ReadBig5Data read = new ReadBig5Data();
				Map<String, Double[]> map = read.parseData();
				Double[] big5 = weighted.assignWeight(wordFrequency, map);
				reset.reset();
				create.create(big5);
				System.out.println("Analysis completed!");
				browser.browser();
			}
		}
	}		
}