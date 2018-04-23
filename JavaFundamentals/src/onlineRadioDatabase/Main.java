package onlineRadioDatabase;

import onlineRadioDatabase.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Song> songs = new ArrayList<>();
        int songsCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < songsCount; i++) {
            String[] inputTokens = reader.readLine().split(";");
            String artist = inputTokens[0];
            String songName = inputTokens[1];
            int minutes = Integer.parseInt(inputTokens[2].split(":")[0]);
            int seconds = Integer.parseInt(inputTokens[2].split(":")[1]);

            try {
                songs.add(new Song(artist, songName, minutes, seconds));
                System.out.println("Song added.");
            } catch (InvalidSongException ise) {
                System.out.println(ise.getMessage());
            }
        }

        int totalHours = 0;
        int totalMinutes = songs.stream().mapToInt(Song::getMinutes).sum();
        int totalSeconds = songs.stream().mapToInt(Song::getSeconds).sum();

        while (totalSeconds > 59) {
            totalMinutes++;
            totalSeconds -= 60;
        }

        while (totalMinutes > 59) {
            totalHours++;
            totalMinutes -= 60;
        }

        System.out.println("Songs added: " + songs.size());
        System.out.printf("Playlist length: %dh %dm %ds", totalHours, totalMinutes, totalSeconds);
    }
}
