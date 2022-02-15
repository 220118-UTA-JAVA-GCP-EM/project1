
const apiLogin = 'http://localhost:8080/login';
let loginButton = document.getElementById("loginForm");


loginButton.addEventListener('submit', function(event) {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    event.preventDefault();


    let login = {
        username, password
    }

    fetch(apiLogin, {
        method: 'POST',
        body: JSON.stringify(login),
    })
    .then(res => {
        document.cookie = `id=${res.headers.get("id")}`;
        return res.text();
    })
    .then(data => {
        console.log('Success', data);
    })
    .catch((error) => {
        console.error('Error:', error);
    });

});





