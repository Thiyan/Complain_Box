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

    @Column(name = "office_remark")
    private String OfficerRemark;

    @Column(name = "document")
    private String document;

    @ManyToOne
    private Account user;

    @ManyToOne
    private Account police;

    public Complain() {
    }

    public Complain(String subject, String description, String date, String status, String file,
                    String remark, String officerRemark, String document, Account user, Account police) {
        this.subject = subject;
        this.description = description;
        this.date = date;
        this.status = status;
        this.file = file;
        this.remark = remark;
        OfficerRemark = officerRemark;
        this.document = document;
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

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    public Account getPolice() {
        return police;
    }

    public void setPolice(Account police) {
        this.police = police;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOfficerRemark() {
        return OfficerRemark;
    }

    public void setOfficerRemark(String officerRemark) {
        OfficerRemark = officerRemark;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
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
                ", remark='" + remark + '\'' +
                ", OfficerRemark='" + OfficerRemark + '\'' +
                ", document='" + document + '\'' +
                ", user=" + user +
                ", police=" + police +
                '}';
    }
}
