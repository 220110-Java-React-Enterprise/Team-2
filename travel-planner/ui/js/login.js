// retrieve the button from the page
let regButton = document.getElementById("loginButton");

//! fact finding
console.log(regButton)

regButton.addEventListener('click', function (e) {
    // easily changeable base url
    let url = "http://localhost:8080/"

    e.preventDefault();

    //! fact finding
    console.log("loginButton clicked")

    // retrieve form data from the page   
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    //! fact finding 
    console.log("email: ", email);
    console.log("password: ", password);

    // build the user object
    const user = {
        //firstName: firstName,
        //lastName: lastName,
        email: email,
        password: password
    }

    // build the options object (for fetch)
    const options = {
        method: 'GET',
        //body: JSON.stringify(user),
        //headers: {
            //'Content-Type': 'application/json;charset=utf-8'
        //}
    }

    // build the search parameters
    //let searchParams = new URLSearchParams(user);

    // finish building the url
    //url += "api/convert?" + searchParams.toString();
    url += "users/email/?email=" + email;

    // send the request
    // TODO output post's response to user
    let fetched = fetch(url, options)
        .then((response) => response.json())
        .then((data) => {
            console.log("Success: ", data);
        })
        .catch((error) => {
            console.error("Error: ", error);
        });

    // TODO autonavigate back to main page somehow?
    //   if not, just do a "return home" button

})
