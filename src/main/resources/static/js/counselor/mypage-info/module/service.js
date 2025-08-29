const counselorService1 = (() => {
    const checkEmail = async (counselorEmail) => {
        try {
            const response = await fetch("/counselor/check-email", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({ counselorEmail })
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

    return { checkEmail };
})();

const counselorService2 = (() => {
    const checkPhoneNumber = async (counselorPhoneNumber) => {
        try {
            const response = await fetch("/counselor/check-phone-number", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({ counselorPhoneNumber })
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

