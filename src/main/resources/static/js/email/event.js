const phoneInput = document.querySelector("#phone");
const sendButton = document.querySelector("#sendButton");
const sendMessage = document.querySelector("#sendMessage");
const sendMessageText = document.querySelector(".sendMessage");
const verifySection = document.querySelector("#verifySection");
const verifyInput = document.querySelector("#verify");
const verifyButton = document.querySelector("#verifyButton");
const verifyCheck = document.querySelector("#verifyCheck");
const verifyCheckText = document.querySelector(".verifyCheckText");

phoneInput.addEventListener("focus", (e) => {
    e.target.classList.add("active")
});
phoneInput.addEventListener("blur", (e) => {
    e.target.classList.remove("active")
});

sendButton.addEventListener("click", async () => {
    const phone = phoneInput.value;

    if (!phone) {
        sendMessage.style.display = "block";
        sendMessageText.innerHTML = "전화번호를 입력해주세요";
        return;
    }

    const result = await emailService.findEmail({
        memberPhoneNumber: phone
    });

    sendMessage.style.display = "block";
    if (result.success) {
        sendMessageText.innerHTML = "인증번호를 전송하였습니다.";
        verifySection.style.display = "block";
        console.log("인증번호: ", result.code);
    } else {
        sendMessageText.innerHTML = "가입되지 않은 전화번호 입니다.";
        verifySection.style.display = "none";
    }
});

verifyButton.addEventListener("click", async () => {
    const code = verifyInput.value;
    const phone = phoneInput.value;

    if (!code) {
        verifyCheck.style.display = "block";
        verifyCheckText.innerHTML = "인증번호를 확인해주세요.";
        return;
    }

    const result = await emailService.checkCode({
        code: code, memberPhoneNumber: phone
    });

    verifyCheck.style.display = "block";
    if(result.success) {
        verifyCheckText.innerHTML = "인증을 성공했습니다.";
        window.location.href = "/member/find-email-ok";
    } else {
        verifyCheckText.innerHTML = "인증번호가 일치하지 않습니다."
    }


});
