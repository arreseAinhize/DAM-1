from Liburua import Liburua

class LiburuFisikoa(Liburua):
    def __init__(self):
        super().__init__()
        self.orriKop = int(input("Sartu orri kopurua: "))
        self.azala = input("Azal mota (biguna/gogorra): ")

    def print_info(self):
        super().print_info()
        print(f"{CIAN}  - Orri kopurua:{RESET} {self.orriKop}")
        print(f"{CIAN}  - Azal mota:{RESET} {self.azala}")


# **********************  KONTSOLARAKO KOLOREAK  **************************
GORRIA = '\033[91m'
BERDEA = '\033[92m'
HORIA = '\033[93m'
URDINA = '\033[94m'
CIAN = '\033[96m'
RESET = '\033[0m'