let resolvedRequestsDiv = document.createElement("div");
let apiResolvedRequests = "http://localhost:8080/employee/requests/resolved/";
let resolvedRequestsButton = document.getElementById("view-resolved-requests");

let resolvedRequestsClass = document.getElementsByClassName("resolvedRequests")[0];


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

resolvedRequestsButton.addEventListener('click', function (event) {

    let userid = getCookie("id");
    let auth = getCookie("Authorization");
    let getResolvedRequests = `${apiResolvedRequests}${userid}`;

    //Display the url in the console.
    console.log(getResolvedRequests);
    
    //Fetch the url request.
    fetch(getResolvedRequests, {
      method: 'GET',
      headers: {
        id: userid,
        Authorization: auth
      }
    })
        .then((res) => res.json())
        .then((data) => {
            console.log(data)
            console.log(data)
            resolvedRequestsDiv.innerHTML += `<p style="font-size: 30px">Resolved Requests</p>`
            resolvedRequestsClass.append(resolvedRequestsDiv);
            for(let i = 0; i < data.length; i++){
            resolvedRequestsDiv.innerHTML += `<style>
            table, td, th {
              border: 1px solid white;
            }
            
            table {
              border-collapse: collapse;
              width: 100%;
            }
            
            td {
              height: 30px;
              text-align: center;
            }
            </style>
            <table>
            <tr>
              <th>ID #</th>
              <th>Amount $</th>
              <th>Submitted</th>
              <th>Resolved</th>
              <th>Description</th>
              <th>Author</th>
              <th>Resolver</th>
              <th>Status</th>
              <th>Type</th>
            </tr>
            <tr>
              <td>${data[i].id}</td>
              <td>${data[i].amount}</td>
              <td>${data[i].submitted}</td>
              <td>${data[i].resolved}</td>
              <td>${data[i].description}</td>
              <td>${data[i].author}</td>
              <td>${data[i].resolver}</td>
              <td>${data[i].statusId}</td>
              <td>${data[i].typeId}</td>
            </tr>
            <br>
          </table>`
            }
            resolvedRequestsClass.append(resolvedRequestsDiv);
            console.log(resolvedRequestsClass);
        });
})