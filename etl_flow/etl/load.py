from config import get_target_connection


def load_daily_sales(df):

    connection = get_target_connection()
    cursor = connection.cursor()

    sql = """
    INSERT INTO daily_sales
    VALUES(%s,%s,%s,%s)

    ON DUPLICATE KEY UPDATE

    total_orders = total_orders + VALUES(total_orders),

    total_quantity = total_quantity + VALUES(total_quantity),

    total_revenue = total_revenue + VALUES(total_revenue)
    """

    for _, row in df.iterrows():

        cursor.execute(sql, (
            row["order_date"],
            int(row["total_orders"]),
            int(row["total_quantity"]),
            float(row["total_revenue"])
        ))

    connection.commit()

    cursor.close()
    connection.close()


def load_category_sales(df):

    connection = get_target_connection()
    cursor = connection.cursor()

    sql = """
    INSERT INTO category_sales
    VALUES(%s,%s,%s,%s)

    ON DUPLICATE KEY UPDATE

    total_orders = total_orders + VALUES(total_orders),

    total_quantity = total_quantity + VALUES(total_quantity),

    total_revenue = total_revenue + VALUES(total_revenue)
    """

    for _, row in df.iterrows():

        cursor.execute(sql, (
            row["category"],
            int(row["total_orders"]),
            int(row["total_quantity"]),
            float(row["total_revenue"])
        ))

    connection.commit()

    cursor.close()
    connection.close()


def load_state_sales(df):

    connection = get_target_connection()
    cursor = connection.cursor()

    sql = """
    INSERT INTO state_sales
    VALUES(%s,%s,%s)

    ON DUPLICATE KEY UPDATE

    total_orders = total_orders + VALUES(total_orders),

    total_revenue = total_revenue + VALUES(total_revenue)
    """

    for _, row in df.iterrows():

        cursor.execute(sql, (
            row["state"],
            int(row["total_orders"]),
            float(row["total_revenue"])
        ))

    connection.commit()

    cursor.close()
    connection.close()


def load_product_sales(df):

    connection = get_target_connection()
    cursor = connection.cursor()

    sql = """
    INSERT INTO product_sales
    VALUES(%s,%s,%s,%s,%s)

    ON DUPLICATE KEY UPDATE

    total_orders = total_orders + VALUES(total_orders),

    total_quantity = total_quantity + VALUES(total_quantity),

    total_revenue = total_revenue + VALUES(total_revenue)
    """

    for _, row in df.iterrows():

        cursor.execute(sql, (
            int(row["product_id"]),
            row["product_name"],
            int(row["total_orders"]),
            int(row["total_quantity"]),
            float(row["total_revenue"])
        ))

    connection.commit()

    cursor.close()
    connection.close()