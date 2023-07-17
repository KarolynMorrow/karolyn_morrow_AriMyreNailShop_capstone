let totalPrice = 0;

//Get html element where price will be shown
const priceDisplay = document.getElementById("total");

//Function to update total price
function updateTotalPrice(){
if(totalPrice === 0){
priceDisplay.style.display = "none";
}else{
priceDisplay.style.display = "block";
priceDisplay.textContent = `Total Price: ${totalPrice}`;
}

}

// Function to add a row to the choices table
function addToAppointmentTable(treatment, addOns) {
  // Get the choices table body element
  const choicesTableBody = document.querySelector('#appointmentTable tbody');

  // Create a new row
  const newRow = document.createElement('tr');

  // Create treatment cell
  const treatmentCell = document.createElement('td');
  treatmentCell.textContent = treatment;
  newRow.appendChild(treatmentCell);

  // Create add-ons cell
  const addOnsCell = document.createElement('td');
  addOnsCell.textContent = addOns.join(', ');
  newRow.appendChild(addOnsCell);

  // Append the new row to the table body
  choicesTableBody.appendChild(newRow);
}


document.addEventListener('DOMContentLoaded', function() {

  // Fetch treatment data from the server
  fetch('/api/treatments')
    .then(response => response.json())
    .then(data => {
      // Get the carousel inner container
      const carouselInner = document.querySelector('#carousel-inner');

      // Create carousel slides dynamically
      data.forEach((treatment, index) => {
        // Create slide element
        const slide = document.createElement('div');
        slide.classList.add('carousel-item');
        if (index === 0) {
          slide.classList.add('active');
        }

        // Create slide content
        const content = document.createElement('div');
        content.id = treatment.serviceName;
        content.className='treatments';

        let svcTitle = document.createElement('h2');
        svcTitle.className='serviceTitle';
        svcTitle.textContent = treatment.serviceName;

        let includedSvc = document.createElement('p');
        includedSvc.className='includedService';
        includedSvc.textContent = treatment.description;

        let svcPrice = document.createElement('button');
        svcPrice.className='btn btn-outline-primary price';
        svcPrice.textContent = treatment.servicePrice;
        svcPrice.value = treatment.servicePrice;
        svcPrice.setAttribute("data-bs-toggle", "button");
        svcPrice.setAttribute("aria-pressed", "false");

        content.appendChild(svcTitle);
        content.appendChild(includedSvc);
        content.appendChild(svcPrice);



svcPrice.addEventListener("click", ()=>{


        //check if button is pressed
        const isPressed = svcPrice.getAttribute("aria-pressed") === "true" ? true : false;
        console.log(isPressed);
        console.log(svcPrice.value);

        //get the value of each button individually
        const amountInput = svcPrice.value;


        //since button.value is a string parseInt changes value to int type
        if(isPressed){
            totalPrice += parseInt(amountInput);
        } else {
            totalPrice -= parseInt(amountInput);
        }
       //update the price display
       updateTotalPrice();

    });


        // Append slide content to slide element
        slide.appendChild(content);

        // Append slide to carousel inner container
        carouselInner.appendChild(slide);
      });

      // Activate the carousel
      $('#treatmentCarousel').carousel();
    })
    .catch(error => console.error('Error fetching data from the server:', error));
});


    //Event listener for the add-ons buttons
    document.querySelectorAll("button").forEach(button => {
        button.addEventListener("click", () => {
            const isPressed = button.getAttribute("aria-pressed") === "true" ? true : false;
            console.log(isPressed);
            console.log(button.value);

            const amountInput = parseInt(button.value);

            if (isPressed){
            totalPrice += amountInput;
            }else{
            totalPrice -= amountInput;
            }
            updateTotalPrice();
        });

    });


// Get html elements for the add-ons buttons
const addOnButtons = document.querySelectorAll("button.treatmentButton");

// Event listener for the treatment button click
function treatmentButtonClicked() {
  // Get the clicked treatment button
  var clickedButton = event.target;

  // Get the parent row and its unique identifier
  var parentRow = clickedButton.closest('div.treatments');
  var treatment = parentRow.id;

  // Check if the treatment button is currently clicked or unclicked
  var isClicked = clickedButton.checked;

  // Get the selected add-ons
  var addOns = [];
  addOnButtons.forEach(button => {
    if (button.getAttribute('aria-pressed') === 'true') {
      addOns.push(button.textContent);
    }
  });

  // Add the chosen treatment and add-ons to the table
  addToAppointmentTable(treatment, addOns);
}

// Attach the click event handler to all treatment buttons
var treatmentButtons = document.getElementsByClassName('treatmentButton');
for (var i = 0; i < treatmentButtons.length; i++) {
  treatmentButtons[i].addEventListener('click', treatmentButtonClicked);
}

