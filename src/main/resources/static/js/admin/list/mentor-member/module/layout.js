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
                                      title="" data-original-title="">멘토회원</span>
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
                            <div class="action-btn" data-email="${member.memberEmail}">
                                <input id="detail" value="${member.memberEmail}" style="display: none">
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
            text = `<a data-page="${criteria.startPage - 1}" class="paging" style="cursor: pointer; color: black; font-size:15px; padding-top:4px; ">이전</a>`
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
    const showModal=(memberCriteriaDTO)=>{
        const modalWrap = document.querySelector("#modalWrap")
        console.log(memberCriteriaDTO);
        let text = '';
        text=`
        <div class="modal fade member-modal show" style="display: block; background-color:rgba(0,0,0,0.5);" aria-modal="true" role="dialog">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <div class="modal-title">
                            (${memberCriteriaDTO.members[0].memberEmail}) ${memberCriteriaDTO.members[0].memberName}
                            <span class="badge-label text-danger font-weight-bold ml-2">멘토회원</span>
                        </div>
                        <button class="close">
                            <i class="mdi mdi-close"></i>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="divider">
                            <div class="tab-view">
                                <div class="tab-view-header"></div>
                                <div class="tab-view-body">
                                    <div style="display: block;">
                                        <div class="tab-inner tab-detail">
                                            <!-- 일반회원 상세정보 -->
                                            <div class="info-layout detail-info">
                                                <div class="info-title justify-content-between">
                                                    <div class="flex-left d-flex">
                                                        <div class="title">회원 상세정보</div>
                                                    </div>
                                                    <div class="flex-right"></div>
                                                </div>
                                                <div class="d-table w-100">
                                                    <!-- 테이블 왼쪽 -->
                                                    <div class="d-table-cell">
                                                        <table class="info-table">
                                                            <tbody>
                                                                <tr>
                                                                    <th>이름</th>
                                                                    <td>${memberCriteriaDTO.members[0].memberName}</td>
                                                                </tr>
                                                                <tr>
                                                                    <th>핸드폰 번호</th>
                                                                    <td>${memberCriteriaDTO.members[0].memberPhoneNumber}</td>
                                                                </tr>
                                                                <tr>
                                                                    <th>가입일</th>
                                                                    <td>${memberCriteriaDTO.members[0].createdDate}</td>
                                                                </tr>
                                                                <tr>
                                                                    <th>8월 채택 수</th>
                                                                    <td>10</td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                    <!-- 테이블 오른쪽 -->                                                        
                                                    <div class="d-table-cell">
                                                        <table class="info-table">
                                                            <tbody>
                                                                <tr>
                                                                    <th>회원ID</th>
                                                                    <td>${memberCriteriaDTO.members[0].memberName}</td>
                                                                </tr>
                                                                <tr>
                                                                    <th>이메일</th>
                                                                    <td>${memberCriteriaDTO.members[0].memberEmail}</td>
                                                                </tr>
                                                                <tr>
                                                                    <th>최근 접속일</th>
                                                                    <td>2025-07-29</td>
                                                                </tr>
                                                                <tr>
                                                                    <th>7월 채택 수</th>
                                                                    <td>10</td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- 회원 작성 게시글 -->
                                            <div class="info-layout detail-info">
                                                <div class="info-title justify-content-between">
                                                    <div class="flex-left d-flex">
                                                        <!-- 작성 게시글 클릭 시 콘텐츠 관리 내 게시글 페이지로 이동 -->
                                                        <a href="" class="info-detail">
                                                            <div class="title">작성 게시글
                                                                <i class="mdi mdi-menu-left ml-2"></i>
                                                            </div>
                                                        </a>
                                                    </div>
                                                    <div class="flex-right"></div>
                                                </div>
                                                <div class="d-table w-100">
                                                    <table class="info-table">
                                                        <thead>
                                                            <tr>
                                                                <th>게시글 제목</th>
                                                                <th>게시글 내용</th>
                                                                <th>게시글 작성 일자</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td>test-title</td>
                                                                <td>test-context</td>
                                                                <td>2025-08-01</td>
                                                            </tr>
                                                            <tr>
                                                                <td>test-title</td>
                                                                <td>test-context</td>
                                                                <td>2025-08-01</td>
                                                            </tr>
                                                            <tr>
                                                                <td>test-title</td>
                                                                <td>test-context</td>
                                                                <td>2025-08-01</td>
                                                            </tr>                                                                                                                               
                                                        </tbody>
                                                    </table>
                                                </div>                             
                                            </div>
                                            <!-- 회원 작성 댓글 -->
                                            <div class="info-layout detail-info">
                                                <div class="info-title justify-content-between">
                                                    <div class="flex-left d-flex">
                                                        <!-- 작성 댓글 클릭 시 콘텐츠 관리 내 댓글 페이지로 이동 -->
                                                        <a href="" class="info-detail">
                                                            <div class="title">작성 댓글
                                                                <i class="mdi mdi-menu-left ml-2"></i>
                                                            </div>
                                                        </a>
                                                    </div>
                                                    <div class="flex-right"></div>
                                                </div>
                                                <div class="d-table w-100">
                                                    <table class="info-table">
                                                        <thead>
                                                            <tr>
                                                                <th>게시글 제목</th>
                                                                <th>댓글 내용</th>
                                                                <th>댓글 작성 일자</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td>test-title</td>
                                                                <td>test-context</td>
                                                                <td>2025-08-01</td>
                                                            </tr>
                                                            <tr>
                                                                <td>test-title</td>
                                                                <td>test-context</td>
                                                                <td>2025-08-01</td>
                                                            </tr>
                                                            <tr>
                                                                <td>test-title</td>
                                                                <td>test-context</td>
                                                                <td>2025-08-01</td>
                                                            </tr>                                                                                                                               
                                                        </tbody>
                                                    </table>
                                                </div>                             
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn-close btn btn-outline-filter">닫기</button>
                    </div>
                </div>
            </div>
        </div>`
        modalWrap.innerHTML=text;
    }


    return {showList:showList,showModal:showModal};
})();