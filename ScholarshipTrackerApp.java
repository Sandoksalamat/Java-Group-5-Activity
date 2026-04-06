import java.util.Scanner;

public class ScholarshipTrackerApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scholar currentScholar = null;
        ScholarshipOfficeReport report = new ScholarshipOfficeReport();
        int choice = 0;

        while (choice != 10) {
            System.out.println("\n===============================================");
            System.out.println("     UNIVERSITY SCHOLARSHIP OFFICE CONSOLE     ");
            System.out.println("===============================================");
            System.out.println("[1] Register Scholar");
            System.out.println("[2] Encode Semester Academic Record");
            System.out.println("[3] Encode Service Hours");
            System.out.println("[4] Encode Attendance / Disciplinary Issues");
            System.out.println("[5] Compute Monthly Allowance");
            System.out.println("[6] Evaluate Scholar Status");
            System.out.println("[7] Print Scholar Summary");
            System.out.println("[8] Print Notice or Decision Letter");
            System.out.println("[9] Compare Two Scholars (Requires 2 Scholars)");
            System.out.println("[10] Exit");
            System.out.print("Enter choice: ");
            
            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else {
                System.out.println("Invalid Choice.");
                input.next();
            }
            input.nextLine();

            if (choice == 1) {
                System.out.println("\n=== Register New Scholar ===");
                System.out.print("Enter ID: ");
                String id = input.nextLine();
                System.out.print("Enter Name: ");
                String name = input.nextLine();
                System.out.print("Enter Program: ");
                String prog = input.nextLine();
                System.out.print("Enter Year Level: ");
                String year = input.nextLine();
                
                System.out.println("Select Type: [1] Full Merit  [2] Partial Merit  [3] Athletic  [4] Service Grant  [5] Research Grant  [6] Emergency Assistance");
                int type = input.nextInt();

                if (type == 1) {
                    currentScholar = new FullMeritScholar(name, id, 0.0, 0.0, 0);
                } else if (type == 2) {
                    currentScholar = new PartialMeritScholar(name, id, 0.0, 0.0, 0);
                } else if (type == 3) {
                    currentScholar = new AthleticScholar(name, id, 0.0, 0.0, 0);
                } else if (type == 4) {
                    currentScholar = new ServiceGrantScholar(name, id, 0.0, 0.0, 0);
                } else if (type == 5) {
                    currentScholar = new ResearchGrantScholar(name, id, 0.0, 0, 0);
                } else if (type == 6) {
                    currentScholar = new EmergencyAssistanceScholar(name, id, 0.0, 0.0, 0);
                }
                
                if (currentScholar != null) {
                    currentScholar.course = prog;
                    currentScholar.yearLvl = year;
                    System.out.println("Scholar Registered Successfully!");
                }

            } else if (choice == 2) {
                if (currentScholar == null) {
                    System.out.println("Error: Register a scholar first.");
                } else {
                    System.out.print("Enter Semester Label: ");
                    currentScholar.semLabel = input.nextLine();
                    System.out.print("Enter GWA: ");
                    if (input.hasNextDouble()) {
                        currentScholar.gwa = input.nextDouble();
                    } else {
                        System.out.println("Invalid Input");
                        input.next();
                    }
                }
            } else if (choice == 3) {
                if (currentScholar == null) {
                    System.out.println("Error: Register a scholar first.");
                } else {
                    if (currentScholar instanceof AthleticScholar ath1) {
                        System.out.print("Enter participated Games: ");
                        if (input.hasNextInt()) {
                            ath1.addGames(input.nextInt());
                            input.nextLine();
                        }
                    } else if (currentScholar instanceof ResearchGrantScholar rs1) {
                        System.out.print("Enter Lab Hours: ");
                        if (input.hasNextInt()) {
                            rs1.LabHrs(input.nextInt());
                            input.nextLine();
                        }
                    } else if (currentScholar instanceof EmergencyAssistanceScholar ea1) {
                        System.out.print("Is your case approved? [true/false]: ");
                        ea1.setCaseApproval(input.nextBoolean());
                        input.nextLine();
                        System.out.print("Enter support level (1-3): ");
                        ea1.setSupportResponse(input.nextInt());
                        input.nextLine();
                    } else {
                        System.out.print("Enter Service Hours to add: ");
                        if (input.hasNextDouble()) {
                            currentScholar.serviceHoursTotal += input.nextDouble();
                            input.nextLine();
                        } else {
                            System.out.println("Invalid Input");
                            input.next();
                        }
                    }
                }
            } else if (choice == 4) {
                if (currentScholar == null) {
                    System.out.println("Error: Register a scholar first.");
                } else {
                    System.out.print("Enter Attendance Issues: ");
                    if (input.hasNextInt()) {
                        currentScholar.attendanceIssues = input.nextInt();
                    } else {
                        System.out.println("Invalid Input.");
                        input.next();
                    }
                    System.out.print("Enter Warning Count: ");
                    if (input.hasNextInt()) {
                        currentScholar.warning_count = input.nextInt();
                    } else {
                        System.out.println("Invalid Input.");
                        input.next();
                    }
                }
            } else if (choice == 5) {
                if (currentScholar == null) {
                    System.out.println("Error: Register a scholar first.");
                } else {
                    double allowance = currentScholar.computeAllowance();
                    System.out.println("Computed Monthly Allowance: " + allowance);
                }
            } else if (choice == 6) {
                if (currentScholar == null) {
                    System.out.println("Error: Register a scholar first.");
                } else {
                    currentScholar.evalStatus();
                }
            } else if (choice == 7) {
                if (currentScholar == null) {
                    System.out.println("Error: Register a scholar first.");
                } else {
                    report.printScholarSummary(currentScholar);
                }
            } else if (choice == 8) {
                if (currentScholar == null) {
                    System.out.println("Error: Register a scholar first.");
                } else {
                    report.printNotice(currentScholar, "OFFICIAL DECISION");
                }
            } else if (choice == 9) {
                double gwa1 = 0.0, gwa2 = 0.0, allow1 = 0.0, allow2 = 0.0;
                System.out.println("\n=== Scholar Comparison ===");

                System.out.println("Scholar 1 Details:");
                System.out.print("Name: ");
                String name1 = input.nextLine();
                System.out.print("Scholarship Type: ");
                String type1 = input.nextLine();

                System.out.print("GWA: ");
                if (input.hasNextDouble()) {
                    gwa1 = input.nextDouble();
                } else {
                    System.out.println("Invalid Input.");
                    input.next();
                }

                System.out.print("Allowance: ");
                if (input.hasNextDouble()) {
                    allow1 = input.nextDouble();
                } else {
                    System.out.println("Invalid Input.");
                    input.next();
                }

                input.nextLine(); 

                System.out.println("\nScholar 2 Details:");
                System.out.print("Name: ");
                String name2 = input.nextLine();
                System.out.print("Scholarship Type: ");
                String type2 = input.nextLine();

                System.out.print("GWA: ");
                if (input.hasNextDouble()) {
                    gwa2 = input.nextDouble();
                } else {
                    System.out.println("Invalid Input.");
                    input.next();
                }

                System.out.print("Allowance: ");
                if (input.hasNextDouble()) {
                    allow2 = input.nextDouble();
                } else {
                    System.out.println("Invalid Input.");
                    input.next();
                }

                input.nextLine();

                System.out.println("\n===============================================");
                System.out.println("            COMPARISON RESULT                 ");
                System.out.println("===============================================");
                System.out.printf("%-15s %-20s %-10s %-10s\n", "NAME", "TYPE", "GWA", "ALLOWANCE");
                System.out.printf("%-15s %-20s %-10.2f %-10.2f\n", name1, type1, gwa1, allow1);
                System.out.printf("%-15s %-20s %-10.2f %-10.2f\n", name2, type2, gwa2, allow2);
                System.out.println("-----------------------------------------------");


                if (gwa1 < gwa2) {
                    System.out.println("Verdict: " + name1 + " has a better Academic Standing.");
                } else if (gwa2 < gwa1) {
                    System.out.println("Verdict: " + name2 + " has a better Academic Standing.");
                } else {
                    System.out.println("Verdict: Both scholars have an equal Academic Standing.");
                }
                System.out.println("===============================================");

            } else if (choice == 10) {
                System.out.println("Thank you, scholar!");
            } else {
                System.out.println("Invalid Choice.");
            }
        }
        input.close();
    }
}