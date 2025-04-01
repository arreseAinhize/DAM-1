class Liburua (object):
    def __init__(self):
        self.izenburua = input("Sartu liburuaren izenburua: ")
        self.egilea = input("Sartu egilea: ")
        self.isbn = int(input("Sartu ISBN zenbakia: "))
        self.argitaletxea = input("Sartu argitaletxea: ")
        self.generoa = input("Sartu generoa: ")
        self.saga = input("Sartu liburuaren saga (idatzi '--' sagarik ez badu): ")
        self.argitaratze_data = input("Sartu argitaratze data (UUUU-HH-EE): ")

    def print_info(self):
        print(f"\n{BERDEA}📖 Liburuaren datuak:{RESET}")
        print(f"{CIAN}  - Izenburua:{RESET} {self.izenburua}")
        print(f"{CIAN}  - Egilea:{RESET} {self.egilea}")
        print(f"{CIAN}  - ISBN:{RESET} {self.isbn}")
        print(f"{CIAN}  - Argitaletxea:{RESET} {self.argitaletxea}")
        print(f"{CIAN}  - Generoa:{RESET} {self.generoa}")
        print(f"{CIAN}  - Saga:{RESET} {self.saga}")
        print(f"{CIAN}  - Argitaratze data:{RESET} {self.argitaratze_data}")


# **********************  KONTSOLARAKO KOLOREAK  **************************
GORRIA = '\033[91m'
BERDEA = '\033[92m'
HORIA = '\033[93m'
URDINA = '\033[94m'
CIAN = '\033[96m'
RESET = '\033[0m'