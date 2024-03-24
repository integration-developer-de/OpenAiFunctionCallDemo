import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FunctionCallDemo {
    // API-Schlüssel zur Authentifizierung
    // https://platform.openai.com/api-keys
    // Achte auf ausreichend Guthaben, ansonsten erhälst du eine Fehlermeldung ->
    // Fehlercode: 401
    private static final String API_KEY = "BITE_KEY_ANGEBEN";
    // API-Endpunkt URL
    private static final String API_ENDPOINT = "https://api.openai.com/v1/chat/completions";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // Benutzer zur Eingabe einer Frage auffordern
            System.out.println(
                    "Willkommen beim Finanzexperten FunctionCallDemo! Welche Länder verwenden die Währung? Bitte Währung angeben: ");
            // Benutzereingabe lesen
            String userInput = reader.readLine();
            // Benutzereingabe an das Chatbot-API senden und die Antwort erhalten
            String response = sendChatRequest(userInput);
            // Die Antwort des Chatbots anzeigen
            System.out.println("Antwort des Chatbots:");
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String sendChatRequest(String userInput) throws IOException {
        // Verbindung zum API-Endpunkt herstellen
        URL url = new URL(API_ENDPOINT);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
        connection.setDoOutput(true);

        // JSON-Eingabestring mit Benutzereingabe vorbereiten
        String jsonInputString = "{\"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"user\", \"content\": \"" +
                userInput + "\"}], \"functions\": [{\"name\": \"currencyQuery\", \"description\": " +
                "\"Gibt den Namen der Währung und die Länder aus, die sie verwenden.\", \"parameters\": {\"type\": " +
                "\"object\",\"properties\": {\"country\": {\"type\": \"string\",\"description\": " +
                "\"Wenn mehrere Länder: 'Semikolongetrennte Liste der Länder'. Ansonsten: 'Land'\"}," +
                "\"currencyName\": {\"type\": \"string\",\"description\": \"Name und Symbol der Währung\"}}," +
                "\"required\": [\"country\",\"currencyName\"]}}],\"function_call\": \"auto\"}";

        // Anfrage an API mit JSON-Eingabestring senden
        connection.getOutputStream().write(jsonInputString.getBytes("UTF-8"));

        // Antwort von API lesen
        StringBuilder response = new StringBuilder();
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
        } else {
            System.out.println("Fehler beim Abrufen der Antwort. Fehlercode: " + responseCode);
        }

        return response.toString();
    }
}