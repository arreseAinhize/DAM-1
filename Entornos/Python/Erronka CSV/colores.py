# Mostrar todos los colores ANSI para texto y fondo
for i in range(30, 38):  # Colores estándar de texto
    print(f"\033[{i}m Color {i} de texto \033[0m", end="   ")
print("\n")

for i in range(40, 48):  # Colores estándar de fondo
    print(f"\033[{i}m Color {i} de fondo \033[0m", end="   ")
print("\n")

# Colores brillantes
for i in range(90, 98):  # Colores brillantes de texto
    print(f"\033[{i}m Color {i} de texto (brillante) \033[0m", end="   ")
print("\n")

for i in range(100, 108):  # Colores brillantes de fondo
    print(f"\033[{i}m Color {i} de fondo (brillante) \033[0m", end="   ")
print("\n")

# Mostrar efectos
print("\033[1mTexto en negrita\033[0m")
print("\033[3mTexto en cursiva\033[0m")
print("\033[4mTexto subrayado\033[0m")
print("\033[7mTexto invertido\033[0m")
print("\033[5mTexto parpadeando (puede no funcionar)\033[0m")

# Mostrar combinación de colores
print("\033[1;33;44mTexto amarillo brillante sobre fondo azul\033[0m")
print("\033[3;35;46mTexto magenta cursiva sobre fondo cian\033[0m")
print("\033[4;92;100mTexto subrayado verde claro sobre gris oscuro\033[0m")

# Ejemplo con 256 colores
for i in range(16, 232, 36):  # Mostrar algunos colores de la paleta 256
    print(f"\033[38;5;{i}mTexto en color {i} (256 colors)\033[0m", end="   ")
print("\n")

for i in range(16, 232, 36):
    print(f"\033[48;5;{i}m Fondo en color {i} (256 colors) \033[0m", end="   ")
print("\n")

# Ejemplo con RGB (24 bits)
print("\033[38;2;255;0;0mTexto en rojo puro (RGB)\033[0m")
print("\033[48;2;0;255;255mFondo en cian puro (RGB)\033[0m")
