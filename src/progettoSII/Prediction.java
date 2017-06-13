package progettoSII;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

public class Prediction {
	ConverterUtils.DataSource source3;
	public String prediction(int index) throws Exception, IOException{
		String a;
		FileReader file=new FileReader("myPersonalityPrediction.arff");  //address of the file 
        List<String> Lines=new ArrayList<>();  //to store all lines
        Scanner sc=new Scanner(file);
        while(sc.hasNextLine()){  //checking for the presence of next Line
            Lines.add(sc.nextLine());  //reading and storing all lines
        }
        sc.close();  //close the scanner
        
        if(index == 1)
		source3 = new ConverterUtils.DataSource("prediction1.arff");
        
        if(index == 2)
    		source3 = new ConverterUtils.DataSource("prediction2.arff");
        
        if(index == 3)
    		source3 = new ConverterUtils.DataSource("prediction3.arff");
        
        if(index == 4)
    		source3 = new ConverterUtils.DataSource("prediction4.arff");
        
        if(index == 5)
    		source3 = new ConverterUtils.DataSource("prediction5.arff");
        
        Instances train2 = source3.getDataSet();
        // setting class attribute if the data format does not provide this information
        // For example, the XRFF format saves the class attribute information as well
        if (train2.classIndex() == -1)
            train2.setClassIndex(train2.numAttributes() - 1);

        ConverterUtils.DataSource source4 = new ConverterUtils.DataSource("myPersonalityPrediction.arff");
        Instances test2 = source4.getDataSet();
        // setting class attribute if the data format does not provide this information
        // For example, the XRFF format saves the class attribute information as well
        if (test2.classIndex() == -1)
            test2.setClassIndex(train2.numAttributes() - 1);

        // model

        NaiveBayes naiveBayes2 = new NaiveBayes();
        naiveBayes2.buildClassifier(train2);
        
            
        double label2 = naiveBayes2.classifyInstance(test2.instance(0));
        test2.instance(0).setClassValue(label2);
        
        a = test2.instance(0).stringValue(index);
        return a;

        
	}

}