package advertisementMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] phrases = new String[]{"Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = new String[]{"Now I feel good.", "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = new String[]{"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
        int messagesCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < messagesCount; i++) {
            int randomNumPhrase = ThreadLocalRandom.current().nextInt(0, phrases.length);
            int randomNumEvent = ThreadLocalRandom.current().nextInt(0, events.length);
            int randomNumAuthor = ThreadLocalRandom.current().nextInt(0, authors.length);
            int randomNumCity = ThreadLocalRandom.current().nextInt(0, cities.length);
            System.out.printf("%s %s %s - %s%n", phrases[randomNumPhrase], events[randomNumEvent],
                    authors[randomNumAuthor], cities[randomNumCity]);
        }
    }
}
