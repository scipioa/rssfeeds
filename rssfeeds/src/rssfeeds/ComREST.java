package rssfeeds;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.MediaType;
import rssfeeds.connectStatus;
import rssfeeds.model.User;

/**
 * Created by alexa_000 on 30/04/2016.
 */

public class ComREST {
    String host;
    int port;
    OkHttpClient client;
    User user;
    static String cookie = null;

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public ComREST() {
        this.client = new OkHttpClient();
        this.host = "rssflux.bitnamiapp.com";
        this.port = 8443;
        this.user = null;
    }
    public ComREST(String host){
        this.client = new OkHttpClient();
        this.host = host;
        this.port = 8443;
        this.user = null;
    }
    public ComREST(String host, int port){
        this.client = new OkHttpClient();
        this.host = host;
        this.port = port;
        this.user = null;
    }

    public connectStatus createUser(String email, String password) {
        String json = "{\"email\" : \"" + email + "\","
                + "\"password\" : \"" + password + "\""
                + "}";
        String url = "http://" + this.host + ":" + this.port + "/users/sign_up/";
        try {
            String ret = post(url, json);
            if (ret.equals("{\"error\": \"user already exist\"}"))
                return connectStatus.ERR_USER_ALREADY_EXIST;
            else {
                return connectUser(email, password);
            }
        } catch (IOException e) {
            return connectStatus.ERR_SERVER;
        }
    }

    public connectStatus connectUser(String login, String password) {
        String json = "{\"email\" : \"" + login + "\","
                + "\"password\" : \"" + password + "\""
                + "}";
        String url = "http://" + this.host + ":" + this.port + "/users/sign_in/";
        try {
            String ret = post(url, json);
            //System.out.println(post("http://" + this.host + ":" + this.port + "/feeds/create/", "{\"url\": \"http://www.jeuxvideo.com/rss/rss.xml\"}"));
            System.out.println(ret);
            if (ret.startsWith("{\"error\":"))
                return connectStatus.ERR_BAD_LOGIN;
            else {
                return connectStatus.OK;
            }

        } catch (IOException e) {
            return connectStatus.ERR_SERVER;
        }
    }

    public String getAllFeeds() {
        String url = "http://" + this.host + ":" + this.port + "/feeds/";
        try {
            return get(url);
        } catch (IOException e) {
            return "connection error";
        }
    }

    public String getFav() {
        String url = "http://" + this.host + ":" + this.port + "/feeds/subscribed";
        try {
            return get(url);
        } catch (IOException e) {
            return "connection error";
        }
    }

    public String addToFav(int id) {
        String url = "http://" + this.host + ":" + this.port + "/feeds/subscribe";
        String json = "{\"id\": " + id + "}";
        try {
            return post(url, json);
        } catch (IOException e) {
            return "connection error";
        }
    }

    public String rmFav(int id) {
        String url = "http://" + this.host + ":" + this.port + "/feeds/" + id + "/unsubscribe";
        try {
            return del(url);
        } catch (IOException e) {
            return "connection error";
        }
    }

    public String getAllItems(int id) {
        String url = "http://" + this.host + ":" + this.port + "/feeds/" + id + "/items/";
        try {
            return get(url);
        } catch (IOException e) {
            return "connection error";
        }
    }

    public String disconnect() {
        String url = "http://" + this.host + ":" + this.port + "/users/sign_out";
        try {
            String d = del(url);
            this.cookie = null;
            return d;
        } catch (IOException e) {
            return "connection error";
        }
    }

    private String post(String url, String json) throws IOException {
        System.out.println("POST request to " + url + "   --->   " + json);
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .header("Cookie", this.cookie == null ? "" : this.cookie)
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if (this.cookie == null)
            this.cookie = response.header("Set-cookie");
        return response.body().string();
    }

    private String del(String url) throws IOException {
        System.out.println("DELETE request to " + url);
        Request request = new Request.Builder()
                .header("Cookie", this.cookie == null ? "" : this.cookie)
                .url(url)
                .delete()
                .build();
        Response response = client.newCall(request).execute();
        if (this.cookie == null)
            this.cookie = response.header("Set-cookie");
        return response.body().string();
    }

    private String get(String url) throws IOException {
        Request request = new Request.Builder()
                .header("Cookie", this.cookie == null ? "" : this.cookie)
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        if (this.cookie == null)
            this.cookie = response.header("Set-cookie");
        return response.body().string();
    }
}
