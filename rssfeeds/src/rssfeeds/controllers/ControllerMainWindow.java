package rssfeeds.controllers;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import rssfeeds.ComREST;
import rssfeeds.Main;
import rssfeeds.model.Feeds.Feeds;
import rssfeeds.model.Items.Item;
import rssfeeds.model.Items.Items;

import java.net.URL;
import java.util.ResourceBundle;



/**
 * Created by alexa on 28/04/2016.
 */
public class ControllerMainWindow implements Initializable {
    private ComREST client = new ComREST();
    private Feeds feeds = null;
    private Feeds fav = null;
    private Items items = null;
    private Main application = null;
    @FXML  private ListView<String> listFeeds;
    @FXML  private ListView<String> favoris;
    @FXML  private ListView<String> listItems;
    @FXML  private WebView content;

    public ControllerMainWindow() {
    }

    public void setApp(Main application) {
        this.application = application;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateFeeds();
        updateFavoris();
    }

    private void updateFeeds() {
        if (feeds != null)
            listFeeds.getItems().remove(0, feeds.getFeeds().toArray().length);
        String json = client.getAllFeeds();
        Gson gson = new Gson();
        feeds = gson.fromJson(json, Feeds.class);
        System.out.println(feeds.getFeeds().toArray().length);
        for (int i = 0; i < feeds.getFeeds().toArray().length; ++i) {
            listFeeds.getItems().add(feeds.getFeeds().get(i).getTitle());
        }
    }

    private void updateFavoris() {
        if (fav != null)
            favoris.getItems().remove(0, fav.getFeeds().toArray().length);
        String json = client.getFav();
        Gson gson = new Gson();
        fav = gson.fromJson(json, Feeds.class);
        for (int i = 0; i < fav.getFeeds().toArray().length; ++i) {
            favoris.getItems().add(fav.getFeeds().get(i).getTitle());
        }
    }

    private void updateItems(int id) {
        if (items != null)
            listItems.getItems().remove(0, items.getItems().toArray().length);
        String json = client.getAllItems(id);
        Gson gson = new Gson();
        items = gson.fromJson(json, Items.class);
        for (int i = 0; i < items.getItems().toArray().length; ++i) {
            listItems.getItems().add(items.getItems().get(i).getTitle());
        }
    }

    private void updateContent(Item item) {
        WebEngine webEngine = content.getEngine();
        String article = item.getDescription();
        article += "<br /><br /><a href='" + item.getUri() + "'>Read full article</a>";
        webEngine.loadContent(article);
    }

    @FXML public void handleMouseClickAllFeeds(MouseEvent arg0) {
        int id = getId(listFeeds.getSelectionModel().getSelectedItem());
        updateItems(id);
        content.getEngine().loadContent("");
    }

    @FXML public void handleMouseClickAllItems(MouseEvent arg0) {
        updateContent(getItem(listItems.getSelectionModel().getSelectedItem()));
    }

    @FXML public void addToFav() {
        int id = getId(listFeeds.getSelectionModel().getSelectedItem());
        if (id < 0)
            return ;
        System.out.println(client.addToFav(id));
        updateFavoris();
    }

    @FXML public void handleClickFav(){
        int id = getId(favoris.getSelectionModel().getSelectedItem());
        updateItems(id);
    }

    private int getId(String title) {
        for (int i = 0; i < feeds.getFeeds().toArray().length; ++i) {
            if (feeds.getFeeds().get(i).getTitle().equals(title)) {
                return feeds.getFeeds().get(i).getId();
            }
        }
        return (-1);
    }

    private Item getItem(String title) {
        for (int i = 0; i < items.getItems().toArray().length; ++i) {
            if (items.getItems().get(i).getTitle().equals(title)) {
                return items.getItems().get(i);
            }
        }
        return (null);
    }

    @FXML public void btnExit() {
        System.exit(0);
    }

    @FXML public void rmFav() {
        int id = getId(favoris.getSelectionModel().getSelectedItem());
        System.out.println(client.rmFav(id));
        updateFavoris();
    }

    @FXML public void update() {
        updateFeeds();
        updateFavoris();
    }

    @FXML public void disconnect() {
        System.out.println(client.disconnect());
        application.goToLogin();
    }
}
