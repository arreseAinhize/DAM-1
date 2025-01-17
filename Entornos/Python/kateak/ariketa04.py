# Erabiltzaileak emandako kate batean zenbat bokal dauden zenbatu.
hitza = input("Sartu hitz bat: ")

contador = 0
for letra in hitza:
    if letra.lower() in "aeiouáéíóúü":
        contador += 1
print(f"'{hitza}' katean, {contador} bokal zenbatu dira.")