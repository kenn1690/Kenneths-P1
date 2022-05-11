async function register(newUser) {

    let response = await fetch(
        "http://localhost:8080/ERS/User",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(newUser)
        }

    );
    return response
}
async function login(authDto) {
    let response = await fetch(
        "http://localhost:8080/ERS/Login",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(authDto)
        }

    );
    return response;
}

async function getUser(un) {
    let response = await fetch(
        "http://localhost:8080/ERS/Login",
        {
            method: "GET",
            headers: {
                userName: un
            }
        }
    );

    return response;
}