def main_ariketa1():
    num = int(input("Zein zenbakiren 'Sum of Natural Numbers' kalkulatu nahi duzu? "))
    gehiketa = 0
    for cont in range(0, num + 1): # range(1, num + 1) Esto asegura que iteramos desde 1 hasta el valor de num (ambos incluidos).
        gehiketa += cont
    
    print(f"{num} zenbakiaren batuketa naturalaren batura {gehiketa} da.")
    
if __name__ == "__main__":
    main_ariketa1()