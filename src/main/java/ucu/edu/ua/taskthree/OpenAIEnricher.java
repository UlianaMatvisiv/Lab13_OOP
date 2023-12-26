package ucu.edu.ua.taskthree;
import org.json.JSONObject;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class OpenAIEnricher {
    @SneakyThrows
    public static void main(String[] args) throws IOException {
        URL urlGet = new URL("https://nltu.edu.ua/");
        HttpURLConnection connectionGet = (HttpURLConnection) urlGet
                .openConnection();
        connectionGet.setRequestMethod("GET");
        connectionGet.connect();
        String textGet = new Scanner(connectionGet.getInputStream())
                .useDelimiter("\\Z").next();
        System.out.println(textGet);

        URL urlPost = new URL("https://api.openai.com/v1/completions");
        HttpURLConnection connectionPost = (HttpURLConnection) urlPost
                .openConnection();
        connectionPost.setRequestMethod("POST");
        connectionPost.setRequestProperty("Content-Type",
                 "application/json");
        connectionPost.setRequestProperty("Authorization",
                 "Bearer my api key");

        JSONObject data = new JSONObject();
        data.put("model", "gpt-3.5-turbo");
        data.put("prompt", "Extract logo from " + textGet);

        connectionPost.setDoOutput(true);
        connectionPost.getOutputStream()
                .write(data.toString()
                .getBytes(StandardCharsets.UTF_8));

        String textPost = new Scanner(connectionPost.getInputStream(), 
                StandardCharsets.UTF_8)
                .useDelimiter("\\Z").next();
        System.out.println(textPost);
    }
}
