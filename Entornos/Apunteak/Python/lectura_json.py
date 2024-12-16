import json
from clases import  Ordenagailua, Gela, Solairua

def leer_datos_json(path):
    with open(path, 'r') as archivo_json:
        gelak = []
        ordenagailuak = []
        datos = json.load(archivo_json)
        
        num_gela = datos[0]["room"]

        for line in datos:
            if num_gela != line["room"]:
                gelak.append(Gela(num_gela, ordenagailuak))
                ordenagailuak = []
                num_gela = line["room"]

            pc = Ordenagailua(line["id"],line["ip"],line["os"], line["buydate"] if line["buydate"] != 'unkown' else None, line["revisiondate"], line["notes"])
            ordenagailuak.append(pc)
    return Solairua(4, gelak)


