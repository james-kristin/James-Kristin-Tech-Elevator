package com.techelevator;

public class HomeworkAssignment {

    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;


    public int getEarnedMarks() {
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public String getLetterGrade() {
        double percent = (double) earnedMarks / (double) possibleMarks;
        if (percent >= 0.9) {
            letterGrade = "A";
        } else if (percent >= 0.8) {
            letterGrade = "B";
        } else if (percent >= 0.7) {
            letterGrade = "C";
        } else if (percent >= 0.6) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }
        return letterGrade;
    }

    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

}
