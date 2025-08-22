const service = (() => {
    const getMember = async(callback, page=1,keyword='') => {
        const response = await fetch(`/api/list/general/${page}?keyword=${keyword}`);
        const memberCriteriaDTO = await response.json();
        if(callback){
            callback(memberCriteriaDTO);
        }
        return memberCriteriaDTO;

    }
    const getPost = async (callback, page=1,keyword='')=>{
        const response = await fetch(`/api/list/post/${page}?keyword=${keyword}`);
        const postsCriteriaDTO = await response.json();
        if(callback){
            callback(postsCriteriaDTO);
        }
        return postsCriteriaDTO;
    }
    return {getMember: getMember,getPost:getPost};
})();