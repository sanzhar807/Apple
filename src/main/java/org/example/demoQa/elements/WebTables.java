package org.example.demoQa.elements;

import org.example.demoQa.models.Employee;
import org.example.demoQa.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

public class WebTables extends BasePage {

    @FindBy(id = "addNewRecordButton")
    private WebElement addBtn;

    @FindBy(id = "firstName")
    private WebElement firstName;
    @FindBy(id = "lastName")
    private WebElement lastName;
    @FindBy(id = "userEmail")
    private WebElement userEmail;
    @FindBy(id = "age")
    private WebElement age;
    @FindBy(id = "salary")
    private WebElement salary;
    @FindBy(id = "department")
    private WebElement department;
    @FindBy (id = "submit")
    private WebElement submit;
    @FindBy(className = "rt-tr-group")
    private List<WebElement> rowsList;
    @FindBy(xpath = "//label[@id]")
    private List<WebElement> usersElements;
    @FindBy(id = "edit-record-1")
    private WebElement editRecord1;

    public WebTables clickEdit(){
        elementActions.waitElementToBeClickable(editRecord1);
        return this;
    }

    public WebTables clickAdd(){
        elementActions.clickBtn(addBtn);
        return this;
    }

    public WebTables firstName (String name){
        elementActions.inputText(firstName,name);
        return this;
    }

    public WebTables lastName (String name){
        elementActions.inputText(lastName,name);
        return this;
    }

    public WebTables email (String name){
        elementActions.inputText(userEmail,name);
        return this;
    }

    public WebTables age (String ageUser){
        elementActions.inputText(age,ageUser);
        return this;
    }

    public WebTables salary (String name){
        elementActions.inputText(salary,name);
        return this;
    }

    public WebTables department (String name){
        elementActions.inputText(department,name);
        return this;
    }

    public WebTables submit(){
        elementActions.clickBtn(submit);
        return this;
    }

    public WebTables addNewEmployee(Employee employee){

        for (Employee element : getEmployeeFromTable()){
                if (element.getFirstName().equalsIgnoreCase(employee.getFirstName()) &&
                        element.getLastName().equalsIgnoreCase(employee.getLastName())) {
                    throw new IllegalArgumentException("This employee already created");
                }else{
                    getEmployeeFromTable().add(employee);
                }
        }
        return this;
    }

    public void changeElement(String element,String text){
        clickEdit();
        for (WebElement el:usersElements){
            if (el.getText().equalsIgnoreCase(element)){
               // WebElement element1 =
                elementActions.inputText(el,text);
                break;
            }
        }
    }

    public ArrayList<Employee> getEmployeeFromTable(){
        ArrayList<Employee> employees = new ArrayList<>();

        for(WebElement row: rowsList){
            List<WebElement> cells = row.findElements(By.className("rt-td"));

            String firstName = cells.getFirst().getText();
            String lastName = cells.get(1).getText();
            String ageText = cells.get(2).getText().replaceAll("[^0-9]","");
            String email = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]","");
            String department = cells.get(5).getText();

            if(firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || email.isEmpty() ||
                    salaryText.isEmpty() || department.isEmpty()){
                continue;
            }

            int age = Integer.parseInt(ageText.trim());
            int salary = Integer.parseInt(salaryText.trim());



            employees.add(new Employee(firstName,lastName,age,email,
                    salary,department));

        }
        return employees;
    }
}
