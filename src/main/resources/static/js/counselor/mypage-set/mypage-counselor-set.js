document.addEventListener("DOMContentLoaded", () => {
    const wrapForm = document.getElementById("wrap");
    const subForm = document.getElementById("sub");
    const editButton = document.getElementById("button");
    const cancelButton = document.getElementById("cancle1");
    const input = document.getElementById("insert1");
    const saveButton = subForm.querySelector("button[type='submit']");

    const profileImage = document.getElementById("profile-image");

    const fileIdSafe = typeof fileId !== 'undefined' ? fileId : null;
    const filePathSafe = (typeof filePath !== 'undefined' && filePath !== null) ? filePath : '';
    const fileNameSafe = (typeof fileName !== 'undefined' && fileName !== null) ? fileName : '';

    subForm.style.display = "none";

    editButton.addEventListener("click", () => {
        wrapForm.style.display = "none";
        subForm.style.display = "block";
        input.focus();
    });

    cancelButton.addEventListener("click", () => {
        subForm.style.display = "none";
        wrapForm.style.display = "block";
    });

    input.addEventListener("input", () => {
        saveButton.disabled = input.value.trim() === "";
    });

    document.addEventListener("click", async (e) => {
        if (e.target.closest(".main-8")) {
            console.log("버튼 클릭됨");
            document.querySelector(".photo-1")?.classList.add("active");
        }

        if (e.target.closest(".photo-10")) {
            console.log("취소 버튼 눌림");
            document.querySelector(".photo-1")?.classList.remove("active");
        }

        if (e.target.closest(".change-profile")) {
            console.log("change-button 인식");

            if (e.target.closest(".photo-9") && fileIdSafe) {
                console.log("프로필 삭제 버튼 클릭됨", fileIdSafe);
                await myPageSetService.profileDelete(fileIdSafe);
                if (profileImage) {
                    profileImage.src = "/images/member/no-profile.png";
                }
            }
        }
    });

    if (profileImage && filePathSafe && fileNameSafe) {
        profileImage.setAttribute("src", `/api/display?filePath=${filePathSafe}&fileName=${fileNameSafe}`);
    }

    const fileInput = document.querySelector(".photo-8");

    fileInput.addEventListener("change", async (e) => {
        const file = e.target.files[0];
        console.log(file);
        console.log(counselorId);
        if (!file) return;

        const formData = new FormData();
        formData.append("file", file);
        formData.append("counselorId", counselorId);



        const response = await fetch("/api/profile-counselor/upload", {
            method: "POST",
            body: formData
        });

        if (response.ok) {
            const savedFile = await response.json();

            const existingImage = document.getElementById("profile-image");
            if (existingImage) {
                existingImage.src = `/api/display?filePath=${savedFile.filePath}&fileName=${savedFile.fileName}`;
            } else {
                const newImage = document.createElement("img");
                newImage.classList.add("profile-img");
                newImage.id = "profile-image";
                newImage.src = `/api/display?filePath=${savedFile.filePath}&fileName=${savedFile.fileName}`;

                const container = document.querySelector(".main-7");
                container.innerHTML = "";
                container.appendChild(newImage);
            }
        } else {
            alert("업로드 실패!");
        }
    });
});
