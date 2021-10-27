package ch.ost.aif.dialogflow.dialogflow;

import org.json.*;

public class Helper {

	private class Size {
		final static double SMALL = 0.6d;
		final static double MEDIUM = 1.1;
		final static double LARGE = 1.6;
	}

	private class Pizza {
		final static double MARGHERITA = 4d;
		final static double CALZONE = 8d;
	}

	private class Drink {
		final static double AMERICANO = 3d;
		final static double ESPRESSO = 1d;
		final static double BARISTA = 2d;
		final static double COCOA = 2d;
		final static double CAPPUCCINO = 4d;
		final static double ESPRESSP_MACCHIATO = 2d;
		final static double ESPRESSO_PANNA = 2d;
		final static double LATTE = 1.5d;
		final static double TEA = 1.5d;
		final static double COFFE = 2d;

		final static double HOT_CHOCCOLATE = 2d;
		final static double MACCHIATO = 2.5d;;
	}

	private class Milk {
		final static double CREAM = 0.5d;
		final static double NON_FAT_MILK = 0.3d;
		final static double REGULAR_MILK = 0.5d;
		final static double SOY_MILK = 0.7d;;
	}

	private class IceCream {
		final static double CONED = 1.5d;
		final static double CUP = 1d;
	}

	private class Waffle {
		final static double BELGIAN = 2d;
		final static double AMERICAN = 4d;
		final static double TOASTER = 3d;
		final static double HONG_KONG_EGG = 5d;
	}

	public class Topping {
		final static double CARAMEL = 0.3d;
		final static double CINNAMON = 0.2d;
		final static double CHOCOLATE = 0.4d;
		final static double WHIPPED_CREAM = 0.4d;
	}

	public static double calculatePricePizza(String size, String type, String delivery) {
		double total = 0;
		switch (size) {
		case "small":
			total += Size.SMALL;
			break;
		case "medium":
			total += Size.MEDIUM;
			break;
		case "large":
			total += Size.LARGE;
			break;
		}

		switch (type) {
		case "margherita":
			total += Pizza.MARGHERITA;
			break;
		case "calzone":
			total += Pizza.CALZONE;
			break;
		}

		if (delivery.equals("delivery")) {
			total += 2d;
		}

		return total;
	}
//
//	public static double calculatePriceDrink(String size, String drink, String milk, String delivery, String iced) {
//
//	}
//
//	public static double calculatePriceWaffle(String size, String drink, String milk, String delivery) {
//
//	}
}
