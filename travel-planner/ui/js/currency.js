let submitBtn = document.getElementById("submitButton");
console.log(submitBtn)


submitBtn.addEventListener('click', function (e) {
    e.preventDefault();
    //const params = new URLSearchParams([...new FormData(e.target).entries()]);
    console.log("button clicked")
    let origCur = document.getElementById("have").value;
    console.log(origCur)
    let oldAmt = document.getElementById("amount").value;
    console.log(oldAmt);
    let newCur = document.getElementById("want").value;
    console.log(newCur);
    let url = "http://localhost:8080/api/convert";
    let response = fetch(url, {
        headers: {
            'Content_Type': 'application/json;charset=utf-8'
        },
        method: "GET",
        //body: params
    });

    try {
        let result = response.json;
        console.log(result);
    } catch (error) {
        console.log(error);
    }

})
    .then(response => response.json())
    .then(data => console.log(data));







