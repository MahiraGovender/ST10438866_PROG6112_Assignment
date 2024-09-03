package assignment_q1;

import java.util.*;
public class Student {
     ArrayList<String> name = new ArrayList<String>();
        
     ArrayList<String> email = new ArrayList<String>();
        
     ArrayList<Integer> age = new ArrayList<Integer>();
        
     ArrayList<String> courses = new ArrayList<String>();
        
     ArrayList<String> ID = new ArrayList<String>();
     
     //Referancing arraylists
     /************************************************************
     *********************************************************
     Title: Create ArrayList from array
     Author: Christoffer Hammarström, StackOverflow
     Date: 2022
     Code version: 2.0
     Availability: https://stackoverflow.com/questions/157944/create-arraylist-from-array
     *********************************************************
     *************************************************************/
    Scanner input = new Scanner(System.in);
    
    public Student() {
        
    }
    
    public void intro() {
        System.out.println("STUDENT MANAGEMENT SYSTEM");
         System.out.println("**********************************");
       ExitStudentApplication();
    }
    
    //Menu
    private void menu() {
        String menu;
             while (true) {
             System.out.println(""" 
                              Please select one of the menu options
                              (1) Capture a new student
                              (2) Search for a student
                              (3) Delete a student
                              (4) Print student report
                              (5) Exit application """);
             menu = input.next();
             
             switch(menu) {
                 case "1":
                     SaveStudent();
                    break;
                     
                 case "2":
                     SearchStudent();
                     break;
                     
                 case "3":
                     DeleteStudent();
                     break;
                     
                 case "4":
                     StudentReport();
                     break;
                     
                 case "5":
                     System.exit(0); //exit
                     break;
                     
                 default:
                     System.out.println("Error please input a number 1-5\n"); //Error handling
                     break;
             }
           } 
    }
    
    //Entering data on a new student
    public void SaveStudent() {
               
        while (true) {
        System.out.println("CAPUTE A NEW STUDENT");
        System.out.println("***************************");
        
        System.out.println("Enter the student ID: ");
        String id = input.next();
        ID.add(id);
        
        System.out.println("Enter the student Name: ");
        String Name = input.next();
        name.add(Name);
        
       do {
    try {
            System.out.println("Enter the student Age: ");
            int Age = Integer.parseInt(input.next());

            if (Age < 16) {
                throw new NumberFormatException();
            }else {
                age.add(Age);
                break;
            }
        } catch (NumberFormatException e) {
        System.out.println("You have entered an incorrect student age!!!");
        System.out.println("Please re-enter the student's age ");
        }
    } while (true);
        
        System.out.println("Enter the student Email: ");
        String Email = input.next();
        email.add(Email);
        
        System.out.println("Enter the student Course: ");
        String Course = input.next();
        courses.add(Course);
        
        System.out.println("Student details have been successfully saved!");
        break;
        }
        ExitStudentApplication();
    }
    
    //Looks up students via ID's
    public void SearchStudent() {
        System.out.println("SEARCH FOR A STUDENT");
        System.out.println("***************************");
        System.out.println("Enter the student id to search: ");
        String searchID = input.next();
        
        if(ID.contains(searchID)) {
            int index = ID.indexOf(searchID);
            System.out.println("STUDENT ID: " + ID.get(index));
            System.out.println("STUDENT NAME: " + name.get(index));
            System.out.println("STUDENT AGE: " + age.get(index));
            System.out.println("STUDENT EMAIL: " + email.get(index));
            System.out.println("STUDENT COURSE: " + courses.get(index));
        }
        else {
            System.out.println("Student with ID: " + searchID + " was not found!");
        }
        ExitStudentApplication();
    }
    
    //Deletes student data
    public void DeleteStudent() {
        System.out.println("DELETE A STUDENT");
        System.out.println("***************************");
        System.out.println("Enter the student id to delete: ");
        String deleteID = input.next();
        
        if(ID.contains(deleteID)) {
            int index = ID.indexOf(deleteID);
            System.out.println("Are you sure you want to delete student with ID: " + deleteID + " (y/n): ");
            String confirm = input.next();
            if (confirm.toLowerCase().equals("y")) {
                ID.remove(index);
                name.remove(index);
                age.remove(index);
                email.remove(index);
                courses.remove(index);
                System.out.println("Student with ID: " + deleteID + " was successfully deleted!");
            } else {
                System.out.println("Student with ID: " + deleteID + " was not deleted!");
            }
        }
        else {
            System.out.println("Student with ID: " + deleteID + " was not found!");
        }
      ExitStudentApplication();
    }
    
    //Display everything saved
    public void StudentReport() {
        System.out.println("STUDENT REPORT");
        System.out.println("***************************");
        if (ID.isEmpty()) {
            System.out.println("No students have been added yet!");
        }
        else {
            for (int i = 0; i < ID.size(); i++) {
                System.out.println("STUDENT " + (i+1));
                System.out.println("***************************");
                System.out.println("STUDENT ID: " + ID.get(i));
                System.out.println("STUDENT NAME: " + name.get(i));
                System.out.println("STUDENT AGE: " + age.get(i));
                System.out.println("STUDENT EMAIL: " + email.get(i));
                System.out.println("STUDENT COURSE: " + courses.get(i));
                System.out.println("***************************");
            }
        }
       ExitStudentApplication();
    }
    
    //Exits app
    public void ExitStudentApplication() {
        System.out.println("Enter (1) to launch menu or any other key to exit");
        String launchMenu = input.next();
         if (launchMenu.contains("1")) {
              menu();
             
         }
         
         else if(!launchMenu.contains("1")){
            System.exit(0);
         }
    }
    
    //Updating student info that has been saved already
    public void UpdateStudentInfo() {
    System.out.println("UPDATE STUDENT INFO");
    System.out.println("***************************");
    System.out.println("Enter the student id to update: ");
    String updateID = input.next();

    if (ID.contains(updateID)) {
        int index = ID.indexOf(updateID);
        System.out.println("STUDENT ID: " + ID.get(index));
        System.out.println("STUDENT NAME: " + name.get(index));
        System.out.println("STUDENT AGE: " + age.get(index));
        System.out.println("STUDENT EMAIL: " + email.get(index));
        System.out.println("STUDENT COURSE: " + courses.get(index));

        System.out.println("Enter new student name (or press enter to keep current): ");
        String newName = input.next();
        if (!newName.isEmpty()) {
            name.set(index, newName);
        }

        System.out.println("Enter new student age (or press enter to keep current): ");
        String newAge = input.next();
        if (!newAge.isEmpty()) {
            int ageValue = Integer.parseInt(newAge);
            if (ageValue >= 16) {
                age.set(index, ageValue);
            } else {
                System.out.println("Age must be 16 or above. Please try again.");
                UpdateStudentInfo(); // Re-enter age
            }
        }

        System.out.println("Enter new student email (or press enter to keep current): ");
        String newEmail = input.next();
        if (!newEmail.isEmpty()) {
            email.set(index, newEmail);
        }

        System.out.println("Enter new student course (or press enter to keep current): ");
        String newCourse = input.next();
        if (!newCourse.isEmpty()) {
            courses.set(index, newCourse);
        }

        System.out.println("Student info has been successfully updated!");
    } else {
        System.out.println("Student with ID: " + updateID + " was not found!");
    }
    ExitStudentApplication();
}
    
}