HTMLCollection.prototype.forEach = Array.prototype.forEach;
// const test = document.getElementsByClassName("text");
// test.forEach((data) => {
//     data.addEventListener("focus", (e) => {
//         e.target.classList.add("active");
//     });
//     data.addEventListener("blur", (e) => {
//         e.target.classList.remove("active");
//     });
// });

const memberInputs=document.querySelectorAll(".member-input-box");
const joinForm=document.getElementById("joinForm")

const nameErrorMessage=document.querySelector(".name-error-message");
const emailErrorMessage=document.querySelector(".email-error-message");
const phoneNumberErrorMessage=document.querySelector(".phoneNumber-error-message");
const passwordErrorMessage=document.querySelector(".password-error-message");

const nameInput=document.getElementById("memberName");
const phoneNumberInput=document.getElementById("memberPhoneNumber");
const emailInput=document.getElementById("memberEmail");
const passwordInput=document.getElementById("memberPassword");

const passwordOK=document.getElementById("passwordOK")
const passwordOKErrorMassage=document.querySelector(".passwordOK-error-message")

const joinButton=document.querySelector(".joinButton");

memberInputs.forEach((memberInput)=>{
    memberInput.addEventListener("focus", (e)=>{
        e.target.classList.add("active");
    });
    memberInput.addEventListener("blur", (e)=>{
        e.target.classList.remove("active")
    });
});

joinButton.addEventListener("click", (e)=>{
    let joinOK=true;
    if(!nameInput.value){
        nameErrorMessage.classList.remove("disableEvent");
        joinOK=false;
    } else{
        nameErrorMessage.classList.add("disableEvent");
    }
    if(!phoneNumberInput.value){
        phoneNumberErrorMessage.classList.remove("disableEvent");
        joinOK=false;
    } else{
        phoneNumberErrorMessage.classList.add("disableEvent");
    }
    if(!emailInput.value){
        emailErrorMessage.classList.remove("disableEvent");
        joinOK=false;
    } else{
        emailErrorMessage.classList.add("disableEvent");
    }
    if(!passwordInput.value){
        passwordErrorMessage.classList.remove("disableEvent");
        joinOK=false;
    } else{
        passwordErrorMessage.classList.add("disableEvent");
    }
    if(passwordOK.value!==passwordInput.value){
        passwordOKErrorMassage.classList.remove("disableEvent");
        joinOK=false;
    } else{
        passwordOKErrorMassage.classList.add("disableEvent");
    }
    if(!joinOK){
        e.preventDefault();
    } else{
        joinForm.submit();
    }
})

