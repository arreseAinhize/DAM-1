def main_ariketa1():
    inputnum = int(input("Sartu zenbaki bat(1-7): "))
    if inputnum == 1:
        print("Astelehena")
    elif inputnum == 2:
        print("Asteartea")
    elif inputnum == 3:
        print("Asteazkena")
    elif inputnum ==4:
        print("Osteguna")
    elif inputnum == 5:
        print("Ostirala")
    elif inputnum == 6:
        print("Larunbata")
    elif inputnum == 7:
        print("Igandea")
    else:
        print("Sartutako zenbakiak ez du egun baliokiderik.")


if __name__ == "__main__":
    main_ariketa1()