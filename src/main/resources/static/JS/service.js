let totalPrice = 0;

//Get html element where price will be shown
const priceDisplay = document.getElementById("total");

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

        //get the value of each button individually
        const amountInput = svcPrice.value;


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


