package AnalyticsSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class DataReader {
	private String filename = null;
	private final String END_OF_FILE = null;
	private final char NEW_LINE='#';
	private Data analytics_data = null;
	private HashMap<String,Integer> words;
	DataReader(String filename) {
		this.filename = filename;
		analytics_data = new Data();
		words=new HashMap<>();
	}
	public void printResult() {
		System.out.println("Average Word Length:"+analytics_data.getAvgwordlength());
		System.out.println("Max Word Length:"+analytics_data.getMaxlength());
		System.out.println("Min Word Length:"+analytics_data.getMinlength());
		System.out.println("Total Number of Words:"+analytics_data.getTotalwords());
//		int maxrepeated=0;
//		String maxrepeatedword=null;
//		for(Map.Entry<String,Integer> entry: words.entrySet()) {
//			if(entry.getValue()>maxrepeated) {
//				maxrepeated=entry.getValue();
//				maxrepeatedword=entry.getKey();
//			}
//		}
//		analytics_data.setMostCommonword(maxrepeatedword);
		System.out.println("Most common Word:"+analytics_data.getMostCommonword());
	}
	public synchronized void readFile() throws IOException {
		BufferedReader reader;
		int maxlength=Integer.MIN_VALUE,minlength=Integer.MAX_VALUE;
		try {
			reader=new BufferedReader(new FileReader(filename));
			String line=reader.readLine();
			int wordcount=0,wordlength=0;
			while(line!=END_OF_FILE) {
				if(line.charAt(0)==NEW_LINE) {
					line=reader.readLine();
					continue;
				}
				words.put(line, words.getOrDefault(line, 0)+1);
				wordlength+=line.length();
				maxlength=Math.max(maxlength, line.length());
				minlength=Math.min(minlength, line.length());
				wordcount++;
				line=reader.readLine();
			}
			analytics_data.setAvgwordlength(wordlength/wordcount);
			analytics_data.setMaxlength(maxlength);
			analytics_data.setMinlength(minlength);
			analytics_data.setTotalwords(wordcount);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File Not found!");
		}
	}
}
