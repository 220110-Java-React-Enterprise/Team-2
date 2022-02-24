let submitBtn = document.getElementById("button-currency");
console.log(submitBtn)


submitBtn.addEventListener('click', function(e) {
    e.preventDefault();
    const params = new URLSearchParams;
    console.log("button clicked")
    let origCur = document.getElementById("have").value;
    console.log(origCur)
    let oldAmt = document.getElementById("amount").value;
    console.log(oldAmt);
    let newCur = document.getElementById("want").value;
    console.log(newCur);

    let url = "http://localhost:8080/api/convert?have=" + origCur + "&want=" + newCur + "&amount=" + oldAmt   ;
    let response = fetch(url, {
        headers: {
            'Content_Type': 'application/json;charset=utf-8'
        },
        method: "get",
        
    }).then(response => {
        return response.json();
    })
    .then(function(data) {
        console.log(data)
        document.getElementById("new_currency_amount").innerHTML = data;

    });

    let x = document.getElementById("result2");
        if (x.style.visibility === "hidden") {
            x.style.visibility = "visible";
        } 

    try {
        let result = response.json;
        console.log(result);
    } catch (error) {
        console.log(error);
    }

}) //END OF CURRENCY FUNCTION!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

let submitButton = document.getElementById("button-predict");
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
            document.getElementById("userForecast").innerText = cityName;
            
            console.log(data['list'][0])
                document.getElementById("6").innerHTML = "Date and Time: "
                document.getElementById("6").append(data['list'][0]["dt_txt".slice(0,9)])
                document.getElementById("6").append("  Min Temp: ")
                document.getElementById("6").append(data['list'][0]["tempMin"])
                document.getElementById("6").append("  Max Temp: ")
                document.getElementById("6").append(data['list'][0]["tempMax"]) 
                document.getElementById("6").append("  Humidity: ")
                document.getElementById("6").append(data['list'][0]["humidity"])
                document.getElementById("6").append("   Weather: ")
                document.getElementById("6").append(data['list'][4]['weather'][0]["description"])
                
                document.getElementById("7").innerHTML = "Date and Time: "
                document.getElementById("7").append(data['list'][8]["dt_txt"])
                document.getElementById("7").append("  Min Temp: ")
                document.getElementById("7").append(data['list'][8]["tempMin"])
                document.getElementById("7").append("  Max Temp: ")
                document.getElementById("7").append(data['list'][8]["tempMax"]) 
                document.getElementById("7").append("  Humidity: ")
                document.getElementById("7").append(data['list'][8]["humidity"])
                document.getElementById("7").append("   Weather: ")
                document.getElementById("7").append(data['list'][4]['weather'][0]["description"])

                document.getElementById("8").innerHTML = "Date and Time: "
                document.getElementById("8").append(data['list'][16]["dt_txt"])
                document.getElementById("8").append("  Min Temp: ")
                document.getElementById("8").append(data['list'][16]["tempMin"])
                document.getElementById("8").append("  Max Temp: ")
                document.getElementById("8").append(data['list'][16]["tempMax"]) 
                document.getElementById("8").append("  Humidity: ")
                document.getElementById("8").append(data['list'][16]["humidity"])
                document.getElementById("8").append("   Weather: ")
                document.getElementById("8").append(data['list'][4]['weather'][0]["description"])

                document.getElementById("9").innerHTML = "Date and Time: "
                document.getElementById("9").append(data['list'][24]["dt_txt"])
                document.getElementById("9").append("  Min Temp: ")
                document.getElementById("9").append(data['list'][24]["tempMin"])
                document.getElementById("9").append("  Max Temp: ")
                document.getElementById("9").append(data['list'][24]["tempMax"]) 
                document.getElementById("9").append("  Humidity: ")
                document.getElementById("9").append(data['list'][24]["humidity"])
                document.getElementById("9").append("   Weather: ")
                document.getElementById("9").append(data['list'][4]['weather'][0]["description"])

                document.getElementById("0").innerHTML = "Date and Time: "
                document.getElementById("0").append(data['list'][32]["dt_txt"])
                document.getElementById("0").append("  Min Temp: ")
                document.getElementById("0").append(data['list'][32]["tempMin"])
                document.getElementById("0").append("  Max Temp: ")
                document.getElementById("0").append(data['list'][32]["tempMax"]) 
                document.getElementById("0").append("  Humidity: ")
                document.getElementById("0").append(data['list'][32]["humidity"])
                document.getElementById("0").append("   Weather: ")
                document.getElementById("0").append(data['list'][4]['weather'][0]["description"])
            

                let x = document.getElementById("another-forecast");
                if (x.style.visibility === "hidden") {
                    x.style.visibility = "visible";
                }
        });
}) //END OF FORECAST FUNCTION!!!!!!!!!!!!!!!!!!!
    







