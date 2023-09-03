document.querySelector(".return").addEventListener('click', function (){
    window.scrollTo({
        top:0,
        behavior:'smooth'
    });
});

let loginElements = document.querySelectorAll('.loginBtn');
for(let i = 0; i < loginElements.length; i++){
    loginElements[i].addEventListener("click", function (){
        let form = document.querySelector("form");
        form.innerHTML = '        <div class="mask"></div>\n' +
            '        <div class="model">\n' +
            '            <div class="passwordLogin">密码登录</div>\n' +
            '            <input class="logonName" type="text" placeholder="手机号或邮箱">\n' +
            '            <input class="loginPwd" type="password" placeholder="密码">\n' +
            '            <button>注册/登录</button>\n' +
            '            <div class="intro">未注册手机验证后自动登录，注册即代表同意《知乎协议》《隐私保护指引》</div>\n' +
            '            <img class="close" src="../static/imgs/download.jpg">\n' +
            '        </div>';
        form.addEventListener("click", function(event) {
            if (event.target.classList.contains("close")) {
                form.innerHTML = '';
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
                window.location.href = "other.html";
                blueLines[i].classList.add("blueLine");
            }else{
                window.location.href = "index.html";
                blueLines[i].classList.add("blueLine");
            }
        });
    }

    let reads = document.querySelectorAll(".read");
    for (let i = 0; i < reads.length; i++) {
        reads[i].addEventListener("click", function () {
            let hide = document.querySelector(".hide");
            hide.style.cssText = "";
        });
    }