const postLayout = (() => {
    const showList = (postsCriteria) => {
        const feedList = document.querySelector(".feed-list");
        let text = '';

        postsCriteria.posts.forEach((post) => {
            text += `
                <li class="feed-item">
                    <a>
                        <div class="feed-content">
                            <div>
                                <section class="item-wrapper">
                                    <h3 class="prisma-typography body14:medium primary">${post.title}</h3>
                                    <p class="content prisma-typography body14:regular secondary">${post.content}</p>
                                </section>
                                <p class="sub-information prisma-typography body12:regular tertiary">${post}</p>
                            </div>
                        </div>
                        <div class="feed-footer">
                            <div class="user-interaction">
                                <span class="comment prisma-typography body12:regular quaternary">${post}</span>
                            </div>
                            <span class="prisma-typography body12:regular quaternary">${post}</span>
                        </div>
                    </a>
                </li>
            `;
        });

        feedList.innerHTML = text;
    };

    return { showList : showList };
})();
