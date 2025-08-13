// 게시글 목록
const curationTitle = document.querySelectorAll(".curation-title");
const curationContent = document.querySelectorAll(".curation-content");

posts.slice(0, 3).forEach((post, i) => {
    curationTitle[i].innerHTML = post.postTitle
    curationContent[i].innerHTML = post.postContent
});

// 상담사 목록1
const counselorName = document.querySelectorAll(".couselor-name");

counselors.slice(0, 8).forEach((counselor, i) => {
    counselorName[i].innerHTML = counselor.counselorName
});