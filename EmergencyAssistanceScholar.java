class EmergencyAssistanceScholar extends Scholar implements PrintableNotice {
    private boolean isCaseApproved;
    private int support_level; // minimal, medyo malala, max support

    public EmergencyAssistanceScholar(String name, String scholarID, double gwa, double serviceHoursTotal, int attendanceIssues) {
        super(name, scholarID, gwa, serviceHoursTotal, attendanceIssues);
        this.isCaseApproved = isCaseApproved;
        this.support_level = support_level;
    }

    @Override
    public String getScholarCategoryName() {
        this.scholarType = "Emergency Assistsance Scholarship";
        return this.scholarType;
    }   

    @Override
    public void buildDecisionReason() {
        if (!isCaseApproved) {
            currentStatus = "TERMINATED";
            renewalResult = "Scholar is not in need of Emergency Assistance.";
        } else if (support_level == 1) {
            currentStatus = "EMERGENCY MINIMAL SUPPORT";
            renewalResult = "One-time Emergency Relief granted.";
        } else if (support_level == 2) {
            currentStatus = "EMERGENCY MODERATE SUPPORT";
            renewalResult = "2-Week Emergency Relief granted.";
        } else if (support_level == 3) {
            currentStatus = "EMERGENCY CONTINUOUS SUPPORT";
            renewalResult = "Continuous Emergency Support granted.";
        }
    }

    @Override
    public double computeAllowance() {
        this.baseAllowance = 5000.00;
        this.penalties = 0;
        this.deductions = 0;

        double supportMultiplier = 1.0;

        if (support_level == 1) {
            supportMultiplier = 1.5;
        } 

        if (support_level == 2) {
            supportMultiplier = 2.0;
        }

        if (support_level == 3) {
            supportMultiplier = 3.0;
        } 


        this.finalAllowance = this.baseAllowance * supportMultiplier;

        if (currentStatus.equals("TERMINATED")) {
            this.finalAllowance = 0;
        }

        return this.finalAllowance;
    }

    @Override
    public String noticeHeader() {
        return "*********************************\n" +
               "   EMERGENCY CASE EVALUATION   \n" +
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
        System.out.println("Case Evaluation For         : " + name);
        System.out.println("Current Status              : " + currentStatus);
        System.out.println("Relief Allowance            : " + finalAllowance);
        System.out.println("Reason                      : " + renewalResult);
        System.out.println("=============================================");
    }
}