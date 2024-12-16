import pymysql.cursors
from lectura_csv import leer_datos_csv
from lectura_json import leer_datos_json
from lectura_xml import leer_datos_xml
from sqlite import leer_datos_sqlite

# Connect to the database
connection = pymysql.connect(host='127.0.0.1',
                            port=3306,
                            user='unieibar',
                            password='uniibar',
                            database='ordenagailuak',
                            cursorclass=pymysql.cursors.DictCursor)

with connection:
    solairuak= []
    csv = leer_datos_csv("./datuak/solairua_1/ordenagailuak.csv")
    json = leer_datos_json("./datuak/solairua_4/ordenagailuak.json") 
    xml = leer_datos_xml("./datuak/solairua_5/ordenagailuak.xml")
    sqli = leer_datos_sqlite("./datuak/solairua_2/ordenagailuak.db")

    solairuak.extend([csv, json, xml, sqli])
    # print(solairuak)
    
    with connection.cursor() as cursor:
        # Create a new record
        select_sql_solairua = "SELECT ID FROM SOLAIRUA WHERE `KODEA`=%s"
        select_sql_gela = "SELECT ID FROM GELA WHERE `KODEA`=%s"
        select_sql_ordenagailua = "SELECT ID FROM ORDENAGAILUA WHERE `KODEA`=%s"
        
        sql_solairua = "INSERT INTO `SOLAIRUA` (`KODEA`, `IZENA`) VALUES (%s, %s)"
        sql_gela = "INSERT INTO `GELA` (`SOLAIRUA`, `KODEA`, `IZENA`) VALUES (%s, %s, %s)"
        sql_ordenagailua = "INSERT INTO `ORDENAGAILUA` (`GELA`, `KODEA`, `IP_HELBIDEA`, `SISTEMA_ERAGILEA`, `EROSKETA_EGUNA`, `AZKEN_ERREBISIOA`, `OHARRAK`) VALUES (%s, %s, %s, %s, %s, %s, %s)"

        for solairua in solairuak:
            cursor.execute(sql_solairua, ("{a}".format(a=csv.kodea),"{a} solairua".format(a=csv.kodea)))
            cursor.execute(select_sql_solairua, ("{a}".format(a=csv.kodea)))
            res_solairu = cursor.fetchone()['ID']
    
            for gela in solairua.gelak:
                cursor.execute(sql_gela, (res_solairu,"{a}".format(a=gela.kodea),"{a} gela".format(a=gela.kodea)))
                cursor.execute(select_sql_gela, ("{a}".format(a=gela.kodea)))
                res_gela = cursor.fetchone()['ID']
                
                for ordenagailua in gela.ordenagailuak:
                    cursor.execute(sql_ordenagailua, (res_gela,"{a}".format(a=ordenagailua.kodea),ordenagailua.ip_helbidea, ordenagailua.sistema_eragilea, ordenagailua.erosketa_eguna, ordenagailua.azken_errebisioa, ordenagailua.oharrak))


    connection.commit()


