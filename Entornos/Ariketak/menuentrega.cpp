#include <stdio.h>
int main()
{
    int n = 5;
    // The index n for F(n), starting from n=3, as n=1 and n=2 are pre-defined
    // F(n) to be computed  // F(n-1), init to F(2) // F(n-2), init to F(1) // maximum n, inclusive
    for(int row =1;row<=n;row++){
        for(int col = n; col >0;col--){
            printf("* ");
        }
    printf("\n");
    }
    retunr 0;
}