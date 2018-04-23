import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UrlParser {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String protocol = "";
        StringBuilder resource = new StringBuilder();
        String[] urlParts = input.split("://");
        String[] serverRes = urlParts[1].split("/");

        String server = serverRes[0];
        if (urlParts.length == 2) {
            protocol = urlParts[0];

        }

        if (serverRes.length > 1) {
            for (int i = 1; i < serverRes.length; i++) {
                resource.append(serverRes[i]);
                if (i + 1 < serverRes.length) {
                    resource.append("/");
                }
            }
        }

        System.out.println("[protocol] = \"" + protocol + "\"");
        System.out.println("[server] = \"" + server + "\"");
        System.out.println("[resource] = \"" + resource.toString() + "\"");
    }
}
