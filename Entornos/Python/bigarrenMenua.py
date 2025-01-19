# Egilea: Ainhize Arrese DAM-1

import os
import time
import re
from datetime import datetime, timedelta

def main_menu():
    hasieraMenua = True
    while hasieraMenua == True:
        clear()
        print("\nZer egin nahi duzu? \n 1- Kateen eragiketak \n 2- Zerrenden eragiketak \n 3- Data eta denboren eragiketak \n 4- Menutik irten") 

        aukera = input("Aukeratu: ")

        if aukera == '1':
            clear()
            kateak()
            time.sleep(3)

        elif aukera == '2':
            clear()
            zerrendak()
            time.sleep(3)

        elif aukera == '3':
            clear()
            datatime()
            time.sleep(3)

        elif aukera == '4':
            print("Menutik irtete...")
            time.sleep(3)
            hasieraMenua = False
            break

        else:
            print("Aukera okerra. Zahiatu berriz.")
            time.sleep(3)

def kateak():
    kateMenua = True
    while kateMenua == True:
        clear()
        print("\nZer egin nahi duzu? \n 1- Katea zerrenda bihurtu \n 2- Katean zerbait ordezkatu \n 3- Katea osotara letra txikiz zein larriz idatzi \n 4- Hasierako menura itzuli") 

        aukeraKatea = input("Aukeratu: ")

        if aukeraKatea == '1':
            clear()
            kateZerrenda()
            time.sleep(3)

        elif aukeraKatea == '2':
            clear()
            kateOrdezkapenak()
            time.sleep(3)

        elif aukeraKatea == '3':
            clear()
            kateMayMin()
            time.sleep(3)

        elif aukeraKatea == '4':
            print("Menutik irtete...")
            time.sleep(3)
            kateMenua = False
            break

        else:
            print("Aukera okerra. Zahiatu berriz.")
            time.sleep(3)

def kateZerrenda():
    katea1 = input("Sartu katea bat: ")
    lista1 = katea1.split(' ')
    print(lista1)

def kateOrdezkapenak():
    katea2 = input("Sartu katea bat: ")
    hitza1 = input("Sartu ordezkatu nahi duzun hitza: ")
    hitza2 = input("Zer idatzi nahi duzu bere ordez? ")
    katea4 = katea2.replace(hitza1, hitza2, 1)
    print(f"Hau da zure lehenengo katea: {katea2}\nHau da zure kate berria: {katea4}")

def kateMayMin():
    katea3 = input("Sartu katea bat: ")
    lower = katea3.lower()
    upper = katea3.upper()
    print(f"Katea: {katea3} / Katea minuskulaz: {lower} / Katea maiuskulaz: {upper}")

def zerrendak():
    zerrendaMenua = True
    zerrenda0 = ["patatak", "kipulak", "esnea", "arrautzak", "kafea"]
    while zerrendaMenua:
        clear()
        print("Zure zerrenda:", zerrenda0)
        print("\nZer egin nahi duzu? \n 1- Zerrendan elementu bat gehitu hasierako zerrendan \n 2- Hasierako zerrenda ordenatu \n 3- Kalifikazioen zerrenda bat sortu \n 4- Hasierako menura itzuli")

        aukeraZerrenda = input("Aukeratu: ")

        if aukeraZerrenda == '1':
            clear()
            gehitu(zerrenda0)
            time.sleep(3)

        elif aukeraZerrenda == '2':
            clear()
            ordenatu(zerrenda0)
            time.sleep(3)

        elif aukeraZerrenda == '3':
            clear()
            kalifikazioak()
            time.sleep(3)

        elif aukeraZerrenda == '4':
            print("Menutik irtete...")
            time.sleep(3)
            zerrendaMenua = False
            break

        else:
            print("Aukera okerra. Zahiatu berriz.")
            time.sleep(3)

def gehitu(zerrenda0):
    while True:
        erosiBeharrekoa = input("Zer elementu gehitu nahi duzu? (Idatzi 'stop' amaitzeko): ")
        elementuak = re.split(r'[,\s]+', erosiBeharrekoa.strip())
        if 'stop' in elementuak:
            elementuak.remove('stop')
            zerrenda0.extend(elementuak)
            break
        zerrenda0.extend(elementuak)
    print(f"Hau da zure zerrenda berria: {zerrenda0}")

def ordenatu(zerrenda0):
    zerrenda0.sort()
    print("Zerrenda ordenatua (alfabetikoki):", zerrenda0)

def kalifikazioak():
    ikasleak = {}
    while True:
        izena = input("Sartu ikaslearen izena (edo idatzi 'bukatu' amaitzeko): ")
        if izena.lower() == 'bukatu':
            break
        try:
            kalifikazioa = float(input(f"Sartu {izena}-ren kalifikazioa: "))
            if 0 <= kalifikazioa <= 10:
                ikasleak[izena] = kalifikazioa
            else:
                print("Kalifikazioa 0 eta 10 artean egon behar da.")
        except ValueError:
            print("Errorea: Zenbaki baliodun bat sartu behar duzu.")
    
    if ikasleak:
        batazbestekoa = sum(ikasleak.values()) / len(ikasleak)
        hoberena = max(ikasleak, key=ikasleak.get)
        okerrena = min(ikasleak, key=ikasleak.get)
        print(f"\nKalifikazioen batez bestekoa: {batazbestekoa:.2f}")
        print(f"Ikasle hoberena: {hoberena} ({ikasleak[hoberena]:.2f})")
        print(f"Ikasle okerrena: {okerrena} ({ikasleak[okerrena]:.2f})")

def datatime():
    dataTimeMenua = True
    while dataTimeMenua:
        clear()
        print("\nZer egin nahi duzu? \n 1- Urte betetzerako falta den denbora kalkulatu \n 2- Urte kopurua kalkulatu \n 3- Hasierako menura itzuli")

        aukeradataTime = input("Aukeratu: ")

        if aukeradataTime == '1':
            clear()
            urtebetetzea()
            time.sleep(3)

        elif aukeradataTime == '2':
            clear()
            urtekopurua()
            time.sleep(3)

        elif aukeradataTime == '3':
            print("Menutik irtete...")
            time.sleep(3)
            dataTimeMenua = False
            break

        else:
            print("Aukera okerra. Zahiatu berriz.")
            time.sleep(3)

def urtebetetzea():
    try:
        eguna = int(input("Sartu zure urtebetetze eguna (1-31): "))
        hilea = int(input("Sartu zure urtebetetze hilabetea (1-12): "))
        gaur = datetime.now()
        urteguna = datetime(year=gaur.year, month=hilea, day=eguna)
        if urteguna < gaur:
            urteguna = datetime(year=gaur.year + 1, month=hilea, day=eguna)
        faltadenDenbora = (urteguna - gaur).days
        print(f"{faltadenDenbora} egun falta dira zure urtebetetzetarako.")
    except ValueError:
        print("Errorea: Baliozko data bat sartu behar duzu.")

def urtekopurua():
    try:
        eguna = int(input("Sartu zure jaiotza eguna (1-31): "))
        hilea = int(input("Sartu zure jaiotza hilabetea (1-12): "))
        urtea = int(input("Sartu zure jaiotza urtea: "))
        gaur = datetime.now()
        jaiotzaData = datetime(year=urtea, month=hilea, day=eguna)
        edad = gaur.year - jaiotzaData.year - ((gaur.month, gaur.day) < (jaiotzaData.month, jaiotzaData.day))
        print(f"{edad} urte dituzu.")
    except ValueError:
        print("Errorea: Baliozko data bat sartu behar duzu.")

def clear():
    if os.name == "nt":
        os.system("cls")
    else:
        os.system("clear")

if __name__ == "__main__":
    main_menu()