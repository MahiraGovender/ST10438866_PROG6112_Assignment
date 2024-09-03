package assignment_q1;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StudentTest {
    
    public StudentTest() {}

    Student student = new Student();    
    
    //student details
    int age = 20;
    String ID = "12345";
    String name = "Joe";
    String email = "Joe@gmail.com";
    String course = "BCAD";
     
    @Test
    public void saveStudent() 
    {
        student.ID.add(ID);
        student.name.add(name);
        student.age.add(age);
        student.email.add(email);
        student.courses.add(course);
        
        assertTrue(student.ID.contains(ID));
        assertTrue(student.name.contains(name));
        assertTrue(student.age.contains(age));
        assertTrue(student.email.contains(email));
        assertTrue(student.courses.contains(course));

    }
    
@Test
    public void deleteStudent() 
    {
        String searchID = ID;
        
        boolean studentFound = false;
        
        for (int i = 0; i < student.ID.size(); i++) {
            if (student.ID.get(i) == searchID) {
                studentFound = true;
                student.ID.remove(i);
                student.name.remove(i);
                student.email.remove(i);
                student.age.remove(i);
                student.courses.remove(i);
                break;
            }
        }
        
        StringBuilder actual = new StringBuilder();
        actual.append(student.ID.toString());
        actual.append(student.name.toString());
        actual.append(student.email.toString());
        actual.append(student.age.toString());
        actual.append(student.courses.toString());
        
        String expected = "[][][][][]";

        assertEquals(expected, actual.toString());
        
    }
    
    @Test
    public void deleteStudentNotFound() 
    {
        int searchID = 78940;
 boolean studentFound = false;
        
        for (int i = 0; i < student.ID.size(); i++) {
            if (student.ID.get(i).equals(searchID)) {
                studentFound = true;
                student.ID.remove(i);
                student.name.remove(i);
                student.email.remove(i);
                student.age.remove(i);
                student.courses.remove(i);
                break;
            }
        }
        
        
    }
    
    @Test
    public void searchStudent()
    {
    student.ID.add(ID);
    student.name.add(name);
    student.age.add(age);
    student.email.add(email);
    student.courses.add(course);

    String searchID = ID;
    boolean studentFound = false;

    for (int i = 0; i < student.ID.size(); i++) {
        if (student.ID.get(i).equals(searchID)) {
            studentFound = true;
            assertEquals(name, student.name.get(i));
            assertEquals(age, student.age.get(i));
            assertEquals(email, student.email.get(i));
            assertEquals(course, student.courses.get(i));
            break;
 }
    }
    assertTrue(studentFound,searchID);

    }
    
     @Test
    public void searchStudentNotFound()
    {
        String searchID = "98765"; 
        boolean studentFound = false;

        for (String id : student.ID) {
            if (id.equals(searchID)) {
                studentFound = true;
                break;
            }
    }
    assertFalse(studentFound, searchID);

    }
    
    @Test
    public void captureStudentAge()
    {
        int validAge = 18;
        student.age.add(validAge);
        assertTrue(student.age.contains(validAge));
    }
    
    @Test
    public void captureStudentAge_InvalidAge()
    {
        int invalidAge = 15;
        try {
            student.age.add(invalidAge);
        } catch (NumberFormatException e) {
assertFalse(student.age.contains(invalidAge));
        }
    }
    
    @Test
    public void captureStudentAge_InvalidChar()
    {
        String invalidAge = "abc"; 

    boolean exceptionThrown = false;

    try {
        int ageValue = Integer.parseInt(invalidAge);
        student.age.add(ageValue);
    } catch (NumberFormatException e) {
        exceptionThrown = true; 
    }

    assertTrue(exceptionThrown);
    }
}
