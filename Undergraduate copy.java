//Colin Gibbons-Fly
// Project 2
//February 6, 2014
// The Undergraduate class extends Student, contains 1 instance variables, is immutable, has 1 constructors and 2 methods

// Extends the Student class to model undergraduate student specifics
public class Undergraduate extends Student {
    // Private instance variable to hold the student's academic year
    private String year;
    
    // Constructor to initialize Undergraduate objects with student name, credit hours, quality points, and academic year
    public Undergraduate(String studentName, int creditHours, int qualityPoints, String year) {
        super(studentName, creditHours, qualityPoints); // Calls the superclass (Student) constructor to initialize common fields
        this.year = year; // Sets the specific year field for the undergraduate
    }

    // Overrides the eligibleForHonorSociety method from Student to implement specific eligibility logic
    @Override
    public boolean eligibleForHonorSociety(){
        // Inherits the GPA calculation from the superclass and compares it against the honor society GPA threshold
        // The logic to determine eligibility could include additional conditions specific to undergraduates if needed
        return super.gpa() > Student.getGpaThreshold(); // Directly uses the superclass method to get GPA and compares it to the static GPA threshold
    }

    // Overrides the toString method to include the undergraduate's academic year in the string representation
    @Override
    public String toString() {
        // Calls the superclass toString method and appends the academic year information
        return super.toString() + " Year: " + this.year;
    }
}
