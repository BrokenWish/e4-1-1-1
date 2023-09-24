document.querySelector(".return").addEventListener('click', function (){
    window.scrollTo({
        top:0,
        behavior:'smooth'
    });
});

let commentElements = document.querySelectorAll('.comment');
for(let i = 0; i < commentElements.length; i++){
    commentElements[i].addEventListener("click", function (){
        let commentList = document.querySelector(".commentList");
        commentList.innerHTML = '    <div class="mask">\n' +
            '        <div class="comments">\n' +
            '            <div class="commentTop">\n' +
            '                <div>110条评论</div>\n' +
            '                <div>切换为时间顺序</div>\n' +
            '            </div>\n' +
            '            <div class="">\n' +
            '                <div class="comment-list">\n' +
            '                    <div class="userComment">\n' +
            '                        <h3 class="username">知乎用户</h3>\n' +
            '                        <p class="comment-content">这是一个评论。</p>\n' +
            '                        <img src="../imgs/like2.png" alt="">\n' +
            '                        <span>14</span>\n' +
            '                    </div>\n' +
            '                    <div class="userComment">\n' +
            '                        <h3 class="username">用户名2</h3>\n' +
            '                        <p class="comment-content">这是另一个评论。</p>\n' +
            '                        <img src="..imgs/like2.png" alt="">\n' +
            '                        <span>14</span>\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '        <img class="close" src="../imgs/download.jpg">\n' +
            '        </div>\n' +
            '        <div class="commentSub">\n' +
            '        <form action="/zhihu/comment.html" method="POST">\n' +
            '            <input placeholder="写下你的评论" name="content" type="text">\n' +
            '            <img src="../imgs/expression.png" alt="">\n' +
            '            <button type="submit">发布</button>\n' +
            '        </form>\n' +
            '        </div>\n' +
            '    </div>';
        commentList.addEventListener("click", function(event) {
            if (event.target.classList.contains("close")) {
                commentList.innerHTML = '';
            }
        });
    });
}

let searchContent = document.querySelector(".search-content");
searchContent.addEventListener("keyup", function() {
    let inputValue = searchContent.value;
    let search = document.querySelector(".search ul");


    if (inputValue.includes("奥密克戎")){
        search.classList.add("search-result");

        search.innerHTML = ' <li>奥密克戎变异</li>\n' +
            '            <li>奥密克戎变异株ba.2进化分支</li>\n' +
            '            <li>奥密克戎变异株</li>\n' +
            '            <li>奥密克戎变异株潜伏期</li>\n' +
            '            <li>奥密克戎变异毒株有多厉害</li>\n' +
            '            <li class="search-about">查看「奥密克戎变异」的搜索结果</li>\n' +
            '            <li class="report">举报</li>';

    }

    if (inputValue.trim() === ""){
        search.innerHTML = '';
    }
});

let blueLines = document.querySelectorAll("header.bottom ul li");
for (let i = 0; i < blueLines.length; i++) {
    blueLines[i].addEventListener("click", function () {
        for (let i = 0; i < blueLines.length; i++) {
            blueLines[i].classList.remove("blueLine");
        }

        blueLines[i].classList.add("blueLine");
        if (i != 0){
            window.location.href = "/zhihu/other.html";
            blueLines[i].classList.add("blueLine");
        }else{
            window.location.href = "/zhihu/index.html";
            blueLines[i].classList.add("blueLine");
        }
    });
}


let reads = document.querySelectorAll(".read");
for (let i = 0; i < reads.length; i++) {
    reads[i].addEventListener("click", function () {
        let contents = document.querySelectorAll('.content');
        contents[i].classList.toggle("hide");
    });
}

let likes = document.querySelectorAll(".like");
let hasLikes = document.querySelectorAll(".has_like");
let likeArray =  new Array(likes.length).fill(false);
for (let i = 0; i < likes.length; i++) {
    likes[i].addEventListener("click", function (){
        likeArray[i] = !likeArray[i];

        if (likeArray[i]){
            likes[i].classList.add("liked");
            hasLikes[i].innerHTML = parseInt(hasLikes[i].innerText.trim()) + 1;
        }else{
            likes[i].classList.remove("liked");
            hasLikes[i].innerHTML = parseInt(hasLikes[i].innerText.trim()) - 1;
        }
    });
}