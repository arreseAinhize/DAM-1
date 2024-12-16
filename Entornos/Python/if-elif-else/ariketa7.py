def main_ariketa7():
    strInput = input("Sartu karaktere bat: ")
    charInput = strInput[0]
    charInputLower = charInput.lower()  
    if (charInput >= '0') & (charInput <= '9'):
        print(charInput,"Sartutako karaktera zenbaki bat da.")
    elif (charInputLower >= 'a') & (charInputLower <= 'z'):
        print(charInput,"Alfabetoko letra bat da.")
    else:
        print(charInput,"Sartutako karaktera bete motatako karaktere bat da.")

if __name__ == "__main__":
    main_ariketa7()