HTMLCollection.prototype.forEach = Array.prototype.forEach;
const test = document.getElementsByClassName("text");
test.forEach((data) => {
    data.addEventListener("focus", (e) => {
        e.target.classList.add("active");
    });
    data.addEventListener("blur", (e) => {
        e.target.classList.remove("active");
    });
});
