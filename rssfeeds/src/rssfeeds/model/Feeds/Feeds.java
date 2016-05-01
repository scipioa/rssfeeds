
package rssfeeds.model.Feeds;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Feeds {

    @SerializedName("feeds")
    @Expose
    private List<Feed> feeds = new ArrayList<Feed>();

    /**
     * 
     * @return
     *     The feeds
     */
    public List<Feed> getFeeds() {
        return feeds;
    }

    /**
     * 
     * @param feeds
     *     The feeds
     */
    public void setFeeds(List<Feed> feeds) {
        this.feeds = feeds;
    }

}
