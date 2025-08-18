const layout = (()=>{
    console.log("레이아웃들어옴");
    const showList = (members)=>{
        const memberContainer = document.querySelector("tbody[class=members]");
        console.log(memberContainer);
        let text = '';
        members.forEach((member)=>{
            text += `
                    <tr>
                        <td class="td-name">
                            <div class="member-name">Test01
                                <span class="badge-label badge text-danger ml-2"
                                      data-for="93fee9a1-f685-4eca-ba41-83be3901b9c9" data-toggle="tooltip" data-custom-class=""
                                      title="" data-original-title="">일반회원</span>
                            </div>
                            <div class="member-id">TestId01</div>
                        </td>
                        <td class="td-amount text-right pr-4 font-weight-bold">${member.memberName}
                            <span class="amount-unit"> 님</span>
                        </td>
                        <td class="td-email">${member.memberEmail}</td>
                        <td class="td-phone">${member.memberPhoneNumber}</td>
                        <td class="td-start">${member.createdDateTime}</td>
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
    }
    return {showList:showList};
})();