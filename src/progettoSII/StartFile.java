package progettoSII;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StartFile {
	public void Start(int contArray, String[] prova) throws Exception {	
	
	
	try(FileWriter fw = new FileWriter("myPersonalityPrediction.arff", true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		{ 
		
		    Path path = Paths.get("myPersonalityPrediction.arff");
		    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

		   
		    Files.write(path, lines, StandardCharsets.UTF_8);
		    Charset charset = StandardCharsets.UTF_8;

		    String content = new String(Files.readAllBytes(path), charset);
		    
		    content = content.replace("+", prova[contArray] + "," + "+");
		    content = content.replace("$", prova[contArray]);

		    Files.write(path, content.getBytes(charset));

		} catch (IOException f) {
		}
				
}

}