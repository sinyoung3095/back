const postLayout = (() => {
    const showList = (postsCriteria) => {
        const postContainer = document.querySelector("#post-container");
        let text = ``;
        postsCriteria.posts.forEach((post) => {
            text += `
                <li class="feed-item">
                    <a href="/community-list/${post.id}">
                        <div class="feed-content">
                            <div>
                                <section class="item-wrapper">
                                    <h3 class="prisma-typography body14:medium primary">${post.postTitle}</h3>
                                    <p class="content prisma-typography body14:regular secondary">${post.postContent}</p>
                                </section>
                                <p class="sub-information prisma-typography body12:regular tertiary">${post.categoryName}</p>
                            </div>
                        </div>
                        <div class="feed-footer">
                            <div class="user-interaction">
                                <span class="comment prisma-typography body12:regular quaternary">댓글 수</span>
                            </div>
                            <span class="prisma-typography body12:regular quaternary">${post.relativeDate}</span>
                        </div>
                    </a>
                </li>
            `;
        });
        postContainer.innerHTML += text;
    }
    return { showList : showList };
})();
