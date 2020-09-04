// This class implements a very simple instantiation, a file, which can be changed,
// and a teamBuilder that builds the teams
// Benjamin Ramon
// 827002250
// bramon24@tamu.edu

package driver;

import java.io.*;

public class Driver {
    public static void main(String[] args) throws IOException {
        String file = "CSCE 314 Spring 2020 Project 1 Survey Data  - Form Responses 1.csv";
        TeamBuilder teamMaker = new TeamBuilder(file);
        teamMaker.buildTeams();
    }
}
