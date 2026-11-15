# 🛒 Amazon Data Pipeline

### End-to-End E-Commerce Data Engineering Pipeline

An end-to-end data engineering project designed to extract, process, transform, and analyze e-commerce transactional data using **Java, JDBC, MySQL, Python, and Pandas**.

The project demonstrates how raw transactional data can be transformed into structured, analytics-ready datasets through an integrated data processing workflow.

---

## 🚀 Project Overview

The Amazon Data Pipeline simulates an e-commerce data environment by managing customer, product, and order information through a Java-based backend and processing transactional data using a Python-powered ETL pipeline.

The system follows an Extract, Transform, Load (ETL) architecture to convert raw transactional records into meaningful datasets for analytical reporting and business insights.

## ✨ Key Features

- **Data Generation:** Generates customer and order-related transactional data using Java.
- **Product Import:** Imports product information from CSV files.
- **Database Integration:** Uses JDBC to connect Java applications with MySQL.
- **Data Extraction:** Extracts transactional data from the database using Python.
- **Data Transformation:** Processes and cleans data using Pandas.
- **ETL Workflow:** Organizes extraction, transformation, and loading into separate modules.
- **Data Analytics:** Prepares structured datasets for business intelligence and visualization.

## 🏗️ System Architecture

```text
       ┌─────────────────────────┐
       │       Java Backend      │
       │                         │
       │  Customer Generation    │
       │  Product Import         │
       │  Order Generation       │
       └────────────┬────────────┘
                    │
                    ▼
       ┌─────────────────────────┐
       │       MySQL Database    │
       │                         │
       │  Customers              │
       │  Products               │
       │  Orders                 │
       └────────────┬────────────┘
                    │
                    ▼
       ┌─────────────────────────┐
       │      Python ETL         │
       │                         │
       │  Extract                │
       │  Transform              │
       │  Load                   │
       └────────────┬────────────┘
                    │
                    ▼
       ┌─────────────────────────┐
       │  Analytics-Ready Data   │
       │                         │
       │  Structured Datasets    │
       │  Business Analysis      │
       └─────────────────────────┘
```

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java | Backend development and data generation |
| JDBC | Database connectivity |
| MySQL | Relational database |
| Python | ETL processing |
| Pandas | Data transformation and manipulation |
| CSV | Product data import |

## 📁 Project Structure

```text
Amazon_data_pipeline/
│
├── backend_pipeline/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   ├── Service/
│   │       │   ├── dao/
│   │       │   ├── database/
│   │       │   ├── generator/
│   │       │   ├── model/
│   │       │   ├── util/
│   │       │   └── Main.java
│   │       │
│   │       └── resources/
│   │           └── product.csv
│   │
│   └── pom.xml
│
├── etl_flow/
│   └── etl/
│       ├── config.py
│       ├── extract.py
│       ├── transform.py
│       ├── load.py
│       ├── etl.py
│       └── test_extract.py
│
└── README.md
```

## ⚙️ Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/souumyyya/Amazon_data_pipeline.git
```

```bash
cd Amazon_data_pipeline
```

### 2. Configure the Database

- Install and configure MySQL.
- Create the required database.
- Update the database connection settings in the Java database configuration and Python ETL configuration files.

### 3. Run the Java Backend

Navigate to the backend directory:

```bash
cd backend_pipeline
```

Build the project using Maven:

```bash
mvn clean install
```

Run the Java application using your IDE or configured Maven execution setup.

### 4. Set Up Python Environment

Navigate to the ETL directory:

```bash
cd ../etl_flow/etl
```

Create a virtual environment:

```bash
python -m venv venv
```

Activate it on Windows:

```bash
venv\Scripts\activate
```

Install the required dependencies:

```bash
pip install pandas
```

### 5. Execute the ETL Pipeline

Run:

```bash
python etl.py
```

Ensure that the database connection and required dependencies are configured before execution.

## 🔄 ETL Workflow

**1. Extract**

Retrieve customer, product, and order data from the MySQL database.

**2. Transform**

Use Python and Pandas to process, clean, and structure the extracted transactional data.

**3. Load**

Load the processed data into the configured destination for downstream analysis.

## 🎯 Project Objectives

- Understand real-world data engineering workflows.
- Integrate Java-based backend systems with Python data processing.
- Implement database connectivity and data extraction.
- Build modular ETL components.
- Prepare structured data for analytics and reporting.

## 🔮 Future Enhancements

- Automate ETL execution through scheduled workflows.
- Integrate Apache Airflow for pipeline orchestration.
- Implement incremental data processing.
- Build interactive dashboards using Power BI.
- Introduce machine learning models for sales forecasting and customer behavior analysis.
- Deploy the pipeline on cloud infrastructure.

---

## 👨‍💻 Author

**Soumyaranjan**

Computer Science & Engineering Student | Java Developer | Aspiring Data Engineer

- GitHub: [@souumyyya](https://github.com/souumyyya)

---

⭐ If you find this project interesting, consider giving the repository a star!
