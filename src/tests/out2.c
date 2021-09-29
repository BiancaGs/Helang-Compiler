#include <stdio.h>
int main() {
   int    s   ;
   int    i   ;
   s   = 0   ;
   for ( int j = 1   ;   j <= 100   ;   j++   )   {
      s      = (s + j)      ;
   }
   printf("%d\n", s    );
}
