import pandas as pd


def transform(df):

    if df.empty:
        return None, None, None, None

    # Convert to datetime
    df["order_date"] = pd.to_datetime(df["order_date"])

    daily_sales = (
        df.groupby(df["order_date"].dt.date)
        .agg(
            total_orders=("order_id", "count"),
            total_quantity=("quantity", "sum"),
            total_revenue=("total_amount", "sum")
        )
        .reset_index()
    )

    category_sales = (
        df.groupby("category")
        .agg(
            total_orders=("order_id", "count"),
            total_quantity=("quantity", "sum"),
            total_revenue=("total_amount", "sum")
        )
        .reset_index()
    )

    state_sales = (
        df.groupby("state")
        .agg(
            total_orders=("order_id", "count"),
            total_revenue=("total_amount", "sum")
        )
        .reset_index()
    )

    product_sales = (
        df.groupby(["product_id", "product_name"])
        .agg(
            total_orders=("order_id", "count"),
            total_quantity=("quantity", "sum"),
            total_revenue=("total_amount", "sum")
        )
        .reset_index()
    )

    return daily_sales, category_sales, state_sales, product_sales