const apiRegister = 'http://localhost:8080/user';
let registerButton = document.getElementById("register");

const apiLogin = 'http://localhost:8080/login';
let loginButton = document.getElementById("login");

/*
loginButton.addEventListener('click', function(event) {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    //const formData = new FormData();
    //formData.set("username", username);
    //formData.set("password", password);

    let login = {
        username, password
    }

    fetch(apiLogin, {
        method: 'POST',
        body: JSON.stringify(login),  
    })  
    .then(res => res.text())
    .then(data => {
        console.log('Success', data);
    })
    .catch((error) => {
        console.error('Error:', error);
    });

});
*/

registerButton.addEventListener('click', function(event) {
    let fname = document.getElementById("first").value;
    let lname = document.getElementById("last").value;
    let email = document.getElementById("email").value;
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let roleid = 0;
    //const formData = new FormData();
    //formData.set("first", fname);
    //formData.set("last", lname);
    //formData.set("email", email);
    //formData.set("username", username);
    //formData.set("password", password);

    let register = {
        fname, lname, email, username, password, roleid
    }

    fetch(apiRegister, {
        method: 'POST',
        body: JSON.stringify(register),  
    })  
    .then(res => res.text())
    .then(data => {
        console.log(fname);
        console.log(lname);
        console.log(email);
        console.log(username);
        console.log(password);
        console.log('Success', data);
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});