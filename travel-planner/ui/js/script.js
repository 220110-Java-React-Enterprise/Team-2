let submitBtn = document.getElementById("submitButton");
console.log(submitBtn)


submitBtn.addEventListener('click', function (e) {
    e.preventDefault();
    const params = new URLSearchParams([...new FormData(e.target).entries()]);
    console.log("button clicked")
    let origCur = document.getElementById("have").textContent;
    console.log(origCur)
    let url = "http://localhost:8080/api/convert";
    fetch(url, {
        headers: {
            'Content_Type': 'application/json;charset=utf-8'
        },
        method: "GET",
        body: params
    });

    try {
        console.log("========");
        let result = response.json();
        console.log(result);
    } catch (error) {
        console.log(error);
    }

})
// .then((){
//     NEED TO DO SOMETHING MORE WITH THE RESPONSE
// });



