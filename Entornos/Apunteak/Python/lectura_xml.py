import xml.etree.ElementTree as ET
from clases import  Ordenagailua, Gela, Solairua

def leer_datos_xml(path):
    tree = ET.parse('./datuak/solairua_5/ordenagailuak.xml')
    root = tree.getroot()
    
    gelak = []
    ordenagailuak = []
    
    for gela in root.findall('gela'):
        for ordenagailua in gela.findall('ordenagailua'):
            ordenagailuak.append(Ordenagailua(int(ordenagailua.attrib["id"]), ordenagailua.find('ip').text, ordenagailua.find('se').text, None, None, ""))
        gelak.append(Gela(int(gela.attrib["kodea"]), ordenagailuak))
        
    return Solairua(5, gelak)

