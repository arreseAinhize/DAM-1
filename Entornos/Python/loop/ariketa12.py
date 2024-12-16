def main_ariketa12():
    print("BI ZENBAKIREN ARTEKO, ZENBAKI LEHENAK")
    start = int(input("Hasierako zenbakia sartu: "))
    end = int(input("Amaierako zenbakia sartu: "))

    if start > end:
        print("Sartutako 'rangoa' ez da zuzena.")
        return

    print(f"{start} eta {end}-ren arteko zenbaki lehenak:")
    for num in range(start, end + 1):
        if num > 1: 
            is_prime = True
            for i in range(2, int(num ** 0.5) + 1):
                if num % i == 0:
                    is_prime = False
                    break
            if is_prime:
                print(num, end=", ")
    print() 
    
if __name__ == "__main__":
    main_ariketa12()
