# karolyn_morrow_AriMyreNailShop_capstone
Creating a nail technicians starter business website in an attempt to ease her ability with making and accepting appointments with calendar implementation, the ability for clients to select service add-ons with automatic calculations of services and API integration for connecting to payment service. Clients will have the ability to make an account, if they choose to but also have the ability to continue as a guest. An ability to save and request previous services obtained will be implemented for user ease of appointment setup. Technician will have an admin account for ability to block calendar days if needed and an ability to reach out to clients through website will also be implemented.

# Contents
- Case Study Rubric
- Daily Progress
- User Stories
  - Admin
  - Account holder
- Technical Challenges
- Lessons Learned
- Future Improvements

# Daily Progress
  - June 21st
      - Began adding spring security login from class example
  - June 22nd
      - Able to allow 'continue as guest' accessibility for basic but also guest home and ability to set up an appointment.
      - Fixing registration mapping and saving into database
      - Added 3 error html pages - 403, 404, and 500 under template/html
      - Added LoginController and SignUpController.
      - Set permissions for /registration, /home, /extraServices, and /chooseService
      - ToDO: Figure out why input in form for "/registration" is not being saved into DB. Figure out why photos are not loading in.
  - June 26th
    - Fixed photo loading in issue by ensuring webconfig class knew to ignore security based on .png and .jpg files. Was also able to have JS files work
    - Began working on DOM manipulation for Treatment dropdown
    - Getting assistance from sang as unknown issue why created account is not being saved in DB.
  - June 27th
    - Created account is now saving to DB after fixing validation bug
    - Began working on authentication with security 
    - Began fetch code to obtain data for Treatments
  - June 30th 
    - Authorization works only on second attempt of login with same credentials. 
    - Moved on to continue working on RestController and fetch JS code for Treatments data.
  - July 3rd
    - Fetched data shows through controller. Need to update carousel css and html to show correct data based on name
    - Updated login page css 
    - Updated error page 404 and 500 html
    - Changed websecurityconfig file authorization for fetched data due to issues with login still, will change to SuperAdmin
  - July 8th (85% done)
    - Authorization now works on first attempt
    - Successful default mapping for authorized user
    - Updating CSS for treatment carousel 
  - July 11th (89% done)
    - Successful fetching of data from calendly API
    - Implemented mapping for appointment reading after creation
    - Successful completion of carousel including addition and movement through carousel
  

# User Stories
# Admin
# Account holder
# Technical Challenges
 - Spring Security not registering that my passwords are coming in bcrypt. Updated password encryption in WebConfig class. Password was being registered with String "bcrypt" in front of it for the account creation but not for the POST verification so password technically was not the same.
 - Spring Security is printing a message of ACCESS DENIED BEFORE signing in, even tho .permitAll access is given for login page. Ability to login with created account is successful on second attempt.
 - Browser Firefox is throwing error when attempting to obtain fetched data, whereas browser edge is not throwing error and allowing treatmentCarousel to show RestAPI data.
# Lessons learned
 - Spring Security has its own POST methods for sign in which handle the input of username and password.
 - Creation of GET mapping while needing an authorization token is done through a fetch method via JS code.
 - Reading documentation on how to implement an API's data reading capabilities.
# Future Improvements
 - Providing SuperAdmin CRUD ability to the nail technician for price updates, changing, and/or deleting offered services.
 - Allowing the premium account holders to view past appointments and based on date, allowing to make updates to requested appointments.