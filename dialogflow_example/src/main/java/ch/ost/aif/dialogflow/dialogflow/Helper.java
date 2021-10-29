package ch.ost.aif.dialogflow.dialogflow;

import org.json.*;

public class Helper {

	private class Size {
		final static double SMALL = 0.6d;
		final static double MEDIUM = 1.0d;
		final static double LARGE = 1.6d;
	}

	private class Pizza {
		final static double MARGHERITA = 14d;
		final static double CALZONE = 18d;
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
		final static double ALMOND_MILK = 0.4d;
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

		switch (type) {
		case "margherita":
			total += Pizza.MARGHERITA;
			break;
		case "calzone":
			total += Pizza.CALZONE;
			break;
		}

		total = sizePriceAdjustment(total, size);

		if (delivery.equals("delivery")) {
			total += 2d;
		}

		return total;
	}

	public static double calculatePriceDrink(String size, String drink, String milk, String delivery, String iced,
			double amount) {
		double total = 0;

		switch (drink) {
		case "Coffe":
			total += Drink.COFFE;
			break;
		case "Americano":
			total += Drink.AMERICANO;
			break;
		case "Cappucino":
			total += Drink.CAPPUCCINO;
			break;
		case "Espresso con Panna":
			total += Drink.ESPRESSO_PANNA;
			break;
		case "Espresso":
			total += Drink.ESPRESSO;
			break;
		case "Espresso Macchiato":
			total += Drink.ESPRESSP_MACCHIATO;
			break;
		case "Latte":
			total += Drink.LATTE;
			break;
		case "Macchiato":
			total += Drink.MACCHIATO;
			break;
		case "Hot Choccolate":
			total += Drink.HOT_CHOCCOLATE;
			break;
		case "Tea":
			total += Drink.TEA;
			break;
		case "Barista":
			total += Drink.BARISTA;
			break;
		case "Cocoa":
			total += Drink.COCOA;
			break;
		}

		total = sizePriceAdjustment(total, size);

		switch (milk) {
		case "almond milk":
			total += Milk.ALMOND_MILK;
			break;
		case "cream":
			total += Milk.CREAM;
			break;
		case "non fat milk":
			total += Milk.NON_FAT_MILK;
			break;
		case "regular milk":
			total += Milk.REGULAR_MILK;
			break;
		case "soy milk":
			total += Milk.SOY_MILK;
			break;
		}

		if (iced.equals("true")) {
			total += 2d;
		}

		if (amount != 0) {
			total *= amount;
		}

		if (delivery.equals("delivery")) {
			total += 2d;
		}

		return total;
	}

	public static double calculatePriceWaffle(String size, String waffle, String delivery) {
		double total = 0;
		switch (waffle) {
		case "american":
			total += Waffle.AMERICAN;
			break;
		case "belgian":
			total += Waffle.BELGIAN;
			break;
		case "toaster":
			total += Waffle.TOASTER;
			break;
		case "hong kong egg":
			total += Waffle.HONG_KONG_EGG;
			break;
		}

		total = sizePriceAdjustment(total, size);

		if (delivery.equals("delivery")) {
			total += 2d;
		}
		return total;

	}

	public static double calculatePriceIceCream(String size, String cone, String delivery) {
		double total = 0;
		if (cone.equals("cone"))
			total += IceCream.CONED;
		else
			total += IceCream.CUP;

		total = sizePriceAdjustment(total, size);

		if (delivery.equals("delivery")) {
			total += 2d;
		}
		return total;

	}

	private static double sizePriceAdjustment(double price, String size) {
		switch (size) {
		case "small":
			price *= Size.SMALL;
			break;
		case "medium":
			price *= Size.MEDIUM;
			break;
		case "large":
			price *= Size.LARGE;
			break;
		}
		return price;
	}
}
