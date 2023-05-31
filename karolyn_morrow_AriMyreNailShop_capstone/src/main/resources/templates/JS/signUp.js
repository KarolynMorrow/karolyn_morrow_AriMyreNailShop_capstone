 const submitBtn = document.getElementById("submitBtn")

 const validate = (e) => {
 e.preventDefault();

     const firstName = document.getElementById("firstName");
     const lastName = document.getElementById("lastName");
     const password = document.getElementById("pwd");
     const email = document.getElementById("emailAddress");

    if(firstName.value === "") {
    alert("Please enter your first name.");
    firstName.focus();
    return false
    }

    if(lastName.value === "") {
        alert("Please enter your last name.");
        lastName.focus();
        return false
    }

    if(password.value === "") {
        alert("Please enter a password");
        password.focus();
        return false;
    }

    if(email.value === ""){
        alert("Please enter an email");
        email.focus();
        return false;

    }
    if(!emailIsValid(email.value)){
        alert("Please enter a valid email address.");
        email.focus();
        return false;
    }
    return true;
 }


 const emailIsValid = email => {
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)
 }

 
submitBtn.addEventListener('click', validate);

const phoneNumIsValid = phoneNumber => {
    return
}

