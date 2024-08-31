//Colin Gibbons-Fly
// Project 2
//February 6, 2014
// The Project2 Class is the main class containing the main method
//Project2 pulls in data from the Student superclass, and Undergraduate / Graduate subclasses


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Main class for the honor society eligibility project
public class Project2 {
    public static void main(String[] args) {

        // ArrayList to store Student objects
        ArrayList<Student> students = new ArrayList<>();
        // Variables to calculate the average GPA
        double totalGpa = 0;
        double studentCount = 0;
        // Constant for the maximum possible GPA
        final double MAX_GPA = 4.0;

        try {
            // Attempt to open and read from the file "students.txt"
            File file = new File("students.txt");
            Scanner input = new Scanner(file);

            // Loop through each line of the file, representing a student's information
            while (input.hasNextLine()) {
                String line = input.nextLine();
                // Split the line into parts: name, credit hours, quality points, and year/degree
                String[] parts = line.split(" ");
                // Replace commas in the name with spaces for correct formatting
                String name = parts[0].replace(',', ' ');
                // Parse credit hours and quality points as integers
                int creditHours = Integer.parseInt(parts[1]);
                int qualityPoints = Integer.parseInt(parts[2]);
                // The last part represents either the year for undergraduates or degree for graduates
                String yearOrDegree = parts[3];

                // Determine if the student is an undergraduate or graduate based on yearOrDegree
                Student student;
                if (yearOrDegree.equals("Junior") || yearOrDegree.equals("Senior") ||
                    yearOrDegree.equals("Sophomore") || yearOrDegree.equals("Freshman")) {
                    student = new Undergraduate(name, creditHours, qualityPoints, yearOrDegree);
                } else {
                    student = new Graduate(name, creditHours, qualityPoints, yearOrDegree);
                }

                // Add the student to the ArrayList and update GPA calculations
                students.add(student);
                totalGpa += student.gpa();
                studentCount++;
            }

            // Close the file after reading
            input.close();

            // Compute the average GPA and set the GPA threshold for honor society eligibility
            double averageGpa = totalGpa / studentCount;
            // The threshold is the midpoint between the average GPA and the maximum GPA of 4.0
            double gpaThreshold = (averageGpa + MAX_GPA) / 2;
            Student.setGpaThreshold(gpaThreshold);

            // Output the GPA threshold
            System.out.println("GPA Threshold for Honor Society: " + gpaThreshold);

            // Display the students eligible for the honor society
            System.out.println("Students eligible for the Honor Society:");
            for (Student s : students) {
                if (s.eligibleForHonorSociety()) {
                    System.out.println(s.toString());
                }
            }

        } catch (FileNotFoundException e) {
            // Handle the case where the "students.txt" file does not exist
            System.err.println("Error: The file students.txt was not found.");
        }
    }
}
