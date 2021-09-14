package com.example.android.justjava;

public class ReportCard {

    private char mSection;
    private String mName;
    private int mClass;
    private int mGeography;
    private int mHistory;
    private int mPhysics;
    private int mChemistry;
    private int mComputerScience;
    private int sum;

    public ReportCard(String name, int class_, char section, int history, int geography,
                      int physics, int chemistry, int computerScience) {
        mName = name;
        mClass = class_;
        mSection = section;
        mHistory = history;
        mGeography = geography;
        mPhysics = physics;
        mChemistry = chemistry;
        mComputerScience = computerScience;
    }

    // Get name of Student
    public String getName() {
        return mName;
    }
    // Set Name of Student
    public void setName(String name) {
        mName = name;
    }
    // Get class of student
    public int getClass_() {
        return mClass;
    }
    // Set class of student
    public void setClass(int class_) {
        mClass = class_;
    }
    // Get section of student
    public char getSection() {
        return mSection;
    }
    // Set section of student
    public void setSection(char section) {
        mSection = section;
    }
    // Get history marks
    public int getHistoryMarks() {
        return mHistory;
    }
    // Set history marks
    public void setHistoryMarks(int history) {
        mHistory = history;
    }
    // Get geography marks
    public int getGeographyMarks() {
        return mGeography;
    }
    // Set geography marks
    public void setGeographyMarks(int geography) {
        mGeography = geography;
    }
    // Get physics marks
    public int getPhysicsMarks() {
        return mPhysics;
    }
    // Set physics marks
    public void setPhysicsMarks(int physics) {
        mPhysics = physics;
    }
    // Get chemistry marks
    public int getChemistryMarks() {
        return mChemistry;
    }
    // Set chemistry marks
    public void setChemistryMarks(int chemistry) {
        mChemistry = chemistry;
    }
    // Get CS marks
    public int getComputerScienceMarks() {
        return mComputerScience;
    }
    // Set CS marks
    public void setComputerScienceMarks(int computerScience) {
        mComputerScience = computerScience;
    }
    // get total marks
    public int getTotalMarks() {
        sum = mGeography + mChemistry + mPhysics + mComputerScience +
                mHistory;
        return sum;
    }

    public double getPercentage() {
        return (sum/5);
    }

    @Override
    public String toString() {
        return "Result { " +
                "History = " + mHistory +
                ", Geography = " + mGeography +
                ", Computer Science = " + mComputerScience +
                ", Chemistry = " + mChemistry +
                ", Physics = " + mPhysics +
                " }";
    }
}
//    String mName;
//    String mEnglishGrade;
//    String mMathGrade;
//    int mHistoryGrade;
//    double mBiologyGrade;
//
//    public ReportCard (String name, String englishGrade, String mathGrade,int historyGrade, double biologyGrade){
//        mName= name;
//        mEnglishGrade = englishGrade;
//        mMathGrade = mathGrade;
//        mHistoryGrade = historyGrade;
//        mBiologyGrade= biologyGrade;
//    }
//    public String getmName(){return mName;}
//    public void setmName(String grade){ mName = grade;}
//
//    public String getmEnglishGrade(){return mEnglishGrade;}
//    public void setmEnglishGrade(String grade){ mEnglishGrade = grade;}
//
//    public String getmMathGrade(){
//        return mMathGrade;
//    }
//
//    public void setmMathGrade(String grade){
//        mMathGrade=grade;
//    }
//
//    public int getmHistoryGradee() {
//        return mHistoryGrade;
//    }
//
//    public void setmHistoryGrade(int grade) {
//        mHistoryGrade = grade;
//    }
//
//    public double getmBiologyGrade(){
//        return mBiologyGrade;
//    }
//
//    public void setmBiologyGrade(double grade){
//        mBiologyGrade=grade;
//    }
//    @Override
//    public String toString() {
//        return "Name = " + mName +
//                ", English = " + mEnglishGrade +
//                ", Biology = " + mBiologyGrade +
//                ", History = " + mHistoryGrade +
//                ", Math = " + mMathGrade +
//                " }";
//    }
//}
