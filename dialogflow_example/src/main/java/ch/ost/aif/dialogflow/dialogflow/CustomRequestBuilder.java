package ch.ost.aif.dialogflow.dialogflow;

import java.io.IOException;
import java.util.Map;

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.QueryResult;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.TextInput;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;

public class CustomRequestBuilder {

	public static void detectIntentTexts(String projectId, String text, String sessionId, String languageCode)
			throws IOException, ApiException {
		try (SessionsClient sessionsClient = SessionsClient.create()) {
			SessionName session = SessionName.of(projectId, sessionId);
			TextInput.Builder textInput = TextInput.newBuilder().setText(text).setLanguageCode(languageCode);
			QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();
			DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);

			QueryResult queryResult = response.getQueryResult();

			String intent = queryResult.getIntent().getDisplayName();

			System.out.println(queryResult.getFulfillmentText());

			switch (intent) {
			case "order.Pizza-yes":

				for (int i = 0; i < queryResult.getOutputContextsCount(); i++) {
					if (queryResult.getOutputContexts(i).getName().endsWith("orderpizza-followup")) {

						Map<String, Value> parameters = queryResult.getOutputContexts(i).getParameters().getFieldsMap();

						double price = Helper.calculatePricePizza(parameters.get("size").getStringValue(),
								parameters.get("pizza").getStringValue(),
								parameters.get("delivery-pickup").getStringValue());
						SevenSegmentDisplay display = new SevenSegmentDisplay();

						display.printLargeNumber(price);
						break;
					}
				}

				break;

			case "order.drink.same_card":
			case "order.drink.different_card":
				if (queryResult.getAllRequiredParamsPresent()) {
					for (int i = 0; i < queryResult.getOutputContextsCount(); i++) {
						if (queryResult.getOutputContexts(i).getName().endsWith("orderdrink-followup")) {

							Map<String, Value> parameters = queryResult.getOutputContexts(i).getParameters()
									.getFieldsMap();

							double price = Helper.calculatePriceDrink(parameters.get("size").getStringValue(),
									parameters.get("drink").getStringValue(),
									parameters.get("milk-type").getStringValue(),
									parameters.get("delivery-pickup").getStringValue(),
									parameters.get("iced").getStringValue(), parameters.get("amount").getNumberValue());

							SevenSegmentDisplay display = new SevenSegmentDisplay();

							display.printLargeNumber(price);
							break;
						}
					}
				}

				break;
			case "order.waffle-yes":

				if (queryResult.getAllRequiredParamsPresent()) {
					for (int i = 0; i < queryResult.getOutputContextsCount(); i++) {
						if (queryResult.getOutputContexts(i).getName().endsWith("orderwaffle-followup")) {

							Map<String, Value> parameters = queryResult.getOutputContexts(i).getParameters()
									.getFieldsMap();

							double price = Helper.calculatePriceWaffle(parameters.get("size").getStringValue(),
									parameters.get("waffle").getStringValue(),
									parameters.get("delivery-pickup").getStringValue());
							SevenSegmentDisplay display = new SevenSegmentDisplay();

							display.printLargeNumber(price);
							break;
						}
					}
				}

				break;
			case "order.icecream-yes":
				if (queryResult.getAllRequiredParamsPresent()) {
					for (int i = 0; i < queryResult.getOutputContextsCount(); i++) {
						if (queryResult.getOutputContexts(i).getName().endsWith("ordericecream-followup")) {

							Map<String, Value> parameters = queryResult.getOutputContexts(i).getParameters()
									.getFieldsMap();

							double price = Helper.calculatePriceIceCream(parameters.get("size").getStringValue(),
									parameters.get("ice_cream").getStringValue(),
									parameters.get("delivery-pickup").getStringValue());

							SevenSegmentDisplay display = new SevenSegmentDisplay();

							display.printLargeNumber(price);
							break;
						}
					}
				}
			case "Goodbye":
				System.out.println("Thank you, goodbye");
				break;
			}
		}
	}
}
