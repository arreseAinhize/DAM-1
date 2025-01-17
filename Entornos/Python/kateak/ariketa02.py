# Hitz bat eta zenbaki bat eskatu, eta hitza zenbakia adina aldiz errepikatuta erakutsi.
hitza = input("Sartu hitz bat: ")
errepikapena = int(input("zenbat aldiz errepikatu nahi duzu? "))

hasi = 1
if errepikapena < 0:
    errepikapena = (-1) * errepikapena
    
if errepikapena == 0:
    print(hitza)
else:
    while hasi <= errepikapena:
        print(hitza)
        hasi = hasi +1