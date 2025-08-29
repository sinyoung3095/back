// const PostsService = (() => {
//     const getList = async (postId, callback, page=1) => {
//         const response = await fetch(`/api/replies/${page}?postId=${postId}`)
//         const repliesCriteria = await response.json();
//
//         if(callback){
//             callback(repliesCriteria);
//         }
//
//     }
//
//     return {getList: getList}
// })();
//
