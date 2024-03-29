//make a button with an onClick that will call this global fetch from html
fetch('https://api.calendly.com/scheduled_events/?user=https://api.calendly.com/users/1d60d996-da2f-47c8-9877-1cb26c6340df', {

//makes a get method, due to security for the auth token, instead of putting it in controller
method:"GET",
headers:{
"Authorization":`Bearer eyJraWQiOiIxY2UxZTEzNjE3ZGNmNzY2YjNjZWJjY2Y4ZGM1YmFmYThhNjVlNjg0MDIzZjdjMzJiZTgzNDliMjM4MDEzNWI0IiwidHlwIjoiUEFUIiwiYWxnIjoiRVMyNTYifQ.eyJpc3MiOiJodHRwczovL2F1dGguY2FsZW5kbHkuY29tIiwiaWF0IjoxNjg5MTA5OTM2LCJqdGkiOiJkOTgzZDliMy1mZjZjLTQxMDYtYmU2ZC1kODA1NjQ0MGRkMGUiLCJ1c2VyX3V1aWQiOiIxZDYwZDk5Ni1kYTJmLTQ3YzgtOTg3Ny0xY2IyNmM2MzQwZGYifQ.F5fKqJXzzke5Rf_l4ASfciWksK9IpuADhWbIE3bHle0ObhEgTqosEoFBEdQ6ADhHvbcieRfS3yZgSYwSVBF5Aw`
}
})

.then(response => response.json())
.then(data => console.log(data.collection))
.catch(error => console.log(error))


//Fetch request is pulling the data. Then using JavaScript you can dynamically fill your table with that data
const populateTable = async () => {
    const tableBody = document.querySelector('#appointmentTable tbody')
    while (tableBody.firstChild){
    tableBody.removeChild(tableBody.firstChild)
    };

    try{
        const data = await response.json();

        data.collection.forEach((item) => {
            const row = document.createElement('tr');
            const dateCell = document.createElement('td');
            const treatmentCell = document.createElement('td');

            const dateText = document.createTextNode(item.start_date);

            dateCell.appendChild(dateText);
            row.appendChild(dateCell);

            tableBody.appendChild(row);

        });
        } catch (error){
            console.error('Error fetching data:', error);

        }

    };

    populateTable();
