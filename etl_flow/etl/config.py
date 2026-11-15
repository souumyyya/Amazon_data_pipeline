import mysql.connector

# Operational Database (Java writes here)
SOURCE_DB = {
    "host": "localhost",
    "user": "root",
    "password": "qwerty",
    "database": "ecommerce_pipeline"
}

# Analytics Database (Python writes here)
TARGET_DB = {
    "host": "localhost",
    "user": "root",
    "password": "qwerty",
    "database": "ecommerce_analytics"
}


def get_source_connection():
    return mysql.connector.connect(**SOURCE_DB)


def get_target_connection():
    return mysql.connector.connect(**TARGET_DB)