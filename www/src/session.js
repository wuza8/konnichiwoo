backend = "http://localhost:8000/api"

function loadUser() {
    return fetch(backend + "/user/current");
}

function logout(){
    window.location=backend + "/logout";
}

function hasRole(user, roleName){
    let r = false;
    user.roles.forEach(role => {
        if(role == roleName) r = true;
    }
    )
    return r;
}