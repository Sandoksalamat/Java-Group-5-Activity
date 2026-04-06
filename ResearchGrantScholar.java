class ResearchGrantScholar extends Scholar implements PrintableNotice {
    private final double GWA_Req = 2.00;
    private final int Lab_Req_Hours = 40;
    private final int Max_absence = 5;
    private final boolean isResearchApproved = true;
    private int currentLabHrs;

    public ResearchGrantScholar(String name, String scholarID, double gwa, int Lab_Req_Hours, int attendanceIssues) {
        super(name, scholarID, gwa, Lab_Req_Hours, attendanceIssues);
        this.currentLabHrs = currentLabHrs;
    }

    @Override
    public String getScholarCategoryName() {
        this.scholarType = "Research Grant Scholarship";
        return this.scholarType;
    }   

    @Override
    public void buildDecisionReason() {
        if (gwa > GWA_Req && currentLabHrs < Lab_Req_Hours) {
            currentStatus = "TERMINATED";
            renewalResult = "GWA and Lab Hours has not met the Standard Requirement.";
        } else if (attendanceIssues > Max_absence) {
            currentStatus = "PROBATIONARY";
            renewalResult = "Attendance has not met the Standard Requirement.";
        } else if (!isResearchApproved) {
            currentStatus = "FOR REVIEW";
            renewalResult = "Research Pending for approval.";
        } else if (currentLabHrs < Lab_Req_Hours) {
            currentStatus = "SUSPENDED";
            renewalResult = "Insufficient Lab/Research service hours.";
        } else {
            currentStatus = "ACTIVE";
            renewalResult = "Research progress and Academic standing are satisfactory.";
        }
    }

    @Override
    public double computeAllowance() {
        this.baseAllowance = 10000.00;
        this.penalties = 0;
        this.deductions = 500.00;

        if (this.attendanceIssues > 0) {
            this.penalties += (this.attendanceIssues * 200.00);
        }

        if (this.currentStatus.equals("FOR REVIEW")) {
            this.penalties += (this.baseAllowance * 0.5);
        } else if (this.currentStatus.equals("PROBATIONARY")) {
            this.penalties += (this.baseAllowance * 0.25);
        } else if (this.currentStatus.equals("TERMINATED") && this.currentStatus.equals("SUSPENDED")) {
            this.penalties = this.baseAllowance;
        }

        this.finalAllowance = this.baseAllowance - (this.deductions + this.penalties);
        if (this.finalAllowance < 0) this.finalAllowance = 0;

        return this.finalAllowance;
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
        System.out.println("Research Hours Completed    : " + currentLabHrs);
        System.out.println("Current Status              : " + currentStatus);
        System.out.println("Final Allowance             : " + finalAllowance);
        System.out.println("Reason                      : " + renewalResult);
        System.out.println("=============================================");
    }
}