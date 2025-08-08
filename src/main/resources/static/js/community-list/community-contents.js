// 상단 게시글 정보 라인 나타나기/숨기기
const topLine = document.querySelector("div.vue-portal-target");

topLine.style.transition = "opacity 0.3s ease, transform 0.3s ease";
topLine.style.transform = "translateY(-60px)";
topLine.style.opacity = 0;

window.addEventListener("scroll", () => {
    if (window.scrollY === 0) {
        topLine.style.transform = "translateY(-60px)";
        setTimeout(() => {
            topLine.style.opacity = 0;
            topLine.style.visibility = "hidden";
        }, 300);
    } else {
        topLine.style.opacity = 1;
        topLine.style.visibility = "visible";
        topLine.style.transform = "translateY(0)";
    }
});

// 게시글 수정하기 타나탐/사라짐
const button01 = document.querySelector(
    "div#app-sticky-nav button[type=button]"
);
const dropdownMenu01 = document.querySelector(
    "div#app-sticky-nav ul.dropdown-menu"
);
const button02 = document.querySelector("div.post-actions button[type=button]");
const dropdownMenu02 = document.querySelector(
    "div.post-actions ul.dropdown-menu"
);

console.log(button01);
console.log(dropdownMenu01);
console.log(button02);
console.log(dropdownMenu02);

button01.addEventListener("click", (e) => {
    if (dropdownMenu01.classList.contains("show")) {
        dropdownMenu01.classList.remove("show");
    } else {
        dropdownMenu01.classList.add("show");
    }
});

button02.addEventListener("click", (e) => {
    if (dropdownMenu02.classList.contains("show")) {
        dropdownMenu02.classList.remove("show");
    } else {
        dropdownMenu02.classList.add("show");
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
