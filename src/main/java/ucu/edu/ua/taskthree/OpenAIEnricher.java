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
        URL url_get = new URL("https://nltu.edu.ua/");
        HttpURLConnection connection_get = (HttpURLConnection) url_get.openConnection();
        connection_get.setRequestMethod("GET");
        connection_get.connect();
        String text_get = new Scanner(connection_get.getInputStream()).useDelimiter("\\Z").next();
        System.out.println(text_get);

        URL url_post = new URL("https://api.openai.com/v1/completions");
        HttpURLConnection connection_post = (HttpURLConnection) url_post.openConnection();
        connection_post.setRequestMethod("POST");
        connection_post.setRequestProperty("Content-Type", "application/json");
        connection_post.setRequestProperty("Authorization", "Bearer my api key");

        JSONObject data = new JSONObject();
        data.put("model", "gpt-3.5-turbo");
        data.put("prompt", "Extract logo from " + text_get);

        connection_post.setDoOutput(true);
        connection_post.getOutputStream().write(data.toString().getBytes(StandardCharsets.UTF_8));

        String text_post = new Scanner(connection_post.getInputStream(), StandardCharsets.UTF_8)
                .useDelimiter("\\Z").next();
        System.out.println(text_post);
    }
}
