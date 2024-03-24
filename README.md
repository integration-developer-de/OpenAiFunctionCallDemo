# FunctionCallDemo

Dieses Java-Programm demonstriert die Verwendung der OpenAI API, um eine Frage an ein Chatbot-Modell zu senden, das mit GPT-3.5-Turbo trainiert wurde.

## Voraussetzungen

Um dieses Programm auszuführen, benötigen Sie einen gültigen API-Schlüssel von OpenAI. Sie können einen API-Schlüssel von [hier](https://platform.openai.com/api-keys) erhalten. Stellen Sie sicher, dass Ihr Konto ausreichend Guthaben hat, um Anfragen zu bearbeiten.

## Anleitung

1. Ersetzen Sie den Platzhalter `BITE_KEY_ANGEBEN` in der Klasse `FunctionCallDemo` durch Ihren OpenAI-API-Schlüssel.
2. Kompilieren Sie die Java-Datei und führen Sie das Programm aus.
3. Geben Sie eine Frage zu Ländern und Währungen ein, auf die Sie eine Antwort erhalten möchten.
4. Das Programm sendet die Frage an die OpenAI API und gibt die Antwort des Chatbots aus.

## Klasse: FunctionCallDemo

Diese Klasse enthält die `main`-Methode, um das Programm auszuführen, und eine Methode `sendChatRequest`, um die Benutzereingabe an die OpenAI-API zu senden.

### Methoden

- `main(String[] args)`: Diese Methode liest die Benutzereingabe ein, sendet die Anfrage an die API und gibt die Antwort aus.
- `sendChatRequest(String userInput)`: Diese Methode erstellt eine HTTP-Verbindung zum API-Endpunkt, sendet die Benutzereingabe als JSON-Anfrage und gibt die Antwort des Chatbots zurück.

### Beispielverwendung

```java
public class FunctionCallDemo {
    private static final String API_KEY = "YOUR_OPENAI_API_KEY";
    private static final String API_ENDPOINT = "https://api.openai.com/v1/chat/completions";

    public static void main(String[] args) {
        // Code wie oben gezeigt...
    }

    private static String sendChatRequest(String userInput) throws IOException {
        // Code wie oben gezeigt...
    }
}
```
