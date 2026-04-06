public class ScholarshipOfficeReport {

    public void printScholarSummary(Scholar s) {

        System.out.println("============================================================");
        System.out.println("               SCHOLAR STATUS SUMMARY REPORT                ");
        System.out.println("============================================================");
        System.out.println("Scholar ID            : " + s.ScholarID);
        System.out.println("Scholar Name          : " + s.name);
        System.out.println("Program / Course      : " + s.course);
        System.out.println("Year Level            : " + s.yearLvl);
        System.out.println("Scholarship Category  : " + s.getScholarCategoryName());
        System.out.println("Semester              : " + s.semLabel);
        System.out.println("GWA                   : " + s.gwa);
        System.out.println("Attendance Issues     : " + s.attendanceIssues);
        System.out.println("Warnings              : " + s.warning_count);
        System.out.println("Service Hours         : " + s.serviceHoursTotal);
        System.out.println("Base Allowance        : " + s.baseAllowance);
        System.out.println("Deductions            : " + s.deductions);
        System.out.println("Final Allowance       : " + s.finalAllowance);
        System.out.println("Scholar Status        : " + s.currentStatus);
        if (s instanceof renewBenefit rb) {
            boolean isQualified = s.isQualified();
            System.out.println("Decision              :" + rb.renewDecision(isQualified));
        }
        System.out.println("Reason                : " + s.renewalResult); 
        System.out.println("============================================================");
    }

    public void printNotice(Scholar s, String noticeType) {

        System.out.println("============================================================");
        System.out.println("                  OFFICE NOTICE / DECISION                  ");
        System.out.println("============================================================");
        System.out.println("Notice Type           : " + noticeType);
        System.out.println("Scholar Name          : " + s.name);
        System.out.println("Scholarship Category  : " + s.getScholarCategoryName());
        System.out.println("Semester              : " + s.semLabel);
        System.out.println("Decision              : " + s.currentStatus);
        System.out.println("Reason                : " + s.renewalResult);
        System.out.println("Required Action       : " + s.adviserNote);
        System.out.println("Prepared By           : Scholarship Office");
        System.out.println("============================================================");
    }

    public void compareScholars(Scholar s1, Scholar s2) {

        System.out.println("============================================================");
        System.out.println("                 SCHOLAR COMPARISON REPORT                  ");
        System.out.println("============================================================");
        System.out.println("Name 1               : " + s1.name);
        System.out.println("Category             : " + s1.getScholarCategoryName());
        System.out.println("GWA                  : " + s1.gwa);
        System.out.println("Status               : " + s1.currentStatus);
        System.out.println("------------------------------------------------------------");
        System.out.println("Name 2               : " + s2.name);
        System.out.println("Category             : " + s2.getScholarCategoryName());
        System.out.println("GWA                  : " + s2.gwa);
        System.out.println("Status               : " + s2.currentStatus);
        System.out.println("============================================================");
    }
}