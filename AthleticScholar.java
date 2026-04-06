class AthleticScholar extends Scholar implements renewBenefit, PrintableNotice {
    private final double GWA_Req = 2.25;
    private final int Max_absence = 3;
    private final int Participation_Req = 5; // aka participation
    private  int games;    

    public AthleticScholar(String name, String scholarID, double gwa, double serviceHoursTotal, int attendanceIssues) {
        super(name, scholarID, gwa, serviceHoursTotal, attendanceIssues);
        this.games = games;
    }

    @Override
    public String getScholarCategoryName() {
        this.scholarType = "Athletic Scholarship";
        return this.scholarType;
    }   

    // Overrides evaluation rules to consider grade standing, participation issues, and attendance problems.
    @Override
    public void buildDecisionReason() {
        if (gwa > GWA_Req && attendanceIssues > Max_absence && Participation_Req < games) {
            currentStatus = "TERMINATED";
            renewalResult = "Total failure of GWA, Attendance, and Lack of Participation.";
        } 
        else if (gwa > GWA_Req || attendanceIssues > Max_absence) {
            currentStatus = "PROBATIONARY";
            renewalResult = "Academic or Attendance requirement not met.";
        }
        else if (Participation_Req < games) {
            currentStatus = "SUSPENDED";
            renewalResult = "Lack of Participated Games.";
        } 
        else if (warning_count > 1) {
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
        this.deductions = 500.00;

        if (this.attendanceIssues > 0) {
            this.penalties += (this.attendanceIssues * 200.00);
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
    public boolean checkQualification(double gwa, int attendanceIssues, int warning_count) {
        // Logic: Return true if they meet the requirements
        return (gwa <= GWA_Req && attendanceIssues <= Max_absence);
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

            // Overrides notice generation so the final message can mention academic or participation deficiencies.
            if (gwa > GWA_Req && games < Participation_Req) {
                System.out.println("Scholar has Academic and Participation deficiencies.");
            } else if (gwa > GWA_Req) {
                System.out.println("Scholar has Academic Deficiencies.");
            } else if (games < Participation_Req) {
                System.out.println("Scholar has Participation Deficiencies.");
            } else {
                System.out.println("Scholar has no deficiencies.");
            }
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