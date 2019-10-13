package YANmakes.complain.dto;

import org.springframework.web.multipart.MultipartFile;

public class Evidence {

    private int complainId;

    private String officerRemarks;

    private MultipartFile document;

    public Evidence() {
    }

    public int getComplainId() {
        return complainId;
    }

    public void setComplainId(int complainId) {
        this.complainId = complainId;
    }

    public String getOfficerRemarks() {
        return officerRemarks;
    }

    public void setOfficerRemarks(String officerRemarks) {
        this.officerRemarks = officerRemarks;
    }

    public MultipartFile getDocument() {
        return document;
    }

    public void setDocument(MultipartFile document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "Evidence{" +
                "complainId=" + complainId +
                ", officerRemarks='" + officerRemarks + '\'' +
                ", document=" + document +
                '}';
    }
}
