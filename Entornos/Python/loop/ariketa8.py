def main_ariketa8():
    num = int(input("Sartu zenbaki bat bere digituak zenbatzeko: "))
    digit = 0
    if num == 0:
        print(f"zure zenbaki berria: {num}")
    else:
        # end="" <-- salto de linea kendu
        print(f"Zure zenbaki berria: ", end="")
        while num>0:
            digit = num % 10
            print(digit, end="")
            num = num//10
    
if __name__ =="__main__":
    main_ariketa8()