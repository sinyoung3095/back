const service = (() => {
    console.log("서비스 들어옴");
    const getMember = async(callback) => {
        const response = await fetch(`/api/general/find`);
        const members = await response.json();
        console.log(members)
        if(callback){
                callback(members);
        }

        return members;

    }
    console.log(" 서비스 끝");
    return {getMember: getMember};
})();