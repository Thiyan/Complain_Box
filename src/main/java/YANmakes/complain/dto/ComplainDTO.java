package YANmakes.complain.dto;

import YANmakes.complain.utils.ComplainStatus;

public class ComplainDTO {

    private int complainId;

    private String subject;

    private String description;

    private String date;

    private ComplainStatus status;

    private String file;

    public ComplainDTO() {
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

    public ComplainStatus getStatus() {
        return status;
    }

    public void setStatus(ComplainStatus status) {
        this.status = status;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "ComplainDTO{" +
                "complainId=" + complainId +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", status=" + status +
                ", file='" + file + '\'' +
                '}';
    }
}
