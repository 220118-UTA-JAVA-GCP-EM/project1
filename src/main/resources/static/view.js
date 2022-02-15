
let newDiv = document.createElement("div");

let viewButton = document.getElementById("view-account");



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

viewButton.addEventListener('submit', function (event) {

    let userid = getCookie("id");
    const apiView = "http://localhost:8080/employee/user/";
    const getUser = `${apiView}${userid}`;

    //Display the url in the console.
    console.log(getUser);

    //Fetch the url request.
    fetch(getUser)
        .then((res) => res.text()
        .then((data) => {
            console.log(data),
            console.log(data),
            //Add inner HTML to the element.
            //newDiv.innerHTML += `<p>${data.species.name}</p> <img src="${data.sprites.front_default}"/>`

            //newPokemonClass.append(newDiv);
            //console.log(newDiv);
        }))

});
