package Utils;

import com.sun.jdi.event.StepEvent;

import java.util.Date;

public class Tasks extends com.ceica.Modelos.ModeloBase {


    private int idtask;
    private String title;
    private String descripction;
    private User user;
    private boolean status;
    private Date create_time;
    private Date deadline;

    public Tasks() {
    }

    public int getIdtask() {
        return idtask;
    }

    public void setIdtask(int idtask) {
        this.idtask = idtask;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripction() {
        return descripction;
    }

    public void setDescripction(String descripction) {
        this.descripction = descripction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    protected String getNombreTabla() {
        return null;
    }

    public Tasks(int idtask, String title, String descripction, User user, boolean status, Date create_time, Date deadline) {
        this.idtask = idtask;
        this.title = title;
        this.descripction = descripction;
        this.user = user;
        this.status = status;
        this.create_time = create_time;
        this.deadline = deadline;
    }
}
