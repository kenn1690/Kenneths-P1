async function adminUpdateReimbursement(reimbursement) {
    let response = await fetch(
        "http://localhost:8080/ERS/Admin",
        {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(reimbursement)
        }
    );
    return response;
}

