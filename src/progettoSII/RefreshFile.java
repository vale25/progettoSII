package progettoSII;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class RefreshFile {
	public void Refresh() throws FileNotFoundException, IOException{

		try (FileWriter fw = new FileWriter("myPersonalityPrediction.arff", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{ 
			
			    Path path = Paths.get("myPersonalityPrediction.arff");
			    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

			   
			    Files.write(path, lines, StandardCharsets.UTF_8);
			    Charset charset = StandardCharsets.UTF_8;

			    String content = new String(Files.readAllBytes(path), charset);
			    
			    content = content.replace("@attribute sNEU {3.00 , 4.00 , 2.15 , 3.20 , 2.90 , 2.85 , 1.90 , 3.10 , 3.15 , 3.25 , 2.75 , 3.80 , 3.75 , 2.30 , 2.65 , 4.75 , 3.60 , 1.78 , 2.80 , 1.45 , 3.50 , 2.00 , 2.70 , 2.60 , 1.65 , 1.68 , 2.50 , 2.05 , 1.55 , 2.20 , 1.50 , 2.25 , 1.84 , 1.60 , 2.17 , 2.45 , 3.57 , 1.85 , 3.65 , 2.10 , 3.13 , 3.05 , 2.35 , 1.75 , 1.40 , 1.95 , 3.70 , 1.25 , 2.55 , 1.43 , 3.30 , 4.25 , 2.40 , 2.67 , 2.33 , 1.80 , 3.90 , 3.35 , 1.70 , 2.58 , 3.85 , 3.40 , 1.35 , 1.89 , 3.55 , 4.70 , 2.95 , 1.63 , 1.56 , 3.45 , 2.38 , 4.15 , 4.05 } ","% @attribute sNEU {3.00 , 4.00 , 2.15 , 3.20 , 2.90 , 2.85 , 1.90 , 3.10 , 3.15 , 3.25 , 2.75 , 3.80 , 3.75 , 2.30 , 2.65 , 4.75 , 3.60 , 1.78 , 2.80 , 1.45 , 3.50 , 2.00 , 2.70 , 2.60 , 1.65 , 1.68 , 2.50 , 2.05 , 1.55 , 2.20 , 1.50 , 2.25 , 1.84 , 1.60 , 2.17 , 2.45 , 3.57 , 1.85 , 3.65 , 2.10 , 3.13 , 3.05 , 2.35 , 1.75 , 1.40 , 1.95 , 3.70 , 1.25 , 2.55 , 1.43 , 3.30 , 4.25 , 2.40 , 2.67 , 2.33 , 1.80 , 3.90 , 3.35 , 1.70 , 2.58 , 3.85 , 3.40 , 1.35 , 1.89 , 3.55 , 4.70 , 2.95 , 1.63 , 1.56 , 3.45 , 2.38 , 4.15 , 4.05 } ");
			    content = content.replace("@attribute sAGR {3.15 , 3.00 , 3.60 , 3.05 , 3.40 , 2.80 , 4.15 , 3.20 , 3.45 , 4.50 , 2.85 , 1.75 , 2.90 , 3.65 , 2.10 , 4.10 , 3.30 , 3.35 , 4.40 , 2.50 , 3.80 , 4.17 , 3.90 , 3.10 , 3.95 , 4.53 , 4.00 , 3.50 , 3.55 , 4.55 , 2.95 , 3.70 , 4.95 , 3.25 , 2.45 , 2.65 , 3.75 , 4.83 , 4.30 , 4.65 , 3.14 , 4.45 , 3.85 , 4.25 , 1.65 , 4.20 , 5.00 , 4.75 , 3.17 , 2.25 , 3.94 , 4.35 , 2.40 , 3.38 , 2.75 , 4.60 , 3.67 , 1.95 , 2.00 , 4.38 , 2.20 , 4.05 , 2.30 } ","% @attribute sAGR {3.15 , 3.00 , 3.60 , 3.05 , 3.40 , 2.80 , 4.15 , 3.20 , 3.45 , 4.50 , 2.85 , 1.75 , 2.90 , 3.65 , 2.10 , 4.10 , 3.30 , 3.35 , 4.40 , 2.50 , 3.80 , 4.17 , 3.90 , 3.10 , 3.95 , 4.53 , 4.00 , 3.50 , 3.55 , 4.55 , 2.95 , 3.70 , 4.95 , 3.25 , 2.45 , 2.65 , 3.75 , 4.83 , 4.30 , 4.65 , 3.14 , 4.45 , 3.85 , 4.25 , 1.65 , 4.20 , 5.00 , 4.75 , 3.17 , 2.25 , 3.94 , 4.35 , 2.40 , 3.38 , 2.75 , 4.60 , 3.67 , 1.95 , 2.00 , 4.38 , 2.20 , 4.05 , 2.30 } ");
			    content = content.replace("@attribute sCON {3.25 , 4.50 , 3.30 , 3.65 , 3.35 , 2.70 , 4.00 , 3.60 , 2.35 , 5.00 , 3.10 , 3.05 , 3.00 , 4.65 , 2.20 , 2.40 , 4.55 , 4.10 , 4.30 , 3.45 , 2.85 , 3.50 , 2.80 , 4.25 , 3.67 , 2.50 , 2.10 , 3.95 , 2.90 , 4.40 , 3.90 , 4.15 , 3.40 , 4.75 , 2.75 , 3.70 , 3.75 , 1.50 , 3.17 , 4.35 , 3.64 , 1.55 , 4.80 , 2.05 , 3.55 , 1.95 , 2.25 , 3.20 , 4.17 , 2.00 , 3.63 , 2.95 , 3.15 , 4.20 , 3.83 , 2.65 , 4.70 , 2.55 , 2.60 , 3.85 , 3.21 , 4.32 , 1.45 , 4.05 , 4.60 , 4.45 , 3.88 , 3.89 } ", "% @attribute sCON {3.25 , 4.50 , 3.30 , 3.65 , 3.35 , 2.70 , 4.00 , 3.60 , 2.35 , 5.00 , 3.10 , 3.05 , 3.00 , 4.65 , 2.20 , 2.40 , 4.55 , 4.10 , 4.30 , 3.45 , 2.85 , 3.50 , 2.80 , 4.25 , 3.67 , 2.50 , 2.10 , 3.95 , 2.90 , 4.40 , 3.90 , 4.15 , 3.40 , 4.75 , 2.75 , 3.70 , 3.75 , 1.50 , 3.17 , 4.35 , 3.64 , 1.55 , 4.80 , 2.05 , 3.55 , 1.95 , 2.25 , 3.20 , 4.17 , 2.00 , 3.63 , 2.95 , 3.15 , 4.20 , 3.83 , 2.65 , 4.70 , 2.55 , 2.60 , 3.85 , 3.21 , 4.32 , 1.45 , 4.05 , 4.60 , 4.45 , 3.88 , 3.89 } ");
			    content = content.replace("@attribute sOPN {4.40 , 3.75 , 4.10 , 4.75 , 4.05 , 4.15 , 3.55 , 3.80 , 4.50 , 4.00 , 3.95 , 3.50 , 4.20 , 4.60 , 4.25 , 4.55 , 4.70 , 4.35 , 2.50 , 4.30 , 5.00 , 3.85 , 2.65 , 4.80 , 4.90 , 3.65 , 4.65 , 3.70 , 2.85 , 3.30 , 3.90 , 4.33 , 3.57 , 4.95 , 3.63 , 3.45 , 2.75 , 4.84 , 4.13 , 4.45 , 4.42 , 4.83 , 2.25 , 2.70 , 3.25 , 4.17 , 3.05 , 3.38 , 3.15 , 2.90 , 3.47 , 3.61 , 3.60 , 4.85 , 3.40 , 3.35 , 2.63 } ","% @attribute sOPN {4.40 , 3.75 , 4.10 , 4.75 , 4.05 , 4.15 , 3.55 , 3.80 , 4.50 , 4.00 , 3.95 , 3.50 , 4.20 , 4.60 , 4.25 , 4.55 , 4.70 , 4.35 , 2.50 , 4.30 , 5.00 , 3.85 , 2.65 , 4.80 , 4.90 , 3.65 , 4.65 , 3.70 , 2.85 , 3.30 , 3.90 , 4.33 , 3.57 , 4.95 , 3.63 , 3.45 , 2.75 , 4.84 , 4.13 , 4.45 , 4.42 , 4.83 , 2.25 , 2.70 , 3.25 , 4.17 , 3.05 , 3.38 , 3.15 , 2.90 , 3.47 , 3.61 , 3.60 , 4.85 , 3.40 , 3.35 , 2.63 } ");
			    
			    Files.write(path, content.getBytes(charset));

			} catch (IOException f) {
			}
	

        FileInputStream fstream = new FileInputStream("myPersonalityPrediction.arff");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
 
        String strLine;
        String lastLine = "";

        while ((strLine = br.readLine()) != null)   {
        	lastLine = strLine;
        }
    
        br.close();
        
        try(FileWriter fw = new FileWriter("myPersonalityPrediction.arff", true);
    		    BufferedWriter bw = new BufferedWriter(fw);
    		    PrintWriter out = new PrintWriter(bw))
    		{ 
    		
    		    Path path = Paths.get("myPersonalityPrediction.arff");
    		    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

    		   
    		    Files.write(path, lines, StandardCharsets.UTF_8);
    		    Charset charset = StandardCharsets.UTF_8;

    		    String content = new String(Files.readAllBytes(path), charset);
    		    
    		    content = content.replace(lastLine, "% " + lastLine);

    		    Files.write(path, content.getBytes(charset));

    		} catch (IOException f) {
    		}
        
		Files.write(Paths.get("myPersonalityPrediction.arff"), "$,? ".getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);


	}
		
 }

