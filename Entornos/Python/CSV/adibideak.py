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

# CSV fitxategia ireki eta irakurri
with open('datuak.csv', mode='r') as file:
    reader = csv.reader(file)
    for row in reader:
        print(row)

with open('datuak.csv', mode='r') as fitxategia:
    reader = csv.DictReader(fitxategia)
    for row in reader:
        print(f"Izena: {row['Izena']}, Adina: {row['Adina']}")

# Fitxategian datuak idatzi
with open('datuak_idatzi.csv', 'w', newline='') as fitxategia:
    idazlea = csv.writer(fitxategia)
    idazlea.writerow(['Izena', 'Adina', 'Hiria'])  # Zutabe-izenak gehitzen ditu
    idazlea.writerow(['Ane', 25, 'Bilbo'])  # Erregistro bat idazten du
    idazlea.writerow(['Mikel', 30, 'Donostia'])  # Beste erregistro bat gehitzen du
    idazlea.writerow(['Leire', 22, 'Gasteiz'])

# Fitxategian datuak irakurri eta bilatu langile bat izenaren arabera
def bilatu_langilea(izena_bilatuta):
    with open('datuak_idatzi.csv', 'r') as fitxategia:
        irakurlea = csv.DictReader(fitxategia)
        
        for langilea in irakurlea:
            if langilea['Izena'].lower() == izena_bilatuta.lower():
                return f"Langilea aurkitu da: Izena: {langilea['Izena']}, Adina: {langilea['Adina']}, Hiria: {langilea['Hiria']}"
        return "Langilea ez da aurkitu."

# Adibide bat erabiliz
izena_bilatuta = input("Sartu langilearen izena bilatzeko: ")
print(bilatu_langilea(izena_bilatuta))