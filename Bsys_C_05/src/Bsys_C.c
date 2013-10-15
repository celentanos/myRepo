/* Berechnung von Primzahlen nach Prof. Jahn */
#include<sys/types.h>
#include<unistd.h>
#include<stdlib.h>
#include<sys/wait.h>
#include <stdio.h>
#include <math.h>

short isPrime(long p);

pid_t pid;
int status;

int main(){
//---------------------------------------------------------------------
  long i, n, anz=0;
  printf ("Bis zu welcher Zahl sollen Primzahlen ausgegeben werden? ");
  scanf ("%ld", &n);
  for ( i = 2; i <= n; i++ )
    if ( isPrime(i) ) {
        anz++;
        printf ("%ld \n", i);
    }
  printf ("\n%ld Primzahlen\n", anz);
//---------------------------------------------------------------------
	pid = fork();

	switch (pid){
	case -1:
		perror("fork");
		exit(1);
	case 0: //child

		exit(0);
	default: //parent

		pid = wait(&status);
		exit(0);
	}

 	printf("%d\n", getpid());
 	printf("%d\n", getppid());

  return 0;
}

short isPrime(long p){
  long s, d;
  s = (long) sqrt(p) + 1;
  if ( p <  2 ) return 0;
  if ( p == 2 ) return 1;
  if ( p % 2 == 0 ) return 0;
  for ( d = 3; d <= s; d+=2 )
    if ( p % d == 0 ) return 0;
  return 1;
}
