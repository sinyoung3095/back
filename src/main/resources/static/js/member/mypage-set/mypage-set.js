// HTMLCollection.prototype.filter = Array.prototype.filter;
// HTMLCollection.prototype.forEach = Array.prototype.forEach;
// const button = document.querySelector("button[class=main-8]");
// const photo = document.querySelector("div[class=photo-1]");
// const cancle = document.querySelector("button[class=photo-10]");
// const set = document.querySelector("button[class=main-10]");
// const infoName = document.querySelector("div[id=setName]");
// const cancleName = document.querySelector("button[id=cancle1]");
//
// button.addEventListener("click", (e) => {
//     photo.classList.add("active");
// });
// cancle.addEventListener("click", (e) => {
//     photo.classList.remove("active");
// });
//
// set.addEventListener("click", (e) => {
//     infoName.classList.add("active");
// });
// cancleName.addEventListener("click", (e) => {
//     infoName.classList.remove("active");
// });
//
// const set1 = document.getElementById("button");
// const general = document.getElementById("wrap");
// const hide = document.getElementById("sub");
// const cancle1 = document.getElementById("cancle1");
//
// set1.addEventListener("click", (e) => {
//     general.classList.add("active");
//     hide.classList.add("active");
// });
//
// cancle1.addEventListener("click", (e) => {
//     general.classList.remove("active");
//     hide.classList.remove("active");
//     set1.style.display = "block";
// });
const wrapForm = document.getElementById("wrap");
const subForm = document.getElementById("sub");
const editButton = document.getElementById("button");
const cancelButton = document.getElementById("cancle1");
const input = document.getElementById("insert1");
const saveButton = subForm.querySelector("button[type='submit']");
const noProfileButton=document.querySelector(".photo-9");
const updateButton=document.querySelector(".photo-9");
const deleteButton=document.querySelector(".photo-10");

subForm.style.display = "none";

editButton.addEventListener("click", function () {
    wrapForm.style.display = "none";
    subForm.style.display = "block";
    input.focus();
});

cancelButton.addEventListener("click", function () {
    subForm.style.display = "none";
    wrapForm.style.display = "block";
});

input.addEventListener("input", function () {
    if (input.value.trim() !== "") {
        saveButton.disabled = false;
    } else {
            saveButton.disabled = true;
    }
});

noProfileButton.addEventListener("click", async ()=>{
    await myPageSetService.profileDelete(fileId);
})