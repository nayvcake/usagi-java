package org.rabbithousecorp;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class Usagi {
    private String URL_API = "https://usagiapi.danielagc.repl.co/api/";

    private String endpoint(String point) {
        return "/" + point;
    }


    private JsonNode makeRequest(String point)  {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(this.URL_API + this.endpoint(point))
                    .build();

            Response response = client.newCall(request).execute();
            JsonNode objectMapper = null;
            try {
                objectMapper = new ObjectMapper().readTree(response.body().string());
            } catch (JsonMappingException e) {
                e.printStackTrace();
            }

            return objectMapper;
        } catch (IOException ignored) {

        }
        return null;
    }

    /**
     * Well, I don't see why you receive it in JSON because it only has the image's URL so it's easier to return only the URL.
     * If you are using a bot in Discord you can either return this to an Embed.imageURL or return an ordinary message.
     * {@return String}
     */
    public String dance() {
        return this.makeRequest("dance").get("url").asText();
    }

    /**
     * Well, I don't see why you receive it in JSON because it only has the image's URL so it's easier to return only the URL.
     * If you are using a bot in Discord you can either return this to an Embed.imageURL or return an ordinary message.
     * {@return String}
     */
    public String feed() {
        return this.makeRequest("feed").get("url").asText();
    }

    /**
     * Well, I don't see why you receive it in JSON because it only has the image's URL so it's easier to return only the URL.
     * If you are using a bot in Discord you can either return this to an Embed.imageURL or return an ordinary message.
     * {@return String}
     */
    public String hug() {
        return this.makeRequest("hug").get("url").asText();
    }

    /**
     * Well, I don't see why you receive it in JSON because it only has the image's URL so it's easier to return only the URL.
     * If you are using a bot in Discord you can either return this to an Embed.imageURL or return an ordinary message.
     * {@return String}
     */
    public String kiss() {
        return this.makeRequest("kiss").get("url").asText();
    }

    /**
     * Well, I don't see why you receive it in JSON because it only has the image's URL so it's easier to return only the URL.
     * If you are using a bot in Discord you can either return this to an Embed.imageURL or return an ordinary message.
     * {@return String}
     */
    public String pat() {
        return this.makeRequest("pat").get("url").asText();
    }

    /**
     * Well, I don't see why you receive it in JSON because it only has the image's URL so it's easier to return only the URL.
     * If you are using a bot in Discord you can either return this to an Embed.imageURL or return an ordinary message.
     * {@return String}
     */
    public String poke() {
        return this.makeRequest("poke").get("url").asText();
    }

    /**
     * Well, I don't see why you receive it in JSON because it only has the image's URL so it's easier to return only the URL.
     * If you are using a bot in Discord you can either return this to an Embed.imageURL or return an ordinary message.
     * {@return String}
     */
    public String slap() {
        return this.makeRequest("slap").get("url").asText();
    }

}
