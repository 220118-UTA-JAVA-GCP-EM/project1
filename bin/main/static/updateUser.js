let apiView = "http://localhost:8080/employee/user/";
let updateButton = document.getElementById("update");

//let newUserClass = document.getElementsByClassName("userInfo")[0];
//let newUser = document.getElementById("currUser");

function getCookie(cname) {
  let name = cname + "=";
  let decodedCookie = decodeURIComponent(document.cookie);
  let ca = decodedCookie.split(';');
  for(let i = 0; i <ca.length; i++) {
    let c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}

//try this later, but maybe fill in existing fields? but how???
//document.getElementById('first').setAttribute('value', fname);

updateButton.addEventListener('click', function (event) {

    let userid = getCookie("id");
    let auth = getCookie("Authorization");
    let getUser = `${apiView}${userid}`;
    let fname = document.getElementById("first").value;
    let lname = document.getElementById("last").value;
    let email = document.getElementById("email").value;
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    event.preventDefault();

    let register = {
        fname, lname, email, username, password
      }

    //Display the url in the console.
    console.log(getUser);
    
    //Fetch the url request.
    fetch(getUser, {
        method: 'PUT',
        headers: {
          id: userid,
          Authorization: auth
        },
        body: JSON.stringify(register)
    })
        .then((res) => res.text())
        .then((data) => {
            console.log(data),
            console.log("Updated.")
            document.location.href = "employeeHome.html";
        });
})