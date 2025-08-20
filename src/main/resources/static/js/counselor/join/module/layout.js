const counselorLayout1 = (() => {
    const showEmailError = (message) => {
        // console.log("이메일 중복 메세지 가져오기");
        const errorMessage1 = document.querySelector(".exist-email-error-message");
        errorMessage1.style.display = "block";
        errorMessage1.innerText = message;
    };

    const hideEmailError = () => {
        const errorMessage1 = document.querySelector(".exist-email-error-message");
        errorMessage1.style.display = "none";
        errorMessage1.innerText = "";
    };

    return {
        showEmailError,
        hideEmailError
    };
})();

const counselorLayout2 = (() => {
    const showPhoneNumberError = (message) => {
        // console.log("전화번호 중복 메세지 가져오기");
        const errorMessage2 = document.querySelector(".exist-phoneNumber-error-message");
        errorMessage2.style.display = "block";
        errorMessage2.innerText = message;
    };

    const hidePhoneNumberError = () => {
        const errorMessage2 = document.querySelector(".exist-phoneNumber-error-message");
        errorMessage2.style.display = "none";
        errorMessage2.innerText = "";
    };

    return {
        showPhoneNumberError,
        hidePhoneNumberError
    };
})();

