const auto_login_checkbox = document.getElementById("auto-login-checkbox");
const auto_login_icon = document.querySelector(".rebound-check-box i");
const modal = document.querySelector(".rebound-modal");
const modal_Inner = document.querySelector(".modal-inner");
const modalButton = document.getElementById("rebound-modal-success-button");
const loginButton = document.querySelector(".btn-login");
const email = document.querySelector('input[name="rebound"]');
const pw = document.querySelector('input[name="password"]');

// 자동로그인 클릭 이벤트
auto_login_checkbox.addEventListener("change", () => {
    auto_login_icon.style.display = auto_login_checkbox.checked
        ? "block"
        : "none";
});

// 가입된 회원정보가 없거나 비밀번호가 잘못 입력 되었을 상황의 모달
loginButton.addEventListener("click", (e) => {
    if (!email.value || !pw.value) {
        modal.classList.add("active");
        modal_Inner.style.animation = "popUp 0.1s";
        e.preventDefault();
    }
});

modalButton.addEventListener("click", (e) => {
    modal.classList.remove("active");
    e.preventDefault();
});
