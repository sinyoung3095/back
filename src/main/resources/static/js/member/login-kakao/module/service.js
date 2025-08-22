const memberService2 = (() => {
    const checkPhoneNumber = async (memberPhoneNumber) => {
        try {
            const response = await fetch("/member/check-phone-number", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({ memberPhoneNumber })
            });

            if (response.status === 409) {
                return { isExist: true };
            }

            if (!response.ok) {
                const errorText = await response.text();
                throw new Error(errorText || "Fetch error");
            }

            return await response.json();
        } catch (error) {
            console.error(error);
            return { isExist: true };
        }
    };

    return { checkPhoneNumber };
})();

