package progettoSII;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ResetFile {
	public void reset() throws Exception {
		FileReader in = new FileReader("myPersonalityPrediction.arff");
        
        BufferedReader reader = new BufferedReader(in);

        String[] lines = new String[11];

        for(int i = 0; i<11; i++){
        		String s = reader.readLine();
        		lines[i] = s;
        }
        
        File tempFile = new File("myPersonalityPrediction.arff");
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        
        for(int i = 0; i<11; i++){
        	writer.write(lines[i]);
        	writer.write("\n");
        }
        
        writer.close(); 
        reader.close(); 
        
        Path path = Paths.get("myPersonalityPrediction.arff");
	    List<String> lines2 = Files.readAllLines(path, StandardCharsets.UTF_8);
	    Files.write(path, lines2, StandardCharsets.UTF_8);
	    Charset charset = StandardCharsets.UTF_8;

	    String content = new String(Files.readAllBytes(path), charset);
	    
	    content = content.replace(lines[2], "@attribute STATUS {+}");
	    Files.write(path, content.getBytes(charset));
		Files.write(Paths.get("myPersonalityPrediction.arff"), "$,? ".getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);

	}

}