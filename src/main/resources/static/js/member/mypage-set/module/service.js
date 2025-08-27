const myPageSetService=(()=>{
    const profileDelete=async (fileId)=>{
        const response=await fetch(`/api/delete/${fileId}`, {
            method: "DELETE"
        })
    }
    return {profileDelete: profileDelete}
})();