package progettoSII;

public class WekaPrediction {
		
	public void createPrediction(String[] prova) throws Exception {
		
		int indice = 1;
		int indice2 = 2;
		int indice3 = 3;
		int indice4 = 4;
		int indice5 = 5;
		Prediction a = new Prediction();
		AddTextFile b = new AddTextFile();
		
		int i;
		for(i = 0 ; i<prova.length ; i++){
			StartFile start = new StartFile();
			start.Start(i, prova);
	
			String prediction = a.prediction(indice);
			b.addTextFile(prediction, indice);
			String c = a.prediction(indice2);
			b.addTextFile(c, indice2);
			String d = a.prediction(indice3);
			b.addTextFile(d, indice3);
			String e = a.prediction(indice4);
			b.addTextFile(e, indice4);
			String f = a.prediction(indice5);
			b.addTextFile(f, indice5);
			RefreshFile ref = new RefreshFile();
			ref.Refresh();
		}
	}
}
