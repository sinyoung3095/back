const passwordService = (() => {
    const updatePassword = async (counselor, callback) => {
        try {
            const response = await fetch("/mail/new-password", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(counselor)
            });

            const result = await response.json();

            if (response.ok) {
                console.log("비밀번호 변경 성공");
            } else {
                console.log("비밀번호 변경 실패", response.status);
            }

            if (callback) callback(result);

            return result;
        } catch (error) {
            console.error(error);
        }
    };

    return {updatePassword: updatePassword};

})();
