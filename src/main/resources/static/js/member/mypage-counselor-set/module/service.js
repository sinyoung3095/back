const myPageSetService=(()=>{
    const profileDelete=async (fileId)=>{
        const response=await fetch(`/api/delete-counselor/${fileId}`, {
            method: "DELETE"
        })
    }
    return {profileDelete: profileDelete}
})();