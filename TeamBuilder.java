// This class implements our workload function team builder.
// Benjamin Ramon
// 827002250
// bramon24@tamu.edu

package driver;

import java.io.*;
import java.util.*;

public class TeamBuilder {
    // members
    protected String file;
    private ArrayList<CMSC314Student> array;
    protected ArrayList<CMSC314Student> sortedPairs;
    protected ArrayList<CMSC314Student> subs;
    protected Utility nU;

    // constructor
    TeamBuilder(String file) throws IOException {
        this.file = file;
        this.nU = new Utility();
        this.array = new ArrayList<CMSC314Student>();
        this.sortedPairs = new ArrayList<CMSC314Student>();
        this.subs = new ArrayList<CMSC314Student>();
    }

    // getters
    public ArrayList<CMSC314Student> getSortedPairs() {
        return this.sortedPairs;
    }
    public ArrayList<CMSC314Student> getSubs() {
        return this.subs;
    }
    public String getFile() {
        return this.file;
    }

    //setters
    public void setFile(String file) {
        this.file = file;
    }
    public void setSortedPairs(ArrayList<CMSC314Student> sortedPairs) {
        this.sortedPairs = sortedPairs;
    }
    public void setSubs(ArrayList<CMSC314Student> subs) {
        this.subs = subs;
    }

    // functions
    public void buildTeams() throws IOException {
        // most of actual work done here, sorting, pairing, and outputting
        this.nU.readFile(this.file, this.array);
        this.array = this.nU.getAllStudents();
        // sorts array using our comparator
        array.sort(new JavaKnowledgeComparator());
        this.sortedPairs = this.nU.getSorted();
        this.subs = this.nU.getSubs();
        ArrayList<Integer> changesSec = new ArrayList<Integer>();
        changesSec.add(0);
        // first initial iteration to add all index when the section changes
        // made sure this worked when adding another section as well
        for (int i = 0; i < array.size(); i++) {
            // if statement to avoid out of bounds error
            if (i == array.size()-1) break;
            else {
                // we want to only save the index when there is a change in sections
                if (array.get(i).getSection() != array.get(i+1).getSection()) {
                    // add new section index
                    changesSec.add(i+1);
                }
            }
        }
        ArrayList<Integer> sections = new ArrayList<Integer>();
        // loops through our changes of section and saves the actual section to a section array
        for (Integer a: changesSec) {
            sections.add(array.get(a).getSection());
        }
        changesSec.add(array.size()-1);

        // bounds of where sections are declared
        int start = 0;
        int end;
        // basically looking at one section at a time, then performing a sorting algorithm on the section
        for (Integer line: changesSec) {
            end = line - 1;
            while (start <= end) {
                // we only have valid student in our array, so if there is a odd person out,
                // they become a substitute
                if (start == end) {
                    subs.add(array.get(start));
                    break;
                }
                sortedPairs.add(array.get(start++));
                sortedPairs.add(array.get(end--));
            }
            start = line;
        }
        // calls write results to output data to file
        this.nU.writeResults(this.sortedPairs,this.subs);
    }

}
