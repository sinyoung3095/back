// 게시글, 댓글 수정 버튼
document.addEventListener("click", (e) => {
    const toggleBtn = e.target.closest(".dropdown-toggle");
    if (toggleBtn) {
        const dropdown = toggleBtn.closest(".dropdown");
        const menu = dropdown.querySelector(".dropdown-menu");
        menu.classList.toggle("show");
    } else {
        document.querySelectorAll(".dropdown-menu.show").forEach((menu) => {
            menu.classList.remove("show");
        });
    }
});

document.addEventListener("input", (e) => {
    if (e.target.classList.contains("comment-input")) {
        e.target.style.height = "auto";
        e.target.style.height = e.target.scrollHeight + "px";
    }
});

// 댓글 버튼
const commentInput = document.getElementById("commentContent");
const commentWriteButton = document.getElementById("commentWriteButton");

commentWriteButton.style.display = "none";

commentInput.addEventListener("input", () => {
    commentWriteButton.style.display = commentInput.value.length === 0 ? "none" : "block";
});

// 페이지 로드 시 댓글 불러오기
commentService.getList(post.id, commentLayout.showList);

// 댓글 등록 이벤트
commentWriteButton.addEventListener("click", async () => {
    const content = commentInput.value;

    const comment = {
        postId: post.id,
        memberId: memberId,
        commentContent: content,
        postMemberId: post.postMemberId
    };

    await commentService.write(comment);

    commentInput.value = "";
    commentWriteButton.style.display = "none";

    await commentService.getList(post.id, commentLayout.showList);
});

const commentWrap = document.getElementById("commentWrap");
commentWrap.addEventListener("click", async (e) => {

    let commentId = 0;
    let textArea = null;
    let span = null;
    if(e.target.classList.contains("update-button")) {
        commentId = e.target.classList[0].replaceAll("id", "");
        span = document.querySelector(`span.id${commentId}`)
        textArea = document.querySelector(`textarea.id${commentId}`);
        textArea.style.display = "inline-block";
        span.style.display = "none";
        e.target.style.display = "none"
        e.target.nextElementSibling.style.display = "inline-block";
        document.querySelector(`button.cancel-button.id${commentId}`).style.display = "inline-block";
        document.querySelector(`button.delete-button.id${commentId}`).style.display = "none";
    } else if(e.target.classList.contains("cancel-button")){
        commentId = e.target.classList[0].replaceAll("id", "");
        span = document.querySelector(`span.id${commentId}`)
        textArea = document.querySelector(`textarea.id${commentId}`);
        textArea.value = span.innerText;
        textArea.style.display = "none";
        span.style.display = "inline";
        e.target.style.display = "none";
        e.target.previousElementSibling.style.display = "none";
        document.querySelector(`button.update-button.id${commentId}`).style.display = "inline-block";
        document.querySelector(`button.delete-button.id${commentId}`).style.display = "inline-block";

    } else if(e.target.classList.contains("update-ok-button")){
        commentId = e.target.classList[0].replaceAll("id", "");
        textArea = document.querySelector(`textarea.id${commentId}`);
        const comment = {
            commentContent: textArea.value,
            id: commentId
        }
        await commentService.update(comment);
        await commentService.getList(post.id, commentLayout.showList);

    } else if(e.target.classList.contains("delete-button")) {
        commentId = e.target.classList[0].replaceAll("id", "");
        if(confirm("댓글을 삭제하시겠습니까?")) {
            await commentService.remove(commentId);
            await commentService.getList(post.id, commentLayout.showList);
        }
    } else if(e.target.classList.contains("send-request-button")) {
        commentId = e.target.closest("li").classList[0].replaceAll("id", "");

        if(!e.target.classList.contains("liked")) {
            await commentService.like(commentId, memberId);
            e.target.classList.add("liked");
            e.target.textContent = "추천됨";
        } else {
            await commentService.removeLike(commentId, memberId);
            e.target.classList.remove("liked");
            e.target.textContent = "추천하기";
        }

        const countResponse = await fetch(`/api/likes/${commentId}/count`);
        const count = await countResponse.json();
        e.target.closest("li").querySelector(".pro-user-services span:last-child").textContent = `+ ${count}개의 추천 수`;
    }
});

postActionLayout.showPostActions(post, memberId);

