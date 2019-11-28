package mx.reel.pojos;

import java.io.Serializable;
import com.google.gson.annotations.Expose;

public class AppointmentStatusUpdate implements Serializable
{
    @Expose
    private String status;
    private final static long serialVersionUID = -6127598540517304653L;

    /**
     * No args constructor for use in serialization
     *
     */
    public AppointmentStatusUpdate() {
    }

    /**
     *
     * @param status
     */
    public AppointmentStatusUpdate(String status) {
        super();
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}