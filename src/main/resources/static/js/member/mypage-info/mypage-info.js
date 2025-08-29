HTMLCollection.prototype.filter = Array.prototype.filter;
HTMLCollection.prototype.forEach = Array.prototype.forEach;
const set = document.getElementsByClassName("main-5");
const general = document.getElementsByClassName("wrap");
const hide = document.getElementsByClassName("sub");
const cancle = document.getElementsByClassName("select-2");

console.log(cancle);
set.forEach((data, i) => {
    data.addEventListener("click", (e) => {
        e.target.style.display = "none";
        general[i].classList.add("active");
        hide[i].classList.add("active");
    });
});
cancle.forEach((data, i) => {
    data.addEventListener("click", (e) => {
        general[i].classList.remove("active");
        hide[i].classList.remove("active");
        set[i].style.display = "block";
    });
});

const phoneNumber = document.getElementById("phoneNumberInput");
const phoneNumberButton = document.getElementById("phoneNumberButton");
const emailInput = document.getElementById("emailInput");
const emailButton = document.getElementById("emailButton");

const phoneNumberErrorMessage = document.querySelector(".exist-phoneNumber-error-message");
const emailErrorMessage = document.querySelector(".exist-email-error-message");
const emailForm=document.getElementById("email-form");
const phoneForm=document.getElementById("phone-form");

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

phoneNumber.addEventListener("blur", async () => {
    const phone = phoneNumber.value.trim();
    if (!phone) return;

    const result = await memberService2.checkPhoneNumber(phone);
    isPhoneNumberValid = !result.isExist;

    if (result.isExist) {
        memberLayout2.showPhoneNumberError("이미 사용 중인 전화번호입니다.");
    } else {
        memberLayout2.hidePhoneNumberError();
    }
});

phoneNumberButton.addEventListener("click", async (e) => {
    e.preventDefault();
    let emailOK = true;

    const result2 = await memberService2.checkPhoneNumber(phoneNumber.value.trim());
    isPhoneNumberValid = !result2.isExist;

    if (!isPhoneNumberValid) {
        memberLayout2.showPhoneNumberError("이미 사용 중인 전화번호입니다.");
        emailOK = false;
    } else {
        memberLayout2.hidePhoneNumberError();
    }

    if (!phoneNumber.value) { phoneNumberErrorMessage.classList.remove("disableEvent"); joinOK = false; }
    else { phoneNumberErrorMessage.classList.add("disableEvent"); }

    if (emailOK) {
        phoneForm.submit();
    }
});

emailButton.addEventListener("click", async (e) => {
    e.preventDefault();
    let emailOK = true;

    const result1 = await memberService1.checkEmail(emailInput.value.trim());
    isEmailValid = !result1.isExist;

    if (!isEmailValid) {
        memberLayout1.showEmailError("이미 사용 중인 이메일입니다.");
        emailOK = false;
    } else {
        memberLayout1.hideEmailError();
    }

    if (!emailInput.value) { emailErrorMessage.classList.remove("disableEvent"); joinOK = false; }
    else { emailErrorMessage.classList.add("disableEvent"); }

    if (emailOK) {
        emailForm.submit();
    }
});