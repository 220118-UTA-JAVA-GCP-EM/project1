

let logoutBtn = document.getElementById('logout').addEventListener('submit', () =>
        fetch('http://localhost:8080/logout')
            .then(res => {
            document.cookie = 'id=;';
            })
        })

