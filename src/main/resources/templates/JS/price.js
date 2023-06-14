
//make a global variable that takes price and is hidden when === 0; add prices to variable onclick based on value: $amount

//Define global variable
let totalPrice = 0;

//Get html element where price will be shown
const priceDisplay = document.getElementById("total");

//Get html elements where the buttons are located using the tag name
const buttons = document.querySelectorAll("button");

//Add an onlick eventlistener to each button
buttons.forEach(button => {
    button.addEventListener("click", ()=>{
        //Obtain chosen service from price.html


        //check if button is pressed
        const isPressed = button.getAttribute("aria-pressed") === "true" ? true : false;
        console.log(isPressed);

        //get the value of each button individually in extraSvcs.html
        const amountInput = button.value;


        //since button.value is a string parseInt changes value to int type
        if(isPressed){
            totalPrice += parseInt(amountInput);
        } else {
            totalPrice -= parseInt(amountInput);
        }

        if(totalPrice === 0){
            priceDisplay.style.display = "none";
        } else {
            priceDisplay.style.display = "block";
            priceDisplay.textContent = `Total Price: ${totalPrice}`;
        }

    });

});





