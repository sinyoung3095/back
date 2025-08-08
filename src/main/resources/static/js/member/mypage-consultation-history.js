HTMLCollection.prototype.forEach = Array.prototype.forEach;
const hide = document.querySelector("div[class=main-28]");
const view = document.querySelector("div[class=main-2]");
const button = document.getElementsByClassName("main-26-1");
const remove = document.getElementsByClassName("main-26");

button.forEach((data) => {
    data.addEventListener("click", (e) => {
        hide.classList.add("active");
        view.classList.add("active");
    });
});
// remove.forEach((data) => {
//     data.addEventListener("click", (e) => {
//        삭제 이벤트
//     });
// });
