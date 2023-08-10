backend = "http://localhost:8000/api"

function loadUser() {
    
    return "Don't use it"
}

function logout(){
    var xhr = new XMLHttpRequest();

    xhr.open("POST", "/api/auth/logout", true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify({
        token: localStorage.getItem("token")
    }));

    xhr.onreadystatechange = function () {
        if (this.readyState != 4) return;

        if (this.status == 200) {
            document.location.href = "index.html";
        }
    };
}