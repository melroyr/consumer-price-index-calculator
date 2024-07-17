package com.tedredington.ConsumerPriceIndexCalculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProcessFile {
	
	public static void main(String[]  args) throws IOException {
		String filenamein = "C:/Projects/consumer-price-index-calculator/src/main/resources/data/CPIUSBLSOut.csv";
		String filenameout = "C:/Projects/consumer-price-index-calculator/src/main/resources/data/CPIUSBLSOuter.csv";
		
		BufferedReader reader = new BufferedReader(new FileReader(new File(filenamein)));
		FileWriter writer = new FileWriter(new File(filenameout));
		String line;
		boolean header=true;
		while ((line = reader.readLine()) != null) {
			StringBuilder sb = new StringBuilder();
			if (header == true) {
				sb.append(line);
				writer.write(sb.toString()+"\n");
				writer.flush();
				header = false;
			} else {
				sb.append(line.substring(0, 38));
				sb.append(",a\n");
				writer.write(sb.toString());
				writer.flush();
			}
			
	    }
		writer.close();
		reader.close();
		System.out.println("Done");
				
	}

}
