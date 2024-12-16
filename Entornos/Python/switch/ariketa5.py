def main_ariketa5():
    num1 = int(input("Enter the first number: "))
    print(find_evenOrOdd(num1))

def find_evenOrOdd(num1):
    # Simulate switch-case using if-else
    if num1 % 2 == 0:
        return f"{num1} Is an even number."
    else:
        return f"{num1} Is an odd number."
    
if __name__ == "__main__":
    main_ariketa5()