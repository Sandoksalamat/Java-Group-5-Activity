interface renewBenefit {
    boolean checkQualification(double gwa, int attendanceIssues, int warning_count); 
    String renewDecision(boolean isQualified);
}   