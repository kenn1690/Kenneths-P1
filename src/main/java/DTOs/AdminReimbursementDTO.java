package DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class is created, so the admin can update only the reimbursement parts needed.
 * It is a pojo but contains the JSon ignore properties, so if more items are given
 * to the backend from the front end, it can ignore those "unknown" fields.
 */

@JsonIgnoreProperties
public class AdminReimbursementDTO {
    private int reimbursementId;
    private int status;
    private int resolver;


    public AdminReimbursementDTO() {
    }

    public AdminReimbursementDTO(int reimbursementId, int status) {
        this.reimbursementId = reimbursementId;
        this.status = status;
    }

    public int getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getResolver() {
        return resolver;
    }

    public void setResolver(int resolver) {
        this.resolver = resolver;
    }

    @Override
    public String toString() {
        return "AdminReimbursementDTO{" +
                "reimbursementId=" + reimbursementId +
                ", status=" + status +
                ", resolver=" + resolver +
                '}';
    }
}
