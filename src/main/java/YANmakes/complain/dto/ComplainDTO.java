package YANmakes.complain.dto;

import YANmakes.complain.utils.ComplainStatus;
import org.springframework.web.multipart.MultipartFile;

public class ComplainDTO {

    private int complainId;

    private String subject;

    private String description;

    private String date;

    private ComplainStatus status;

    private String file;

    private MultipartFile attachment;

    private String userID;

    private String policeName;

    private String remark;

    private String OfficerRemark;


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

    public MultipartFile getAttachment() {
        return attachment;
    }

    public void setAttachment(MultipartFile attachment) {
        this.attachment = attachment;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPoliceName() {
        return policeName;
    }

    public void setPoliceName(String policeName) {
        this.policeName = policeName;
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
