package mx.reel.pojos;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Appointment implements Serializable
{
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("customer_id")
    @Expose
    private int customerId;
    @SerializedName("estate_id")
    @Expose
    private int estateId;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private Object endTime;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("appoiment_type")
    @Expose
    private String appoimentType;
    @SerializedName("guests")
    @Expose
    private Object guests;
    @SerializedName("comments")
    @Expose
    private Object comments;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    private final static long serialVersionUID = -5117571540517304653L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Appointment() {
    }

    /**
     *
     * @param date
     * @param comments
     * @param estateId
     * @param createdAt
     * @param customerId
     * @param guests
     * @param appoimentType
     * @param startTime
     * @param location
     * @param id
     * @param endTime
     * @param status
     * @param updatedAt
     */
    public Appointment(int id, int customerId, int estateId, String date, String startTime, Object endTime, String location, String appoimentType, Object guests, Object comments, String status, String createdAt, String updatedAt) {
        super();
        this.id = id;
        this.customerId = customerId;
        this.estateId = estateId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.appoimentType = appoimentType;
        this.guests = guests;
        this.comments = comments;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEstateId() {
        return estateId;
    }

    public void setEstateId(int estateId) {
        this.estateId = estateId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Object getEndTime() {
        return endTime;
    }

    public void setEndTime(Object endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAppoimentType() {
        return appoimentType;
    }

    public void setAppoimentType(String appoimentType) {
        this.appoimentType = appoimentType;
    }

    public Object getGuests() {
        return guests;
    }

    public void setGuests(Object guests) {
        this.guests = guests;
    }

    public Object getComments() {
        return comments;
    }

    public void setComments(Object comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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