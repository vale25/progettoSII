package progettoSII;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


public class Browser {
	public void browser() throws IOException {
		File file = new File("WebContent/PersonalityGraph.html");
		Desktop.getDesktop().open(file);
	}
}
