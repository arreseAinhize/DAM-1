def main_ariketa4():
    # import complex math module
    import cmath

    print("ax2 + bx + c = 0")
    print("a, b and c are real numbers and a ≠ 0")


    a = int(input("The value of a: "))
    b = int(input("The value of b: "))
    c = int(input("The value of c: "))

    # calculate the discriminant
    d = (b**2) - (4*a*c)

    # find two solutions
    sol1 = (-b-cmath.sqrt(d))/(2*a)
    sol2 = (-b+cmath.sqrt(d))/(2*a)

    print('The solution are {0} and {1}'.format(sol1,sol2))


if __name__ == "__main__":
    main_ariketa4()