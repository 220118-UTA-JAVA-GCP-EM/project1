let newDiv2 = document.createElement("div");
let apiViewReq = "http://localhost:8080/employee/requests/";
let viewRequestsButton = document.getElementById("view-requests");

let newUserClass2 = document.getElementsByClassName("userInfo")[0];
let newUser2 = document.getElementById("currUser");



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

viewRequestsButton.addEventListener('click', function (event) {

    let userid = getCookie("id");
    let auth = getCookie("Authorization");
    let getUser = `${apiViewReq}${userid}`;

    //Display the url in the console.
    console.log(getUser);
    
    //Fetch the url request.
    fetch(getUser, {
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
            newDiv2.innerHTML += `<p>${data}</p>`
            newUserClass.append(newDiv2);
            console.log(newUser2);
        });
})