const text = document.getElementById("phone");

console.log(text);
text.addEventListener("focus", (e) => {
    e.target.classList.add("active");
});
text.addEventListener("blur", (e) => {
    e.target.classList.remove("active");
});

const phoneNumberInput = document.getElementById("phone");
const sendButton = document.querySelector(".main-9");


form.addEventListener("submit", async (e) => {

    const phone = phoneNumberInput.value;


    const result = await emailService.findEmail({
        memberPhoneNumber: phone
    });

    if (result) {
        window.location.href = "/member/find-email-ok";
    }
});
