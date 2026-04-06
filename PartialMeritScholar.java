class PartialMeritScholar extends Scholar implements renewBenefit, PrintableNotice {
    private final double GWA_Req = 2.25;
    private final int Min_srvcHour = 10;
    private final int Max_absence = 5;

    public PartialMeritScholar(String name, String scholarID, double gwa, double serviceHoursTotal, int attendanceIssues) {
        super(name, scholarID, gwa, serviceHoursTotal, attendanceIssues);
    }

    @Override
    public String getScholarCategoryName() {
        this.scholarType = "Partial Merit Scholarship";
        return this.scholarType;
    }

    @Override
    public void buildDecisionReason() {
        if (gwa > GWA_Req && attendanceIssues > Max_absence && serviceHoursTotal < Min_srvcHour) {
            currentStatus = "TERMINATED";
            renewalResult = "Total failure of GWA, Attendance, and Service standards.";
        } 
        else if (gwa > GWA_Req || attendanceIssues > Max_absence) {
            currentStatus = "PROBATIONARY";
            renewalResult = "Academic or Attendance requirement not met.";
        }
        else if (serviceHoursTotal < Min_srvcHour) {
            currentStatus = "SUSPENDED";
            renewalResult = "Service hour deficiency.";
        } 
        else if (warning_count > 3) {
            currentStatus = "FOR REVIEW";
            renewalResult = "Disciplinary warnings exceeding limit.";
        }
        else {
            currentStatus = "ACTIVE";
            renewalResult = "Scholarship standards maintained.";
        }
    }

    @Override
    public double computeAllowance() {
        this.baseAllowance = 7500.00;
        this.penalties = 0;
        this.deductions = 300.00;

        if (this.attendanceIssues > 0) {
            this.penalties += (this.attendanceIssues * 100.00);
        }

        if (this.currentStatus.equals("PROBATIONARY")) {
            this.penalties += (this.baseAllowance * 0.5);
        } else if (this.currentStatus.equals("SUSPENDED") || this.currentStatus.equals("FOR REVIEW")) {
            this.penalties += (this.baseAllowance * 0.25);
        } else if (this.currentStatus.equals("TERMINATED")) {
            this.penalties = this.baseAllowance;
        }

        this.finalAllowance = this.baseAllowance - (this.deductions + this.penalties);
        if (this.finalAllowance < 0) this.finalAllowance = 0;

        return this.finalAllowance;
    }

    @Override
    public boolean isQualified() {
        return checkQualification(gwa, attendanceIssues, warning_count);
    }

    @Override
    public boolean checkQualification(double gwa, int attendanceIssues, int warning_count) {
        return (gwa <= GWA_Req && attendanceIssues <= Max_absence && warning_count < 5);
    }

    @Override
    public String renewDecision(boolean isQualified) {
        return isQualified ? "RENEWED" : "NOT RENEWED";
    }

    @Override
    public String noticeHeader() {
        return "*********************************\n" +
               "   OFFICIAL SCHOLARSHIP NOTICE   \n" +
               "*********************************";
    }

    @Override
    public void printStatusNotice(int currentStatus) {
        System.out.println(noticeHeader());
        System.out.println("Scholar: " + name);
        System.out.println("Status Level: " + currentStatus);
    }

    @Override
    public void evalStatus() {
        getScholarCategoryName();
        buildDecisionReason();
        computeAllowance();

        System.out.println("=============================================");
        System.out.println("Evaluation Result for       : " + name);
        System.out.println("Current Status              : " + currentStatus);
        System.out.println("Final Allowance             : " + finalAllowance);
        System.out.println("Reason                      : " + renewalResult);
        System.out.println("=============================================");
    }
    
}