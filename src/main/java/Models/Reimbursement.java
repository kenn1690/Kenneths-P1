package Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.Date;

/**
 * Simple Pojo for reimbursements meeting all requirements
 * Items persisted from this class will be in ers_reimbusements (table name)
 */

@JsonIgnoreProperties
public class Reimbursement extends Model{
    private int reimbursementId;
    private double reimbursementAmount;
    private String submitted;
    private String resolved;
    private String description;
    private Blob image;
    private int author;
    private int resolver;
    private int status;
    private int type;
    private Status enumStatus;
    private Type enumType;
    private String authorName;
    private String resolverName;

    public Reimbursement() {
    }

    public Reimbursement(double reimbursementAmount, String description, /*Blob image,*/ int author, int type) {
        this.reimbursementAmount = reimbursementAmount;
        this.description = description;
        //this.image = image;
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

    public void setReimbursementAmount(double reimbursementAmount) {
        this.reimbursementAmount = reimbursementAmount;
    }

    public String getSubmitted() {
        return submitted;
    }

    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    public String getResolved() {
        return resolved;
    }

    public void setResolved(String resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getResolver() {
        return resolver;
    }

    public void setResolver(int resolver) {
        this.resolver = resolver;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Status getEnumStatus() {
        return enumStatus;
    }

    public void setEnumStatus(Status enumStatus) {
        this.enumStatus = enumStatus;
    }

    public Type getEnumType() {
        return enumType;
    }

    public void setEnumType(Type enumType) {
        this.enumType = enumType;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getResolverName() {
        return resolverName;
    }

    public void setResolverName(String resolverName) {
        this.resolverName = resolverName;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementId=" + reimbursementId +
                ", reimbursementAmount=" + reimbursementAmount +
                ", submitted='" + submitted + '\'' +
                ", resolved='" + resolved + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", author=" + author +
                ", resolver=" + resolver +
                ", status=" + status +
                ", type=" + type +
                ", enumStatus=" + enumStatus +
                ", enumType=" + enumType +
                ", authorName='" + authorName + '\'' +
                ", resolverName='" + resolverName + '\'' +
                '}';
    }
}
