package mx.reel.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pivot {

    @SerializedName("user_id")
    @Expose
    private int userId;
    @SerializedName("role_id")
    @Expose
    private int roleId;

    /**
     * No args constructor for use in serialization
     *
     */
    public Pivot() {
    }

    /**
     *
     * @param roleId
     * @param userId
     */
    public Pivot(int userId, int roleId) {
        super();
        this.userId = userId;
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

}