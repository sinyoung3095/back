const layout = (()=> {
    const showList = (counselorCriteriaDTO) => {
        const memberContainer = document.querySelector("tbody[class=members]");
        const pageWrap = document.getElementById("pageWrap");

        let text = '';


        counselorCriteriaDTO.counselors.forEach((counselor) => {
            text += `
                    <tr>
                        <td class="td-name">${counselor.counselorName}</td>
                        <td class="td-email">${counselor.counselorEmail}</td>
                        <td class="td-phone">${counselor.counselorPhoneNumber}</td>
                        <td class="td-address">${counselor.counselorAddress}</td>
                        <td class="td-license">${counselor.counselorLicenseName}</td>
                    `
                if(counselor.counselorApprovalStatus==="approval"){
                    text +=
                    `
                        <td class="td-apply" style="color: green">승인</td>
                    </tr>
                     `;
                }else if(counselor.counselorApprovalStatus==="await"){
                    text +=
                        `
                        <td class="td-apply" style="color: blue">대기</td>
                    </tr>
                     `;
                }else{
                    text +=
                        `
                        <td class="td-apply" style="color: red">거절</td>
                    </tr>
                     `;}

        })
        memberContainer.innerHTML = text;

        text = ``;
        let criteria = counselorCriteriaDTO.memberCriteria;

        if (criteria.hasPreviousPage) {
            text = `<a data-page="${criteria.startPage - 1}" class="paging" style="cursor: pointer; color: black; font-size:15px; padding-top:4px;">이전</a>`
        }
        for (let i = criteria.startPage; i <= criteria.endPage; i++) {
            text += `
            <li class="page-item page-num`
            i === criteria.page && (text += ` active`);
            text += `
                ">
                    <a data-page="${i}" class="page-item-link page-item-num paging">${i}</a>
                </li>`
        }

        if (criteria.hasNextPage) {
            text += `<a id="next" data-page="${criteria.endPage + 1}" class="paging" style="cursor: pointer; color: black; font-size:15px; padding-top:4px;">다음</a>`
        }

        pageWrap.innerHTML = text;
    }


    return {showList: showList};
})();