const service = (() => {
    const getCounselor = async(callback, page=1,keyword='') => {
        const response = await fetch(`/api/list/counselor-qualification/${page}?keyword=${keyword}`);
        const counselorCriteriaDTO = await response.json();
        if(callback){
            callback(counselorCriteriaDTO);
        }
        return counselorCriteriaDTO;

    }

    return {getCounselor: getCounselor};
})();