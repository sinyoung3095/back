const emailService = (() => {
    const sendCode = async (counselor) => {
        const response = await fetch("/sms/send", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(counselor)
        });

        return await response.json();
    };

    const getEmailByPhoneNumber = async (counselor) => {
        const response = await fetch("/sms/find-email", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(counselor)
        });

        return await response.json();
    };

    return {sendCode:sendCode, getEmailByPhoneNumber:getEmailByPhoneNumber};

})();
