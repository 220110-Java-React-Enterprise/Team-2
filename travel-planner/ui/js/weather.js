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
            document.getElementById("forecastCity").innerHTML = cityName;
            
            console.log(data['list'][0])
                document.getElementById("1").innerHTML = "Date and Time: "
                document.getElementById("1").append(data['list'][0]["dt_txt".slice(0,9)])
                document.getElementById("1").append("  Min Temp: ")
                document.getElementById("1").append(data['list'][0]["tempMin"])
                document.getElementById("1").append("  Max Temp: ")
                document.getElementById("1").append(data['list'][0]["tempMax"]) 
                document.getElementById("1").append("  Humidity: ")
                document.getElementById("1").append(data['list'][0]["humidity"])
                document.getElementById("1").append("   Weather: ")
                document.getElementById("1").append(data['list'][4]['weather'][0]["description"])
                
                document.getElementById("2").innerHTML = "Date and Time: "
                document.getElementById("2").append(data['list'][8]["dt_txt"])
                document.getElementById("2").append("  Min Temp: ")
                document.getElementById("2").append(data['list'][8]["tempMin"])
                document.getElementById("2").append("  Max Temp: ")
                document.getElementById("2").append(data['list'][8]["tempMax"]) 
                document.getElementById("2").append("  Humidity: ")
                document.getElementById("2").append(data['list'][8]["humidity"])
                document.getElementById("2").append("   Weather: ")
                document.getElementById("2").append(data['list'][4]['weather'][0]["description"])

                document.getElementById("3").innerHTML = "Date and Time: "
                document.getElementById("3").append(data['list'][16]["dt_txt"])
                document.getElementById("3").append("  Min Temp: ")
                document.getElementById("3").append(data['list'][16]["tempMin"])
                document.getElementById("3").append("  Max Temp: ")
                document.getElementById("3").append(data['list'][16]["tempMax"]) 
                document.getElementById("3").append("  Humidity: ")
                document.getElementById("3").append(data['list'][16]["humidity"])
                document.getElementById("3").append("   Weather: ")
                document.getElementById("3").append(data['list'][4]['weather'][0]["description"])

                document.getElementById("4").innerHTML = "Date and Time: "
                document.getElementById("4").append(data['list'][24]["dt_txt"])
                document.getElementById("4").append("  Min Temp: ")
                document.getElementById("4").append(data['list'][24]["tempMin"])
                document.getElementById("4").append("  Max Temp: ")
                document.getElementById("4").append(data['list'][24]["tempMax"]) 
                document.getElementById("4").append("  Humidity: ")
                document.getElementById("4").append(data['list'][24]["humidity"])
                document.getElementById("4").append("   Weather: ")
                document.getElementById("4").append(data['list'][4]['weather'][0]["description"])

                document.getElementById("5").innerHTML = "Date and Time: "
                document.getElementById("5").append(data['list'][32]["dt_txt"])
                document.getElementById("5").append("  Min Temp: ")
                document.getElementById("5").append(data['list'][32]["tempMin"])
                document.getElementById("5").append("  Max Temp: ")
                document.getElementById("5").append(data['list'][32]["tempMax"]) 
                document.getElementById("5").append("  Humidity: ")
                document.getElementById("5").append(data['list'][32]["humidity"])
                document.getElementById("5").append("   Weather: ")
                document.getElementById("5").append(data['list'][4]['weather'][0]["description"])
            
         
        });

    let y = document.getElementById("forecast");
    if (y.style.visibility === "hidden") {
        y.style.visibility = "visible";
    } 
})
