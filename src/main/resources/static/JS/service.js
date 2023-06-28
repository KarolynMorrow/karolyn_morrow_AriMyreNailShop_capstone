// Attach an onchange event listener to the dropdown
document.getElementById("serviceDropdown").addEventListener("change", function() {
  let selectedService = this.value;
  if (selectedService) {
    fetchServiceDetails(selectedService);
  } else {
    clearServiceDetails();
  }
});

// Function to fetch service details from the database
function fetchServiceDetails(serviceName) {
  // Make a request to the server to fetch the details based on the selected service
  fetch('/api/chooseService/' + serviceName)
    .then(response => response.json())
    .then(data => {
      // Update the HTML or create new elements in the DOM to display the fetched details
      let serviceDetails = document.getElementById("serviceDetails");
      serviceDetails.innerHTML = '';

      // Create elements to display the details
      let serviceNameElement = document.createElement("h2");
      serviceNameElement.textContent = data.name;

      let serviceDescriptionElement = document.createElement("p");
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
  let serviceDetails = document.getElementById("serviceDetails");
  serviceDetails.innerHTML = '';
}
