def main_ariketa1():
    letter = input("Enter a single alphabet: ")
    print(check_alphabet(letter))

def check_alphabet(letter):
    # Convert to lowercase for uniformity
    letter = letter.lower()

    # Simulating switch case with if-else
    if letter in ('a', 'e', 'i', 'o', 'u'):
        return f"{letter} is a vowel."
    elif letter.isalpha() and len(letter) == 1:
        return f"{letter} is a consonant."
    else:
        return "Invalid input. Please enter a single alphabet character."
    

if __name__ == "__main__":
    main_ariketa1()