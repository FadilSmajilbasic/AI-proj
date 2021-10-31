package ch.ost.aif.dialogflow.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ch.ost.aif.dialogflow.dialogflow.CustomRequestBuilder;

public class Terminal {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Hallo, please enter a line for the client and confirm with enter, 'q' for quit");
			String line = "";
			while (true) {
				line = br.readLine();
				if (line.equals("")) {
					continue;
				}
				if (line.equals("q")) {
					break;
				}
				CustomRequestBuilder.detectIntentTexts("coffee-shop-bpgc", line, "terminal-client", "en-US");
			}
			System.out.println("Goodbye");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
