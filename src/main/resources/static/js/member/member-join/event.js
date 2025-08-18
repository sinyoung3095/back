const joinForm = document.getElementById("joinForm");
const joinButton = document.querySelector(".joinButton");

const nameInput = document.getElementById("memberName");
const phoneNumberInput = document.getElementById("memberPhoneNumber");
const emailInput = document.getElementById("memberEmail");
const passwordInput = document.getElementById("memberPassword");
const passwordOK = document.getElementById("passwordOK");

const nameErrorMessage = document.querySelector(".name-error-message");
const phoneNumberErrorMessage = document.querySelector(".phoneNumber-error-message");
const emailErrorMessage = document.querySelector(".email-error-message");
const passwordErrorMessage = document.querySelector(".password-error-message");
const passwordOKErrorMassage = document.querySelector(".passwordOK-error-message");

let isEmailValid = false;
let isPhoneNumberValid=false;

emailInput.addEventListener("blur", async () => {
    const email = emailInput.value.trim();
    if (!email) return;

    const result = await memberService1.checkEmail(email);
    isEmailValid = !result.isExist;

    if (result.isExist) {
        memberLayout1.showEmailError("이미 사용 중인 이메일입니다.");
    } else {
        memberLayout1.hideEmailError();
    }
});

phoneNumberInput.addEventListener("blur", async () => {
    const phone = phoneNumberInput.value.trim();
    if (!phone) return;

    const result = await memberService2.checkPhoneNumber(phone);
    isPhoneNumberValid = !result.isExist;

    if (result.isExist) {
        memberLayout2.showPhoneNumberError("이미 사용 중인 전화번호입니다.");
    } else {
        memberLayout2.hidePhoneNumberError();
    }
});

joinButton.addEventListener("click", async (e) => {
    e.preventDefault();
    let joinOK = true;

    const result1 = await memberService1.checkEmail(emailInput.value.trim());
    isEmailValid = !result1.isExist;

    if (!isEmailValid) {
        memberLayout1.showEmailError("이미 사용 중인 이메일입니다.");
        joinOK = false;
    } else {
        memberLayout1.hideEmailError();
    }

    const result2 = await memberService2.checkPhoneNumber(phoneNumberInput.value.trim());
    isPhoneNumberValid = !result2.isExist;

    if (!isPhoneNumberValid) {
        memberLayout2.showPhoneNumberError("이미 사용 중인 전화번호입니다.");
        joinOK = false;
    } else {
        memberLayout2.hidePhoneNumberError();
    }

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
});
