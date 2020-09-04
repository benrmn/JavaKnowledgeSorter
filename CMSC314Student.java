// This class implements the extended student class, allows a person to have
// java knowledge and a section number
// Benjamin Ramon
// 827002250
// bramon24@tamu.edu

package driver;

public class CMSC314Student extends Student {
    // members
    protected int JavaKnowledge;
    protected int section;

    // constructor
    CMSC314Student(String fname, String lname, int rank, String uin, int java, int sec) {
        super(fname, lname, rank, uin);
        this.JavaKnowledge = java;
        this.section = sec;
    }

    // setters
    public void setJavaKnowledge(int javaknow) {
        this.JavaKnowledge = javaknow;
    }
    public void setSection(int sec) {
        this.section = sec;
    }

    // getters
    public int getJavaKnowledge() {
        return this.JavaKnowledge;
    }
    public int getSection() {
        return this.section;
    }

    // to string
    @Override
    public String toString() {
        return "First name: " + getFirstName() + ", Last name: " + getLastName() + ", Rank: " +
                getRank() + ", UIN: " + getUIN() + ", JavaKnowledge: (" + getJavaKnowledge() + "), section: " + getSection();
    }
}
