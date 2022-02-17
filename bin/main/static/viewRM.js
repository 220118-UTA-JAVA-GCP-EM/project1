let newDiv3 = document.createElement("div");
let apiViewReq3 = "http://localhost:8080/manager/requests/";
let viewRequestsButton3 = document.getElementById("employee-requests");

let newUserClass3 = document.getElementsByClassName("userInfo")[0];
let newUser3 = document.getElementById("currUser");



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

viewRequestsButton3.addEventListener('click', function (event) {

    let userid = document.getElementById("user-id").value;
    console.log(userid);
    let auth = getCookie("Authorization");
    let getUser = `${apiViewReq3}${userid}`;

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
            newDiv3.innerHTML += `<p>${data}</p>`
            newUserClass3.append(newDiv3);
            console.log(newUser3);
        });
})