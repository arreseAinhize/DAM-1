import pickle

# Objektu fitxategiaren izena
egoera_fitxategia = 'egoera.dat'

# Egoera lehenetsia
egoera_berria = {
    'izena': '',
    'maila': 1,
    'puntuak': 0
}

# Azken egoera berreskuratu
try:
    with open(egoera_fitxategia, mode='rb') as file:
        egoera = pickle.load(file)
        print("Azken egoera berreskuratua:")
        print(egoera)
except FileNotFoundError:
    egoera = egoera_berria
    print("Ez da aurkitu egoera gordea, egoera berria hasiko da.")

# Erabiltzailearen datuak aldatu
print("\nErabiltzailearen egoera eguneratzen...")
egoera['izena'] = input("Sartu zure izena: ")
egoera['maila'] += 1
egoera['puntuak'] += 50

print("\nEguneratutako egoera:")
print(egoera)

# Egoera gordetzen
with open(egoera_fitxategia, mode='wb') as file:
    pickle.dump(egoera, file)
    print("\nEgoera gordeta!")


import pickle

# Gordeko dugun objektua
datuak = {'Izena': 'Ane', 'Adina': 25, 'Hiria': 'Bilbo'}

# Objektua fitxategian gorde
with open('datuak.pkl', 'wb') as fitxategia:
    pickle.dump(datuak, fitxategia)  # Objektua binario-formatuan gordetzen du

import pickle

# Objektu fitxategia irakurri
with open('datuak.pkl', 'rb') as fitxategia:
    berreskuratutako_datuak = pickle.load(fitxategia)  # Objektua kargatzen du
    print(berreskuratutako_datuak)  # Gordetako datuak inprimatzen ditu

import pickle

# Gordeko dugun objektua (adibidez, zerrenda)
zerrenda = [1, 2, 3, 4, 5]

# Objektua fitxategian idatzi
with open('zerrenda.pkl', 'wb') as fitxategia:
    pickle.dump(zerrenda, fitxategia)  # Objektua binario-formatuan gordetzen du

    import pickle

# Lehendik zeuden datuak berreskuratu
try:
    with open('zerrenda.pkl', 'rb') as fitxategia:
        zerrenda = pickle.load(fitxategia)
except FileNotFoundError:
    zerrenda = []

# Datu berriak gehitu
zerrenda.append(6)

# Objektu fitxategia eguneratu
with open('zerrenda.pkl', 'wb') as fitxategia:
    pickle.dump(zerrenda, fitxategia)

print("Eguneratutako zerrenda:", zerrenda)



import pickle

# Pertsona klasea definitu
class Pertsona:
    def __init__(self, izena, adina):
        self.izena = izena
        self.adina = adina

# Objektu bat sortu eta gorde
pertsona = Pertsona('Ane', 25)
with open('pertsona.pkl', 'wb') as fitxategia:
    pickle.dump(pertsona, fitxategia)

# Objektua irakurri
with open('pertsona.pkl', 'rb') as fitxategia:
    berreskuratua = pickle.load(fitxategia)
    print(f"Izena: {berreskuratua.izena}, Adina: {berreskuratua.adina}")
