let submitButton = document.getElementById("getForecast");
console.log(submitButton);

submitButton.addEventListener("click", function(event) {
    event.preventDefault();
    const params = new URLSearchParams;
    console.log("get forecast button clicked");
    let cityName = document.getElementById("city").value;
    console.log(city);

    let url = "http://localhost:8080/api/weather?cityName=" + cityName;
    let response = fetch(url, {
        headers: {'Content_Type': 'application/json;charset=utf-8'},
        method: "get"
    }).then(response => response.json())
        .then(function(data) {
            console.log(data)
            document.getElementById("forecastCity").append(cityName)
          
            console.log(data['list'][0])
            
            for (let index = 0; index < data.length; index++) {
                const element = data[index];
                document.getElementById("print_fore").append("Date and Time: ")
                document.getElementById("print_fore").append(data['list'][index]["dt_txt"])

                document.getElementById("print_fore").append("\nMin Temp: ")
                document.getElementById("print_fore").append(data['list'][index]["tempMin"])
            
                document.getElementById("print_fore").append("\nMax Temp: ")
                document.getElementById("print_fore").append(data['list'][index]["tempMax"]) 

                document.getElementById("print_fore").append("\nHumidity: ")
                document.getElementById("print_fore").append(data['list'][index]["humidity"])
                
            }
            
         
        });

    let y = document.getElementById("forecast");
    if (y.style.visibility === "hidden") {
        y.style.visibility = "visible";
    } else {
        y.style.visibility = "hidden";
    }
})