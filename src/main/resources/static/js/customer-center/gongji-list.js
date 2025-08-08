const pageButtons = document.querySelectorAll("nav.pagination li");

pageButtons.forEach((button) => {
    button.addEventListener("click", (e) => {
        // a링크로 이동 막아주는 메소드
        // 나중에 서버 연결하면 삭제
        e.preventDefault();
        pageButtons.forEach((btn) => {
            btn.classList.remove("pagination-current");
        });
        button.classList.add("pagination-current");
    });
});
