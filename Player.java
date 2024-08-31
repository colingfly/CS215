//Colin Gibbons-Fly
// Project 1
//January 23, 2014
// The Player class contains 3 instance variables, is immutable, has 1 constructor and 2 additional methods

public class Player { //create Player class
    private final String name; //initialize name variable for player
    private final Height height; // initiaize height variable for player
    private final int age; // initialize age variable for player

    public Player(String name, Height height, int age) { //Constructor creating Player object with name, height and age
        this.name = name;
        this.height = height;
        this.age = age;
    }

    public String getName() { //method to return players Name 
        return name; 
    }

    public Height getHeight() { //method to return players Height 
        return height;
    }

    public int getAge() { //method to return players Age 
        return age;
    }

    @Override //overriding method from Object superclass
    public String toString() { //create toString method
        return "Name: " + name + ", Height: " + height.toString() + ", Age: " + age; //return specified data as a string
    }
    
}
