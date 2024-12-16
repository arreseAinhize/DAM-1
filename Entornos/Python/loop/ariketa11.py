def main_ariketa11():
    print("ZENBAKI LEHENA DA EDO EZ?")
    num = int(input("Sartu zenbaki bat: "))
    
    if num <= 1:  # 0 y 1 no son primos
        print(f"{num} ez da zenbaki lehena.")
        return

    # Verificar si tiene divisores
    lehenaDa = True
    for cont in range(2, int(num**0.5) + 1):  # Comprobar hasta la raíz cuadrada
        if num % cont == 0:
            lehenaDa = False
            break

    # Resultado
    if lehenaDa == True:
        print(f"{num} zenbaki lehena da.")
    else:
        print(f"{num} ez da zenbaki lehena.")

if __name__ == "__main__":
    main_ariketa11()
