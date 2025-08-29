const counselorLayout1 = (() => {
    const showEmailError = (message) => {
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

