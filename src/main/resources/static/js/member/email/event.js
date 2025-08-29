const phoneInput = document.querySelector("#phone");
const sendButton = document.querySelector("#sendButton");
const sendMessage = document.querySelector("#sendMessage");
const sendMessageText = document.querySelector(".sendMessage");
const verifySection = document.querySelector("#verifySection");
const verifyInput = document.querySelector("#verify");
const verifyButton = document.querySelector("#verifyButton");
const verifyCheck = document.querySelector("#verifyCheck");
const verifyCheckText = document.querySelector(".verifyCheckText");
const correctCodeButton = document.querySelector("#correctCodeButton");

phoneInput.addEventListener("focus", (e) => {
    e.target.classList.add("active")
});
phoneInput.addEventListener("blur", (e) => {
    e.target.classList.remove("active")
});

let savedCode = "";

sendButton.addEventListener("click", async () => {
    if (!phoneInput.value) {
        sendMessage.style.display = "block";
        sendMessageText.innerHTML = "전화번호를 입력해주세요";
        return;
    }

    const result = await emailService.sendCode({
        memberPhoneNumber: phoneInput.value
    });

    sendMessage.style.display = "block";

    if (result.success) {
        savedCode = result.code;
        sendMessageText.innerHTML = "인증번호를 전송하였습니다.";
        verifySection.style.display = "block";
        console.log("인증번호: ", savedCode);
    } else {
        sendMessageText.innerHTML = "가입되지 않은 전화번호 입니다.";
        verifySection.style.display = "none";
    }
});

verifyButton.addEventListener("click", (e) => {
    verifyCheck.style.display = "block";

    if(!verifyInput.value) {
        verifyCheckText.innerHTML = "인증번호를 입력해주세요.";
        correctCodeButton.disabled = true;
        return;
    }

    if(verifyInput.value === savedCode) {
        verifyCheckText.innerHTML = "인증을 성공했습니다.";
        correctCodeButton.disabled = false;
    } else {
        verifyCheckText.innerHTML = "인증번호가 다릅니다.";
        correctCodeButton.disabled = true;
    }
});



