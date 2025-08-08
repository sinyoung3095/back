// 리뷰 이벤트 tooltip 버튼
const tooltipContainer = document.querySelector(
    "div.tooltip-container div.tooltip-info"
);
const tooltipButton = document.querySelector(
    "div.tooltip-container button.btn-tooltip"
);

tooltipContainer.style.opacity = 0;
let tooltipCount = 1;

tooltipButton.addEventListener("click", (e) => {
    tooltipCount++;
    if (tooltipCount % 2 === 0) {
        tooltipContainer.style.opacity = 0.9;
    } else {
        tooltipContainer.style.opacity = 0;
    }
});

// 상담사 정보/리뷰/질문답변 스타일

const goCounselorInfoButton = document.querySelector(
    "ul.sticky-nav li.about.active"
);
const goReviewButton = document.querySelector("ul.sticky-nav li.reviews");
const goFAQButton = document.querySelector("ul.sticky-nav li.FAQ");

window.addEventListener("scroll", (e) => {
    if (window.scrollY <= 1250) {
        goCounselorInfoButton.style.color = "#293341";
        goCounselorInfoButton.style.fontWeight = "700";
        goCounselorInfoButton.style.borderBottom = ".125rem solid #293341";

        goReviewButton.style = "none";
        goFAQButton.style = "none";
    } else if (1250 < window.scrollY && window.scrollY < 2634) {
        goReviewButton.style.color = "#293341";
        goReviewButton.style.fontWeight = "700";
        goReviewButton.style.borderBottom = ".125rem solid #293341";

        goCounselorInfoButton.style = "none";
        goFAQButton.style = "none";
    } else if (2634 <= window.scrollY) {
        goFAQButton.style.color = "#293341";
        goFAQButton.style.fontWeight = "700";
        goFAQButton.style.borderBottom = ".125rem solid #293341";

        goCounselorInfoButton.style = "none";
        goReviewButton.style = "none";
    }
});
