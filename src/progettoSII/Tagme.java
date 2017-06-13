package progettoSII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Tagme {
	
	  private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	  }
	  
	  public String[] list2array(Set<String> l) {
		  String[] s = new String[l.size()];
		  Iterator<String> iter = l.iterator();
		  int i = 0;
		  while(iter.hasNext()) {
			  String elem = iter.next();
			  s[i] = elem;
			  i++;
		  }
		  return s;
	  }
	  
	  public List<String> tweets2keywords(Set<String> tweets) throws IOException, JSONException{

		  List<String> keywords = new ArrayList<String>();
		  for (String s: tweets) {
			  JSONObject json = readJsonFromUrl("https://tagme.d4science.org/tagme/tag?lang=en&tweet=true&gcube-token=edc123ea-fe22-48c0-90d1-3f8b11c82116-843339462&text="+s);
			  JSONArray titles = json.getJSONArray("annotations");
			  for (int i=0; i<titles.length(); i++) {
				  String spot = ((JSONObject)titles.get(i)).get("spot").toString();
				  if (!spot.contains(" ")) {
					  String edited = null;
					  if(spot.contains("'"))
						  edited = spot.replace("'", "");
					  else
						  edited = spot;
					  keywords.add(edited.toLowerCase());
				  }
			  }
		  }
		  return keywords;
	  }
	  
	  public Set<String> uniqueKeywords(List<String> l) {
		  Set<String> unique = new TreeSet<String>();
		  for (String s: l)
			  unique.add(s);
		  return unique;
	  }
	  
	  public Map<String, Integer> wordFrequency(List<String> list) {
		  Map<String, Integer> freq = new HashMap<String, Integer>();
		  for (String s: list) {
			  if (!freq.containsKey(s)) 
				  freq.put(s, 1);
			  else
				  freq.put(s, freq.get(s)+1);
		  }
		  return freq;
	  }
}