 const submitBtn = document.getElementById("submitBtn")


 
submitBtn.addEventListener('click', validate);

const phoneNumIsValid = phoneNumber => {
    return /^[0-9]{3}[\- ]?[0-9]{3}[\- ]?[0-9]{4}$/.test(phoneNumber);
}

