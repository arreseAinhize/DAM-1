# Egileak: Angie Criollo, Anas Brahim eta Ainhize Arrese
# Ikasturtea: 2024-2025
# Ikasgaia: Garapen Ingurumena (PAAG-1)
# Data: 2025eko otsaila 6a

# **********************  APLIKAZIOAREN KUDEAKETARAKO GEHIGARRIAK  **********************
import os
import time
import csv

# **********************  KONTSOLARAKO KOLOREAK  **************************
GORRIA = '\033[91m'
BERDEA = '\033[92m'
HORIA = '\033[93m'
URDINA = '\033[94m'
CIAN = '\033[96m'
RESET = '\033[0m'

# **********************  MENUAK NAGUSIA  **********************
def main_menu():
    loop = True

    while loop:
        kontsolaGarbitu()
        print(f"{BERDEA}Ongi etorri menu nagusira, zer egin nahi duzu?{RESET}")
        print(f"{CIAN} ----------------------------------------{RESET}")
        print(f"{URDINA}| 1- Gazteen datuak kudeatu.             |{RESET}")
        print(f"{URDINA}| 2- Langileen datuak kudeatu.           |{RESET}")
        print(f"{URDINA}| 3- Orientatzaileen datuak kudeatu.     |{RESET}")
        print(f"{URDINA}| 4- Hitzaldien datuak kudeatu.          |{RESET}")
        print(f"{URDINA}| 5- Aplikazioa itxi.                    |{RESET}")
        print(f"{CIAN} ----------------------------------------{RESET}")
        try:
            aukera = int(input(f"  · Aukeratu (1-5):{HORIA} "))
            print(RESET, end="") 

            match aukera:
                case 1:
                    kontsolaGarbitu()
                    sub_Menu('Gazte')
                    time.sleep(2.5)
                
                case 2:
                    kontsolaGarbitu()
                    sub_Menu('Langile')
                    time.sleep(2.5)
                
                case 3:
                    kontsolaGarbitu()
                    sub_Menu('Orientatzaile')
                    time.sleep(2.5)
                
                case 4:
                    kontsolaGarbitu()
                    sub_Menu('Hitzaldi')
                    time.sleep(2.5)
                
                case 5: 
                    kontsolaGarbitu()
                    print("Aplikazioa itxi da, eskerrik asko erabiltzeagatik.")
                    loop = False

                case _:
                    print("Sartutako aukera ez da zuzena, gogoratu aukera 1etik 5era direla!")
                    time.sleep(2.5)
        except ValueError:
            print(f"{GORRIA}  ✖  Zenbaki bat sartu beharr duzu!{RESET}")
            time.sleep(2.75)

# **********************  AZPI-MENUA  **********************
def sub_Menu(norena):
    while True:
        kontsolaGarbitu()
        print(f"{BERDEA}{norena}en datuak kudeatzeko aukera duzu orain.  {RESET}")
        print(f"{CIAN} --------------------------------------{RESET}")
        print(f"{URDINA}| 1.- {norena}en datuak gehitu.        |{RESET}")
        print(f"{URDINA}| 2.- {norena}en datuak kendu.         |{RESET}")
        print(f"{URDINA}| 3.- {norena}en datuak ikusi.         |{RESET}")
        print(f"{URDINA}| 4.- Menu nagusira itzuli.            |{RESET}")
        print(f"{CIAN} --------------------------------------{RESET}")
        try:
            subAukera = int(input(f"   · Aukeratu (1-4): {HORIA}"))
            print(RESET, end="") 

            match subAukera:
                case 1: #DATUAK GEHITU
                    datuakGehitu(norena)
                    time.sleep(2.5)

                case 2: #DATUAK KENDU
                    datuakKendu(norena)
                    time.sleep(2.5)

                case 3: #DATUAK ERAKUTZI
                    datuakErakutzi(norena)
                    input(f'Sartu{GORRIA} ENTER {RESET}ahurrera jarraitzeko... ')
                    kontsolaGarbitu()

                case 4:
                    kontsolaGarbitu()
                    print("Menu nagusira itzultzen.")
                    break

                case _:
                    print(f"{GORRIA}Sartutako aukera ez da zuzena, gogoratu aukerak 1etik 4era direla!{RESET}")
                    time.sleep(2.75)
        except ValueError:
            print(f"{GORRIA}   ✖ Zenbaki bat sartu beharr duzu!{RESET}")
            time.sleep(2.75)

# **********************  DATUEK KUDEAKETA   **********************
def datuakGehitu(norena):
    kontsolaGarbitu()
    izena = input(f"Sartu {norena}ren izena: ")
    if(norena == 'Hitzaldi'):
        hitzaldiHeman = input("Nok hemango du hitzaldia? ")
        hitzaldiData = input("Noiz izango da hitzaldia: ")
        gaia = input(f'Zeinda {norena}ren gaia: ')
        while True:
            try:
                partaideKopMax = int(input('Plaza kopurua: '))
                break
            except ValueError:
                print(f"{GORRIA}   ✖ Partaide kopurua edota Plaza kopurua zenbakiak izan behar dira!{RESET}")
        datuak = [izena, hitzaldiHeman, hitzaldiData, gaia, partaideKopMax]    

    elif (norena == 'Orientatzaile'):
        NANa = input(f'Sartu {norena}ren NAN zenbakia? ')
        Abizena = input(f'Sartu {norena}ren abizena: ')
        Kontaktua = input(f'Sartu {norena}ren telefono zenbakia: ')
        Eskola = input(f'Sartu {norena}k lan egiten duen eskolaren izena: ')
        ZaindUmeIzena = input(f'Sartu {norena}k zaintzen duen umearen izena: ')
        ZaindUmeAbizena = input(f'Sartu {norena}k zaintzen duen umearen abizena: ')
        datuak = [izena, NANa, Abizena, Kontaktua, Eskola, ZaindUmeIzena, ZaindUmeAbizena]

    with open('./CSV/'+norena+'.csv', 'a', newline='') as fitxategia:
        idazlea = csv.writer(fitxategia)
        idazlea.writerow(datuak)

def datuakKendu(norena):
    with open('./CSV/'+norena+'.csv', mode='r') as fitxategia:
        irakurri = csv.DictReader(fitxategia)
        if (norena != 'Hitzaldi'):
            for row in irakurri:
                print(f"{CIAN}Izena:{RESET} {row['Izena']}")
        else:
            for row in irakurri:
                print(f"{CIAN}Hitzaldia:{RESET} {row['izena']}")
    
    izena_kendu = input(f"Sartu ezabatu nahi duzun {norena}ren izena: {HORIA}")
    print(RESET, end="") 
    
    # Irakurri fitxategiko datuak
    with open('./CSV/'+norena + '.csv', 'r', newline='') as fitxategia:
        irakurlea = csv.reader(fitxategia)
        lerroak = list(irakurlea)  # Fitxategiko edukia zerrenda batean gordetzeko
        
    lerro_berriak = []# izena_kendu ez duten errenkadak bakarrik gordetzeko
    for lerroa in lerroak:
        if lerroa and lerroa[0] != izena_kendu:
            lerro_berriak.append(lerroa)
    
    # Fitxategia o-tik idatzi, ezabatu nahi den izena ez edukitzeko.
    with open('./CSV/'+norena + '.csv', 'w', newline='') as fitxategia:
        idazlea = csv.writer(fitxategia)
        idazlea.writerows(lerro_berriak)
    print(f"{CIAN}{izena_kendu}{RESET}, {URDINA}'{norena}.csv'{RESET}-tik ezabatua izan da.")

def datuakErakutzi(norena):
    kontsolaGarbitu()
    with open('./CSV/'+norena+'.csv', mode='r') as fitxategia:
        irakurri = csv.DictReader(fitxategia)
        if (norena == 'Orientatzaile'):
            for row in irakurri:
                print(f"{CIAN}{norena}:{RESET} {row['Izena']} {row['Abizena']}\n\t{URDINA}·Kontaktua:{RESET} {row['Kontaktua']}\n\t{URDINA}·Lantokia:{RESET} {row['Eskola']}\n\t{URDINA}·Zaintzapeko ahurra:{RESET} {row['ZaindUmeIzena']} {row['ZaindUmeAbizena']}")
        elif (norena == 'Hitzaldi'):
            for row in irakurri:
                print(f"{CIAN}Hitzaldia:{RESET} {row['izena']}\n\t{URDINA}·Nork eman:{RESET} {row['hitzaldiHeman']}\n\t{URDINA}·Data:{RESET} {row['hitzaldiData']}\n\t{URDINA}·Hitzaldiaren gaia:{RESET} {row['gaia']}\n\t{URDINA}·Plaza Kopurua:{RESET} {row['partaideKopMax']}")

# **********************  APLIKAZIOAREN ATAL GEHIGARRIAK  **********************
def kontsolaGarbitu():
    if os.name == "nt":
        os.system("cls")
    else:
        os.system("clear")

if __name__ == "__main__":
    main_menu()