
var password = document.getElementById('password1');
var confirmPassword = document.getElementById('password2');


function check() {
    if (password.value != confirmPassword.value)  {
        confirmPassword.setCustomValidity("Passwords Don't Match");
    } else {
        confirmPassword.setCustomValidity(" ");
    }
}

password.onchange = check;
password.onkeyup = check;