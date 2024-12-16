import csv
from clases import  Ordenagailua, Gela, Solairua

def leer_datos_csv(path):
    gelak = []
    ordenagailuak = []

    with open(path) as file:
        csv_reader = csv.reader(file)
        next(csv_reader)
        num_gela = 101
        
        for line in csv_reader:
            if num_gela != int(line[0]):
                gelak.append(Gela(num_gela, ordenagailuak))
                ordenagailuak = []
                num_gela = int(line[0])

            pc = Ordenagailua(line[1],line[2],line[3], None, None, line[4])
            ordenagailuak.append(pc)
    return Solairua(1, gelak)
            

