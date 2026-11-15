import time

from extract import extract_new_orders
from transform import transform
from load import *

while True:

    df = extract_new_orders()

    if df.empty:
        print("No new orders...")
        time.sleep(5)
        continue

    daily, category, state, product = transform(df)

    load_daily_sales(daily)
    load_category_sales(category)
    load_state_sales(state)
    load_product_sales(product)

    print("Analytics Updated Successfully")

    time.sleep(5)