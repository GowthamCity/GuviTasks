package task4;

class AgeNotWithinRangeException extends Exception {
    public AgeNotWithinRangeException(String message) {
	        super(message);
    }
}
	
class NameNotValidException extends Exception {
    public NameNotValidException(String message) {
        super(message);
    }
}

	
class Student {
	    private int rollNo;
	    private String name;
	    private int age;
	    private String course;

	    
	    public Student(int rollNo, String name, int age, String course) throws AgeNotWithinRangeException, NameNotValidException {
	        this.rollNo = rollNo;
	        
	        if (age < 15 || age > 21) {
	            throw new AgeNotWithinRangeException("Age should be between 15 and 21.");
	        }
	        this.age = age;
	        
	        if (!name.matches("[a-zA-Z\\s]+")) {
	            throw new NameNotValidException("Name should contain only letters and spaces.");
	        }
	        this.name = name;
	        this.course = course;
	    }

	    
	    public int getRollNo() {
	        return rollNo;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public String getCourse() {
	        return course;
	    }

	    public void setRollNo(int rollNo) {
	        this.rollNo = rollNo;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setAge(int age) throws AgeNotWithinRangeException {
	       
	        if (age < 15 || age > 21) {
	            throw new AgeNotWithinRangeException("Age should be between 15 and 21.");
	        }
	        this.age = age;
	    }

	    public void setCourse(String course) {
	        this.course = course;
	    }
	}

	public class Q1 {
	    public static void main(String[] args) {
	        try {
	            
	            Student student1 = new Student(1, "John Doe", 20, "Computer Science");
	            
	            System.out.println("Student Information:");
	            System.out.println("Roll No: " + student1.getRollNo());
	            System.out.println("Name: " + student1.getName());
	            System.out.println("Age: " + student1.getAge());
	            System.out.println("Course: " + student1.getCourse());
	        } catch (AgeNotWithinRangeException e) {
	            System.out.println("AgeNotWithinRangeException: " + e.getMessage());
	        } catch (NameNotValidException e) {
	            System.out.println("NameNotValidException: " + e.getMessage());
	        }
	    }
	}
