const emailService = (() => {
    const findEmail = async (member, callback) => {
        try {
            const response = await fetch("/send-one", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({member})
            });

            const result = await response.json();

            if (response.ok) {
                console.log("이메일 찾기 성공");
            } else {
                console.log("이메일 찾기 실패", response.status);
            }

            if (callback) callback(result);

            return result;
        } catch (error) {
            console.error("이메일 찾기 오류", error);
        }
    };

    return{findEmail: findEmail};

})();
