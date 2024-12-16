package moodlegaldetegiak.arrayak;
// Zer inprimatuko da?


public class Galdera6 {
    public static void main(String[] args) {
        String[] kodeak = new String[10];
for (int i = 0; i < kodeak.length; i++) {
    if (i % 2 == 0) {
        kodeak[i] = "A" + i;
    } else {
        kodeak[i] = "B" + i;
    }
}
System.out.println(kodeak[2]);

    }
}

//Nire erantzuna: A2
