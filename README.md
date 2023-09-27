# MaCNSS - Moroccan Healthcare System Management Console Application
MaCNSS is a Java console application developed to facilitate the management of patient reimbursement files within the CNSS network of agencies in Morocco. This application allows CNSS agents to efficiently track and process reimbursement requests submitted by CNSS-insured patients.

## Features
- User Authentication: Each CNSS agent must log in with their email, password, and a verification code sent to their email (valid for 5 minutes) to access the application.

- Patient Reimbursement Files: Patients submit reimbursement files that include a CNSS form and may optionally include barcode information for prescribed medications, laboratory test results, and radiology reports.

- Manual Verification: CNSS agents manually review each submitted document and enter relevant information into the MaCNSS application.

- Automatic Reimbursement Calculation: The system automatically calculates the reimbursement amount for each document submitted by the patient.

- Document Identification: Each patient-submitted document is identified by a unique code.

- Administrator Role: The system includes a single administrator responsible for managing CNSS agent accounts.

- Medication Reimbursement Rates: Different medications have predefined reimbursement rates set by CNSS management.

- Non-Reimbursable Medications: Some medications are not reimbursable by CNSS. In such cases, patients may receive reimbursement only for a medical visit.

- Historical Record: Patients can view the history of their reimbursement files at any time.

- File Status: Reimbursement files can have one of the following statuses:
-Pending: The file is being processed by a CNSS agent.
-Rejected: The patient's file is incomplete, and an automatic email is sent to the patient with the reason for rejection.
-Approved: The file has been successfully processed by a CNSS agent, and an automatic email is sent to the patient with the reimbursement amount.
## Development
- Use of UML Diagrams: We have created UML diagrams, including Use Case, Sequence, Class, and State Transition diagrams, to help understand the application's structure.

- Project Management: We have organized our development tasks using Jira to ensure efficient project management.

- Database: We manage data using either MySQL database.

## Technologies and Concepts Utilized
- Java Time API
- Collection API (Hashmaps)
- Garbage Collection
- SOLID Principles
- Singleton Design Pattern

## Contributing
If you would like to contribute to this project, feel free to do so.
