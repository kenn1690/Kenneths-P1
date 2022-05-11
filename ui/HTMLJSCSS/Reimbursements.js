async function createReimbursement(newReimbursement) {
    let response = await fetch(
        "http://localhost:8080/ERS/Reimbursement",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(newReimbursement)
        }
    );
    return response;
}

async function getReimbursement(id) {
    let response = await fetch(
        "http://localhost:8080/ERS/Reimbursement",
        {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "reimbursementId": id
            }
        }
    );
    return response;
}

async function updateReimbursement(reimbursement) {
    let response = await fetch(
        "http://localhost:8080/ERS/Reimbursement",
        {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(reimbursement)
        }
    );

    return response;
}

async function deleteReimbursement(id) {
    var answer = window.confirm("Do you want to delete reimbursement id: " + id );
    if(answer){
    let response = await fetch(
        "http://localhost:8080/ERS/Reimbursement",
        {
            method: "DELETE",
            headers:
            {
                "Content-Type": "application/json",
                "reimbId": id
            }
        });
    return response;
    }
    else{
        alert("Did not delete");
        window.location.href = "./ViewReimbursements.html"
    }
}