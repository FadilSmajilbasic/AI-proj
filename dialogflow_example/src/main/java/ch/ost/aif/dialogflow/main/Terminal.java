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
//			String[] test = {"pizza","margherita","small","soft","delivery","yes"};
			String[] test = {"coffe","delivery","medium","yes"};
			String line = "";
			int i = 0;
			while (true) {
//				line = br.readLine();
				if(i < 4)
					line = test[i];
				else
					line = br.readLine();
				if (line.equals("")) { //skip empty lines
					continue;
				}
				if (line.equals("q")) { // quit the application
					break;
				}
				CustomRequestBuilder.detectIntentTexts("coffee-shop-bpgc", line, "terminal-client", "en-US");
				i++;
			}
			System.out.println("Goodbye");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
