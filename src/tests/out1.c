#include <stdio.h>
int main() {
   int    i   ;
   int    soma   ;
   int    somaFor   ;
   int    n   ;
   int    verd   ;
   n   = 100   ;
   soma   = 0   ;
   i   = 0   ;
   verd   = 2   ;
   while ( ((i < n) && verd)   )   {
      if (((i % 2) == (0 + ((0 * 0) / 1)))      )      {
         soma         = (soma + (i * i))         ;
      }
      i      = (i + 1)      ;
   }
   somaFor   = 0   ;
   for ( int k = 0   ;   k <= 100   ;   k++   )   {
      if (((i % 2) == 0)      )      {
         somaFor         = (somaFor + (k * k))         ;
      }
   }
   printf("%d\n", soma    );
   printf("%d\n", somaFor    );
}