const sendButton = document.querySelector("#sendButton");

sendButton.addEventListener("click", () => {

    sendButton.disabled = true;
    const buttonText = sendButton.querySelector(".button-text");
    const loadingText = sendButton.querySelector(".loading-send-email");

    buttonText.style.display = "none";
    loadingText.style.display = "inline-block";

    sendButton.closest("form").submit();
});