const profileImage = document.getElementById("profile-image");

profileImage.setAttribute("src",   `/api/display?filePath=${filePath}&fileName=${fileName}`);