# ********************** PICKLE FITXATEGIAK KUDEATZEKO **********************
# Moduluak inportatu
import pickle
from runpy import run_path

import os,time
import Ebook, LiburuFisikoa, AudioLiburua

# ********************** FITXATEGIEN IZENA DEFINITZEKO **********************
# Fitxategiaren kokalekua zehaztu
fitxategia = os.path.join(os.path.dirname(__file__), "liburuak.pkl")

# **********************  KONTSOLARAKO KOLOREAK  **************************
GORRIA = '\033[91m'
BERDEA = '\033[92m'
HORIA = '\033[93m'
URDINA = '\033[94m'
CIAN = '\033[96m'
RESET = '\033[0m'

# **********************  LIBURUEN KUDEAKETA MENUA  **********************
"""
Liburuen kudeaketa menua bistaratzen duen funtzio nagusia.
Erabiltzaileak aukera bat aukeratuko du eta dagokion funtzioa exekutatuko da.
"""
def main_menu():
    loop = True
    while loop:
        kontsolaGarbitu()
        print(f"{BERDEA}📚 Liburuen kudeaketa menura ongi etorri!{RESET}")
        print(f"{CIAN} ----------------------------------------------{RESET}")
        print(f"{URDINA}| 1- Ebook berria gehitu                     |{RESET}")
        print(f"{URDINA}| 2- Liburu fisiko berria gehitu             |{RESET}")
        print(f"{URDINA}| 3- Audioliburua berria gehitu              |{RESET}")
        print(f"{URDINA}| 4- Liburu guztiak bistaratu                |{RESET}")
        print(f"{URDINA}| 5- Ebook-ak bistaratu                      |{RESET}")
        print(f"{URDINA}| 6- Liburu fisikoak bistaratu               |{RESET}")
        print(f"{URDINA}| 7- Audioliburuak bistaratu                 |{RESET}")
        print(f"{URDINA}| 8- Bilatu liburu bat ISBN-aren arabera     |{RESET}")
        print(f"{URDINA}| 9- Bilatu liburu bat izenburuaren arabera  |{RESET}")
        print(f"{URDINA}| 10- Bilatu liburu bat idazlearen arabera   |{RESET}")
        print(f"{URDINA}| 11- Bilatu liburu bat generoaren arabera   |{RESET}")
        print(f"{URDINA}| 12- Liburu bat borratu                     |{RESET}")
        print(f"{URDINA}| 13- Irten                                  |{RESET}")
        print(f"{CIAN} ----------------------------------------------{RESET}")
        try:
            aukera = int(input(f"  · Aukeratu (1-13):{HORIA} "))
            print(RESET, end="")

            match aukera:
                case 1:
                    kontsolaGarbitu()
                    print("📥 Ebook bat gehitzen...")
                    time.sleep(1.5)
                    kontsolaGarbitu()
                    ebookGehitu()
                    time.sleep(2)

                case 2:
                    kontsolaGarbitu()
                    print("📥 Liburu fisiko bat gehitzen...\n")
                    time.sleep(1.5)
                    kontsolaGarbitu()
                    fisikoaGehitu()
                    time.sleep(2)

                case 3:
                    kontsolaGarbitu()
                    print("📥 Audioliburua bat gehitzen...")
                    time.sleep(1.5)
                    kontsolaGarbitu()
                    audioaGehitu()
                    time.sleep(2)

                case 4:
                    kontsolaGarbitu()
                    print("📋 Liburu guztiak bistaratzen...")
                    time.sleep(1.5)
                    kontsolaGarbitu()
                    gustiaBistaratu()
                    input(f"\nSakatu{HORIA} ENTER{RESET} jarraitzeko...")

                case 5:
                    kontsolaGarbitu()
                    print("📋 Liburu elektronikoak bistaratzen...")
                    time.sleep(1.5)
                    kontsolaGarbitu()
                    ebookBistaratu()
                    input(f"\nSakatu{HORIA} ENTER{RESET} jarraitzeko...")

                case 6:
                    kontsolaGarbitu()
                    print("📋 Liburu fisikoak bistaratzen...")
                    time.sleep(1.5)
                    kontsolaGarbitu()
                    libFisBistaratu()
                    input(f"\nSakatu{HORIA} ENTER{RESET} jarraitzeko...")

                case 7:
                    kontsolaGarbitu()
                    print("📋 Audioliburuak bistaratzen...")
                    time.sleep(1.5)
                    kontsolaGarbitu()
                    audlibBistaratu()
                    input(f"\nSakatu{HORIA} ENTER{RESET} jarraitzeko...")

                case 8:
                    kontsolaGarbitu()
                    print("🔍 Bilaketa ISBN-aren arabera...")
                    time.sleep(1.5)
                    kontsolaGarbitu()
                    isbnBilatu()
                    input(f"\nSakatu{HORIA} ENTER{RESET} jarraitzeko...")

                case 9:
                    kontsolaGarbitu()
                    print("🔍 Bilaketa izenburuaren arabera...")
                    time.sleep(1.5)
                    kontsolaGarbitu()
                    izenburuaBilatu()
                    input(f"\nSakatu{HORIA} ENTER{RESET} jarraitzeko...")

                case 10:
                    kontsolaGarbitu()
                    print("🔍 Bilaketa idazlearen arabera...")
                    time.sleep(1.5)
                    kontsolaGarbitu()
                    idazleaBilatu()
                    input(f"\nSakatu{HORIA} ENTER{RESET} jarraitzeko...")

                case 11:
                    kontsolaGarbitu()
                    print("🔍 Bilaketa generoaren arabera...")
                    time.sleep(1.5)
                    kontsolaGarbitu()
                    generoaBilatu()
                    input(f"\nSakatu{HORIA} ENTER{RESET} jarraitzeko...")

                case 12:
                    kontsolaGarbitu()
                    print("📚 Liburua borratzen...")
                    time.sleep(1.5)
                    kontsolaGarbitu()
                    borratuliburua()
                    input(f"\nSakatu{HORIA} ENTER{RESET} jarraitzeko...")

                case 13:
                    konfirm = input(f"Ziur zaude irten nahi duzula? (bai/ez):{HORIA} ")
                    print(RESET, end="")
                    if konfirm.lower() == "bai":
                        print("👋 Aplikazioa ixten...")
                        loop = False

                case _:
                    print(f"{GORRIA}❌ Aukera ez da zuzena. Saiatu berriro (1-13).{RESET}")
                    time.sleep(2.5)

        except ValueError:
            print(f"{GORRIA}❌ Zenbaki bat sartu behar duzu!{RESET}")
            time.sleep(2.5)
# ********************** PICKLE FITXATEGIA KARGATU ****************
"""
Liburuen datuak pickle fitxategitik kargatzen ditu.
Fitxategia existitzen ez bada edo errore bat gertatzen bada, zerrenda hutsa itzultzen du.
Returns:
    list: Liburuen zerrenda, edo hutsik baldin badago []
"""
def fitxategia_kargatu():
    if os.path.exists(fitxategia):
        try:
            with open(fitxategia, "rb") as f:
                return pickle.load(f)
        except (pickle.UnpicklingError, EOFError, Exception) as e:
            print(f"{GORRIA}❌ Errorea fitxategia kargatzean: {e}{RESET}")
            return []
    else:
        print(f"{HORIA}ℹ️ Fitxategia ez da existitzen. Zerrenda hutsarekin hasiko gara.{RESET}\n")
        return []

"""
Liburuen datuak pickle fitxategian gordetzen ditu.
Args:
    liburuak (list): Gorde beharreko liburuen zerrenda.
"""
def fitxategira_gorde(liburuak):
    try:
        with open(fitxategia, "wb") as f:
            pickle.dump(liburuak, f)
    except Exception as e:
        print(f"{GORRIA}❌ Errorea datuak gordetzean: {e}{RESET}")

# **********************  DATUEK KUDEAKETA   **********************

# ******************  DATUEK GEHITZEA ******************
"""
Liburu elektroniko berri bat gehitzen du.
- Datuak kargatzen ditu, objektua sortzen du eta pickle fitxategian gordetzen du.
"""
def ebookGehitu():
    liburuak = fitxategia_kargatu() # Zerrenda zaharra kargatu
    loop = "bai"

    while loop.lower() == "bai":
        kontsolaGarbitu()
        berria = Ebook.Ebook() # Liburu berria sortu
        liburuak.append(berria) # Zerrendara gehitu
        fitxategira_gorde(liburuak) # Zerrenda osoa berriz gorde
        
        loop = input("Beste liburu elektroniko bat sortu nahi duzu? (bai/ez): ").lower()
        # Erantzuna egokia dela begiratzeko
        while loop != "bai" and loop != "ez":
            # Jasotako erantzuna ez dela ulertu eta berriro galdetu
            loop = input("Barkatu baina ez da erantzuna ulertu.\nBeste liburu elektroniko bat sortu nahi duzu?").lower()

"""
Liburu fisko berri bat gehitzen du.
- Datuak kargatzen ditu, objektua sortzen du eta pickle fitxategian gordetzen du.
"""
def fisikoaGehitu():
    liburuak = fitxategia_kargatu()
    loop = "bai"

    while loop.lower() == "bai":
        kontsolaGarbitu()
        berria = LiburuFisikoa.LiburuFisikoa()
        liburuak.append(berria)
        fitxategira_gorde(liburuak)

        loop = input("Beste liburu fisiko bat sortu nahi duzu? (bai/ez): ").lower()
        while loop != "bai" and loop != "ez":
            loop = input("Barkatu baina ez da erantzuna ulertu.\nBeste liburu fisiko bat sortu nahi duzu?").lower()

"""
Audioliburu berri bat gehitzen du.
- Datuak kargatzen ditu, objektua sortzen du eta pickle fitxategian gordetzen du.
"""   
def audioaGehitu():
    liburuak = fitxategia_kargatu()
    loop = "bai"

    while loop.lower() == "bai":
        kontsolaGarbitu()
        berria = AudioLiburua.AudioLiburua()
        liburuak.append(berria)
        fitxategira_gorde(liburuak)
        loop = input("Beste audioliburu bat sortu nahi duzu? (bai/ez): ").lower()
        while loop != "bai" and loop != "ez":
            loop = input("Barkatu baina ez da erantzuna ulertu.\nBeste audioliburu bat sortu nahi duzu?").lower()

# **********************  DATUEN BISTARATZEA **********************
"""
Liburu guztiak bistaratzeko funtzioa.
""" 
def gustiaBistaratu():
    liburuak = fitxategia_kargatu()
    if not liburuak:
        kontsolaGarbitu()
        print(f"{HORIA}📭 Fitxategia ez da existitzen edo ez dago libururik gordeta.{RESET}")
    for l in liburuak:
        if l.__class__.__name__ == "Ebook":
            l.print_info()
        elif l.__class__.__name__ == "LiburuFisikoa":
            l.print_info()
        else:
            l.print_info()

"""
Liburu elektroniko guztiak bistaratzeko funtzioa.
"""     
def ebookBistaratu():
    liburuak = fitxategia_kargatu()
    if not liburuak:
        kontsolaGarbitu()
        print(f"{HORIA}📭 Fitxategia ez da existitzen edo ez dago libururik gordeta.{RESET}")
    print(f"{URDINA}[Ebook]{RESET}")
    for l in liburuak:
        if l.__class__.__name__ == "Ebook":
            l.print_info()

"""
Liburu fisko guztiak bistaratzeko funtzioa.
"""     
def libFisBistaratu():
    liburuak = fitxategia_kargatu()
    if not liburuak:
        kontsolaGarbitu()
        print(f"{HORIA}📭 Fitxategia ez da existitzen edo ez dago libururik gordeta.{RESET}")
    print(f"{URDINA}[Liburu Fisikoa]{RESET}")
    for l in liburuak:
        if l.__class__.__name__ == "LiburuFisikoa":
            l.print_info()

"""
Audioliburu guztiak bistaratzeko funtzioa.
"""     
def audlibBistaratu():
    liburuak = fitxategia_kargatu()
    if not liburuak:
        kontsolaGarbitu()
        print(f"{HORIA}📭 Fitxategia ez da existitzen edo ez dago libururik gordeta.{RESET}")
    print(f"{URDINA}[Audio Liburua]{RESET}")
    for l in liburuak:
        if l.__class__.__name__ == "AudioLiburua":
            l.print_info()

# **********************  DATUEN BILAKETA  **********************
"""
Liburua ISBN-aren arabera bilatzen du.
Erabiltzaileari ISBN-a sartzeko eskatzen dio eta dagokion liburua bistaratzen du.
"""
def isbnBilatu():
    liburuak = fitxategia_kargatu()
    isbn = int(input("Sartu liburuaren ISBN osoa: "))
    emaitzak = [l for l in liburuak if isbn == l.isbn]
    atributuak = ["izenburua", "egilea", "argitaletxea", "saga"] 
    if not emaitzak:
        print(f"{GORRIA}❌ Ez da bat datorren libururik aurkitu.{RESET}")
    for l in emaitzak:
        print(f"\n{URDINA}[{l.__class__.__name__}]{RESET}") #Objetu klasearen izena inprimatzen du
        for k in atributuak:
            print(f"{CIAN}{k.capitalize()}:{RESET} {getattr(l, k, '--')}")

"""
Liburua izenburuaren arabera bilatzen du.
"""
def izenburuaBilatu():
    liburuak = fitxategia_kargatu()
    izenburua = input("Sartu liburuaren izenburu osoa (osoa edo zati bat): ").lower()
    emaitzak = [l for l in liburuak if izenburua in l.izenburua.lower()]
    atributuak = ["izenburua", "egilea", "argitaletxea", "saga"] 
    if not emaitzak:
        print(f"{GORRIA}❌ Ez da bat datorren libururik aurkitu.{RESET}")
    for l in emaitzak:
        print(f"\n{URDINA}[{l.__class__.__name__}]{RESET}")
        for k in atributuak:
            print(f"{CIAN}{k.capitalize()}:{RESET} {getattr(l, k, '--')}")

"""
Liburua idazlearen arabera bilatzen du.
"""    
def idazleaBilatu():
    liburuak = fitxategia_kargatu()
    egilea = input("Sartu liburuaren idazlea osoa: ").lower()
    emaitzak = [l for l in liburuak if egilea in l.egilea.lower()]
    atributuak = ["izenburua", "egilea", "argitaletxea", "saga"] 
    if not emaitzak:
        print(f"{GORRIA}❌ Ez da bat datorren libururik aurkitu.{RESET}")
    for l in emaitzak:
        print(f"\n{URDINA}[{l.__class__.__name__}]{RESET}") #Objetu klasearen izena inprimatzen du
        for k in atributuak:
            print(f"{CIAN}{k.capitalize()}:{RESET} {getattr(l, k, '--')}")

"""
Liburua generoaren arabera bilatzen du.
"""    
def generoaBilatu():
    liburuak = fitxategia_kargatu()
    generoa = input("Sartu liburuaren generoa: ").lower()
    emaitzak = [l for l in liburuak if generoa in l.generoa.lower()]
    atributuak = ["izenburua", "egilea", "argitaletxea", "saga"] 
    if not emaitzak:
        print(f"{GORRIA}❌ Ez da bat datorren libururik aurkitu.{RESET}")
    for l in emaitzak:
        print(f"\n{URDINA}[{l.__class__.__name__}]{RESET}") #Objetu klasearen izena inprimatzen du
        for k in atributuak:
            print(f"{CIAN}{k.capitalize()}:{RESET} {getattr(l, k, '--')}")   

# **********************  DATUAK BORRATU **********************
"""
Liburua zerrenda batean bistaratzen ditu, erabiltzaileak borratzeko.
"""
def borratuliburua():
    liburuak = fitxategia_kargatu() 
    loop = "bai"

    if not liburuak:
        kontsolaGarbitu()
        print(f"{HORIA}📭 Ez dago borratzeko libururik.{RESET}")
        return
    while loop.lower() == "bai":
        kontsolaGarbitu()
        # Ditugun liburuak bistaratzen ditu
        print(f"{URDINA}📚 Aukeratu borratu nahi duzun liburua:{RESET}")
        for i, l in enumerate(liburuak, 1):
            print(f"{i}. {l.izenburua} --- {l.egilea}")

        try:
            aukera = int(input(f"{HORIA}Sartu borratu nahi duzun liburuaren zenbakia:{RESET} "))
            if aukera < 1 or aukera > len(liburuak):
                print(f"{GORRIA}❌ Aukera okerra.{RESET}")
                return
            # Aukeratutako liburua ezabatzen du
            liburuak.pop(aukera - 1)
            fitxategira_gorde(liburuak)
            loop = input("Beste liburu elektroniko bat sortu nahi duzu? (bai/ez): ").lower()
            # Erantzuna egokia dela begiratzeko
            while loop != "bai" and loop != "ez":
                # Jasotako erantzuna ez dela ulertu eta berriro galdetu
                loop = input("Barkatu baina ez da erantzuna ulertu.\nBeste liburu elektroniko bat sortu nahi duzu?").lower()
        
        except ValueError:
            print(f"{GORRIA}❌ Zenbaki bat sartu behar duzu.{RESET}")

# **********************  APLIKAZIOAREN ATAL GEHIGARRIAK  **********************
"""
Kontsolako edukia garbitzen duen funtzioa.
"""
def kontsolaGarbitu():
    if os.name == "nt":
        os.system("cls")
    else:
        os.system("clear")

if __name__ == "__main__":
    main_menu()