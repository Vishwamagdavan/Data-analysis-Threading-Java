package AnalyticsSystem;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AnalyticsDriver {

	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter File Name(Default wordlist.txt):");
		String fileName="wordlist.txt";
		System.out.println();
		DataReader filereader=new DataReader(fileName);
		ExecutorService executor=Executors.newFixedThreadPool(10);
		executor.execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					filereader.readFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		//filereader.readFile();
		filereader.printResult();
		executor.shutdown();
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		sc.close();
	}

}
