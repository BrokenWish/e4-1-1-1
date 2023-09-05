let form = document.querySelector("form");
form.addEventListener("click", function(event) {
    if (event.target.classList.contains("close")) {
        window.history.back(-1);
    }
});

window.onload = function(){
    let loginName = document.querySelector(".logonName");
    let logonPwd = document.querySelector(".logonPwd");
    let enter = document.querySelector(".enter");

    let newLoginName;
    let newLogonPwd;

    loginName.onchange = function (){
        newLoginName = loginName.value;
    }
    logonPwd.onchange = function (){
        newLogonPwd = logonPwd.value;
    }

    const data = {
        username: "example"
    };


    function compareData() {
        // 发送AJAX请求
        fetch('/api/getUserData') // 替换为你的后台接口地址
            .then(response => response.json())
            .then(data => {
                // 对比数据
                if (data.loginName === newLoginName && data.logonPwd === newLogonPwd) {
                    // 数据匹配，执行相应操作
                    enter.disabled = false;
                } else {
                    // 数据不匹配，执行相应操作
                    enter.disabled = true;
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }
}


