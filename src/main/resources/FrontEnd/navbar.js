//popup menu navbar
document.getElementById('account-name').addEventListener('click', function() {
    var popupMenu = document.getElementById('popup-menu');
    popupMenu.style.display = popupMenu.style.display === 'none' ? 'block' : 'none';
});

// Redirect the id basket page
document.getElementById('basketButton').addEventListener('click', function() {
    var urlParams = new URLSearchParams(window.location.search);
    var userId = urlParams.get('userId');
    window.location.href = 'basket.html?userId=' + userId;
});
document.getElementById('managerButton').addEventListener('click', function() {
    var urlParams = new URLSearchParams(window.location.search);
    var userId = urlParams.get('userId');
    window.location.href = 'Manager.html?userId=' + userId;
});

// Redirect the id home page
document.getElementById('homeButton').addEventListener('click', function() {
    var urlParams = new URLSearchParams(window.location.search);
    var userId = urlParams.get('userId');
    window.location.href = 'home.html?userId=' + userId;
});


window.onload = function() {
    var urlParams = new URLSearchParams(window.location.search);
    var userId = urlParams.get('userId');

    document.getElementById('managerButton').style.display = 'none';
    document.getElementById('juniorButton').style.display = 'none';
    document.getElementById('seniorButton').style.display = 'none';

    // Fetch the user details
    fetch('http://localhost:8081/user/' + userId)
        .then(response => response.json())
        .then(user => {
            document.getElementById('managerButton').style.display = user.role === 'MANAGER' ? 'block' : 'none';
            document.getElementById('juniorButton').style.display = user.role === 'JUNIOR_SWE' ? 'block' : 'none';
            document.getElementById('seniorButton').style.display = user.role === 'SENIOR_SWE' ? 'block' : 'none';

            var userName = user.firstName && user.lastName ? user.firstName + ' ' + user.lastName : 'Account Name';
            document.getElementById('userName').textContent = userName;
        })
        .catch((error) => {
            console.error('Error:', error);
            document.getElementById('userName').textContent = 'Account Name';
        });
};