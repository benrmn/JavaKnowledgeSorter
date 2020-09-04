// This class implements two basic functions, reading from our file, and outputting results
// Benjamin Ramon
// 827002250
// bramon24@tamu.edu

package driver;

import com.intellij.openapi.vcs.history.VcsRevisionNumber;

import java.io.*;
import java.util.*;

public class Utility {
    // members
    public ArrayList<CMSC314Student> allStudents;
    public ArrayList<CMSC314Student> sorted;
    public ArrayList<CMSC314Student> subs;

    // constructor
    Utility() throws IOException {
        this.allStudents = new ArrayList<CMSC314Student>();
        this.sorted = new ArrayList<CMSC314Student>();
        this.subs = new ArrayList<CMSC314Student>();
    }
    // getters
    public ArrayList<CMSC314Student> getAllStudents() {
        return this.allStudents;
    }
    public ArrayList<CMSC314Student> getSorted() {
        return this.sorted;
    }
    public ArrayList<CMSC314Student> getSubs() {
        return this.subs;
    }

    // setters
    public void setAllStudents(ArrayList<CMSC314Student> a) {
        this.allStudents = a;
    }
    public void setSorted(ArrayList<CMSC314Student> a) {
        this.sorted = a;
    }
    public void setSubs(ArrayList<CMSC314Student> a) {
        this.subs = a;
    }

    // functions
    public boolean readFile(String filename, ArrayList<CMSC314Student> students) throws FileNotFoundException {
        students = new ArrayList<CMSC314Student>();
        // set std error to file
        PrintStream writer = new PrintStream("errors.txt");
        System.setErr(writer);
        Scanner infile = null;
        // catches invalid file name
        try {
            infile = new Scanner(new FileReader(filename));
        } catch (FileNotFoundException e) {
            writer.println("File Not Found Exception, please enter a valid file name");
        }
        int java; String fullName; String sec;
        String email; int rank; int section;
        String[] name;
        String[] uin;
        String[] secT;
        String firstName, lastName, UIN;
        int i = 0; // variable to count indicies of students
        String headerLine = infile.nextLine();
        int lineNum = 2; // ignore first line, need to offset indexing of file
        while (infile.hasNextLine()) {
            String curLine = infile.nextLine();
            String[] threaded = curLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            // catches invalid java knowledge
            try {
                java = Integer.parseInt(threaded[1]);
            } catch (IllegalArgumentException e) {
                writer.println("Illegal Argument Exception at line: "+lineNum);
                continue;
            }
            fullName = threaded[4];
            name = fullName.split(" ");
            firstName = name[0];
            lastName = name[1];
            sec = threaded[5];
            secT = sec.split(" ");
            // catches invalid section number
            try {
                section = Integer.parseInt(secT[0]);
            } catch (IllegalArgumentException e) {
                writer.println("Illegal Argument Exception at line: "+lineNum);
                continue;
            }
            email = threaded[6];
            uin = email.split("@");
            UIN = uin[0];
            // catches invalid rank
            try {
                rank = Integer.parseInt(threaded[7]);
            } catch (IllegalArgumentException e) {
                writer.println("Illegal Argument Exception at line: "+lineNum);
                continue;
            }
            // adds student to array
            students.add(i, new CMSC314Student(firstName, lastName, rank, UIN, java, section));
            i++;
            lineNum++;
        }
        this.allStudents = students;
        return true;
    }

    public boolean writeResults(ArrayList<CMSC314Student> pairs, ArrayList<CMSC314Student> extras) throws IOException {
        PrintWriter outfile = null;
        try {
            FileWriter out = new FileWriter("results.txt", false);
            outfile = new PrintWriter(out);
            int section;
            String fname1, lname1;
            String fname2, lname2;
            int score1, score2;
            outfile.println("All students with a partner (pairs)");
            outfile.println("--------------------------------------------");
            // outputs all paired students to file
            for (int i = 0; i < pairs.size(); i+=2) {
                section = pairs.get(i).getSection();
                fname1 = pairs.get(i).getFirstName();
                lname1 = pairs.get(i).getLastName();
                score1 = pairs.get(i).getJavaKnowledge();
                //System.out.println(section+fname1+lname1+score1);
                fname2 = pairs.get(i+1).getFirstName();
                lname2 = pairs.get(i+1).getLastName();
                score2 = pairs.get(i+1).getJavaKnowledge();
                //System.out.println(section+" - "+fname1+" "+lname1+" ("+score1+") "+fname2+" "+lname2+" ("+score2+")");
                outfile.println(section+" - "+fname1+" "+lname1+" ("+score1+") "+fname2+" "+lname2+" ("+score2+")");

            }
            outfile.println("--------------------------------------------");
            outfile.println("All students without a partner (substitutes)");
            outfile.println("--------------------------------------------");
            // outputs all substitutes to file
            for (CMSC314Student extra : extras) {
                section = extra.getSection();
                fname1 = extra.getFirstName();
                lname1 = extra.getLastName();
                score1 = extra.getJavaKnowledge();
                //System.out.println(section+" - "+fname1+" "+lname1+" ("+score1+")");
                outfile.println(section + " - " + fname1 + " " + lname1 + " (" + score1 + ")");
            }
            outfile.close();
        } catch (FileNotFoundException e) {
            System.exit(0);
        }
        return true;
    }
}
