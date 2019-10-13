package YANmakes.complain.models;

import javax.persistence.*;

@Entity
@Table(name = "complain")
public class Complain {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int complainId;

    @Column(name = "subject")
    private String subject;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private String date;

    @Column(name = "status")
    private String status;

    @Column(name = "file")
    private String file;

    @Column(name = "remark")
    private String remark;

    @ManyToOne
    private User user;

    @ManyToOne
    private Police police;

    public Complain() {
    }

    public Complain(String subject, String description, String date, String status, String file, String remark, User user, Police police) {
        this.subject = subject;
        this.description = description;
        this.date = date;
        this.status = status;
        this.file = file;
        this.remark = remark;
        this.user = user;
        this.police = police;
    }

    public int getComplainId() {
        return complainId;
    }

    public void setComplainId(int complainId) {
        this.complainId = complainId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Police getPolice() {
        return police;
    }

    public void setPolice(Police police) {
        this.police = police;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Complain{" +
                "complainId=" + complainId +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", file='" + file + '\'' +
                ", user=" + user +
                ", police=" + police +
                '}';
    }
}
