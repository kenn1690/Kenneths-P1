package DTOs;

import Models.Reimbursement;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class is created, so the user can update only the reimbursement parts needed.
 * It is a pojo but contains the JSon ignore properties, so if more items are given
 * to the backend from the front end, it can ignore those "unknown" fields.
 */

@JsonIgnoreProperties
public class ReimbursementDTO{
    private int reimbursementId;
    private double reimbursementAmount;
    private String description;
    private int author;
    private int type;

    public ReimbursementDTO() {
    }

    public ReimbursementDTO(double reimbursementAmount, String description, int author, int type) {
        this.reimbursementAmount = reimbursementAmount;
        this.description = description;
        this.author = author;
        this.type = type;
    }

    public int getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public double getReimbursementAmount() {
        return reimbursementAmount;
    }

    public void setReimbursementAmount(double amount) {
        this.reimbursementAmount = amount;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }


    public int getType() {
        return type;
    }


    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ReimbursementDTO{" +
                "reimbursementAmount=" + reimbursementAmount +
                ", description='" + description + '\'' +
                ", author=" + author +
                ", type=" + type +
                '}';
    }
}
