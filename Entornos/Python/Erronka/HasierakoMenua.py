# Egileak: Angie, Anas eta Ainhize
# Data: 2025-02-20
# Ikastaroa: PAAG - 1

import CSV
import os
import time

def main_menua():
    loop = True
    
    while loop:
        clear()
        
        print("Ongi etorri menura, zer egin nahi duzu?")
        print("-----------------------------------------")
        print("| 1.- Erabiltzaile berri bat gehitu      |")
        print("| 2.- Erabiltzaile bat ezabatu           |")
        print("| 3.- Erabiltzaile baten datuak editatu  |")
        print("| 4.- Erabiltzaileak erakutzi            |")
        print("| 5.- Irte                               |")
        print("-----------------------------------------")
        print("Zer gin nahi duzu? (1-5)")
        
        aukera = input("Aukeratu: ")

        match aukera:
            case 1:
                clear()
                print("lehen aukera")
                erbBerriGehitu()
                time.sleep(3)

            case 2:
                clear()
                print("bigarren aukera")
                erbEzabatu()
                time.sleep(3)
            case 3:
                clear()
                print("hirugarren aukera")
                erbAktualizatu()
                time.sleep(3)
            case 4:
                clear()
                print("laugarren aukera")
                erbGuztiakErakutsi()
                time.sleep(3)
            case 5:
                clear()
                print("bostgarren aukera")
                loop = False
                
            case _:
                print("aukera okerra")
                time.sleep(3)

def erbBerriGehitu():
    print("Erabiltzaile berria gehitu")
    
def erbEzabatu():
    print("Erabiltzailea ezabatzen")

def erbAktualizatu():
    print("Erabiltzailea aktualizatzen")

def erbGuztiakErakutsi():
    print("Erabiltzailea guztiak erakusten")

def clear():
    if os.name == "nt":
        os.system("cls")
    else:
        os.system("clear")
    
if __name__ == "__main__":
    main_menua()
                
