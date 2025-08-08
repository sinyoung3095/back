const mtbutton = document.querySelector(".mybutton");
const mydiv = document.querySelector("div.mydiv");
const profile = document.querySelector(".myprofile");

mtbutton.addEventListener("click", (e) => {
    mydiv.classList.toggle("active");
    profile.classList.toggle("active");
});

const alimbutton = document.querySelector("button.alimbutton");
const alimdiv = document.querySelector("div.alimarea");

alimbutton.addEventListener("click", (e) => {
    alimdiv.classList.toggle("active");
});
