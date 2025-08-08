// 제목
const postTitle = document.querySelector("input.post-title-input");

postTitle.addEventListener("focus", (e) => {
    postTitle.style.outline = "none";
});

// 내용
const postContent = document.querySelector("textarea.editor-contents-textarea");
const postContentExample = document.querySelector(
    "span.editor-contents-textarea-placeholder"
);

postContent.addEventListener("focus", (e) => {
    postContent.style.outline = "none";
});

postContent.addEventListener("keydown", (e) => {
    postContentExample.style.display = "none";
    if (!e.target.value) {
        postContentExample.style.display = "block";
    }
});

// 등록 버튼 활성화
const submit = document.querySelector(
    "div.subject-header-wrapper button.write-post-submit"
);
const writeContainers = document.querySelectorAll(
    "section.write-post-container"
);

writeContainers.forEach((writeContainer) => {
    postContent.addEventListener("keydown", (e) => {
        if (!postTitle.value || !postContent.value) {
            submit.classList.remove("active");
            submit.style.cursor = "default";
        } else {
            submit.classList.add("active");
            submit.style.cursor = "pointer";
        }
    });
    postTitle.addEventListener("keydown", (e) => {
        if (!postTitle.value || !postContent.value) {
            submit.classList.remove("active");
            submit.style.cursor = "default";
        } else {
            submit.classList.add("active");
            submit.style.cursor = "pointer";
        }
    });
});
