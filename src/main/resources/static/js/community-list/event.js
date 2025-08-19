let page = 1;
const showList = async (page = 1) => {
    const loading = document.getElementById("loading");

    loading.style.display = "block";
    const postsCriteria = await postService.getPost(postLayout.showList, page);
    setTimeout(() => {
        loading.style.display = "none";
    }, 1000)

    return postsCriteria;
}
showList();

let checkScroll = true;
let postsCriteria;

window.addEventListener("scroll", async (e) => {
    // 현재 스크롤 위치
    const scrollTop = window.scrollY
    // 화면 높이
    const windowHeight = window.innerHeight;
    // 문서 전체 높이
    const documentHeight = document.documentElement.scrollHeight
    if(scrollTop + windowHeight >= documentHeight - 2) {
        //     바닥에 닿았을 때
        if(checkScroll){
            postsCriteria = await showList(++page);
            checkScroll = false;
        }
        setTimeout(() => {
            if(postsCriteria !== null && postsCriteria.criteria.hasMore){
                checkScroll = true
            }
        }, 1100);
    }
})