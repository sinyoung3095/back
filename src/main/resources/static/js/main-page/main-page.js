const banner = document.querySelector("div.slick-track");
const firstBanner = document.createElement("div");
const lastBanner = document.createElement("div");
const bannerButtons = document.querySelectorAll("div.slide-button");
const totalBanners = 5;
let bannercount = 1;
const bannerTotalcount = 5;
const indicator = document.querySelector("div.indicator");

let serviceButtonCheck = true;
let servicecount = 0;
const serviceslick = document.querySelector("div.service-slick");
const serviceButtons = document.querySelectorAll(".service-button");
const prevButton = serviceButtons[0];
const nextButton = serviceButtons[1];

const updateServiceButtonVisibility = () => {
    if (servicecount === 0) {
        prevButton.classList.add("slick-disabled");
        nextButton.classList.remove("slick-disabled");
    } else if (servicecount === 1) {
        prevButton.classList.remove("slick-disabled");
        nextButton.classList.remove("slick-disabled");
    } else if (servicecount === 2) {
        prevButton.classList.remove("slick-disabled");
        nextButton.classList.add("slick-disabled");
    }
};

serviceButtons.forEach((serviceButton) => {
    serviceButton.addEventListener("click", (e) => {
        if (
            serviceButtonCheck === false ||
            e.currentTarget.classList.contains("slick-disabled")
        ) {
            return;
        }

        serviceButtonCheck = false;

        const seviceButtonType = e.currentTarget.classList[1];
        if (seviceButtonType === "slick-prev") {
            // console.log("이전 버튼 눌림");
            servicecount--;
            updateServiceButtonVisibility();
            serviceslick.style.transform = `translate(-${
                494 * servicecount
            }px)`;
            serviceslick.style.transition = `transform 0.5s`;
        } else {
            // console.log("다음 버튼 눌림");
            servicecount++;
            updateServiceButtonVisibility();
            serviceslick.style.transform = `translate(-${
                494 * servicecount
            }px)`;
            serviceslick.style.transition = `transform 0.5s`;
        }
        setTimeout(() => {
            serviceButtonCheck = true;
        }, 500);
    });
});

updateServiceButtonVisibility();

let portfolioButtonCheck = true;
let portfoliocount = 0;
const portfolioslick = document.querySelector("div.portfolio-track");
const portfolioButtons = document.querySelectorAll(".portfolio-slide-button");
const portfolioPrevButton = portfolioButtons[0];
const portfolioNextButton = portfolioButtons[1];

const updatePortfolioButtonVisibility = () => {
    if (portfoliocount === 0) {
        portfolioPrevButton.classList.add("slick-disabled");
        portfolioNextButton.classList.remove("slick-disabled");
    } else if (portfoliocount === 1) {
        portfolioPrevButton.classList.remove("slick-disabled");
        portfolioNextButton.classList.remove("slick-disabled");
    } else if (portfoliocount === 2) {
        portfolioPrevButton.classList.remove("slick-disabled");
        portfolioNextButton.classList.add("slick-disabled");
    }
};

portfolioButtons.forEach((portfolioButton) => {
    portfolioButton.addEventListener("click", (e) => {
        if (
            portfolioButtonCheck === false ||
            e.currentTarget.classList.contains("slick-disabled")
        ) {
            return;
        }

        portfolioButtonCheck = false;

        const portfolioButtonType = e.currentTarget.classList[1];
        if (portfolioButtonType === "slick-prev") {
            // console.log("이전 버튼 눌림");
            portfoliocount--;
            updatePortfolioButtonVisibility();
            portfolioslick.style.transform = `translate(-${
                494 * portfoliocount
            }px)`;
            portfolioslick.style.transition = `transform 0.5s`;
        } else {
            // console.log("다음 버튼 눌림");
            portfoliocount++;
            updatePortfolioButtonVisibility();
            portfolioslick.style.transform = `translate(-${
                494 * portfoliocount
            }px)`;
            portfolioslick.style.transition = `transform 0.5s`;
        }
        setTimeout(() => {
            portfolioButtonCheck = true;
        }, 500);
    });
});

updatePortfolioButtonVisibility();

let counselorButtonCheck = true;
let counselorcount = 0;
const counselorslick = document.querySelector("div.counselor-track");
const counselorButtons = document.querySelectorAll(".counselor-list-button");
const counselorPrevButton = counselorButtons[0];
const counselorNextButton = counselorButtons[1];

const updateCounselorButtonVisibility = () => {
    if (counselorcount === 0) {
        counselorPrevButton.classList.add("slick-disabled");
        counselorNextButton.classList.remove("slick-disabled");
    } else if (counselorcount < 4) {
        counselorPrevButton.classList.remove("slick-disabled");
        counselorNextButton.classList.remove("slick-disabled");
    } else if (counselorcount === 4) {
        counselorPrevButton.classList.remove("slick-disabled");
        counselorNextButton.classList.add("slick-disabled");
    }
};

counselorButtons.forEach((counselorButton) => {
    counselorButton.addEventListener("click", (e) => {
        if (
            counselorButtonCheck === false ||
            e.currentTarget.classList.contains("slick-disabled")
        ) {
            return;
        }

        counselorButtonCheck = false;

        const portfolioButtonType = e.currentTarget.classList[1];
        if (portfolioButtonType === "slick-prev") {
            // console.log("이전 버튼 눌림");
            counselorcount--;
            updateCounselorButtonVisibility();
            counselorslick.style.transform = `translate(-${
                396 * counselorcount
            }px)`;
            counselorslick.style.transition = `transform 0.5s`;
        } else {
            // console.log("다음 버튼 눌림");
            counselorcount++;
            updateCounselorButtonVisibility();
            counselorslick.style.transform = `translate(-${
                396 * counselorcount
            }px)`;
            counselorslick.style.transition = `transform 0.5s`;
        }
        setTimeout(() => {
            counselorButtonCheck = true;
        }, 500);
    });
});

updateCounselorButtonVisibility();

let good1ButtonCheck = true;
let good1count = 0;
const good1slick = document.querySelector("div.good1-track");
const good1Buttons = document.querySelectorAll(".good1-button");
const good1PrevButton = good1Buttons[0];
const good1NextButton = good1Buttons[1];

const updateGood1ButtonVisibility = () => {
    if (good1count === 0) {
        good1PrevButton.classList.add("slick-disabled");
        good1NextButton.classList.remove("slick-disabled");
    } else if (good1count === 1) {
        good1PrevButton.classList.remove("slick-disabled");
        good1NextButton.classList.add("slick-disabled");
    }
};

good1Buttons.forEach((good1Button) => {
    good1Button.addEventListener("click", (e) => {
        if (
            good1ButtonCheck === false ||
            e.currentTarget.classList.contains("slick-disabled")
        ) {
            return;
        }

        good1ButtonCheck = false;

        const good1ButtonType = e.currentTarget.classList[1];
        if (good1ButtonType === "slick-prev") {
            // console.log("이전 버튼 눌림");
            good1count--;
            updateGood1ButtonVisibility();
            good1slick.style.transform = `translate(-${494 * good1count}px)`;
            good1slick.style.transition = `transform 0.5s`;
        } else {
            // console.log("다음 버튼 눌림");
            good1count++;
            updateGood1ButtonVisibility();
            good1slick.style.transform = `translate(-${494 * good1count}px)`;
            good1slick.style.transition = `transform 0.5s`;
        }
        setTimeout(() => {
            good1ButtonCheck = true;
        }, 500);
    });
});

updateGood1ButtonVisibility();

let good2ButtonCheck = true;
let good2count = 0;
const good2slick = document.querySelector("div.good2-track");
const good2Buttons = document.querySelectorAll(".good2-button");
const good2PrevButton = good2Buttons[0];
const good2NextButton = good2Buttons[1];

const updateGood2ButtonVisibility = () => {
    if (good2count === 0) {
        good2PrevButton.classList.add("slick-disabled");
        good2NextButton.classList.remove("slick-disabled");
    } else if (good2count === 1) {
        good2PrevButton.classList.remove("slick-disabled");
        good2NextButton.classList.add("slick-disabled");
    }
};

good2Buttons.forEach((good2Button) => {
    good2Button.addEventListener("click", (e) => {
        if (
            good2ButtonCheck === false ||
            e.currentTarget.classList.contains("slick-disabled")
        ) {
            return;
        }

        good2ButtonCheck = false;

        const good2ButtonType = e.currentTarget.classList[1];
        if (good2ButtonType === "slick-prev") {
            // console.log("이전 버튼 눌림");
            good2count--;
            updateGood2ButtonVisibility();
            good2slick.style.transform = `translate(-${494 * good2count}px)`;
            good2slick.style.transition = `transform 0.5s`;
        } else {
            // console.log("다음 버튼 눌림");
            good2count++;
            updateGood2ButtonVisibility();
            good2slick.style.transform = `translate(-${494 * good2count}px)`;
            good2slick.style.transition = `transform 0.5s`;
        }
        setTimeout(() => {
            good2ButtonCheck = true;
        }, 500);
    });
});

updateGood2ButtonVisibility();

let storyButtonCheck = true;
let storycount = 0;
const storyslick = document.querySelector("div.story-track");
const storyButtons = document.querySelectorAll(".story-button");
const storyPrevButton = storyButtons[0];
const storyNextButton = storyButtons[1];

const updateStoryButtonVisibility = () => {
    if (storycount === 0) {
        storyPrevButton.classList.add("slick-disabled");
        storyNextButton.classList.remove("slick-disabled");
    } else if (storycount < 4) {
        storyPrevButton.classList.remove("slick-disabled");
        storyNextButton.classList.remove("slick-disabled");
    } else {
        storyPrevButton.classList.remove("slick-disabled");
        storyNextButton.classList.add("slick-disabled");
    }
};

storyButtons.forEach((storyButton) => {
    storyButton.addEventListener("click", (e) => {
        if (
            storyButtonCheck === false ||
            e.currentTarget.classList.contains("slick-disabled")
        ) {
            return;
        }

        // console.log("storycount:", storycount);

        storyButtonCheck = false;

        const storyButtonType = e.currentTarget.classList[1];
        if (storyButtonType === "slick-prev") {
            // console.log("이전 버튼 눌림");
            storycount--;
            updateStoryButtonVisibility();
            storyslick.style.transform = `translate(-${329 * storycount}px)`;
            storyslick.style.transition = `transform 0.5s`;
        } else {
            // console.log("다음 버튼 눌림");
            storycount++;
            updateStoryButtonVisibility();
            storyslick.style.transform = `translate(-${329 * storycount}px)`;
            storyslick.style.transition = `transform 0.5s`;
            // console.log(storyNextButton.classList, storycount);
        }
        setTimeout(() => {
            storyButtonCheck = true;
        }, 500);
    });
});

updateStoryButtonVisibility();

let joinButtonCheck = true;
let joincount = 0;
const joinslick = document.querySelector("div.join-counselor-track");
const joinButtons = document.querySelectorAll(".join-counselor-button");
const joinPrevButton = joinButtons[0];
const joinNextButton = joinButtons[1];

const updateJoinButtonVisibility = () => {
    if (joincount === 0) {
        joinPrevButton.classList.add("slick-disabled");
        joinNextButton.classList.remove("slick-disabled");
    } else if (joincount === 1) {
        joinPrevButton.classList.remove("slick-disabled");
        joinNextButton.classList.remove("slick-disabled");
    } else {
        joinPrevButton.classList.remove("slick-disabled");
        joinNextButton.classList.add("slick-disabled");
    }
};

joinButtons.forEach((joinButton) => {
    joinButton.addEventListener("click", (e) => {
        if (
            joinButtonCheck === false ||
            e.currentTarget.classList.contains("slick-disabled")
        ) {
            return;
        }

        // console.log("storycount:", storycount);

        joinButtonCheck = false;

        const joinButtonType = e.currentTarget.classList[1];
        if (joinButtonType === "slick-prev") {
            // console.log("이전 버튼 눌림");
            joincount--;
            updateJoinButtonVisibility();
            joinslick.style.transform = `translate(-${641 * joincount}px)`;
            joinslick.style.transition = `transform 0.5s`;
        } else {
            // console.log("다음 버튼 눌림");
            joincount++;
            updateJoinButtonVisibility();
            joinslick.style.transform = `translate(-${641 * joincount}px)`;
            joinslick.style.transition = `transform 0.5s`;
            // console.log(storyNextButton.classList, storycount);
        }
        setTimeout(() => {
            joinButtonCheck = true;
        }, 500);
    });
});

updateJoinButtonVisibility();

// 슬라이드 개수 가져오기
const slideCount = joinslick.querySelectorAll(".slick-slide").length;

// slick-track의 width를 슬라이드 수 × 641px로 설정
joinslick.style.width = `${slideCount * 641}px`;

firstBanner.innerHTML = `<div class="slick-slide slick-cloned" tabindex="-1" data-index="-1" area-hidden="true" style="width: 970px;">
                            <div>
                                <div class="banner-item" style="width: 100%; display: inline-block;">
                                    <div>
                                        <!-- 970px X 105px -->
                                        <img src="../../static/images/main/banner1.png" alt="" class="banner-image">
                                    </div>
                                </div>
                            </div>
                        </div>`;
lastBanner.innerHTML = `<div class="slick-slide slick-cloned" tabindex="-1" data-index="5" area-hidden="true" style="width: 970px;">
                            <div>
                                <div class="banner-item" style="width: 100%; display: inline-block;">
                                    <div>
                                        <img src="../../static/images/main/banner5.png" alt="" class="banner-image">
                                    </div>
                                </div>
                            </div>
                        </div>`;

firstBanner.classList.add("slick-cloned");
lastBanner.classList.add("slick-cloned");
banner.appendChild(firstBanner);
banner.prepend(lastBanner);

const updateBannerIndicator = () => {
    let currentDisplayCount = bannercount;
    if (bannercount === 0) {
        currentDisplayCount = totalBanners;
    } else if (bannercount === totalBanners + 1) {
        currentDisplayCount = 1;
    }
    indicator.innerHTML = `${currentDisplayCount}/${totalBanners}`;
};

banner.style.transform = `translate(-970px)`;

const autoSlide = () => {
    bannercount++;
    banner.style.transform = `translate(-${970 * bannercount}px)`;
    banner.style.transition = `transform 0.5s`;

    if (bannercount === 6) {
        setTimeout(() => {
            banner.style.transform = `translate(-970px)`;
            banner.style.transition = `transform 0s`;
        }, 500);
        bannercount = 1;
    }
    updateBannerIndicator();
};

let autoSlideInterval = setInterval(autoSlide, 2000);
let bannerButtonCheck = true;

bannerButtons.forEach((bannerButton) => {
    const img = bannerButton.firstElementChild;
    img.addEventListener("click", (e) => {
        if (!bannerButtonCheck) {
            return;
        }
        bannerButtonCheck = false;
        clearInterval(autoSlideInterval);

        const bannerButtonType = e.target.parentElement.classList[1];
        if (bannerButtonType === "prev-button") {
            bannercount--;
            banner.style.transform = `translate(-${970 * bannercount}px)`;
            banner.style.transition = `transform 0.5s`;
            if (bannercount === 0) {
                setTimeout(() => {
                    banner.style.transform = `translate(-4850px)`;
                    banner.style.transition = `transform 0s`;
                }, 500);
                bannercount = 5;
            }
        } else {
            bannercount++;
            banner.style.transform = `translate(-${970 * bannercount}px)`;
            banner.style.transition = `transform 0.5s`;
            if (bannercount === 6) {
                setTimeout(() => {
                    banner.style.transform = `translate(-970px)`;
                    banner.style.transition = `transform 0s`;
                }, 500);
                bannercount = 1;
            }
        }

        autoSlideInterval = setInterval(autoSlide, 2000);
        updateBannerIndicator();
        setTimeout(() => {
            bannerButtonCheck = true;
        }, 500);
    });
});
updateBannerIndicator();
