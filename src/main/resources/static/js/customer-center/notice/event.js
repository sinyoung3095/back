const listPageWrap = document.getElementById("pageWrap");
const find = document.getElementById("query")

service.getNotice(layout.showList);

listPageWrap.addEventListener("click", async (e) => {
    if(e.target.classList.contains("paging")){
        e.preventDefault();
        await service.getNotice(layout.showList, e.target.dataset.page);
    }
});

find.addEventListener("keyup", (e)=>{
    e.preventDefault();
    if(e.key==="Enter"){
        console.log(e.target.value);
        service.getNotice(layout.showList,1,e.target.value);
    }
})
