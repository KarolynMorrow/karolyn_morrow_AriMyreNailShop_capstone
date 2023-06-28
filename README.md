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

# User Stories
# Admin
# Account holder
# Technical Challenges
# Lessons learned
# Future Improvements