package ch.ost.aif.dialogflow.dialogflow;

/**
 * Class for displaying Price output as a seven segment display on the terminal
 * 
 * @author Fadil Smajilbasic
 *
 */
public class SevenSegmentDisplay {

	private final String[][] numbers = { { " - ", "| |", "   ", "| |", " - " }, // 0
			{ "   ", "  |", "   ", "  |", "   " }, // 1
			{ " - ", "  |", " - ", "|  ", " - " }, // 2
			{ " - ", "  |", " - ", "  |", " - " }, // 3
			{ "   ", "| |", " - ", "  |", "   " }, // 4
			{ " - ", "|  ", " - ", "  |", " - " }, // 5
			{ " - ", "|  ", " - ", "| |", " - " }, // 6
			{ " - ", "  |", "   ", "  |", "   " }, // 7
			{ " - ", "| |", " - ", "| |", " - " }, // 8
			{ " - ", "| |", " - ", "  |", " - " } // 9
	};

	private final String[] minus = { "   ", "   ", " - ", "   ", "   " };
	private final String[] point = { "   ", "   ", "   ", "   ", " . " };

	void printLargeNumber(double i) {

		String stringNumber = String.valueOf(i);
		if (i < 0)
			stringNumber = stringNumber.substring(1);

		for (int j = 0; j < 5; j++) {
			if (i < 0) {
				System.out.print(minus[j]);
			}
			for (int k = 0; k < stringNumber.length(); k++) {

				if (46 == (int) stringNumber.charAt(k)) {
					System.out.print(point[j]);
				} else {

					int intNum = ((int) stringNumber.charAt(k)) - 48;
					System.out.print(numbers[intNum][j]);
				}
			}
			System.out.println("");
		}
	}

	void printLargeError() {
		System.out.println(
					  " -             \n" 
					+ "|              \n" 
					+ " -  -  -  -  - \n" 
					+ "|  |  |  | ||  \n"
					+ " -        -    \n");
	}

}
