const emailErrorBox = document.getElementById(
    "request_anonymous_requester_email_error"
);
const titleErrorBox = document.getElementById("request_subject_error");
const descriptionErrorBox = document.getElementById(
    "request_description_error"
);
const customerEmailErrorBox = document.getElementById(
    "request_custom_fields_70987527_error"
);
const phoneErrorBox = document.getElementById(
    "request_custom_fields_71442508_error"
);

const emailInput = document.getElementById("request_anonymous_requester_email");
const titleInput = document.getElementById("request_subject");
const descriptionInput = document.getElementById("request_description");
const customerEmailInput = document.getElementById(
    "request_custom_fields_70987527"
);
const phoneInput = document.getElementById("request_custom_fields_71442508");

const button = document.querySelector("input[name=commit]");

const fileInput = document.getElementById("request-attachments");
const fileList = document.getElementById("request-attachments-pool");

console.log("test");

button.addEventListener("click", (e) => {
    e.preventDefault();

    if (emailInput.value) {
        emailErrorBox.classList.remove("active");
    } else {
        emailErrorBox.classList.add("active");
    }

    if (titleInput.value) {
        titleErrorBox.classList.remove("active");
    } else {
        titleErrorBox.classList.add("active");
    }

    if (descriptionInput.value) {
        descriptionErrorBox.classList.remove("active");
    } else {
        descriptionErrorBox.classList.add("active");
    }

    if (customerEmailInput.value) {
        customerEmailErrorBox.classList.remove("active");
    } else {
        customerEmailErrorBox.classList.add("active");
    }

    if (phoneInput.value) {
        phoneErrorBox.classList.remove("active");
    } else {
        phoneErrorBox.classList.add("active");
    }
});

fileInput.addEventListener("change", (e) => {
    const file = e.target.files[0];
    if (!file) return;

    const reader = new FileReader();
    reader.readAsDataURL(file);

    reader.addEventListener("load", (e) => {
        const path = file.name;

        const li = document.createElement("li");
        li.className = "upload-item";
        li.innerHTML = `
            <a class="upload-link">${path}</a>
            <span class="upload-remove"></span>
        `;

        li.querySelector(".upload-remove").addEventListener("click", () => {
            li.remove();
        });

        fileList.appendChild(li);
    });
});
