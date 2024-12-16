def main_ariketa2():
    num = int(input("Zein zenbakiren faktoriala kalkulatu nahi duzu? "))
    faktoriala = 1
    for cont in range(1, num + 1): # range(1, num + 1) Esto asegura que iteramos desde 1 hasta el valor de num (ambos incluidos).
        
        faktoriala *= cont
    
    print(f"{num} zenbakiaren faktoriala {faktoriala} da.")
    
if __name__ == "__main__":
    main_ariketa2()