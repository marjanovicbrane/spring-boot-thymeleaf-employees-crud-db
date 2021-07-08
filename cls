[33mcommit 9d6f96741a4e36101ca97bcd47395d26676b8b5b[m[33m ([m[1;36mHEAD -> [m[1;32mmaster[m[33m)[m
Author: Brane Marjanovic <marjanovicbrane93@gmail.com>
Date:   Thu Jul 8 13:03:32 2021 +0200

    Adding update button in list-employees.html with embedded employee Id.

[33mcommit 921c560e93e7a769d383b557083469ded45ca9f7[m
Author: Brane Marjanovic <marjanovicbrane93@gmail.com>
Date:   Wed Jul 7 20:01:55 2021 +0200

    Created new method saveEmployee to save object in database in controller class with mapping /save.We are used annotation @ModelAttribute to bind data from the form.When we submit our data from the form, browser will redirect us to mapping employees/list to prevent duplicate submissions.We also created a new method in JPA Repository findAllByOrderByLastNameAsc using SPRING DATA JPA.This method will sorl our data from db by last name ascending.Spring Data JPA will parse the method name, looks form specific pattern and then creates appropriate query for us.SPRING DATA JPA do this query automatically:from Employee order by lastName asc.

[33mcommit 037364d29154a0beab15630feed446c91f7f88cd[m
Author: Brane Marjanovic <marjanovicbrane93@gmail.com>
Date:   Wed Jul 7 18:34:05 2021 +0200

    Created form employee-form.html for saving employees objects to database.When we submit the form, we calling /employees/save method from controller class.

[33mcommit f3909fae095df08b07e0cd672c31f67dcdbc31fe[m
Author: Brane Marjanovic <marjanovicbrane93@gmail.com>
Date:   Wed Jul 7 16:59:04 2021 +0200

    Created add button in list-employees.html page and also model attribute employee in controller class for mapping /showFormForAdd when we click on that button.

[33mcommit 58da6e19334ba80b765492c8855792264cad147a[m
Author: Brane Marjanovic <marjanovicbrane93@gmail.com>
Date:   Wed Jul 7 12:33:23 2021 +0200

    Created employeeService object so we can do constructor injection to delegate calls from controller layer to service layer to DAO layer.We also created index.html page to automatically redirect to /employees/list mapping when we star our app.

[33mcommit e51f99bcd46a35390e7bf8db5550c6384ae50aa4[m
Author: Brane Marjanovic <marjanovicbrane93@gmail.com>
Date:   Wed Jul 7 11:37:09 2021 +0200

    This is SERVICE LAYER.We created class EmployeeServiceImpl which implements interface EmployeeService.This class with CRUD methods delegate calls to DAO class EmployeeRepository which using SPRING DATA JPA, so we created constructor injection in EmployeeServiceImpl class.
