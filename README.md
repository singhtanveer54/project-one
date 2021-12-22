# Project One
* To develop an Expense Reimbursement System, there are two main roles: A Finance Manager role and an Employee role.
  - A Finance Manager should be able to Login, and able to view all reimbursements of all employees.
  - The Finance Manager is the only person who has authority to approve or deny all reimbursements submitted by employees. 
  - A Finance Manager is also able to view all past (Pending, Approved, Rejected) reimubursements. 
  - An employee is able to login and view only their past and current status of their reimbursement. 
  - An employee is also able to submit a new reimbursement accompanied by a reciept that matches the total request and refund of the reimbursement. 

# Technical Requirements
* Postgres as database
* Javalin Framework
* Use of HTML, CSS, and JavaScript to develop front-end view
* Fetch API to communicate between HTTP Requests and HTTP Response
* Passwords must be hashed and secured in the database
* Logback
* JUnit 5 (Jupiter) for Unit Testing, Service Layer should achieve 80% - 90% code coverage.
* Selenium test for all major functionality (logging in as a user, logging out, submitting a reimbursement, logging in as a finance manager) should be accomplished.
# Technologies Used
* PostgreSQL 10 
* DBeaver 
* Javalin 
* Logback
* Tika version (For getting file type)
* Bulma version 
# For Testing
* JUnit 5 (Jupiter) API 
* Mockito
* Selenium
* Cucumber
# Feature
1. As a Finance Manager:
    - Successfully logging in
    - Successfully logging out
    - Approving or Denying a Request is functional
    - Filtering a Reimbursement Request by Status
    - Pending Filter implemented
    - Approved Filter implemented
    - Rejected Filter implemented
    - All Request Status implemented
    
2. As an employee:
    - Successfully logging in
    - Successfully logging out
    - Adding a Reimbursement is functional
    - Viewing of Reimbursement History is functional
    - Successfully uploading an Image for receipt
    - Viewing of an Image after submitting a new Reimbursement
    
3. Added feature outside of MVP (Minimum Viable Product)
    - Creation of new Account/User (Sign up page)
