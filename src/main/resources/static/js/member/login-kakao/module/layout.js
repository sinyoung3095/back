const memberLayout2 = (() => {
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

