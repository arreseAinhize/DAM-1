import os
import time
from datetime import datetime, timedelta

def main_menu():
    print("Entrando en el menú...")  # Añadir esta línea

    while True:
        clear()
        print("\nZer egin nahi duzu? \n 1- Find Sum of Natural Numbers \n 2- Find Factorial of a Number \n 3- Generate Multiplication Table (10)")
        print(" 4- Reverse a Number \n 5- Calculate the power of a number \n 6- Check wheather a number is prime or not")
        print(" 7- Fibonacci \n 8- Quadratic Solver \n 9- Draw something \n 10- Happy Birthday \n 11- Calification \n 12- Irten")

        aukera = input("Aukeratu: ")

        if aukera == '1':
            clear()
            naturalNumbers()
            time.sleep(2)

        elif aukera == '2':
            clear()
            try:
                x = int(input("Sartu zenbakia: "))
                num = faktorial(x)
                print(f"Faktorialaren emaitza, {num} da.")
            except ValueError:
                print("Errorea: Zenbaki baliodun bat sartu behar duzu.")
            time.sleep(2)

        elif aukera == '3':
            clear()
            multiTable()
            time.sleep(2)

        elif aukera == '4':
            clear()
            reverseNumber()
            time.sleep(2)

        elif aukera == '5':
            clear()
            powerNumber()
            time.sleep(2)

        elif aukera == '6':
            clear()
            primeNumber()
            time.sleep(2)

        elif aukera == '7':
            clear()
            fibonacci()
            time.sleep(2)

        elif aukera == '8':
            clear()
            quadraticSolver()
            time.sleep(2)

        elif aukera == '9':
            clear()
            drawSomething()
            time.sleep(2)

        elif aukera == '10':
            clear()
            urtebetetzea()
            time.sleep(2)

        elif aukera == '11':
            clear()
            kalifikazioak()
            time.sleep(5)

        elif aukera == '12':
            print("Menutik irtete...")
            time.sleep(2)
            break

        else:
            print("Aukera okerra. Zahiatu berriz.")
            time.sleep(2)

def naturalNumbers():
    try:
        num = int(input("Satu konprobatzeko zenbakia: "))
        cont = 0
        gehiketa = 0
        while cont <= num:
            gehiketa += cont
            cont += 1
        print(f"{num} zenbakitik ateratzen den, zenbaki naturalen gehiketa, {gehiketa} da.")
    except ValueError:
        print("Errorea: Zenbaki baliodun bat sartu behar duzu.")

def faktorial(x):
    if x == 0:
        return 1
    return x * faktorial(x - 1)

def multiTable():
    try:
        num = int(input("Zein zenbakiren biderketa taula kalkulatu nahi duzu? "))
        for cont in range(11):
            biderketa = cont * num
            print(f"|{num} X {cont} = {biderketa}|")
    except ValueError:
        print("Errorea: Zenbaki baliodun bat sartu behar duzu.")

def reverseNumber():
    try:
        num = int(input("Sartu zenbaki bat bere alderantzizkoa ateratzeko: "))
        reversed_num = str(num)[::-1]
        print(f"Zure zenbaki berria: {reversed_num}")
    except ValueError:
        print("Errorea: Zenbaki baliodun bat sartu behar duzu.")

def powerNumber():
    try:
        berrekizuna = int(input("Sartu berrekizunaren balioa: "))
        berretzailea = int(input("Sartu berretzailearen balioa: "))
        emaitza = berrekizuna ** berretzailea
        print(f"{berrekizuna}^{berretzailea}={emaitza}")
    except ValueError:
        print("Errorea: Zenbaki baliodun bat sartu behar duzu.")

def primeNumber():
    try:
        num = int(input("Sartu zenbaki bat: "))
        if num <= 1:
            print(f"{num} ez da zenbaki lehena.")
            return
        lehenaDa = all(num % i != 0 for i in range(2, int(num**0.5) + 1))
        if lehenaDa:
            print(f"{num} zenbaki lehena da.")
        else:
            print(f"{num} ez da zenbaki lehena.")
    except ValueError:
        print("Errorea: Zenbaki baliodun bat sartu behar duzu.")

def fibonacci():
    fn_minus1, fn_minus2 = 1, 1
    n_max = 20
    print(f"Lehenengo {n_max} Fibonacci zenbakiak:", end=" ")
    print(fn_minus2, fn_minus1, end=" ")
    for _ in range(3, n_max + 1):
        fn = fn_minus1 + fn_minus2
        print(fn, end=" ")
        fn_minus2, fn_minus1 = fn_minus1, fn
    print()

def quadraticSolver():
    try:
        a = float(input("Sartu 'a'-ren balioa: "))
        if a == 0:
            print("Errorea: 'a' ezin da izan 0.")
            return
        b = float(input("Sartu 'b'-ren balioa: "))
        c = float(input("Sartu 'c'-ren balioa: "))
        d = (b**2) - (4*a*c)
        sol1 = (-b - d**0.5) / (2*a)
        sol2 = (-b + d**0.5) / (2*a)
        print(f"Irtenbideak: {sol1} eta {sol2}")
    except ValueError:
        print("Errorea: Zenbaki baliodun bat sartu behar duzu.")

def drawSomething():
    while True:
        print("\nMARRAZKIEN MENU NAGUSIA")
        print("1. Triangelua")
        print("2. Karratua")
        print("3. Itxi")

        aukera = input("\nZer marraztu nahi duzu? ")

        if aukera == '1':
            drawTriangle()
        elif aukera == '2':
            drawSquare()
        elif aukera == '3':
            break
        else:
            print("Aukera okerra. Zahiatu berriz.")
            time.sleep(2)

def drawTriangle():
    print("Zein motatako triangelua marraztu nahi duzu? \n 1.-Punta eskerraldean \n 2.-Punta erdialdean\n 3.-Punta eskuinaldean")

    forma = int(input("Sartu triangelu mota: "))

    if forma == 1:
        clear()

        altuera = int(input("Sartu triangeluaren altuera: "))
        for row in range(1, altuera + 1):
            for col in range(1, altuera + 1):
                if row >= col:
                    print("* ", end="")
                else:
                    print("  ", end="")
            print()
        time.sleep(2)

    elif forma == 2:
        clear()
        altuera = int(input("Sartu triangeluaren altuera: "))
        for i in range(altuera):
                # Imprime "altura - i - 1" espacios al inicio de cada línea para crear una sangría.
        # La cantidad de espacios disminuye en cada línea, formando un triángulo.
                print(" " * (altuera - i - 1), end="")
                print("*" * (2 * i + 1))    
        time.sleep(2)
    elif forma == 3:
        clear()
        altuera = int(input("Sartu triangeluaren altuera: "))
        for row in range(1, altuera + 1):
            for col in range(altuera, 0, -1):  # <-- Cambia el rango del bucle interno
                if row >= col:
                    print("* ", end="")
                else:
                    print("  ", end="")
            print()
        time.sleep(2)
    else:
        print("Aukera okerra. Zahiatu berriz.")

def drawSquare():
    try:
        lado = int(input("Sartu karratuaren alboaren luzera: "))
        for _ in range(lado):
            print("*" * lado)
    except ValueError:
        print("Errorea: Zenbaki baliodun bat sartu behar duzu.")

def urtebetetzea():
    try:
        eguna = int(input("Sartu zure urtebetetze eguna (1-31): "))
        hilea = int(input("Sartu zure urtebetetze hilabetea (1-12): "))
        gaur = datetime.now()
        urteguna = datetime(year=gaur.year, month=hilea, day=eguna)
        if urteguna < gaur:
            urteguna = datetime(year=gaur.year + 1, month=hilea, day=eguna)
        faltadenDenbora = (urteguna - gaur).days
        print(f"{faltadenDenbora} egun falta dira zure urtebetetzetarako.")
    except ValueError:
        print("Errorea: Baliozko data bat sartu behar duzu.")

def kalifikazioak():
    print("Ongi etorri kalifikazioen kudeatzailera.\n")
    ikasleak = {}
    while True:
        izena = input("Sartu ikaslearen izena (edo idatzi 'bukatu' amaitzeko): ")
        if izena.lower() == 'bukatu':
            break
        try:
            kalifikazioa = float(input(f"Sartu {izena}-ren kalifikazioa: "))
            if 0 <= kalifikazioa <= 10:
                ikasleak[izena] = kalifikazioa
            else:
                print("Kalifikazioa 0 eta 10 artean egon behar da.")
        except ValueError:
            print("Errorea: Zenbaki baliodun bat sartu behar duzu.")
    
    if ikasleak:
        batazbestekoa = sum(ikasleak.values()) / len(ikasleak)
        hoberena = max(ikasleak, key=ikasleak.get)
        okerrena = min(ikasleak, key=ikasleak.get)
        for izena, kalifikazioa in ikasleak.items():
            print(f"- {izena}: {kalifikazioa:.2f}")
        print(f"\nKalifikazioen batez bestekoa: {batazbestekoa:.2f}")
        print(f"Ikasle hoberena: {hoberena} ({ikasleak[hoberena]:.2f}) kalifikazioarekin")
        print(f"Ikasle okerrena: {okerrena} ({ikasleak[okerrena]:.2f}) kalifikazioarekin")

def clear():
    if os.name == "nt":
        os.system("cls")
    else:
        os.system("clear")

if __name__ == "__main__":
    main_menu()