HTMLCollection.prototype.forEach = Array.prototype.forEach;
const hide = document.querySelector("div[class=main-28]");
const view = document.querySelector("div[class=main-2]");
const button = document.getElementsByClassName("main-26-1");
const remove = document.getElementsByClassName("main-26");
const text = document.querySelector("textarea[class=main-63]");
const count = document.querySelector("span[class=information-2]");

button.forEach((data) => {
    data.addEventListener("click", (e) => {
        hide.classList.add("active");
        view.classList.add("active");
    });
});

text.addEventListener("focus", (e) => {
    e.target.classList.add("active");
});
text.addEventListener("blur", (e) => {
    e.target.classList.remove("active");
});

text.addEventListener("keyup", (e) => {
    const length = text.value.length;
    count.textContent = length;
});

// remove.forEach((data) => {
//     data.addEventListener("click", (e) => {
//        삭제 이벤트
//     });
// });
