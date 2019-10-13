package YANmakes.complain.dto;

public class Assign {

    private int complainId;

    private int officerId;

    private String remarks;

    public Assign() {
    }

    public int getComplainId() {
        return complainId;
    }

    public void setComplainId(int complainId) {
        this.complainId = complainId;
    }

    public int getOfficerId() {
        return officerId;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Assign{" +
                "complainId=" + complainId +
                ", officerId=" + officerId +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
