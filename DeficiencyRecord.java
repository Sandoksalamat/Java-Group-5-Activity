public class DeficiencyRecord {

    private int incompleteGrades;
    private String disciplinaryIssue;
    private boolean missingServiceProof;
    private String otherRemarks;

    public DeficiencyRecord() {
        this.incompleteGrades = 0;
        this.disciplinaryIssue = "";
        this.missingServiceProof = false;
        this.otherRemarks = "";
    }

    public DeficiencyRecord(int incompleteGrades, String disciplinaryIssue, boolean missingServiceProof, String otherRemarks) {
        this.incompleteGrades = incompleteGrades;
        this.disciplinaryIssue = disciplinaryIssue;
        this.missingServiceProof = missingServiceProof;
        this.otherRemarks = otherRemarks;
    }

    public int getIncompleteGrades() {
        return incompleteGrades;
    }

    public void setIncompleteGrades(int incompleteGrades) {
        this.incompleteGrades = incompleteGrades;
    }

    public String getDisciplinaryIssue() {
        return disciplinaryIssue;
    }

    public void setDisciplinaryIssue(String disciplinaryIssue) {
        this.disciplinaryIssue = disciplinaryIssue;
    }

    public boolean isMissingServiceProof() {
        return missingServiceProof;
    }

    public void setMissingServiceProof(boolean missingServiceProof) {
        this.missingServiceProof = missingServiceProof;
    }

    public String getOtherRemarks() {
        return otherRemarks;
    }

    public void setOtherRemarks(String otherRemarks) {
        this.otherRemarks = otherRemarks;
    }
}