const text = document.getElementById("phone");

console.log(text);
text.addEventListener("focus", (e) => {
    e.target.classList.add("active");
});
text.addEventListener("blur", (e) => {
    e.target.classList.remove("active");
});
