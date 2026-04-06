public class SemesterRecord {

    private String semesterLabel;
    private double gwa;
    private int attendanceIssues;
    private int warnings;
    private double serviceHours;
    private String remarks;

    public SemesterRecord() {
        this.semesterLabel = "";
        this.gwa = 0.0;
        this.attendanceIssues = 0;
        this.warnings = 0;
        this.serviceHours = 0.0;
        this.remarks = "";
    }

    public SemesterRecord(String semesterLabel, double gwa, int attendanceIssues, int warnings, double serviceHours, String remarks) {
        this.semesterLabel = semesterLabel;
        this.gwa = gwa;
        this.attendanceIssues = attendanceIssues;
        this.warnings = warnings;
        this.serviceHours = serviceHours;
        this.remarks = remarks;
    }

    public String getSemesterLabel() {
        return semesterLabel;
    }

    public void setSemesterLabel(String semesterLabel) {
        this.semesterLabel = semesterLabel;
    }

    public double getGwa() {
        return gwa;
    }

    public void setGwa(double gwa) {
        this.gwa = gwa;
    }

    public int getAttendanceIssues() {
        return attendanceIssues;
    }

    public void setAttendanceIssues(int attendanceIssues) {
        this.attendanceIssues = attendanceIssues;
    }

    public int getWarnings() {
        return warnings;
    }

    public void setWarnings(int warnings) {
        this.warnings = warnings;
    }

    public double getServiceHours() {
        return serviceHours;
    }

    public void setServiceHours(double serviceHours) {
        this.serviceHours = serviceHours;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}