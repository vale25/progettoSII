package progettoSII;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateJavascript {

	public void create(Double[] big5) throws IOException {
		
		FileWriter fw = new FileWriter("WebContent/big5.js");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("var ext = "+ big5[0]);
		bw.write("\n");
		bw.write("var neu = "+ big5[1]);
		bw.write("\n");
		bw.write("var agr = "+ big5[2]);
		bw.write("\n");
		bw.write("var con = "+ big5[3]);
		bw.write("\n");
		bw.write("var opn = "+ big5[4]);
		bw.close();
	}
}
