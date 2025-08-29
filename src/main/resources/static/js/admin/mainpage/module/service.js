const service = (() =>{
    const getChart = async (callback)=>{
        const response = await fetch("/api/list/chart-general");
        const chartDTO = await response.json();
            if(callback){
                return  callback(chartDTO);
            }
        return chartDTO;
    }
    const getCounselor = async(callback, page=1,keyword='') => {
        const response = await fetch(`/api/list/counselor-qualification/${page}?keyword=${keyword}`);
        const counselorCriteriaDTO = await response.json();
        if(callback){
            callback(counselorCriteriaDTO);
        }
        return counselorCriteriaDTO;

    }
    return {getChart:getChart,getCounselor:getCounselor}
})();
