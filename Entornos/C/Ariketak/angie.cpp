#include <stdio.h>
int main(){
    int lerrokopurua;
    printf("sartu lerro kopurua triangelua marrazteko");
    scanf ("%d,&lerrokopurua");

    int lerroa;
    for (lerroa=1; lerroa<lerrokopurua; lerroa++){
        int zutabea;
        for (zutabea=1; zutabea<=lerrokopurua; zutabea++){
            printf(¨"*");
        }
        printf("\n");
    }
    return 0;
}

