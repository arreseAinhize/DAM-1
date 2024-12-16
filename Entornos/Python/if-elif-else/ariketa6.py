def main_ariketa6():
    num1 = int(input("Sartu lehenengo zenbakia: "))

    if (num1 > 0): 
        print(num1,"zenbaki positibo bat da.")
    elif (num1 == 0): 
        print(num1,"zenbakia da.")
    elif (num1 < 0): 
        print(num1,"zenbaki negatibo bat da.")
    
    else:
        print("Ez dakit zein zenbaki den")
    

if __name__ == "__main__":
    main_ariketa6()