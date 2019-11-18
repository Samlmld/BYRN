package mx.reel.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllEstatesResponse {

    @SerializedName("current_page")
    @Expose
    private int currentPage;
    @SerializedName("data")
    @Expose
    private List<Estate> estates = null;
    @SerializedName("first_page_url")
    @Expose
    private String firstPageUrl;
    @SerializedName("from")
    @Expose
    private int from;
    @SerializedName("last_page")
    @Expose
    private int lastPage;
    @SerializedName("last_page_url")
    @Expose
    private String lastPageUrl;
    @SerializedName("next_page_url")
    @Expose
    private Object nextPageUrl;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("per_page")
    @Expose
    private int perPage;
    @SerializedName("prev_page_url")
    @Expose
    private Object prevPageUrl;
    @SerializedName("to")
    @Expose
    private int to;
    @SerializedName("total")
    @Expose
    private int total;

    /**
     * No args constructor for use in serialization
     *
     */
    public AllEstatesResponse() {
    }

    /**
     *
     * @param path
     * @param lastPageUrl
     * @param total
     * @param firstPageUrl
     * @param nextPageUrl
     * @param perPage
     * @param estates
     * @param lastPage
     * @param from
     * @param to
     * @param currentPage
     * @param prevPageUrl
     */
    public AllEstatesResponse(int currentPage, List<Estate> estates, String firstPageUrl, int from, int lastPage, String lastPageUrl, Object nextPageUrl, String path, int perPage, Object prevPageUrl, int to, int total) {
        super();
        this.currentPage = currentPage;
        this.estates = estates;
        this.firstPageUrl = firstPageUrl;
        this.from = from;
        this.lastPage = lastPage;
        this.lastPageUrl = lastPageUrl;
        this.nextPageUrl = nextPageUrl;
        this.path = path;
        this.perPage = perPage;
        this.prevPageUrl = prevPageUrl;
        this.to = to;
        this.total = total;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<Estate> getEstates() {
        return estates;
    }

    public void setEstates(List<Estate> estates) {
        this.estates = estates;
    }

    public String getFirstPageUrl() {
        return firstPageUrl;
    }

    public void setFirstPageUrl(String firstPageUrl) {
        this.firstPageUrl = firstPageUrl;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public String getLastPageUrl() {
        return lastPageUrl;
    }

    public void setLastPageUrl(String lastPageUrl) {
        this.lastPageUrl = lastPageUrl;
    }

    public Object getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(Object nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public Object getPrevPageUrl() {
        return prevPageUrl;
    }

    public void setPrevPageUrl(Object prevPageUrl) {
        this.prevPageUrl = prevPageUrl;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}