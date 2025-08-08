HTMLCollection.prototype.filter = Array.prototype.filter;
HTMLCollection.prototype.forEach = Array.prototype.forEach;
const set = document.getElementsByClassName("main-5");
const general = document.getElementsByClassName("wrap");
const hide = document.getElementsByClassName("sub");
const cancle = document.getElementsByClassName("select-2");
const input = document.getElementsByTagName("input");

set.forEach((data, i) => {
    data.addEventListener("click", (e) => {
        e.target.style.display = "none";
        general[i].classList.add("active");
        hide[i].classList.add("active");
    });
});
cancle.forEach((data, i) => {
    data.addEventListener("click", (e) => {
        general[i].classList.remove("active");
        hide[i].classList.remove("active");
        set[i].style.display = "block";
    });
});
