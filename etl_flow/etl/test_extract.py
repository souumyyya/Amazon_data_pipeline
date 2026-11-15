from extract import extract_new_orders

df = extract_new_orders()

print(df)

print()

print("Total New Orders :", len(df))