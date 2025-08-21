// 게시글 수정 버튼
const button = document.querySelector("div.post-actions button[type=button]");
const dropdownMenu = document.querySelector("div.post-actions ul.dropdown-menu");

button.addEventListener("click", () => {
    dropdownMenu.classList.toggle("show");
});

// 댓글 버튼
const commentInput = document.getElementById("commentContent");
const commentWriteButton = document.getElementById("commentWriteButton");

commentWriteButton.style.display = "none";

commentInput.addEventListener("input", () => {
    commentWriteButton.style.display = commentInput.value.length === 0 ? "none" : "block";
});

// 페이지 로드 시 댓글 불러오기
commentService.getList(postId, commentLayout.showList);

// 댓글 등록 이벤트
commentWriteButton.addEventListener("click", async () => {
    const content = commentInput.value;

    const comment = {
        postId: postId,
        memberId: memberId,
        commentContent: content
    };

    await commentService.write(comment);

    commentInput.value = "";
    commentWriteButton.style.display = "none";

    await commentService.getList(postId, commentLayout.showList);
});
