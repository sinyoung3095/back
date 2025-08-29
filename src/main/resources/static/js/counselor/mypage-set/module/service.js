const myPageSetService = (() => {
    const profileDelete = async (fileId) => {
        if (!fileId) {
            console.warn("삭제할 파일 ID가 없습니다.");
            return false;
        }

        try {
            const response = await fetch(`/api/delete-counselor/${fileId}`, {
                method: "DELETE"
            });

            if (!response.ok) {
                console.error("프로필 삭제 실패:", response.status);
                return false;
            }

            console.log("프로필 삭제 성공");
            return true;
        } catch (error) {
            console.error("프로필 삭제 중 오류 발생:", error);
            return false;
        }
    };

    return { profileDelete };
})();

