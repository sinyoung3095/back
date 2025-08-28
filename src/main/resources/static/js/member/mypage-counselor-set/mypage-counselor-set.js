const wrapForm = document.getElementById("wrap");
const subForm = document.getElementById("sub");
const editButton = document.getElementById("button");
const cancelButton = document.getElementById("cancle1");
const input = document.getElementById("insert1");
const saveButton = subForm.querySelector("button[type='submit']");

const backButton=document.querySelector(".photo-10");
const profileWrapArea=document.querySelector(".main-8");
const profileUpdateList=document.querySelector(".photo-1");

const profileButtons=document.querySelectorAll(".profile-change");
subForm.style.display = "none";

editButton.addEventListener("click", function () {
    wrapForm.style.display = "none";
    subForm.style.display = "block";
    input.focus();
});

cancelButton.addEventListener("click", function () {
    subForm.style.display = "none";
    wrapForm.style.display = "block";
});

input.addEventListener("input", function () {
    if (input.value.trim() !== "") {
        saveButton.disabled = false;
    } else {
        saveButton.disabled = true;
    }
});

profileWrapArea.addEventListener("click", () => {
    // console.log("버튼 클릭됨")
    profileUpdateList.classList.add("active");
});

backButton.addEventListener("click", () => {
    profileUpdateList.classList.remove("active");
});

profileButtons.forEach((button)=>{
    button.addEventListener("click", async (e)=>{
        if(e.target.classList.contains("photo-7")){
            // myPageSetService.
        } else if(e.target.classList.contains("photo-9")){
            await myPageSetService.profileDelete(fileId);
        }
    })
})
// noProfileButton.addEventListener("click", async () => {
//     await myPageSetService.profileDelete(fileId);
// });

const profileImage = document.getElementById("profile-image");

profileImage.setAttribute("src",   `/api/display?filePath=${filePath}&fileName=${fileName}`);