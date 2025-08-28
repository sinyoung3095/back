const phoneInput = document.querySelector("#phone");
const sendButton = document.querySelector("#sendButton");
const sendMessage = document.querySelector("#sendMessage");
const sendMessageText = document.querySelector(".sendMessage");
const verifySection = document.querySelector("#verifySection");
const verifyInput = document.querySelector("#verify");
const verifyButton = document.querySelector("#verifyButton");
const verifyFail = document.querySelector("#verifyFail");
const verifyFailText = document.querySelector(".failText");
const correctCode = document.querySelector("#correctCode");

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

    if (!code) {
        verifyFail.style.display = "block";
        verifyFailText.innerHTML = "인증번호를 입력해주세요.";
        return;
    } else {
        verifyFailText.innerHTML = "인증 성공";
    }

    const result = await emailService.checkCode({
        code: code
    });

    if(result.success) {
        verifyFail.style.display = "none";
        window.location.href = "/member/find-email-ok";
    }


});
