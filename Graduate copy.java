//Colin Gibbons-Fly
// Project 2
//February 6, 2014
// The Graduate class extends Student, contains 1 instance variables, is immutable, has 1 constructors and 2 methods

// Defines a Graduate class that extends the Student class to incorporate graduate-specific information
public class Graduate extends Student {
    // Private instance variable to hold the type of graduate degree being pursued (e.g., Master's, Doctorate)
    private String degree;

    // Constructor to initialize Graduate objects with student name, credit hours, quality points, and degree type
    public Graduate(String studentName, int creditHours, int qualityPoints, String degree) {
        super(studentName, creditHours, qualityPoints); // Calls the superclass (Student) constructor to set common attributes
        this.degree = degree; // Sets the degree type specific to the graduate student
    }

    // Overrides the eligibleForHonorSociety method to determine eligibility specifically for graduate students
    @Override
    public boolean eligibleForHonorSociety(){
        // Uses the superclass method to calculate GPA and checks it against the honor society GPA threshold
        // This could be expanded to include additional eligibility criteria specific to graduate students
        return super.gpa() > Student.getGpaThreshold(); // Directly compares the calculated GPA to the static GPA threshold
    }

    // Overrides the toString method to add the graduate student's degree type to the string representation
    @Override
    public String toString() {
        // Concatenates the string representation from the superclass with the degree type information
        return super.toString() + " Degree: " + this.degree;
    }
}

