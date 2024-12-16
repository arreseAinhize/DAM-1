def main_ariketa3():
    num = int(input("Zein zenbakiren biderketa taula kalkulatu nahi duzu? "))
    cont = 0
    while cont <= 10 :
        biderketa = cont * num
        print(f"|{num} X {cont} = {biderketa}|")
        cont = cont +1
    
if __name__ == "__main__":
    main_ariketa3()