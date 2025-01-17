

import csv

# CSV fitxategia ireki eta irakurri
with open('langileak.csv', mode='r') as file:
    reader = csv.reader(file)
    for row in reader:
        print(row)