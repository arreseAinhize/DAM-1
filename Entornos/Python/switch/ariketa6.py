def main_ariketa6():
    print("\nERAGIKETEN MENU NAGUSIA")  
    print("1. Biderketa")
    print("2. Gehiketa")
    print("3. Kenketa")
    print("4. Zatiketa")


    aukera = input("\nZer marraztu nahi duzu? ")

    if aukera == '1':
        num1 = int(input("Enter the first number: "))
        num2 = int(input("Enter the second number: "))
        print(biderkatu(num1,num2))
    elif aukera == '2':
        num1 = int(input("Enter the first number: "))
        num2 = int(input("Enter the second number: "))
        print(gehiketa(num1,num2))
    elif aukera == '3':
        num1 = int(input("Enter the first number: "))
        num2 = int(input("Enter the second number: "))
        print(kenketa(num1,num2))
    elif aukera == '4':
        num1 = int(input("Enter the first number: "))
        num2 = int(input("Enter the second number: "))
        print(zatiketa(num1,num2))
    else:
        print("Aukera okerra. Zahiatu berriz.")

def biderkatu(num1,num2):
    num3 = num1 * num2
    return f"Biderketaren emaitza: {num3}"
def gehiketa(num1,num2):
    num3 = num1 +num2
    return f"Gehiketaren emaitza: {num3}"

def kenketa(num1,num2):
    num3 = num1 - num2
    return f"Kenketaren emaitza: {num3}"

def zatiketa(num1,num2):
    num3 = num1 / num2
    return f"Zatiketaren emaitza: {num3}"

if __name__ == "__main__":
    main_ariketa6()