backend = "http://localhost:8000/api"

function loadUser() {
    return fetch(backend + "/user/current");
}

function logout(){
    window.location=backend + "/logout";
}