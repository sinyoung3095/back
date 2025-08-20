const layout = (()=>{
    console.log("레이아웃들어옴");
    const showList = (memberCriteriaDTO)=>{
        const memberContainer = document.querySelector("tbody[class=members]");
        const pageWrap = document.getElementById("pageWrap");
        const total = document.querySelector("span[class=count-amount]");
        total.innerHTML=memberCriteriaDTO.memberCriteria.total;

        let text = '';


        memberCriteriaDTO.members.forEach((member)=>{
            text += `
                    <tr>
                        <td class="td-name">
                            <div class="member-name">${member.memberName}
                                <span class="badge-label badge text-danger ml-2"
                                      data-for="93fee9a1-f685-4eca-ba41-83be3901b9c9" data-toggle="tooltip" data-custom-class=""
                                      title="" data-original-title="">일반회원</span>
                            </div>
                            <div class="member-id">${member.memberEmail}</div>
                        </td>
                        <td class="td-amount text-right pr-4 font-weight-bold">${member.memberName}
                            <span class="amount-unit"> 님</span>
                        </td>
                        <td class="td-email">${member.memberEmail}</td>
                        <td class="td-phone">${member.memberPhoneNumber}</td>
                        <td class="td-start">${member.createdDate}</td>
                        <td class="td-recent">2025-07-29</td>
                        <td class="td-action text-center">
                            <div class="action-btn">
                                <i class="mdi mdi-chevron-right"></i>
                            </div>
                        </td>
                    </tr>
                     `;
        })
        memberContainer.innerHTML=text;

        text = ``;
        let criteria = memberCriteriaDTO.memberCriteria;

        if(criteria.hasPreviousPage){
            text = `<a data-page="${criteria.startPage - 1}" class="paging">이전</a>`
        }

        for(let i = criteria.startPage; i <= criteria.endPage; i++){
            if(i === criteria.startPage){
            text += `
            <li class="page-item page-num active">
                <a data-page="${i}" class="page-item-link page-item-num paging">${i}</a>
            </li>`
            } else {
            text += `
            <li class="page-item page-num">
                <a data-page="${i}" class="page-item-link page-item-num paging">${i}</a>
            </li>`
            }
        }

        if(criteria.hasNextPage){
            text += `<a data-page="${criteria.endPage + 1}" class="paging">다음</a>`
        }

        pageWrap.innerHTML = text;
    }


    return {showList:showList};
})();