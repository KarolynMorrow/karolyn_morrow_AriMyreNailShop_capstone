$(document).ready(function(){
//fetch treatment data from the server
$.get('/api/treatments', function(data){
//create the carousel slides dynamically on the treatments
let carouselInner = $('#treatmentCarousel .carousel-inner');
$.each(data, function(index, treatment){
let slide = $('<div>').addClass('carousel-item');
if (index === 0) {
slide.addClass('active');
}
slide.append($('<h2>').text(treatment.serviceName));
slide.append($('<p>').text(treatment.description));
slide.append($('<p>').text('Price: ' + treatment.servicePrice));
carouselInner.append(slide);

});
//Activate the carousel
$('#treatmentCarousel').carousel();

});


});