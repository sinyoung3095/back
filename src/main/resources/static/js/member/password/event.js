const form = document.querySelector("form");
const emailInput = document.getElementById("memberEmail");
const passwordInput = document.getElementById("newPassword");
const confirmInput = document.getElementById("newPasswordConfirm");

form.addEventListener("submit", async (e) => {

    const email = emailInput.value;
    const password = passwordInput.value;
    const confirm = confirmInput.value;

    if (!password || !confirm) {
        alert("비밀번호를 입력해주세요.");
    }
    if (password !== confirm) {
        alert("비밀번호가 일치하지 않습니다.");
    }

    const result = await passwordService.updatePassword({
        memberEmail: email,
        memberPassword: password
    });

    if (result) {
        window.location.href = "/member/login";
    }
});
