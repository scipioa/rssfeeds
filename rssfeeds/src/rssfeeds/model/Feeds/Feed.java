
package rssfeeds.model.Feeds;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.math.BigInteger;

@Generated("org.jsonschema2pojo")
public class Feed {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("author")
    @Expose
    private Object author;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("uri")
    @Expose
    private Object uri;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("pubDate")
    @Expose
    private BigInteger pubDate;
    @SerializedName("lastBuildDate")
    @Expose
    private Object lastBuildDate;
    @SerializedName("docs")
    @Expose
    private Object docs;
    @SerializedName("managingEditor")
    @Expose
    private Object managingEditor;
    @SerializedName("webMaster")
    @Expose
    private Object webMaster;
    @SerializedName("category")
    @Expose
    private Object category;
    @SerializedName("generator")
    @Expose
    private Object generator;

    /**
     * 
     * @return
     *     The id
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The author
     */
    public Object getAuthor() {
        return author;
    }

    /**
     * 
     * @param author
     *     The author
     */
    public void setAuthor(Object author) {
        this.author = author;
    }

    /**
     * 
     * @return
     *     The link
     */
    public String getLink() {
        return link;
    }

    /**
     * 
     * @param link
     *     The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 
     * @return
     *     The uri
     */
    public Object getUri() {
        return uri;
    }

    /**
     * 
     * @param uri
     *     The uri
     */
    public void setUri(Object uri) {
        this.uri = uri;
    }

    /**
     * 
     * @return
     *     The imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 
     * @param imageUrl
     *     The imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 
     * @return
     *     The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 
     * @param language
     *     The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 
     * @return
     *     The copyright
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * 
     * @param copyright
     *     The copyright
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * 
     * @return
     *     The pubDate
     */
    public BigInteger getPubDate() {
        return pubDate;
    }

    /**
     * 
     * @param pubDate
     *     The pubDate
     */
    public void setPubDate(BigInteger pubDate) {
        this.pubDate = pubDate;
    }

    /**
     * 
     * @return
     *     The lastBuildDate
     */
    public Object getLastBuildDate() {
        return lastBuildDate;
    }

    /**
     * 
     * @param lastBuildDate
     *     The lastBuildDate
     */
    public void setLastBuildDate(Object lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    /**
     * 
     * @return
     *     The docs
     */
    public Object getDocs() {
        return docs;
    }

    /**
     * 
     * @param docs
     *     The docs
     */
    public void setDocs(Object docs) {
        this.docs = docs;
    }

    /**
     * 
     * @return
     *     The managingEditor
     */
    public Object getManagingEditor() {
        return managingEditor;
    }

    /**
     * 
     * @param managingEditor
     *     The managingEditor
     */
    public void setManagingEditor(Object managingEditor) {
        this.managingEditor = managingEditor;
    }

    /**
     * 
     * @return
     *     The webMaster
     */
    public Object getWebMaster() {
        return webMaster;
    }

    /**
     * 
     * @param webMaster
     *     The webMaster
     */
    public void setWebMaster(Object webMaster) {
        this.webMaster = webMaster;
    }

    /**
     * 
     * @return
     *     The category
     */
    public Object getCategory() {
        return category;
    }

    /**
     * 
     * @param category
     *     The category
     */
    public void setCategory(Object category) {
        this.category = category;
    }

    /**
     * 
     * @return
     *     The generator
     */
    public Object getGenerator() {
        return generator;
    }

    /**
     * 
     * @param generator
     *     The generator
     */
    public void setGenerator(Object generator) {
        this.generator = generator;
    }

}
