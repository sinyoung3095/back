// 검색창에 글자 입력 시 검색어 삭제 버튼 나타남/사라짐
const serviceInput = document.querySelector(
    "div.search-pro-input-with-router-button input[type=text]"
);
const inputDeleteButton = document.querySelector(
    "div.search-pro-input-with-router-button div.input-group-append img"
);

inputDeleteButton.style.visibility = "hidden";

serviceInput.addEventListener("keyup", (e) => {
    inputDeleteButton.style.visibility = "visible";

    inputDeleteButton.addEventListener("click", (input) => {
        e.target.value = null;
        if (!e.target.value) {
            inputDeleteButton.style.visibility = "hidden";
        }
    });

    if (!e.target.value) {
        inputDeleteButton.style.visibility = "hidden";
    }
});

// 필터 드롭다운 메뉴
const dropdownItems = document.querySelectorAll("ul.dropdown-menu-right li");
const dropdownItemUl = document.querySelector(
    "ul.dropdown-menu.dropdown-menu-right"
);
const currentSort = document.querySelector(
    "div.sort-wrapper span.current-sort"
);
let dropdownCount = 1;

dropdownItemUl.style.visibility = "hidden";

currentSort.addEventListener("click", (e) => {
    dropdownCount++;
    if (dropdownCount % 2 === 0) {
        dropdownItemUl.style.visibility = "visible";
    } else {
        dropdownItemUl.style.visibility = "hidden";
    }
});

dropdownItems.forEach((dropdownItem) => {
    dropdownItem.addEventListener("mouseenter", (e) => {
        dropdownItem.style.background = "#f6f7f9";
    });

    dropdownItem.addEventListener("mouseleave", (e) => {
        dropdownItem.style.background = "#fff";
    });
});

// 바로 답변 가능한 고수 클릭 시 info 나타남
const tooltipButton = document.querySelector(
    "div.tooltip-container button.btn-tooltip"
);
const tooltip = document.querySelector(
    "div.tooltip-container div.tooltip-info"
);

tooltip.style.opacity = 0;
let tooltipCount = 1;

tooltipButton.addEventListener("click", (e) => {
    tooltipCount++;
    if (tooltipCount % 2 === 0) {
        tooltip.style.opacity = 0.9;
    } else {
        tooltip.style.opacity = 0;
    }
});

// 지역
const locations = document.querySelectorAll(
    "div.main-pro-locations li.location-item>button"
);

locations.forEach((location, i) => {
    location.addEventListener("click", (e) => {
        if (locations[i].classList.contains("active")) {
            locations[i].classList.remove("active");
        } else {
            locations[i].classList.add("active");
        }
    });
});

// 예약/쿠폰 클릭 이벤트
const chipActive = document.querySelectorAll("li.chip-filter-item button");

chipActive.forEach((chip, i) => {
    chip.addEventListener("click", (e) => {
        if (chipActive[i].classList.contains("active")) {
            chipActive[i].classList.remove("active");
        } else {
            chipActive[i].classList.add("active");
        }
    });
});

// 위로 가기 버튼 나타나기/숨기기
const topButton = document.querySelector("a#top-btn.top-btn");

topButton.style.transition = "opacity 0.5s ease, transform 0.5s ease";
topButton.style.opacity = 0;
topButton.style.transform = "trnaslateY(20px)";

window.addEventListener("scroll", () => {
    if (window.scrollY === 0) {
        topButton.style.opacity = 0;
        topButton.style.transform = "translateY(30px)";
        setTimeout(() => {
            topButton.style.visibility = "hidden";
        }, 300);
    } else {
        topButton.style.visibility = "visible";
        topButton.style.opacity = 1;
        topButton.style.transform = "translateY(-20px)";
    }
});
