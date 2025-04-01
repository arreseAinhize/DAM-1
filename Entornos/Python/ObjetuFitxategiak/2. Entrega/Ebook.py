from Liburua import Liburua

class Ebook(Liburua):
    def __init__(self):
        super().__init__()
        self.formatoa = input("Sartu ebookaren formatua (adib. PDF, EPUB...): ")
        self.luzeera = int(input("Sartu luzeera: "))

    def print_info(self):
        super().print_info()
        print(f"{CIAN}  - Formatua:{RESET} {self.formatoa}")
        print(f"{CIAN}  - Luzeera:{RESET} {self.luzeera}")


# **********************  KONTSOLARAKO KOLOREAK  **************************
GORRIA = '\033[91m'
BERDEA = '\033[92m'
HORIA = '\033[93m'
URDINA = '\033[94m'
CIAN = '\033[96m'
RESET = '\033[0m'