const sendButton = document.querySelector("#sendButton");

sendButton.addEventListener("click", () => {

    sendButton.disabled = true;
    const buttonText = sendButton.querySelector(".button-text");
    const loadingText = sendButton.querySelector(".loading-send-email");

    buttonText.style.display = "none";
    loadingText.style.display = "inline-block";

    sendButton.closest("form").submit();
});

const submitButton = document.querySelector("#submitButton");
const emailInput = document.getElementById("memberEmail");
const passwordInput = document.getElementById("newPassword");
const confirmInput = document.getElementById("newPasswordConfirm");
const passwordError = document.getElementById("passwordError");
const confirmError = document.getElementById("confirmError");

submitButton.addEventListener("click", async () => {

    passwordError.textContent = "";
    confirmError.textContent = "";

    let isValid = true;

    if (!passwordInput.value) {
        passwordError.textContent = "비밀번호를 입력해주세요.";
        isValid = false;
    }
    if (!confirmInput.value) {
        confirmError.textContent = "비밀번호 확인을 입력해주세요.";
        isValid = false;
    }
    if (passwordInput.value && confirmInput.value && passwordInput.value !== confirmInput.value) {
        confirmError.textContent = "비밀번호가 일치하지 않습니다.";
        isValid = false;
    }

    if (!isValid) return;

    const result = await passwordService.updatePassword({
        memberEmail: emailInput.value,
        memberPassword: passwordInput.value
    });

    if (result) {
        alert("비밀번호 변경이 완료되었습니다.");
        window.location.href = "/member/login";
    }
});
