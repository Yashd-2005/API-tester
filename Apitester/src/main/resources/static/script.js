async function sendRequest() {

    const method = document.getElementById("method").value;
    const url = document.getElementById("url").value;
    const headerText = document.getElementById("header").value;
    const body = document.getElementById("body").value;

    let header = {};

    try {

        if (headerText.trim() !== "") {
            header = JSON.parse(headerText);
        }

    } catch (e) {
        alert("Header must be valid JSON");
        return;
    }

    try {

        const response = await fetch("/api/request", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify({

                method: method,
                url: url,
                header: header,
                body: body

            })

        });

        const result = await response.json();

        document.getElementById("status").innerText = result.status;
        document.getElementById("time").innerText = result.responseTime + " ms";

        document.getElementById("responseHeaders").innerText =
            JSON.stringify(result.header, null, 4);

        document.getElementById("responseBody").innerText =
            result.body;

    } catch (e) {

        console.error(e);
        alert("Request Failed");

    }

}