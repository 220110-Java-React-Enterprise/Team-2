let submitBtn = document.getElementById("calcButton");
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
        
    }).then(response => response.json())
    .then(function(data) {
        console.log(data)
        document.getElementById("new_amount").append(data)

    });

    var x = document.getElementById("result");
        if (x.style.visibility === "hidden") {
            x.style.visibility = "visible";
        } else {
            x.style.visibility = "hidden";
        }

    // try {
    //     let result = response.json;
    //     console.log(result);
    // } catch (error) {
    //     console.log(error);
    // }

})
    







