## 1. What is this repo?

The **ATM-Simulator** repository is a desktop-based bank management application developed in Java. It provides a simulated interface of an automated teller machine (ATM) alongside a bank portal to handle customer registration, database-driven authentication, and core banking transactions.

The system features:
*   **User Registration Wizard**: A multi-stage enrollment process spanning three distinct screens (`src/signup1.java`, `src/signup2.java`, and `src/signup3.java`) that gathers personal details, additional demographic profiles, and account-level/service options before writing them to a database.
*   **Secure Authentication**: A user sign-in screen (`src/Login.java`) that verifies a generated 16-digit card number and a 4-digit security PIN against a database.
*   **Interactive Virtual ATM Panel**: A main navigation dashboard (`src/transaction.java`) rendered over an ATM background graphic, offering access to transactions.
*   **Financial Operations**: Execution of deposits (`src/deposite.java`), standard withdrawals (`src/withdrawl.java`), simplified fast-cash operations (`src/FastCash.java`), real-time balance inquiries (`src/balanceEnquiry.java`), administrative security updates (`src/pinChange.java`), and transaction auditing via statement outputs (`src/miniStatement.java`).
*   **SQL Persistence**: Centralized database query forwarding using Java Database Connectivity (JDBC) via a helper class (`src/conn.java`) to interact with a MySQL database.

---

## 2. How all main components connect

The system follows a typical client-server architectural partition for desktop programs, where the frontend components are driven by Java's Abstract Window Toolkit (AWT) and Swing frameworks, and the persistence engine relies on a remote SQL server through JDBC API adapters.

### Control and Navigation Workflow

The execution lifecycle of this simulator flows as follows:

1.  **Entrypoint & Verification**: The application starts at the `src/Login.java` panel. Users can either type in valid credentials to access the internal dashboard, or initialize a new registration.
2.  **Registration Pipeline**: Clicking "SIGN UP" shifts the view to the 3-step registration wizard.
    *   `src/signup1.java` collects name, email, DOB, gender, state, and address.
    *   `src/signup2.java` captures supplementary financial and identity attributes such as PAN, Aadhaar, religion, and educational background.
    *   `src/signup3.java` allows selecting account configurations (e.g., Saving or Current) and associated facilities (e.g., ATM card, Internet banking). On submission, it auto-generates a mock card number and a 4-digit PIN, persists them in the DB, and prompts an initial deposit by routing directly to `src/deposite.java`.
3.  **Core Dashboard**: Upon a successful validation on `src/Login.java`, control transfers to `src/transaction.java`, which serves as a routing gateway for all transaction sub-screens.
4.  **Transaction Modules**: Every subsequent screen (`src/deposite.java`, `src/withdrawl.java`, `src/FastCash.java`, `src/balanceEnquiry.java`, `src/miniStatement.java`, and `src/pinChange.java`) accepts the verified customer `pin` as a state variable in its constructor to guarantee transactions execute only on the authenticated account.


## 3. Repository Structure

```shell
ATM-Simulator/
├── .vscode/
│   └── settings.json
├── README.md
├── bin/
│   ├── FastCash.class
│   ├── Login.class
│   ├── balanceEnquiry.class
│   ├── conn.class
│   ├── deposite.class
│   ├── icons/
│   │   ├── atm.jpg
│   │   └── logo.jpg
│   ├── miniStatement.class
│   ├── pinChange.class
│   ├── signup1.class
│   ├── signup2.class
│   ├── signup3.class
│   ├── transaction.class
│   └── withdrawl.class
├── lib/
│   ├── jcalendar-tz-1.3.3-4.jar
│   └── mysql-connector-java-8.0.28.jar
└── src/
    ├── FastCash.class
    ├── FastCash.java
    ├── Login.class
    ├── Login.java
    ├── balanceEnquiry.class
    ├── balanceEnquiry.java
    ├── conn.class
    ├── conn.java
    ├── deposite.class
    ├── deposite.java
    ├── icons/
    │   ├── atm.jpg
    │   └── logo.jpg
    ├── miniStatement.class
    ├── miniStatement.java
    ├── pinChange.class
    ├── pinChange.java
    ├── signup1.class
    ├── signup1.java
    ├── signup2.class
    ├── signup2.java
    ├── signup3.class
    ├── signup3.java
    ├── transaction.class
    ├── transaction.java
    ├── withdrawl.class
    └── withdrawl.java
```

---

## 4. Other important information

### Technology Stack & Libraries
*   **Programming Language**: Java (SE)
*   **GUI Frameworks**: 
    *   `javax.swing.*`: Used for container panes like `JFrame`, input components like `JTextField` and `JPasswordField`, buttons, and dialog overlays like `JOptionPane`.
    *   `java.awt.*`: Used for positioning structures via custom coordinate definitions (`setLayout(null)`), fonts, custom styling colors, and component event delegation (`ActionListener`).
*   **Persistence Driver**: `mysql-connector-java-8.0.28.jar` found in `lib/` registers the MySQL JDBC driver class (`com.mysql.cj.jdbc.Driver`) to negotiate raw SQL execution against a physical MySQL database.
*   **Third-party Components**: `lib/jcalendar-tz-1.3.3-4.jar` facilitates visual date selection inside `src/signup1.java` through the `JDateChooser` bean.

### Database Schema Requirements
Based on SQL update operations in the code, the codebase expects a MySQL database named `bank_management` accessible with the credentials `root` and `Pass@123` (configured inside `src/conn.java`). It operates on the following schema structures:

1.  **`signup` table**: Written by `src/signup1.java`
    *   `formno` (String / Primary identifier)
    *   Fields: `name`, `fname`, `dob`, `gender`, `email`, `marital`, `address`, `city`, `state`, `pin`.
2.  **`signup2` table**: Written by `src/signup2.java`
    *   `formno` (String / Foreign key)
    *   Fields: `religon`, `category`, `income`, `education`, `occupation`, `pan`, `adhar`, `senior`, `exist`.
3.  **`signup3` table**: Written by `src/signup3.java`
    *   `formno`, `account` (Type), `cardno` (Unique), `pin`, `facility` (Services selected).
4.  **`login` table**: Written by `src/signup3.java` and queried by `src/Login.java`
    *   `formno`, `cardno`, `pin`.
5.  **`balance` table**: Initialized by `src/signup3.java` with a default balance of `0`, and updated by operations.
    *   `account_number` (Card Number), `pin`, `balance` (Integer).
6.  **`transactions` table**: Appended dynamically during actions in `src/deposite.java`, `src/withdrawl.java`, and `src/FastCash.java`
    *   `pin`, `date` (formatted as `yyyy-MM-dd HH:mm:ss`), `type_of_transaction`, `amount`.

### Implementation Highlights

#### Validation Routines
In `src/signup1.java` and `src/signup2.java`, input values are rigorously checked prior to database execution. The application enforces validation rules utilizing regular expressions:
*   **Email validation**: Handled by pattern:
    ```java
    "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@gmail.com$"
    ```
*   **PAN format**: Enforces standard Indian PAN rules:
    ```java
    "^[A-Z]{5}\\d{4}[A-Z]{1}$"
    ```
*   **Aadhaar validation**: Requires exactly 12 numeric digits:
    ```java
    "^\\d{12}$"
    ```
*   **Pincode validation**: Ensures an exact 6-digit numeric match:
    ```java
    "^[0-9]+$"
    ```

#### Synchronization of PIN Changes
An important transactional requirement occurs during PIN modifications in `src/pinChange.java`. To prevent integrity failures across tables, a cascade update must occur. The system performs serial executions to update the PIN reference across the entire schema:
```java
conn c = new conn();
String query1 = "update signup3 set pin='"+rpin+"' where pin='"+pin+"'";
c.s.executeUpdate(query1);
String query2 = "update login set pin='"+rpin+"' where pin='"+pin+"'";
c.s.executeUpdate(query2);
String query3 = "update transactions set pin='"+rpin+"' where pin='"+pin+"'";
c.s.executeUpdate(query3);
String query4 = "update balance set pin='"+rpin+"' where pin='"+pin+"'";
c.s.executeUpdate(query4);
```

#### Safe Balance Management
When handling deposit and withdrawal requests, the system prevents overdraft scenarios. Files like `src/withdrawl.java` and `src/FastCash.java` dynamically query the SQL engine to retrieve the current available balance for the logged-in user, cast it into an integer, compare it against the input value, and throw error notifications via `JOptionPane` if funds are insufficient.
