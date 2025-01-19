import csv

# Datuak definitu
lerroak = [
    ['Izena', 'Adina', 'Hiria'],
    ['Ane', 25, 'Bilbo'],
    ['Mikel', 30, 'Donostia'],
    ['Leire', 22, 'Gasteiz']
]

# CSV fitxategia sortu
with open('datuak.csv', 'w', newline='') as fitxategia:
    idazlea = csv.writer(fitxategia)
    idazlea.writerows(lerroak)  # Datuak lerroka idazten ditu  

import csv

# CSV fitxategia ireki eta irakurri
with open('datuak.csv', mode='r') as file:
    reader = csv.reader(file)
    for row in reader:
        print(row)

import csv

with open('datuak.csv', mode='r') as fitxategia:
    reader = csv.DictReader(fitxategia)
    for row in reader:
        print(f"Izena: {row['Izena']}, Adina: {row['Adina']}")

import csv

# Fitxategian datuak idatzi
with open('datuak_idatzi.csv', 'w', newline='') as fitxategia:
    idazlea = csv.writer(fitxategia)
    idazlea.writerow(['Izena', 'Adina', 'Hiria'])  # Zutabe-izenak gehitzen ditu
    idazlea.writerow(['Ane', 25, 'Bilbo'])  # Erregistro bat idazten du
    idazlea.writerow(['Mikel', 30, 'Donostia'])  # Beste erregistro bat gehitzen du
    idazlea.writerow(['Leire', 22, 'Gasteiz'])



