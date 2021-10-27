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

	// same as template
	public static void detectIntentTexts(String projectId, String text, String sessionId, String languageCode)
			throws IOException, ApiException {
		// Instantiates a client
		try (SessionsClient sessionsClient = SessionsClient.create()) {
			// Set the session name using the sessionId (UUID) and projectID (my-project-id)
			SessionName session = SessionName.of(projectId, sessionId);
			// System.out.println("Session Path: " + session.toString());

			// Detect intents for each text input

			// Set the text (hello) and language code (en-US) for the query
			TextInput.Builder textInput = TextInput.newBuilder().setText(text).setLanguageCode(languageCode);

			// Build the query with the TextInput
			QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();

			// Performs the detect intent request
			DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);

			// Display the query result
			QueryResult queryResult = response.getQueryResult();

			// own code
			// get the intent as a String
			String intent = queryResult.getIntent().getDisplayName();
			// print the text answer
			System.out.println(queryResult.getFulfillmentText());
			System.out.println("intent: " + intent);
			// switch-case to treat different intents differently
			switch (intent) {
			case "Default Welcome Intent": // just checking that it is the welcome intent
				System.out.println("hello");
				break;
			case "order.Pizza-yes":
				System.out.println("orderpizza-yes");
					 
					for (int i = 0; i < queryResult.getOutputContextsCount(); i++) {
						if(queryResult.getOutputContexts(i).getName().endsWith("orderpizza-followup")) {
							
							Map<String, Value> parameters = queryResult.getOutputContexts(i).getParameters().getFieldsMap();

							
							double price = Helper.calculatePricePizza(parameters.get("size").getStringValue(), parameters.get("pizza").getStringValue(), parameters.get("delivery-pickup").getStringValue());
							System.out.println("Total price: " + price); 
							SevenSegmentDisplay display = new SevenSegmentDisplay();
							
							display.printLargeNumber(price);
							break;
						}
					}
					
					
				
				break;
			case "order.Pizza":
				
//				System.out.println("Pizza ordered");
				break;
			case "order.waffle":
				System.out.println("Waffle ordered");
				break;
			case "order.icecream":
				System.out.print("Ice cream ordered");
			case "Goodbye":
				System.out.println("Thank you, goodbye");
				break;
			default: // mirrors the intent string and the payload as default (if the intent isn't
						// treated specially)
			}
		}
	}
}
