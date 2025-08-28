const date = new Date();
const year = date.getFullYear();
const month = date.getMonth();
const yearJoin = document.getElementById("year-join");
const monthJoin = document.getElementById("month-join")
const yearPost = document.getElementById("year-post");
const monthPost = document.getElementById("month-post")

google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(service.getChart(drawChart));
function drawChart(chartDTO) {
    yearJoin.innerText = chartDTO[0].yearCount;
    monthJoin.innerText = chartDTO[0].monthCount;
    yearPost.innerText = chartDTO[0].postByYearCount;
    monthPost.innerText = chartDTO[0].postByMonthCount;
    console.log(chartDTO)
    let firstData = google.visualization.arrayToDataTable([
        ['year', '일반 회원(멘토)', '구독 회원'],
        [year - 3,  chartDTO[3].yearCount ,      chartDTO[3].subscribeYearCount],
        [year - 2,  chartDTO[2].yearCount ,       chartDTO[2].subscribeYearCount],
        [year - 1,  chartDTO[1].yearCount ,      chartDTO[1].subscribeYearCount],
        [ year ,  chartDTO[0].yearCount ,  chartDTO[0].subscribeYearCount]
    ]);

    let firstOptions = {
        title: '연간 회원 수',
        curveType: 'function',
        legend: { position: 'bottom' }
    };

    let firstChart = new google.visualization.LineChart(document.getElementById('first-chart'));

    firstChart.draw(firstData, firstOptions);

    let secondData = google.visualization.arrayToDataTable([
        ['month', '일반 회원(멘토)', '구독 회원'],
        [month - 3,  chartDTO[3].monthCount ,      chartDTO[3].subscribeMonthCount],
        [month - 2,  chartDTO[2].monthCount ,       chartDTO[2].subscribeMonthCount],
        [month - 1,  chartDTO[1].monthCount ,      chartDTO[1].subscribeMonthCount],
        [ month ,  chartDTO[0].monthCount ,  chartDTO[0].subscribeMonthCount]
    ]);

    let secondOptions = {
        title: '월간 회원 수',
        curveType: 'function',
        legend: { position: 'bottom' }
    };

    let secondChart = new google.visualization.LineChart(document.getElementById('second-chart'));

    secondChart.draw(secondData, secondOptions);

    let thirdData = google.visualization.arrayToDataTable([
        ['year', '게시글 수'],
        [year - 3,  chartDTO[3].postByYearCount],
        [year - 2,  chartDTO[2].postByYearCount],
        [year - 1,  chartDTO[1].postByYearCount],
        [ year ,  chartDTO[0].postByYearCount]
    ]);

    let thirdOptions = {
        title: '연간 게시글 수',
        curveType: 'function',
        legend: { position: 'bottom' }
    };

    let thirdChart = new google.visualization.LineChart(document.getElementById('third-chart'));

    thirdChart.draw(thirdData, thirdOptions);

    let fourthData = google.visualization.arrayToDataTable([
        ['month', '게시글 수'],
        [month - 3,  chartDTO[3].postByMonthCount],
        [month - 2,  chartDTO[2].postByMonthCount],
        [month - 1,  chartDTO[1].postByMonthCount],
        [ month ,  chartDTO[0].postByMonthCount]
    ]);

    let fourthOptions = {
        title: '월간 게시글 수',
        curveType: 'function',
        legend: { position: 'bottom' }
    };

    let fourthChart = new google.visualization.LineChart(document.getElementById('fourth-chart'));

    fourthChart.draw(fourthData, fourthOptions);

}

const layout = (()=> {
    const showList = (counselorCriteriaDTO) => {
        const counselorContainer = document.querySelector("tbody[id=counselorWrap]");

        let text = '';


        counselorCriteriaDTO.counselors.forEach((counselor) => {
            text += `
                    <tr>
                        <td class="td-name">${counselor.counselorName}</td>
                        <td class="td-email">${counselor.counselorEmail}</td>
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
        counselorContainer.innerHTML = text;
    }


    return {showList: showList};
})();