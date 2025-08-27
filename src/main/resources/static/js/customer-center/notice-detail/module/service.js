const service = (() => {
    console.log("서비스 들어옴")
    const getNotice = async(callback, page=1,keyword='') => {
        const response = await fetch(`/api/list/notice/${page}?keyword=${keyword}`);
        const noticeCriteriaDTO = await response.json();
        console.log("rest들어옴")
        if(callback){
            callback(noticeCriteriaDTO);
        }
        return noticeCriteriaDTO;

    }

    return {getNotice: getNotice};
})();