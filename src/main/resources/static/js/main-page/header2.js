const mtbutton = document.querySelector(".mybutton");
// const notificationDot = document.querySelector("notification-dot");

if (mtbutton) {
    const mydiv = document.querySelector("div.mydiv");
    const profile = document.querySelector(".myprofile");


    const alimbutton = document.querySelector("button.alimbutton");
    const alimdiv = document.querySelector("div.alimarea");

    mtbutton.addEventListener("click", (e) => {
        mydiv.classList.toggle("active");
        profile.classList.toggle("active");
        alimdiv.classList.remove("active");
    });

    if (alimbutton) {
        alimbutton.addEventListener("click", (e) => {
            alimdiv.classList.toggle("active");
            mydiv.classList.remove("active");
            profile.classList.remove("active");
        });
    }
}


// 알림
const commentAlarmContainer = document.getElementById("comment-alarm");
let text = ``;

if (mtbutton) {
console.log(commentAlarms);
    commentAlarms.forEach((commentAlarm) => {
        text += `
            <li class="">
                <a class="card-container">
                    <div class="category-icon">
                        <span class="icon-wrapper">
                            <img src="https://soomgo-assets.s3.ap-northeast-2.amazonaws.com/notification-center/production/notification_graphic_chat.svg" alt="카테고리 아이콘">
                        </span>
                    </div>
                    <div class="info">
                        <div class="row title no-gutters">
                            <p class="prisma-typography body14:semibold secondary" >새 댓글 </p>
                        </div>
                        <p class="prisma-typography body14:medium primary content line-clamp2" >${commentAlarm.commentContent} </p>
<!--                        <p class="prisma-typography body12:regular tertiary" >${commentAlarm.relativeDate} </p>-->
                    </div>  
                </a>
            </li>
        `;
    });
    commentAlarmContainer.innerHTML = text;
}

// 새 알림
