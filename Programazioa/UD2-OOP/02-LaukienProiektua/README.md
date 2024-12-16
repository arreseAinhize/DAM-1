## Getting Started

    Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

    The workspace contains two folders by default, where:

    - `src`: the folder to maintain sources
    - `lib`: the folder to maintain dependencies

    Meanwhile, the compiled output files will be generated in the `bin` folder by default.

    > If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

    The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Zer aurkituko dugu bertan
1.- Programatu Laukia klasea (toString() metodorarte)
           toString metodoak horrelako zerbait bueltatuko du: Laukia[7x1]

2.- Programatu HiruLaukiSortu.java programa:
       Programa honek hiru lauki sortuko ditu (7x1, 2x2, 2x6)
       eta gero kontsolatik inprimatuko ditu.

Hiru lauki sortu dituzu:
Laukia[7x1]
Laukia[2x2]
Laukia[2x6]

3.- Aldatu Laukia programa getMota metodoa gehituz. Zera bueltatuko du:
     "Horizontala", "Bertikala" edo "Karratua" hitzak. (Testerra falta da. Ez baduzu itxaron nahi menuaren ariketararte, aldatu ezazu HiruLaukiSortu)

4.- Garatu LaukiBatSortu programa. Erabiltzaileari lauki baten datuak eskatuko dizkio eta eratutako laukia zein motatakoa de erantzungo dio. Eta gero laukia marraztuko du, beteta eta hutsik. Adibidez:

Sartu laukiaren zabalera: 5
Sartu laukiaren altuera: 5
Lauki karratua sortu duzu: => Laukia[5x5]
Hona marrazkia beteta:
* * * * *
* * * * *
* * * * *
* * * * *
* * * * *
Hona marrazkia hutsik:
* * * * *
*       *
*       *
*       *
* * * * *

Zein ikurrekin nahi duzu laukia bete? @
@ @ @ @ @ @ @ @ @ @
@ @ @ @ @ @ @ @ @ @
@ @ @ @ @ @ @ @ @ @
@ @ @ @ @ @ @ @ @ @
@ @ @ @ @ @ @ @ @ @

Ariketa osagarriak:
Programatu beste metodo hauek Laukia klasean:
  void marraztuBeteta(char ikurra)
  String laukiBetea()

5.- Garatu LaukiAskoSortu.java programa

Zenbat lauki sortu nahi dituzu? 4
1. LAUKIAREN DATUAK:
     Zabalera: 4
     Altuera: 4
2. LAUKIAREN DATUAK:
     Zabalera: 5
     Altuera: 6
3. LAUKIAREN DATUAK:
     Zabalera: 6
     Altuera: 4
4. LAUKIAREN DATUAK:
     Zabalera: 2
     Altuera: 2
Laukia   Zabalera Altuera Azalera Perimetroa  Mota
==============================================================
       1       4       4      16      16      Karratua
       2       5       6      30      22      Bertikala
       3       6       4      24      20      Horizontala
       4       2       2       4       8      Karratua
6.- Garatu Menua.java programa. Hurrengo menua agertuko da Irtetzea aukeratzen ez dugun bitartean:

LAUKIAK
====================================
1.- Lauki berria sortu
2.- Laukien taula ikusi
3.- Lauki bat marraztu
4.- Lauki handiena bilatu
5.- Irten
Aukeratu zenbaki bat: 1

LAUKI BERRIA SORTZEN...
  Sartu zabalera: 2
  Sartu altuera: 4

...
Aukeratu zenbaki bat: 2

Laukia   Zabalera Altuera Azalera Perimetroa  Mota
==============================================================
       1       2       4      8      12      Bertikala


...
Aukeratu zenbaki bat: 3

Zenbatgarren laukia nahi duzu marraztu? 1
Beteta ala hutsik (B/H)? B
* *
* *
* *
* *

Aukeratu zenbaki bat: 4

Laukirik handiena hau da: Laukia[2x4]

Aukeratu zenbaki bat: 5

Eskerrik asko programa hau erabiltzeagatik.

Oharrak:
- 10 laukiko arrayarekin egingo dugu lan.
  Hamaikagarrena sortzen saiatzen bagara: "Ezin dituzu lauki gehiago sortu." mezua agertuko da.

7.- Javadoc-ak idatzi.

-------

Ariketa gehiago:

- Zer egin dezakegu lauki bat proportzionalki handitzea nahi badugu? Zein goiburuko izan beharko luke Laukia klaseko handitu metodoak?

- arrayaBete() metodoa kodifikatu Menua.java klasean. Laukien arrayean hamar lauki sartuko ditu, ausazko neurriak dauzkatenak.

- Laukia klasean .ordenatu(Laukiak[] laukiak) metodo estatikoa programatu, parametro bezala jasoko duen arraya, txikienetik handienera ordenatuko duena. Wikipedian kontsulta dezakezu ordenazio algoritmoen zerrenda. Wikicommons-en Javan idatzitako programak aurkitu ditzakezu. Aukeratu, ulerterraza egiten zaizun algoritmo bat eta egokitu laukien kasura.

