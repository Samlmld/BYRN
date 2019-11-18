package mx.reel.pojos;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EstateImage implements Serializable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("estate_id")
    @Expose
    private int estateId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    private final static long serialVersionUID = 5639771900820784937L;

    /**
     * No args constructor for use in serialization
     *
     */
    public EstateImage() {
    }

    /**
     *
     * @param createdAt
     * @param estateId
     * @param id
     * @param url
     * @param updatedAt
     */
    public EstateImage(int id, String url, int estateId, String createdAt, String updatedAt) {
        super();
        this.id = id;
        this.url = url;
        this.estateId = estateId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getEstateId() {
        return estateId;
    }

    public void setEstateId(int estateId) {
        this.estateId = estateId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}