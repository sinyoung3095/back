const profileImage = document.getElementById("profile-image");

if (profileImage) {
    if (filePath && fileName) {
        profileImage.setAttribute("src", `/api/display?filePath=${filePath}&fileName=${fileName}`);
    }
    else {
        profileImage.setAttribute("src", `/images/member/no-profile.png`);
    }
}