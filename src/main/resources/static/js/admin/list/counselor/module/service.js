const service = (() => {
    console.log("서비스 들어옴")
    const getCounselor = async(callback, page=1,keyword='') => {
        const response = await fetch(`/api/list/counselor/${page}?keyword=${keyword}`);
        const counselorCriteriaDTO = await response.json();
        console.log(counselorCriteriaDTO)
        if(callback){
            callback(counselorCriteriaDTO);
        }
        return counselorCriteriaDTO;

    }
    const getPost = async (callback,keyword='')=>{
        const response = await fetch(`/api/list/posts?keyword=${keyword}`);
        const posts = await response.json();
        if(callback){
            callback(posts);
        }
        return posts;
    }
    const getComment = async (callback,keyword='')=>{
        const response = await fetch(`/api/list/comments?keyword=${keyword}`);
        const comments = await response.json();
        if(callback){
            callback(comments);
        }
        return comments;
    }
    return {getCounselor: getCounselor,getPost:getPost,getComment:getComment};
})();