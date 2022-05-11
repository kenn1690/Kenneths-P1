package Services;

import DTOs.AdminReimbursementDTO;
import DTOs.ReimbursementDTO;
import Models.Reimbursement;
import Persistence.ReimbursementDAO;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * This class is the mediator. It does validation checks and mutates the Data Transfer Objects
 * into models. It then sends the data to the persistence layer.
 */

public class ReimbursementServices {

    private Regex reggie = new Regex();
    ReimbursementDAO rdao = new ReimbursementDAO();

    /**
     * Receives DTO values and mutates the DTO to a Reimbursement model and sends
     * the model along to get created.
     *
     * @param passedValues
     * @return
     */
    public int createReimbursement(ReimbursementDTO passedValues) {
        Reimbursement model = new Reimbursement();
        if (!reggie.dollarCheck(passedValues.getReimbursementAmount())) {
            System.out.println("Made it to regex dollar amount check.");
            return 1;
        } else if (!reggie.descriptionCheck(passedValues.getDescription())) {
            System.out.println("Made it to regex description check.");
            return 2;
        } else {
            model.setReimbursementAmount(passedValues.getReimbursementAmount());
            model.setDescription(passedValues.getDescription());
            model.setAuthor(passedValues.getAuthor());
            model.setType(passedValues.getType());
            rdao.create(model);
            return 0;
        }
    }

    public Reimbursement read(int id) {
        return rdao.read(id);
    }

    public List<Reimbursement> readAll(int id) {
        return rdao.getAllForUser(id);
    }

    public void updateReimbursement(Reimbursement passedValues) {
        System.out.println(passedValues.getReimbursementId() + " " + passedValues.getDescription() + " " + passedValues.getReimbursementAmount());
        rdao.update(passedValues);
    }

    public void delete(int id) {
        rdao.delete(id);
    }

    /**
     * This section is for admin and could be moved to another servlet
     * It returns a list of reimbursements. This list should only contain pending approvals.
     * @return
     */
    public List<Reimbursement> readAllAdmin() {
        return rdao.getAll();
    }


    /**
     * This class receives information from the front end as a DTO and mutates it to a
     * reimbursement object. It then sends just the information that is needed to update
     * the status of the reimbursement.
     * @param passedValues
     */
    public void adminUpdateReimbursement(AdminReimbursementDTO passedValues) {
        System.out.println(passedValues.getReimbursementId() + " " + passedValues.getStatus());
        Reimbursement model = new Reimbursement();
        model.setReimbursementId(passedValues.getReimbursementId());
        model.setStatus(passedValues.getStatus());
        model.setResolver(passedValues.getResolver());
        rdao.adminUpdate(model);
    }

}