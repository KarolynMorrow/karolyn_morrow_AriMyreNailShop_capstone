//make a global variable that holds the service selected
let service = "";

//Get element where service will be shown
const serviceDisplay = document.getElementById("service");

//Get html elements where the buttons are located using the tag name
const buttons = document.querySelectorAll("button")


// Attach an onchange event listener to the dropdown
document.getElementById("serviceDropdown").addEventListener("change", function() {
  var selectedService = this.value;
  if (selectedService) {
    fetchServiceDetails(selectedService);
  } else {
    clearServiceDetails();
  }
});

// Function to fetch service details from the database
function fetchServiceDetails(serviceName) {
  // Make a request to the server to fetch the details based on the selected service
  fetch('/service/' + serviceName)
    .then(response => response.json())
    .then(data => {
      // Update the HTML or create new elements in the DOM to display the fetched details
      var serviceDetails = document.getElementById("serviceDetails");
      serviceDetails.innerHTML = '';

      // Create elements to display the details
      var serviceNameElement = document.createElement("h2");
      serviceNameElement.textContent = data.name;

      var serviceDescriptionElement = document.createElement("p");
      serviceDescriptionElement.textContent = data.description;

      serviceDetails.appendChild(serviceNameElement);
      serviceDetails.appendChild(serviceDescriptionElement);
    })
    .catch(error => {
      console.error("Error occurred while fetching service details:", error);
      clearServiceDetails();
    });
}

// Function to clear the service details
function clearServiceDetails() {
  var serviceDetails = document.getElementById("serviceDetails");
  serviceDetails.innerHTML = '';
}
