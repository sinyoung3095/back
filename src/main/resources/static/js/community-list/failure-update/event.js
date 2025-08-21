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

// 모달 창
const categoryButton = document.querySelector(".category-select-box");
const modal = document.getElementById("search-service-modal___BV_modal_outer_");
const modalClose = modal.querySelector(".btn.close-button");
const categoryButtonText = document.getElementById("categoryButtonText");
const categoryIdInput = document.getElementById("categoryId");
const categoryItems = modal.querySelectorAll("li.category-item");

// 모달 열기
categoryButton.addEventListener("click", () => {
    modal.style.display = "block";
});

// 모달 닫기
modalClose.addEventListener("click", () => {
    modal.style.display = "none";
});

// 카테고리 선택
categoryItems.forEach((categoryItem, index) => {
    categoryItem.addEventListener("click", (e) => {
        const categoryName = categoryItem.textContent.trim();
        const categoryId = index + 1;

        categoryButtonText.textContent = categoryName;
        categoryIdInput.value = categoryId;

        modal.style.display = "none";

        checkSubmit();
    });
});

// 등록 버튼 활성화
const submit = document.querySelector(
    "div.subject-header-wrapper button.write-post-submit"
);

function checkSubmit() {
    submit.classList.add("active");
    submit.style.cursor = "pointer";
    submit.disabled = false;
}

postTitle.addEventListener("input", checkSubmit);
postContent.addEventListener("input", checkSubmit);
categoryIdInput.addEventListener("input", checkSubmit);

checkSubmit();




