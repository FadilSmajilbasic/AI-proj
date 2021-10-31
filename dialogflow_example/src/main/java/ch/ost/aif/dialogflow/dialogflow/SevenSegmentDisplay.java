package ch.ost.aif.dialogflow.dialogflow;

/**
 * Class for displaying Price output as a seven segment display on the terminal
 * 
 * @author Fadil Smajilbasic
 *
 */
public class SevenSegmentDisplay {

	private final String[][] NUMBERS = { { " - ", "| |", "   ", "| |", " - " }, // 0
			{ "   ", "  |", "   ", "  |", "   " }, // 1
			{ " - ", "  |", " - ", "|  ", " - " }, // 2
			{ " - ", "  |", " - ", "  |", " - " }, // 3
			{ "   ", "| |", " - ", "  |", "   " }, // 4
			{ " - ", "|  ", " - ", "  |", " - " }, // 5
			{ " - ", "|  ", " - ", "| |", " - " }, // 6
			{ " - ", "  |", "   ", "  |", "   " }, // 7
			{ " - ", "| |", " - ", "| |", " - " }, // 8
			{ " - ", "| |", " - ", "  |", " - " }  // 9
	};

	private final String[] MINUS = { "   ", "   ", " - ", "   ", "   " };
	private final String[] POINT = { "   ", "   ", "   ", "   ", " . " };

	void printLargeNumber(double i) {

		String stringNumber = String.valueOf(i);
		if (i < 0)
			stringNumber = stringNumber.substring(1);
		for (int j = 0; j < 5; j++) {
			if (i < 0) {
				System.out.print(MINUS[j]);
			}
			for (int k = 0; k < stringNumber.length(); k++) {

				if (46 == (int) stringNumber.charAt(k)) {
					System.out.print(POINT[j]);
				} else {

					int intNum = ((int) stringNumber.charAt(k)) - 48;
					System.out.print(NUMBERS[intNum][j]);
				}
			}
			System.out.println("");
		}
	}

	void printLargeError() {
		System.out.println(" -             \n" + "|              \n" + " -  -  -  -  - \n" + "|  |  |  | ||  \n"
				+ " -        -    \n");
	}

}
