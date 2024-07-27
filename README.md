# Employee Expense Tracker

## J2EE - Web application

## Database schema
```
Admins
- user_id (FK to Users(id))

Users
- id (PK)
- name (VARCHAR)
- email (VARCHAR, unique)
- phone (VARCHAR)
- username (VARCHAR, unique)
- password (VARCHAR)
- profile_picture (BLOB)
- status (BOOLEAN)
- work_role (VARCHAR)
- user_type (ENUM: 'Admin', 'Basic', 'Company')

Company_Users
- user_id (FK to Users(id))
- company_id (FK to Companies(id))
- role_id (FK to Roles(id))

Companies
- id (PK)
- resource_person (VARCHAR)
- name (VARCHAR)
- contact_email (VARCHAR)
- size (INT)
- sector (VARCHAR)

Roles
- id (PK)
- name (VARCHAR)
- level (INT)

Accounts
- id (PK)
- title (VARCHAR)
- income (DECIMAL)
- balance (DECIMAL)
- total_transactions (INT)
- user_id (FK to Users(id))

Expenses
- id (PK)
- title (VARCHAR)
- description (TEXT)
- amount (DECIMAL)
- expense_type (BOOLEAN) -- True for Spending, False for Income
- account_id (FK to Accounts(id))

Reimbursement_Claims
- id (PK)
- user_id (FK to Users(id))
- company_id (FK to Companies(id))
- expense_id (FK to Expenses(id))

```