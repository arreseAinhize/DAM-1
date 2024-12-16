# Operaciones con cadenas, listas y tuplas

# Trabajando con cadenas
cadena1 = 'tengo una yama que Yama se llama'  # Declara variable
longitud = len(cadena1)  # 32, devuelve longitud de la cadena
cuenta = cadena1.count('yama')  # 1, cuenta apariciones de 'yama'
print(cadena1.find('yama'))  # 10, devuelve posición de búsqueda
cadena2 = cadena1.join('***')  # Inserta cadena1 entre caracteres
lista1 = cadena1.split(' ')  # Divide cadena por separador → lista
tupla1 = cadena1.partition(' ')  # Divide cadena por separador → tupla
cadena2 = cadena1.replace('yama', 'cabra', 1)  # Busca/sustituye términos

# Conversión de tipos
numero = 3.14  # Asigna número con decimales
cadena3 = str(numero)  # Convierte número a cadena

# Métodos de evaluación
if cadena1.startswith("tengo"):  # Evalúa si comienza por “tengo”
    pass
if cadena1.endswith("llama"):  # Evalúa si termina por “llama”
    pass
if cadena1.find("llama") != -1:  # Evalúa si contiene “llama”
    pass

# Acceso por índice
cadena4 = 'Python'  # Declara una cadena
print(cadena4[0:4])  # "Pyth", muestra desde la posición 0 a 4
print(cadena4[1])  # "y", muestra la posición 1
print(cadena4[:3] + '-' + cadena4[3:])  # "Pyt-hon"
print(cadena4[:-3])  # "Pyt", todo menos las tres últimas

# Métodos para eliminar caracteres en blanco
cadena5 = "  abc;123  "
print(cadena5.rstrip())  # "  abc;123", suprime por la derecha
print(cadena5.lstrip())  # "abc;123  ", suprime por la izquierda
print(cadena5.strip())  # "abc;123", suprime por ambos lados
print(cadena5.strip("123456790; "))  # "abc", elimina caracteres específicos

# Métodos de transformación
cadena6 = "Mar"  # Declara una variable
print(cadena6.upper())  # "MAR", convierte a mayúsculas
print(cadena6.lower())  # "mar", convierte a minúsculas








# Trabajando con listas
lista1 = ['uno', 2, True]  # Lista heterogénea
lista2 = [1, 2, 3, 4, 5]  # Lista numérica homogénea
lista3 = ['nombre', ['ap1', 'ap2']]  # Lista dentro de otra
lista4 = [54, 45, 44, 22, 0, 2, 99]  # Lista numérica

# Acceso y manipulación
print(lista1)  # Muestra toda la lista
print(lista1[0])  # Primer elemento
print(lista2[-1])  # Último elemento
print(lista3[1][0])  # Primer elemento de la lista anidada
print(lista2[0:3:1])  # [1, 2, 3], patrón inicio:fin:paso
print(lista2[::-1])  # Lista ordenada al revés

# Modificación de listas
lista1[2] = False  # Cambia el valor de un elemento
lista2[-2] += 1  # Incrementa el penúltimo elemento
lista2.pop(0)  # Elimina el primer elemento
lista1.remove('uno')  # Elimina el primer elemento coincidente
del lista2[1]  # Elimina el segundo elemento
lista2.append(7)  # Añade un elemento al final
lista2.extend([8, 9])  # Extiende la lista
lista1.insert(1, 'dos')  # Inserta elemento en posición

# Ordenación
lista4.sort()  # Ordena la lista
lista4.sort(reverse=True)  # Ordena en orden inverso
lista5 = sorted(lista4)  # Ordena lista en una nueva







# Trabajando con tuplas
tupla1 = (1, 2, 3)  # Declara tupla
tupla2 = 1, 2, 3  # Otra forma de declarar

# Operaciones con tuplas
tupla3 = (100,)  # Tupla con un elemento
print(tupla1[0:3])  # Acceso por índices: (1, 2, 3)
tupla4 = tupla1, 4, 5, 6  # Tupla anidada
tupla5 = ()  # Tupla vacía
tupla6 = tuple([1, 2, 3, 4, 5])  # Convierte lista a tupla
