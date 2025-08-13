const memberService = (() => {
    const checkEmail = async (member, callback) => {
        try{
            const response = await fetch("/member/check-email", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(member)
            })
            const result = await response.json();

            return result.isExist;
        } catch (error) {
            console.error(error);
        }


    }
    return {checkEmail: checkEmail}
})();
