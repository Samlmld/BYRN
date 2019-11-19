package mx.reel.pojos;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Serializable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("city_id")
    @Expose
    private Object cityId;
    @SerializedName("state_id")
    @Expose
    private Object stateId;
    @SerializedName("phonenumber")
    @Expose
    private Object phonenumber;
    @SerializedName("cellphone")
    @Expose
    private String cellphone;
    @SerializedName("birthdate")
    @Expose
    private Object birthdate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;
    @SerializedName("roles")
    @Expose
    private List<Role> roles = null;
    private final static long serialVersionUID = -5938733633446705012L;

    /**
     * No args constructor for use in serialization
     *
     */
    public User() {
    }

    /**
     *
     * @param lastName
     * @param address
     * @param birthdate
     * @param stateId
     * @param roles
     * @param phonenumber
     * @param cityId
     * @param createdAt
     * @param name
     * @param cellphone
     * @param id
     * @param email
     * @param status
     * @param updatedAt
     */
    public User(int id, String name, String lastName, String email, String address, Object cityId, Object stateId, Object phonenumber, String cellphone, Object birthdate, String status, String createdAt, Object updatedAt, List<Role> roles) {
        super();
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.cityId = cityId;
        this.stateId = stateId;
        this.phonenumber = phonenumber;
        this.cellphone = cellphone;
        this.birthdate = birthdate;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Object getCityId() {
        return cityId;
    }

    public void setCityId(Object cityId) {
        this.cityId = cityId;
    }

    public Object getStateId() {
        return stateId;
    }

    public void setStateId(Object stateId) {
        this.stateId = stateId;
    }

    public Object getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Object phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Object getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Object birthdate) {
        this.birthdate = birthdate;
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

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}