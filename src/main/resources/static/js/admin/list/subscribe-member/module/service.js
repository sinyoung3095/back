const service = (() => {
    console.log("서비스 들어옴");
    const getMember = async(callback, page=1,keyword='') => {
        const response = await fetch(`/api/list/subscribe/${page}?keyword=${keyword}`);
        const memberCriteriaDTO = await response.json();
        if(callback){
                callback(memberCriteriaDTO);
        }

        return memberCriteriaDTO;

    }
    console.log(" 서비스 끝");
    return {getMember: getMember};
})();