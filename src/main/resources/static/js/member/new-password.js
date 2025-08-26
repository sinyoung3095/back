const text = document.querySelectorAll("input");
text.forEach((data) => {
    data.addEventListener("focus", (e) => {
        e.target.classList.add("active");
    });
});
text.forEach((data) => {
    data.addEventListener("blur", (e) => {
        e.target.classList.remove("active");
    });
});
