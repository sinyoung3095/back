const emailService = (() => {
    // 인증번호 발송
    const sendCode = async (member) => {
        const response = await fetch("/sms/send", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(member)
        });

        return await response.json();
    };

    const getEmailByPhoneNumber = async (member) => {
        const response = await fetch("/sms/find-email", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(member)
        });

        return await response.json();
    };

    return {sendCode:sendCode, getEmailByPhoneNumber:getEmailByPhoneNumber};

})();
