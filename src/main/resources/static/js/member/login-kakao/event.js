const joinForm = document.getElementById("joinForm");
const joinButton = document.querySelector(".joinButton");

const nameInput = document.getElementById("memberName");
const phoneNumberInput = document.getElementById("memberPhoneNumber");

const nameErrorMessage = document.querySelector(".name-error-message");
const phoneNumberErrorMessage = document.querySelector(".phoneNumber-error-message");

let isPhoneNumberValid=false;

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

    if (joinOK) {
        joinForm.submit();
    }
});
