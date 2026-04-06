abstract class Scholar {
    //Scholar Data
    protected String ScholarID;
    protected String name;
    protected String course;
    protected String scholarType;
    protected String yearLvl;
    protected String semLabel;
    
    //Acad Values
    protected int incompleteGrades;
    protected int attendanceIssues;
    protected int warning_count;
    protected double serviceHoursTotal;
    protected double gwa;
    protected int games;
    
    //Allowance
    protected double baseAllowance;
    protected double deductions;
    protected double penalties;
    protected double finalAllowance;

    protected String currentStatus;     //Active/Probation/Suspended/For Review/Terminated
    
    //Admin Data
    protected String remarks;
    protected String adviserNote;
    protected String disciplinaryNote;
    protected String renewalResult;



    public Scholar(String name, String ScholarID, double gwa, double serviceHoursTotal, int attendanceIssues) {
        this.name = name;
        this.ScholarID = ScholarID;
        this.gwa = gwa;
        this.serviceHoursTotal = serviceHoursTotal;
        this.attendanceIssues = attendanceIssues;
        this.currentStatus = "ACTIVE";
    }

    //Update Methods
    public void updateWarning() {
        System.out.println("updateWarning");
    }

    public void updateAttendanceIssues() {
        System.out.println("updateAttendanceIssues");
    }

    public void updateDisciplinaryRemark() {
        System.out.println("updateDisciplinaryRemark");
    }

    public void updateSemLevel() {
        System.out.println("Scholar's semester updated to: " + semLabel);
    }

    //Scholar Identity + Stats
    public void scholarIdentity() {
        System.out.println("==============================================");
        System.out.println("Scholar Name               :" + this.name);
        System.out.println("Scholar ID                 :" + this.ScholarID);
        System.out.println("Scholar Course             :" + this.course);
        System.out.println("Scholar Year-Level         :" + this.yearLvl);
        System.out.println("Current Semester           :" + this.semLabel);
        System.out.println("Scholarship Type           :" + this.scholarType);
    }

    public void scholarStats() {
        System.out.println("==============================================");
        System.out.println("GWA                        :" + this.gwa);
        System.out.println("Incomplete Grades          :" + this.incompleteGrades);
        System.out.println("Attendance                 :" + this.attendanceIssues);
        System.out.println("Disciplinary Warnings      :" + this.warning_count);
        System.out.println("Hours Served               :" + this.serviceHoursTotal);
    }

    abstract double computeAllowance();
    abstract void evalStatus();
    abstract String getScholarCategoryName();
    abstract void buildDecisionReason();
}