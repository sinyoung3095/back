const phoneInput = document.querySelector("#phone");
const sendButton = document.querySelector("#sendButton");
const sendMessage = document.querySelector("#sendMessage");
const verifySection = document.querySelector("#verifySection");
const verifyInput = document.querySelector("#verify");
const verifyButton = document.querySelector("#verifyButton");

phoneInput.addEventListener("focus", (e) => {
    e.target.classList.add("active")
});
phoneInput.addEventListener("blur", (e) => {
    e.target.classList.remove("active")
});

sendButton.addEventListener("click", async () => {
    const phone = phoneInput.value;

    const result = await emailService.findEmail({
        memberPhoneNumber: phone
    });

    if (result.success) {
        sendMessage.style.display = "inline-block";
        verifySection.style.display = "block";
        console.log("인증번호: ", result.code);
    } else {
        console.log("문자 발송 실패: " + result.message);
    }
});
