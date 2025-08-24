const layout = (()=>{
    const showList = (counselorCriteriaDTO)=>{
        const memberContainer = document.querySelector("tbody[class=members]");
        const pageWrap = document.getElementById("pageWrap");
        const total = document.querySelector("span[class=count-amount]");
        total.innerHTML=counselorCriteriaDTO.memberCriteria.total;
console.log("리스트 들어옴")
        let text = '';


        counselorCriteriaDTO.counselors.forEach((member)=>{
            text += `
                    <tr>
                        <td class="td-name">
                            <div class="member-name">${member.counselorName}
                                <span class="badge-label badge text-danger ml-2" data-for="" data-toggle="" data-custom-class="" title="" data-original-title="">상담사</span>
                            </div>
                            <div class="member-id">${member.counselorEmail}</div>
                        </td>
                        <td class="td-amount text-right pr-4 font-weight-bold">${member.counselorName}
                            <span class="amount-unit"> 님</span>
                        </td>
                        <td class="td-email">${member.counselorEmail}</td>
                        <td class="td-phone">${member.counselorPhoneNumber}</td>
                        <td class="td-start">${member.createdDate}</td>
                        <td class="td-career">n년</td>
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
        let criteria = counselorCriteriaDTO.memberCriteria;

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
    const showModal=(counselorCriteriaDTO,postCriteriaDTO)=>{
        const modalWrap = document.querySelector("#modalWrap")
        let text = '';
        text=`
        <div class="modal fade member-modal show" style="display: block;" aria-modal="true" role="dialog">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <div class="modal-title">
                            (${counselorCriteriaDTO.counselor[0].counselorEmail}) ${counselorCriteriaDTO.counselor[0].counselorName}
                            <span class="badge-label text-danger font-weight-bold ml-2">상담사</span>
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
                                            <!-- 상담사 상세정보 -->
                                            <div class="info-layout detail-info">
                                                <div class="info-title justify-content-between">
                                                    <div class="flex-left d-flex">
                                                        <div class="title">상담사 상세정보</div>
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
                                                                    <td>${counselorCriteriaDTO.counselor[0].counselorName}</td>
                                                                </tr>
                                                                <tr>
                                                                    <th>핸드폰 번호</th>
                                                                    <td>${counselorCriteriaDTO.counselor[0].counselorPhoneNumber}</td>
                                                                </tr>
                                                                <tr>
                                                                    <th>가입일</th>
                                                                    <td>${counselorCriteriaDTO.counselor[0].counselorCreatedDate}</td>
                                                                </tr>
                                                                <tr>
                                                                    <th>나이</th>
                                                                    <td>20</td>
                                                                </tr>                                                                       
                                                                <tr>
                                                                    <th>리바운드 경력</th>
                                                                    <td>n개월</td>
                                                                </tr>      
                                                                <tr>
                                                                    <th>총 경력</th>
                                                                    <td>n년</td>
                                                                </tr>                                                        
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                    <!-- 테이블 오른쪽 -->                                                        
                                                    <div class="d-table-cell">
                                                        <table class="info-table">
                                                            <tbody>
                                                                <tr>
                                                                    <th>상담사ID</th>
                                                                    <td>${counselorCriteriaDTO.counselor[0].counselorEmail}</td>
                                                                </tr>
                                                                <tr>
                                                                    <th>이메일</th>
                                                                    <td>${counselorCriteriaDTO.counselor[0].counselorEmail}</td>
                                                                </tr>
                                                                <tr>
                                                                    <th>최근 접속일</th>
                                                                    <td>2025-07-29</td>
                                                                </tr>
                                                                <tr>
                                                                    <th>성별</th>
                                                                    <td>남</td>
                                                                </tr>
                                                                <tr>
                                                                    <th>상담 횟수</th>
                                                                    <td>n회</td>
                                                                </tr>
                                                                <tr>
                                                                    <th>근무지</th>
                                                                    <td>${counselorCriteriaDTO.counselor[0].counselorAddress}</td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- 상담사 상담 내역 -->
                                            <div class="info-layout detail-info">
                                                <div class="info-title justify-content-between">
                                                    <div class="flex-left d-flex">
                                                        <!-- 상담내역 클릭 시 상담사 관리 내 상담 내역 페이지로 이동 -->
                                                        <a href="" class="info-detail">
                                                            <div class="title">상담 내역
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
                                                                <th>상담 회원</th>
                                                                <th>상담 일자</th>
                                                                <th>상담 내용</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td>test01</td>
                                                                <td>2025-08-01</td>
                                                                <td>고민</td>
                                                            </tr>
                                                            <tr>
                                                                <td>test01</td>
                                                                <td>2025-08-01</td>
                                                                <td>고민</td>
                                                            </tr>
                                                            <tr>
                                                                <td>test01</td>
                                                                <td>2025-08-01</td>
                                                                <td>고민</td>
                                                            </tr>
                                                            <tr>
                                                                <td>test01</td>
                                                                <td>2025-08-01</td>
                                                                <td>고민</td>
                                                            </tr>
                                                            <tr>
                                                                <td>test01</td>
                                                                <td>2025-08-01</td>
                                                                <td>고민</td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>                             
                                            </div>
                                            <!-- 오늘의 좋은 말 작성 내역 -->
                                            <div class="info-layout detail-info">
                                                <div class="info-title justify-content-between">
                                                    <div class="flex-left d-flex">
                                                        <!-- 오늘의 좋은 말 클릭 시 콘텐츠 관리 내 오늘의 좋은 말 페이지로 이동 -->
                                                        <a href="" class="info-detail">
                                                            <div class="title">오늘의 좋은 말
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
                                                                <th>작성 내용</th>
                                                                <th>작성 일자</th>
                                                                <th>좋아요 수</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td>test-context</td>
                                                                <td>2025-08-01</td>
                                                                <td>10</td>
                                                            </tr>
                                                            <tr>
                                                                <td>test-context</td>
                                                                <td>2025-08-01</td>
                                                                <td>10</td>
                                                            </tr>
                                                            <tr>
                                                                <td>test-context</td>
                                                                <td>2025-08-01</td>
                                                                <td>10</td>
                                                            </tr>
                                                            <tr>
                                                                <td>test-context</td>
                                                                <td>2025-08-01</td>
                                                                <td>10</td>
                                                            </tr>
                                                            <tr>
                                                                <td>test-context</td>
                                                                <td>2025-08-01</td>
                                                                <td>10</td>
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