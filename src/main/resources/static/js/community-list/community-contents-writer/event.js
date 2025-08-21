// 게시글 수정하기 타나탐/사라짐
const button = document.querySelector("div.post-actions button[type=button]");
const dropdownMenu = document.querySelector(
    "div.post-actions ul.dropdown-menu"
);

button.addEventListener("click", (e) => {
    if (dropdownMenu.classList.contains("show")) {
        dropdownMenu.classList.remove("show");
    } else {
        dropdownMenu.classList.add("show");
    }
});

// 댓글 등록 버튼 나타남/사라짐
const commentInput = document.querySelector(".comment-input");
const writeButton = document.querySelector(".write-button");

writeButton.style.display = "none";

commentInput.addEventListener("input", (e) => {
    if (e.target.value.length === 0) {
        writeButton.style.display = "none";
    } else {
        writeButton.style.display = "block";
    }
});

// 인기 고수 추천 좌우 이동
const prevButton = document.querySelector(
    "section.popular-provider div.slick-slider button.slick-prev"
);
const nextButton = document.querySelector(
    "section.popular-provider div.slick-slider button.slick-next"
);
const suggestion = document.querySelector(
    "section.popular-provider div.slick-list div.slick-track"
);
let suggestionCount = 0;

prevButton.style.visibility = "hidden";
nextButton.style.visibility = "visible";

prevButton.addEventListener("click", (e) => {
    if (suggestionCount > 0) {
        suggestionCount--;
        suggestion.style.transform = `translate(-${300 * suggestionCount}px)`;
        suggestion.style.transition = `transform 0.5s`;
    }

    if (suggestionCount > 0) {
        prevButton.style.visibility = "visible";
    } else {
        prevButton.style.visibility = "hidden";
    }
    if (suggestionCount < 6) {
        nextButton.style.visibility = "visible";
    } else {
        nextButton.style.visibility = "hidden";
    }
});

nextButton.addEventListener("click", (e) => {
    if (suggestionCount < 6) {
        suggestionCount++;
        suggestion.style.transform = `translate(-${300 * suggestionCount}px)`;
        suggestion.style.transition = `transform 0.5s`;
    }

    if (suggestionCount > 0) {
        prevButton.style.visibility = "visible";
    } else {
        prevButton.style.visibility = "hidden";
    }
    if (suggestionCount < 6) {
        nextButton.style.visibility = "visible";
    } else {
        nextButton.style.visibility = "hidden";
    }
});
