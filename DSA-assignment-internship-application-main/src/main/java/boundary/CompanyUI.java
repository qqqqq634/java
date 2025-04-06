package boundary;

import java.util.Scanner;
import adt.ArrayList;
import control.CompanyManager;
import entity.JobPosting;



public class CompanyUI {
    private CompanyManager companyManager = new CompanyManager();
    private Scanner input = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("\n\n\nCompany Menu:");
        System.out.println("1. Register Company");
        System.out.println("2. Remove Company information by ID");
        System.out.println("3. Update Company information by ID");
        System.out.println("4. Manage Job Posting");
        System.out.println("5. List All Companies");
        System.out.println("6. Filter Companies");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        CompanyUI companyUI = new CompanyUI();
        companyUI.run();
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    registerCompany();
                    break;
                case 2:
                    removeCompany();    
                    break;
                case 3:
                    updateCompany();
                    break;    
                case 4:
                    deleteCompany();
                    break;
                case 5:
                    listAllCompanies();
                    break;
                case 6:
                    filterCompanies();
                    break;
                case 7:
                    System.out.println("Exiting Company Management!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }

    private String getInputCompanyName() {
        System.out.print("Enter company name: ");
        String name = input.nextLine();
        return name;
    }

    private String getInputCompanyLocation() {
        System.out.print("Enter company location: ");
        String location = input.nextLine();
        return location;

    }

    private ArrayList<JobPosting> getInputJobPostings() {
        JobPostingUI jobPostingUI = new JobPostingUI();
        jobPostingUI.run();
        return jobPostingUI.getJobManager().getJobPostings();
    }

    private void updateCompanyMenu() {
        System.out.println("\n\n\nUpdate Company Menu:");
        System.out.println("1. Update Company Name");
        System.out.println("2. Update Company Location");
        System.out.println("3. Update Company Job Postings");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private void updateCom(String id) {
        // TODO: Implement company update logic
        String name, location;
        ArrayList<JobPosting> jobPostings;
        int choice;
        do {
            updateCompanyMenu();
            choice = input.nextInt();
            input.nextLine(); // clear buffer
            switch (choice) {
                case 1:
                    name = getInputCompanyName();
                    companyManager.getCompanyById(id).setName(name);
                    break;
                case 2:
                    location = getInputCompanyLocation();
                    companyManager.getCompanyById(id).setLocation(location);
                    break;
                case 3:
                    jobPostings = getInputJobPostings();
                    companyManager.getCompanyById(id).setJobPostings(jobPostings);
                    break;
                case 4:
                    System.out.println("Exiting update menu!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }



    public void registerCompany() {
        // TODO: Implement company registration logic
        String name, location;
        ArrayList<JobPosting> jobPostings;
        input.nextLine();// clear buffer
        name = getInputCompanyName();
        location = getInputCompanyLocation();
        jobPostings = getInputJobPostings();

        companyManager.registerCompany(name, location, jobPostings);

    }

    public void removeCompany() {
        // TODO: Implement company removal logic

        input.nextLine(); // clear buffer
        System.out.print("Enter the ID of the company to remove: ");
        String id = input.nextLine();

        boolean removed = companyManager.removeCompanyById(id);

        if (removed) {
            System.out.println("Company removed successfully!");
        } else {
            System.out.println("Company not found!");
        }
    }

    public void updateCompany() {

        input.nextLine(); // clear buffer
        // enter company ID to update
        System.out.print("Enter the ID of the company to update: ");
        String id = input.nextLine();

        // update the company with the specified ID
        boolean exists = companyManager.getCompanyById(id) != null;
        if (exists) {
            updateCom(id);
        } else {
            System.out.println("Company not found!");
        }

    }

    public void deleteCompany() {

        input.nextLine(); // clear buffer
        System.out.print("Enter the ID of the company to delete: ");
        String id = input.nextLine();
        boolean deleted = companyManager.removeCompanyById(id);
        if (deleted) {
            System.out.println("Company deleted successfully!");
        } else {
            System.out.println("Company not found!");
        }
    }

    public void listAllCompanies() {
        // TODO: Implement company listing logic
        companyManager.listAllCompanies();
    }

    public void filterCompanies() {
        // TODO: Implement company filtering logic

    }
}
