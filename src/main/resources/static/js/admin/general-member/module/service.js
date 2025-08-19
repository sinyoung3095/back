const service = (() => {
    console.log("서비스 들어옴");
    const getMember = async(callback,page=1) => {
        const response = await fetch(`/api/list/${page}`);
        const memberCriteriaDTO = await response.json();
        if(callback){
                callback(memberCriteriaDTO);
        }

        return memberCriteriaDTO;

    }
    console.log(" 서비스 끝");
    return {getMember: getMember};
})();