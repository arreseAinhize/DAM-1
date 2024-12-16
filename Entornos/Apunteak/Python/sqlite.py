import sqlite3
from clases import  Ordenagailua, Gela, Solairua

def leer_datos_sqlite(path):

    konexioa = sqlite3.connect('./datuak/solairua_2/ordenagailuak.db')

    # Kurtsorea lortu
    kurtsorea = konexioa.cursor()

    kurtsorea.execute("SELECT * FROM ordenagailuak")
    ordenagailuak = kurtsorea.fetchall()

    ordenagailu_lista = []
    gela_lista = []
    gela_kodea = 201

    for o in ordenagailuak:
        if gela_kodea != o[1]:
            gela_lista.append(Gela(gela_kodea, ordenagailu_lista))
            ordenagailu_lista = []
            gela_kodea = o[1]
            
        ordenagailu_lista.append(Ordenagailua(o[0], o[2], o[3], None, None, o[4]))

    gela_lista.append(Gela(gela_kodea, ordenagailu_lista))   
    konexioa.close()
    return Solairua(2, gela_lista)