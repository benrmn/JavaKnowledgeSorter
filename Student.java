// This class implements the extended parent class, allows a person to have
// a rank, and a uin
// Benjamin Ramon
// 827002250
// bramon24@tamu.edu

package driver;

public class Student extends Person {
    // members
    enum Rank {FRESHMAN, SOPHOMORE, JUNIOR, SENIOR}
    Rank R;
    protected String UIN;

    // constructors
    Student(String fname, String lname, int rank, String uin) {
        super(fname, lname);
        switch(rank) {
            case 1: this.R = Rank.FRESHMAN; break;
            case 2: this.R = Rank.SOPHOMORE; break;
            case 3: this.R = Rank.JUNIOR; break;
            case 4: this.R = Rank.SENIOR; break;
        }
        this.UIN = uin;
    }

    // setters
    public void setRank(int rank) {
        switch(rank) {
            case 1: this.R = Rank.FRESHMAN; break;
            case 2: this.R = Rank.SOPHOMORE; break;
            case 3: this.R = Rank.JUNIOR; break;
            case 4: this.R = Rank.SENIOR; break;
        }
    }
    public void setUIN(String uin) {
        this.UIN = uin;
    }

    // getters
    public Rank getRank() {
        return this.R;
    }
    public String getUIN() {
        return this.UIN;
    }

    // to string
    @Override
    public String toString() {
        return "First name: " + getFirstName() + " Last name: " + getLastName() + " Rank: " +
                getRank() + " UIN: " + getUIN();
    }
}
