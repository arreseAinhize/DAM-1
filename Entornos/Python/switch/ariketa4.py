def main_ariketa4():
    num1 = input("Enter the first number: ")
    num2 = input("Enter the second number: ")

    if num1.replace('.', '', 1).isdigit() and num2.replace('.', '', 1).isdigit():
        num1 = float(num1)
        num2 = float(num2)
        print(find_maximum(num1, num2))
    else:
        print("Invalid input. Please enter numeric values.")
        
def find_maximum(num1, num2):
    # Simulate switch-case using if-else
    if num1 > num2:
        return f"The maximum number is {num1}."
    elif num2 > num1:
        return f"The maximum number is {num2}."
    else:
        return "Both numbers are equal."
    
if __name__ == "__main__":
    main_ariketa4()