def main_ariketa7():
    count = 0
    num = int(input("Sartu zenbaki bat bere digituak zenbatzeko: "))
    original_num = num
    if num == 0:
        count = 1
    else:
        while num != 0:
            num = num//10  #Doble // para evitar decimales
            count = count +1
    print(f"{original_num} zenbakiaren digitu kopurua: {count}")
    
if __name__ =="__main__":
    main_ariketa7()