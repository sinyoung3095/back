const layout = (()=>{
    const showList = (noticeCriteriaDTO)=>{
        const noticeContainer = document.querySelector("tbody[id=notice]");
        const pageWrap = document.getElementById("pageWrap");

        console.log("리스트 들어옴")
        let text = '';


        noticeCriteriaDTO.notices.forEach((notice)=>{
            text += `
                   <tr class="">
                        <td class="td-date text-grey">${notice.createdDate}</td>
                        <td class="td-title" onclick="window.location.href='/admin/notice-detail?id=${notice.id}'">
                            <span class="notice-title" data-id="${notice.id}">${notice.noticeTitle}</span>
                        </td>
                        <td class="td-writer">주) 리바운드</td>
                    </tr>
                     `;
        })
        noticeContainer.innerHTML=text;

        text = ``;
        let criteria = noticeCriteriaDTO.memberCriteria;

        if(criteria.hasPreviousPage){
            text = `<a data-page="${criteria.startPage - 1}" class="paging" style="cursor: pointer; color: black; font-size:15px; padding-top:4px;">이전</a>`
        }
        for(let i = criteria.startPage; i <= criteria.endPage; i++){
            text += `
            <li class="page-item page-num`
            i === criteria.page && (text += ` active`);
            text += `
                ">
                    <a data-page="${i}" class="page-item-link page-item-num paging">${i}</a>
                </li>`
        }

        if(criteria.hasNextPage){
            text += `<a id="next" data-page="${criteria.endPage + 1}" class="paging" style="cursor: pointer; color: black; font-size:15px; padding-top:4px;">다음</a>`
        }

        pageWrap.innerHTML = text;
    }



    return {showList:showList};
})();