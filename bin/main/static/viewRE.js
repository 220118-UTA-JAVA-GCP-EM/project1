//WIP
let newDiv = document.createElement("div");
let apiView = "http://localhost:8080/employee/requests/";
let viewButton = document.getElementById("view-account");

let newUserClass = document.getElementsByClassName("userInfo")[0];
let newUser = document.getElementById("currUser");



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

viewButton.addEventListener('click', function (event) {

    let userid = getCookie("id");
    let auth = getCookie("Authorization");
    let getUser = `${apiView}${userid}`;

    //Display the url in the console.
    console.log(getUser);
    
    //Fetch the url request.
    fetch(getUser, {
        headers: {
          id: userid,
          Authorization: auth
        }
    })
        .then((res) => res.text())
        .then((data) => {
            console.log(data),
            console.log(data)
            newDiv.innerHTML += `<p>${data}</p>`
            newUserClass.append(newDiv);
            console.log(newUser);
        });
})