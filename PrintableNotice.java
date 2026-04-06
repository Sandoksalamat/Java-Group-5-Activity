interface PrintableNotice {
    String noticeHeader();
    void printStatusNotice(int currentStatus);

    int APPROVAL = 1;
    int DEFICIENCY = 2;
    int PROBATION = 3;
    int SUSPENSION = 4;
}