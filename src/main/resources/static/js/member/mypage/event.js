document.addEventListener("DOMContentLoaded", () => {
    // 버튼 클릭 이벤트
    const buttons = document.querySelectorAll("div[role=button]");
    buttons.forEach(btn => {
        btn.addEventListener("click", (e) => {
            e.target.style.color = "red"; // 임시 표시
        });
    });

    // 계정설정 클릭 이벤트
    const setting = document.querySelector("span.main-12");
    if (setting) {
        setting.addEventListener("click", (e) => {
            e.target.style.color = "red";
        });
    }


});
