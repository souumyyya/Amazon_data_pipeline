import pandas as pd
from config import get_source_connection

CHECKPOINT_FILE = "checkpoint.txt"


def read_checkpoint():

    try:
        with open(CHECKPOINT_FILE, "r") as file:
            return int(file.read().strip())

    except:
        return 0


def update_checkpoint(last_order_id):

    with open(CHECKPOINT_FILE, "w") as file:
        file.write(str(last_order_id))


def extract_new_orders():

    last_order = read_checkpoint()

    connection = get_source_connection()

    query = f"""
        SELECT
            o.order_id,
            o.customer_id,
            c.city,
            c.state,
            p.product_id,
            p.product_name,
            p.category,
            p.brand,
            o.quantity,
            o.total_amount,
            o.payment_method,
            o.order_status,
            o.order_date
        FROM orders o
        JOIN customers c
            ON o.customer_id = c.customer_id
        JOIN products p
            ON o.product_id = p.product_id
        WHERE o.order_id > {last_order}
        ORDER BY o.order_id;
    """

    df = pd.read_sql(query, connection)

    connection.close()

    if not df.empty:
        update_checkpoint(df["order_id"].max())

    return df