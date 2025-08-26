const imgContainer = document.getElementById("imgContainer");

const hasProfile = false;

if (!hasProfile) {
    imgContainer.innerHTML = "<img src=\"/images/member/no-profile.png\" class=\"profile-img\">";
} else {
    imgContainer.innerHTML = "<img src=\"/api/display?filePath=...&fileName=...\" class=\"profile-img\">";
}