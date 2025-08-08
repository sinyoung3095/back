const text = document.getElementById("__BVID__81");

text.addEventListener("focus", (e) => {
    e.target.classList.add("active");
});
text.addEventListener("blur", (e) => {
    e.target.classList.remove("active");
});
