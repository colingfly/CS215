//Colin Gibbons-Fly
// Project 2
//February 6, 2014
// The Student class contains 4 instance variables, is immutable, has 2 constructors and 5 additional methods

// Defines a Student class to model student information and honor society eligibility
public class Student {
    // Private instance variables to hold student's name, credit hours, and quality points
    private String studentName;
    private int creditHours;
    private int qualityPoints;
    // Static variable to hold the GPA threshold for honor society eligibility
    private static double gpaThreshold = 3.0;

    // Default constructor
    public Student(){
        // Intentionally left blank to allow creation of Student objects without setting properties initially
    }

    // Constructor to initialize Student objects with name, credit hours, and quality points
    public Student(String studentName, int creditHours, int qualityPoints) {
        this.studentName = studentName;
        this.creditHours = creditHours;
        this.qualityPoints = qualityPoints;
    }

    // Method to calculate and return the student's GPA
    public double gpa() {
        double gpa = (double) qualityPoints / creditHours; // Cast to double to ensure floating point division
        return gpa;
    }

    // Method to determine if the student is eligible for the honor society based on GPA
    public boolean eligibleForHonorSociety(){
        return gpa() > gpaThreshold; // Returns true if the student's GPA exceeds the threshold
    }

    // Overrides the Object class's toString method to provide a string representation of the Student object
    public String toString() {
        return "Name: " + studentName + " GPA: " + gpa(); // Includes the student's name and calculated GPA
    }
    
    // Static method to set the GPA threshold for honor society eligibility
    public static void setGpaThreshold(double gpaThreshold) {
        Student.gpaThreshold = gpaThreshold; // Allows adjustment of the threshold for all Student objects
    }

    // Static method to get the current GPA threshold for honor society eligibility
    public static double getGpaThreshold() {
        return gpaThreshold; // Returns the current GPA threshold
    }
    
}
