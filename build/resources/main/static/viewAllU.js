
let newDiv = document.createElement("div");
let apiView = "http://localhost:8080/manager/users";
let viewButton = document.getElementById("view-employees");

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
    //let getUser = `${apiView}${userid}`;

    //Fetch the url request.
    fetch(apiView, {
      method: 'GET',
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
            //console.log(newDiv);
        });
})