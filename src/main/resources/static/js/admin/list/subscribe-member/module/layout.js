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
                                      title="" data-original-title="">구독회원</span>
                            </div>`
                        if(member.memberEmail===null){
                            text += `<div class="member-id">${member.kakaoEmail}</div>`
                        }else{text += `<div class="member-id">${member.memberEmail}</div>`}

            text += `    </td>
                        <td class="td-amount text-right pr-4 font-weight-bold">${member.memberName}
                            <span class="amount-unit"> 님</span>
                        </td>`
                if(member.memberEmail===null){
                    text +=`<td class="td-email">${member.kakaoEmail}</td>`
                }else{text +=`<td class="td-email">${member.memberEmail}</td>`}

            text +=`
                        <td class="td-phone">${member.memberPhoneNumber}</td>
                        <td class="td-start">${member.createdDate}</td>
                        <td class="td-recent">${member.latelyDate}</td>
                        <td class="td-action text-center">
                            <div class="action-btn">
                                <i class="mdi mdi-chevron-right" data-email="${member.memberEmail}"></i>
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
                        <div class="modal-title">`
            if(memberCriteriaDTO.members[0].memberEmail===null){
                text+=`(${memberCriteriaDTO.members[0].kakaoEmail})`
            }else{
                text+=`(${memberCriteriaDTO.members[0].memberEmail})`
            }
                text+=`${memberCriteriaDTO.members[0].memberName}
                <span class="badge-label text-danger font-weight-bold ml-2">구독회원</span>
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
                                                                    <th>구독 시작일</th>
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
                                                                    <th>이메일</th>`
                                                        if(memberCriteriaDTO.members[0].memberEmail===null){
                                                            text+=`<td>${memberCriteriaDTO.members[0].kakaoEmail}</td>`
                                                        }else{text+=`<td>${memberCriteriaDTO.members[0].memberEmail}</td>`}
                                                                text+=`</tr>
                                                                <tr>
                                                                    <th>최근 접속일</th>
                                                                    <td>${memberCriteriaDTO.members[0].latelyDate}</td>
                                                                </tr>
                                                                <tr>
                                                                    <th>총 구독 개월</th>
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
                                                        <tbody id ="postWrap">                                                                                                                                     
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
                                                        <tbody id ="commentWrap">                                                                                                                   
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
    const showPost=(posts)=> {
        const postWrap = document.querySelector("#postWrap")
        let text = '';
        console.log(posts)

        for(let i =0;i<3;i++)
        {
            text += `
                <tr>
                    <td>${posts[i].postTitle}</td>
                    <td>${posts[i].postContent}</td>
                    <td>${posts[i].createdDate}</td>
                </tr>`
        }

        postWrap.innerHTML = text;
    }
    const showComment=(comments)=> {
        const commentWrap = document.querySelector("#commentWrap")
        let text = '';
        console.log(comments)

        for(let i =0;i<3;i++)
        {
            text += `
                <tr>
                    <td>${comments[i].postTitle}</td>
                    <td>${comments[i].commentContent}</td>
                    <td>${comments[i].createdDate}</td>
                </tr>
                `
        }

        commentWrap.innerHTML = text;
    }


    return {showList:showList,showModal:showModal,showPost:showPost,showComment:showComment};
})();