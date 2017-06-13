package progettoSII;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadBig5Data {
	
	public List<String> readData() throws IOException {
		
		List<String> list = new ArrayList<String>();
		FileReader fr = new FileReader("myPersonalityPrediction.arff");
		BufferedReader br = new BufferedReader(fr);
		for (int i=0; i<11; i++) 
			br.readLine();
		String line = null;
		while ((line = br.readLine()) != null) {
			String edited = line.substring(2);
			list.add(edited);
		}
		br.close();
		list.remove(list.size()-1);
		return list;
	}
	
	public Map<String, Double[]> parseData() throws IOException {
		List<String> list = readData();
		Map<String, Double[]> big5 = new HashMap<String, Double[]>();
		for (String s: list) {
			Pattern pattern = Pattern.compile("([^,]*)");
			Matcher matcher = pattern.matcher(s);
			if (matcher.find()) {
				String temp = matcher.group(1);
				String word = temp.replace("% ", "");
				String values = s.replace(temp, "").substring(1);
				String[] splitted = values.split(",");
				Double[] val = new Double[5];
				for (int i=0; i<5; i++) 
					val[i] = Double.valueOf(splitted[i]);
				big5.put(word, val);
			}
		}
		return big5;
	}
}
