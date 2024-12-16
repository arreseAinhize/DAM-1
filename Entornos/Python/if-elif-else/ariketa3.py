def main_ariketa3():
    num1 = int(input("Sartu lehenengo zenbakia: "))
    num2 = int(input("Sartu bigarren zenbakia: "))
    num3 = int(input("Sartu hirugarren zenbakia: "))

    if (num1 > num2 & num1 > num3): 
        print(num1,"zenbaki handiena da.")
    elif (num2 > num3 & num2 > num1): 
        print(num2,"zenbaki handiena da.")
    elif (num3 > num2 & num1 < num3): 
        print(num3,"zenbaki handiena da.")
    elif (num3 == num2 & num1 == num3): 
        print("Hiru zenbakiak berdinak dira. 1-",num1, "; 2-",num2,"; 3-",num3)
    else:
        print("Ez dakit zein den zenbakirik handiena, barkatu.1-",num1, "; 2-",num2,"; 3-",num3)
    

if __name__ == "__main__":
    main_ariketa3()