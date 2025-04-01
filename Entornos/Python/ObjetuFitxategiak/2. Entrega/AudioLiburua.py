from Liburua import Liburua

class AudioLiburua(Liburua):
    def __init__(self):
        super().__init__()
        self.iraupena = input("Sartu iraupena (adib. 2h 30m): ")
        self.narratzailea = input("Sartu narratzailearen izena: ")

    def print_info(self):
        super().print_info()
        print(f"{CIAN}  - Iraupena:{RESET} {self.iraupena}")
        print(f"{CIAN}  - Narratzailea:{RESET} {self.narratzailea}")


# **********************  KONTSOLARAKO KOLOREAK  **************************
GORRIA = '\033[91m'
BERDEA = '\033[92m'
HORIA = '\033[93m'
URDINA = '\033[94m'
CIAN = '\033[96m'
RESET = '\033[0m'