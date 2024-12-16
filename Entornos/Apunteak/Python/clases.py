from dataclasses import dataclass
from typing import List

@dataclass
class Ordenagailua:
    kodea: int
    ip_helbidea: str
    sistema_eragilea: str
    erosketa_eguna: str
    azken_errebisioa: str
    oharrak: str
    
@dataclass
class Gela:
    kodea: int
    ordenagailuak: List[Ordenagailua]

@dataclass
class Solairua:
    kodea: int
    gelak: List[Gela]
