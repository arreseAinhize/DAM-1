def main_menu():
    print("Entrando en el menú...")  # Añadir esta línea

    while True:
        print("\nMARRAZKIEN MENU NAGUSIA")  
        print("1. Triangelua")
        print("2. Karratua")
        print("3. Itxi")

        aukera = input("\nZer marraztu nahi duzu? ")

        if aukera == '1':
            option_1()
        elif aukera == '2':
            option_2()
        elif aukera == '3':
            print("Menutik irtete...")
            break
        else:
            print("Aukera okerra. Zahiatu berriz.")

def option_1():
    print("Zein motatako triangelua marraztu nahi duzu? \n 1.-Punta eskerraldean \n 2.-Punta erdialdean\n 3.-Punta eskuinaldean")

    forma = int(input("Sartu triangelu mota: "))

    if forma == 1:
        altuera = int(input("Sartu triangeluaren altuera: "))
        for row in range(1, altuera + 1):
            for col in range(1, altuera + 1):
                if row >= col:
                    print("* ", end="")
                else:
                    print("  ", end="")
            print()
    elif forma == 2:
        altuera = int(input("Sartu triangeluaren altuera: "))
        for i in range(altuera):
                # Imprime "altura - i - 1" espacios al inicio de cada línea para crear una sangría.
        # La cantidad de espacios disminuye en cada línea, formando un triángulo.
                print(" " * (altuera - i - 1), end="")
                print("*" * (2 * i + 1))    
    elif forma == 3:
        altuera = int(input("Sartu triangeluaren altuera: "))
        for row in range(1, altuera + 1):
            for col in range(altuera, 0, -1):  # <-- Cambia el rango del bucle interno
                if row >= col:
                    print("* ", end="")
                else:
                    print("  ", end="")
            print()
    else:
        print("Aukera okerra. Zahiatu berriz.")
    
def option_2():
    lado = int(input("Sartu karratuaren alboaren luzera: "))

    # Iteramos sobre cada fila del cuadrado
    for i in range(lado):
        # Imprimimos una línea de asteriscos con la longitud del lado
        print("*" * lado)

if __name__ == "__main__":
    main_menu()