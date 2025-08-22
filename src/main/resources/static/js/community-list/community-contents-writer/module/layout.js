const commentLayout = (() => {
    const showList = (CommentsCriteria) => {
        const commentWrap = document.getElementById("commentWrap");
        let text = "";
        CommentsCriteria.comments.forEach((comment) => {
            text += `
            <li class="post-comments-list-item">
                <div class="post-comment-wrapper">
                    <div class="profile-image provider">
                        <img alt="${comment.memberName}" class="image" src="https://static.cdn.soomgo.com/upload/profile/95ede868-c74e-4153-8cb0-0e47a354a227.jpg?h=110&amp;w=110&amp;webp=1">
                    </div>
                    <div class="comment-information">
                        <div class="user-info provider">
                            <div class="user-info-wrapper pro-user">
                                <div class="user">
                                    <span class="user-name prisma-typography body14:semibold primary">${comment.memberName}</span>
                                </div>
                                <div class="pro-user-services">
                                    <span class="prisma-typography body12:regular tertiary service main-service">전기배선 설치 및 수리</span>
                                    <span class="prisma-typography body12:regular tertiary service">+ 1개 서비스</span>
                                    <span class="prisma-typography body12:regular tertiary service">고수</span>
                                </div>
                            </div>
                            <button class="send-request-button prisma-typography body12:medium primary">추천하기</button>
                        </div>
                        <div class="post-comment-contents">
                            <p class="text comment-text prisma-typography body14:regular primary">
                                <span>${comment.commentContent}</span>
                            </p>
                        </div>
                        <div class="post-comment-actions">
                            <div class="comment-more-action prisma-typography body12:regular primary">
                                <span class="comment-create-at">${comment.relativeDate}</span>
                                <div class="dropdown b-dropdown btn-group">
                                    <ul role="menu" class="dropdown-menu dropdown-menu-right">
                                        <li role="presentation">
                                            <a role="menuitem" href="#" class="dropdown-item">댓글 신고하기</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </li>`;
        });
        commentWrap.innerHTML = text;
    };

    return {showList:showList};
})();


