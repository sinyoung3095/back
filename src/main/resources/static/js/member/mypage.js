const button = document.querySelectorAll("div[role=button]");
const setting = document.querySelector("span[class=main-12]");
const img = document.querySelector("img[class=main-6]");

button.forEach((data) => {
    data.addEventListener("click", (e) => {
        // 클릭시 이동 이벤트 임시 색 변경으로 함
        e.target.style.color = "red";
    });
});
setting.addEventListener("click", (e) => {
    // 클릭시 이동 이벤트 임시 색 변경으로 함
    e.target.style.color = "red";
});
img.addEventListener("click", (e) => {
    // 클릭시 이동 이벤트 임시 색 변경으로 함
    e.target.style.color = "red";
});
