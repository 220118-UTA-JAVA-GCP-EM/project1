let newDiv2 = document.createElement("div");
let apiViewReq2 = "http://localhost:8080/manager/requests";
let viewButton2 = document.getElementById("all-requests");

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

viewButton2.addEventListener('click', function (event) {

    let userid = getCookie("id");
    let auth = getCookie("Authorization");
    //let getUser = `${apiView}${userid}`;

    //Fetch the url request.
    fetch(apiViewReq2, {
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
            newUserClass2.append(newDiv2);
            //console.log(newDiv);
        });
})