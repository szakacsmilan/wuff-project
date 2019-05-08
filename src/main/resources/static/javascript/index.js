
var password = document.getElementById('password1');
var confirmPassword = document.getElementById('password2');


function check() {
    if (password.value === confirmPassword.value)  {
        document.getElementById('submitbutt').click();
    } else {
        confirmPassword.setCustomValidity("Passwords Don't Match");
    }
}
