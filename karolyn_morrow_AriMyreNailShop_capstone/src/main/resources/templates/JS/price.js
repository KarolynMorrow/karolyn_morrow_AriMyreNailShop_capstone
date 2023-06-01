//let x = document.getElementById("addOns").value
//make a global variable that takes price and is hidden when === 0; add prices to variable onclick based on value: $amount

//Define global variable
let totalPrice = 0;

//Get html element where price will be shown
const priceDisplay = document.getElementById("total");

//Get html elements where the buttons are located
const buttons = document.querySelectorAll("addOns");

//Add an onlick eventlistener to each button
buttons.forEach(button => {
    button.addEventListener("click", ()=>{
        //Obtain chosen service from price.html


        //check if button is pressed
        const isPressed = button.getAttribute("aria-pressed") === "true";
        //get the value of the button in extraSvcs.html
        const amountInput = buttons.value;

        if(isPressed){
        totalPrice += amountInput
        }

        if(totalPrice === 0){
            priceDisplay.style.display = "block";
        } else {
            priceDisplay.style.display = "block";
            priceDisplay.innerHTML = `Total Price: ${totalPrice}`;
        }

    })

})


