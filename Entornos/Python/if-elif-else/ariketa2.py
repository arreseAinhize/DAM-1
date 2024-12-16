def main_ariketa2():
    strInput = input("Sartu karaktere bat: ")
    charInput = strInput[0]
    charInputLower = charInput.lower()  
    if (charInput >= '0') & (charInput <= '9'):
        print(charInput,"Sartutako karaktera zenbaki bat da.")
    elif (charInputLower >= 'a') & (charInputLower <= 'z'):
        if (charInputLower == 'a') | (charInputLower == 'e') | (charInputLower == 'i') | (charInputLower == 'o') | (charInputLower == 'u'):
            print(charInput,"Sartutako karaktera bokal bat da.")
        else:
            print(charInput,"Sartutako karaktera konsonante bat da.")
    else:
        print(charInput,"Sartutako karaktera bete motatako karaktere bat da.")

if __name__ == "__main__":
    main_ariketa2()