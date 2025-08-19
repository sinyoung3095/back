HTMLCollection.prototype.forEach = Array.prototype.forEach;
const test = document.getElementsByClassName("text");
test.forEach((data) => {
    data.addEventListener("focus", (e) => {
        e.target.classList.add("active");
    });
    data.addEventListener("blur", (e) => {
        e.target.classList.remove("active");
    });
});

const joinForm = document.getElementById("joinWrap");
const joinButton = document.querySelector(".joinSubmit");

const nameInput = document.getElementById("counselorName");
const phoneNumberInput = document.getElementById("counselorPhoneNumber");
const emailInput = document.getElementById("counselorEmail");
const passwordInput = document.getElementById("counselorPassword");
const passwordOK = document.getElementById("counselorPasswordOK");

const nameErrorMessage = document.querySelector(".counselor-name-error-message");
const phoneNumberErrorMessage = document.querySelector(".counselor-phoneNumber-error-message");
const emailErrorMessage = document.querySelector(".counselor-email-error");
const passwordErrorMessage = document.querySelector(".counselor-password-error");
const passwordOKErrorMassage = document.querySelector(".counselor-passwordOK-error");

let isEmailValid = false;
let isPhoneNumberValid=false;

emailInput.addEventListener("blur", async () => {
    const email = emailInput.value.trim();
    if (!email) return;

    const result = await counselorService1.checkEmail(email);
    isEmailValid = !result.isExist;

    if (result.isExist) {
        counselorLayout1.showEmailError("이미 사용 중인 이메일입니다.");
    } else {
        counselorLayout1.hideEmailError();
    }
});

phoneNumberInput.addEventListener("blur", async () => {
    const phone = phoneNumberInput.value.trim();
    if (!phone) return;

    const result = await counselorService2.checkPhoneNumber(phone);
    isPhoneNumberValid = !result.isExist;

    if (result.isExist) {
        counselorLayout2.showPhoneNumberError("이미 사용 중인 전화번호입니다.");
    } else {
        counselorLayout2.hidePhoneNumberError();
    }
});

joinButton.addEventListener("click", async (e) => {
    e.preventDefault();
    let joinOK = true;

    // console.log("버튼 클릭");

    const result1 = await counselorService1.checkEmail(emailInput.value.trim());
    isEmailValid = !result1.isExist;

    if (!isEmailValid) {
        counselorLayout1.showEmailError("이미 사용 중인 이메일입니다.");
        joinOK = false;
    } else {
        counselorLayout1.hideEmailError();
    }

    const result2 = await counselorService2.checkPhoneNumber(phoneNumberInput.value.trim());
    isPhoneNumberValid = !result2.isExist;

    if (!isPhoneNumberValid) {
        counselorLayout2.showPhoneNumberError("이미 사용 중인 전화번호입니다.");
        joinOK = false;
    } else {
        counselorLayout2.hidePhoneNumberError();
    }

    // console.log("중복 시 메세지 내용 입력");

    if (!nameInput.value) { nameErrorMessage.classList.remove("disableEvent"); joinOK = false; }
    else { nameErrorMessage.classList.add("disableEvent"); }

    if (!phoneNumberInput.value) { phoneNumberErrorMessage.classList.remove("disableEvent"); joinOK = false; }
    else { phoneNumberErrorMessage.classList.add("disableEvent"); }

    if (!emailInput.value) { emailErrorMessage.classList.remove("disableEvent"); joinOK = false; }
    else { emailErrorMessage.classList.add("disableEvent"); }

    if (!passwordInput.value) { passwordErrorMessage.classList.remove("disableEvent"); joinOK = false; }
    else { passwordErrorMessage.classList.add("disableEvent"); }

    if (passwordOK.value !== passwordInput.value) { passwordOKErrorMassage.classList.remove("disableEvent"); joinOK = false; }
    else { passwordOKErrorMassage.classList.add("disableEvent"); }

    if (joinOK) {
        joinForm.submit();
    }

    // console.log("오류 검사 완료");
});
