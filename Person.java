// This class implements the main person class, which has two child classes
// Benjamin Ramon
// 827002250
// bramon24@tamu.edu

package driver;

public abstract class Person {
    // members
    protected String firstName;
    protected String lastName;

    //constructors
    Person(String fname, String lname) {
        this.firstName = fname;
        this.lastName = lname;
    }

    //setters
    public void setFirstName(String fName) {
        this.firstName = fName;
    }
    public void setLastName(String lName) {
        this.lastName = lName;
    }

    //getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    // to string
    @Override
    public String toString() {
        return "First name: " + getFirstName() + " Last name: " + getLastName();
    }
}
