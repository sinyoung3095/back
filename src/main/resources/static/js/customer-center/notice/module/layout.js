const layout = (()=> {
    const showList = (noticeCriteriaDTO) => {
        const noticeContainer = document.querySelector("ul[id=notices]");
        const pageWrap = document.getElementById("pageWrap");

        console.log("리스트 들어옴")
        let text = '';


        noticeCriteriaDTO.notices.forEach((notice) => {
            text += `
                   <li class="article-list-item page"><a onclick="window.location.href='/customer-center/notice-detail?id=${notice.id}'" class="nofollow">${notice.noticeTitle}</a></li>
                     `;
        })
        noticeContainer.innerHTML = text;

        text = ``;
        let criteria = noticeCriteriaDTO.memberCriteria;
        if (criteria.hasPreviousPage) {
            text = `<a data-page="${criteria.startPage - 1}" class="nofollow paging" style="cursor: pointer; color: black; font-size:15px; padding-top:4px;" >이전</a>`
        }
        for (let i = criteria.startPage; i <= criteria.endPage; i++) {
            text += `
            <li class="page-item page-num`
            i === criteria.page && (text += ` pagination-current`);
            text += `
                ">
                    <a data-page="${i}" class="nofollow paging">${i}</a>
                </li>`
        }
        console.log(criteria.hasNextPage)
        if (criteria.hasNextPage) {
            text += `<a id="next" data-page="${criteria.endPage + 1}" class="nofollow paging" style="cursor: pointer; color: black; font-size:15px; padding-top:4px;" >다음</a>`

        }

        pageWrap.innerHTML = text;
    }


    return {showList: showList};
})();