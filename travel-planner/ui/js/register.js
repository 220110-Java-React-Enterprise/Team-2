// retrieve the button from the page
let regButton = document.getElementById("registerButton");

//! fact finding
console.log(regButton)

// base url
const url = "http://localhost:8080/users"

regButton.addEventListener('click', function (e) {
    e.preventDefault();

    //! fact finding
    console.log("registerButton clicked")

    // retrieve form data from the page
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    //! fact finding
    console.log("firstName: ", firstName)
    console.log("lastName: ", lastName);
    console.log("email: ", email);
    console.log("password: ", password);

    // build the user object
    const user = {
        firstName: firstName,
        lastName: lastName,
        email: email,
        password: password
    }

    // build the options object (for fetch)
    const options = {
        method: 'POST',
        body: JSON.stringify(user),
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        }
    }

    // send the request
    fetch(url, options)
        // convert the response to JSON
        .then((response) => {
            return response.json();
        })

        // let the user know whether or not registration was successful
        .then((data) => {
            // inform user of response
            document.getElementById("response").innerHTML = data;

            // create & insert a line break
            linebreak = document.createElement("br");
            document.getElementById("response").appendChild(linebreak);

            // inform user of redirect
            document.getElementById("response").append("You will be redirected in 5 seconds.");
        })

        // redirect back to the home screen
        .then(() => {
            // wait for user to read stuff
            setTimeout(() => {
                window.location.replace("../index.html");
            }, 5000)();
        })

        // catch any errors
        .catch((error) => {
            console.error("Error: ", error);
        });

})
