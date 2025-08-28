const emailService = (() => {
    const findEmail = async (member) => {
        const response = await fetch("/sms/send", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(member)
        });

        const result = await response.json();

        if (response.ok) {
            console.log("이메일 찾기 성공");
        } else {
            console.log("이메일 찾기 실패", response.status);
        }

        return result;
    };

    const checkCode = async (member) => {
        const response = await fetch("/sms/send", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(member)
        });

        const result = await response.json();

        if (response.ok) {
            console.log("인증번호 검사");
        } else {
            console.log("인증번호 검사 실패", response.status);
        }

        return result;
    };

    return {findEmail:findEmail, checkCode:checkCode};

})();
