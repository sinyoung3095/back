const postService = (() => {
    const getPost = async (callback, page=1) => {
        const response = await fetch(`/api/community-posts/${page}`);
        const postsCriteria = await response.json();
        if(callback){
            setTimeout(() => {
                callback(postsCriteria);
            }, 500)
        }

        return postsCriteria;
    }

    return {getPost: getPost}
})();