package rssfeeds.model;

/**
 * Created by alexa on 30/04/2016.
 */
public class User {
    String email;
    String firstname;
    String lastname;
    int id;

    public User(int id, String email) {
        this.id = id;
        this.email = email;
        this.firstname = null;
        this.lastname = null;
    }
    public User(int id, String email, String firstname, String lastname) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
