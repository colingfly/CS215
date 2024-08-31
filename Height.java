//Colin Gibbons-Fly
// Project 1
//January 23, 2014
// The Height class containts to integer variables, is immutable, has 1 constructor and 2 additional methods

public class Height { // create Height class
    private int feet; //intialize feet variable
    private int inches; // intitialize inches variable

    public Height(int feet, int inches) { // Constructor creating Height object with feet and inches
        this.feet = feet + inches / 12; // if inches is greater than 12, converted to feet
        this.inches = inches % 12; // remaining inches after dividing by 12
    }

    public int toInches() { //method converting height to inches
        return (feet * 12) + inches; //multiplies feet by 12 and adds inches
    }

    @Override //overriding method from Object superclass
    public String toString() { //create toString method
        return feet + " feet " + inches + " inches" + " / " + toInches() + " inches"; //return specified data as a string
    }
}
