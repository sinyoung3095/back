const service = (() => {
    console.log("서비스 들어옴");
    const getMember = async(callback, page=1,keyword='') => {
        const response = await fetch(`/api/list/mentor/${page}?keyword=${keyword}`);
        const memberCriteriaDTO = await response.json();
        if(callback){
                callback(memberCriteriaDTO);
        }

        return memberCriteriaDTO;

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
    console.log(" 서비스 끝");
    return {getMember: getMember,getPost:getPost,getComment:getComment};
})();