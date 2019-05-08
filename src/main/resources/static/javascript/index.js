var password = document.getElementById('password1');
var confirmPassword = document.getElementById('password2');
var button = document.getElementById('submitbutt');

button.addEventListener("click", check);

function check() {
    if (password.value === confirmPassword.value)  {
        document.getElementById('submitbutt').click();
        confirmPassword.setCustomValidity("");

    } else {
        confirmPassword.setCustomValidity("Passwords Don't Match");
    }
}
