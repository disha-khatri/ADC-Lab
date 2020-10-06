#include "fact.h"
void
fact_prog_1(char *host)
{
 CLIENT *clnt;
 int *result_1;
 S factorial_1_arg;
#ifndef DEBUG
 clnt = clnt_create (host, FACT_PROG, FACT_VERS, "udp");
 if (clnt == NULL) {
 clnt_pcreateerror (host);
 exit (1);
 }
#endif /* DEBUG */
 printf("Enter N: ");
 scanf("%d",&(factorial_1_arg.a));

 result_1 = factorial_1(&factorial_1_arg, clnt);
 if (result_1 == (int *) NULL) {
 clnt_perror (clnt, "call failed");
 }
 else
 {
 printf("Factorial: %d\n",*result_1);
 }
#ifndef DEBUG
 clnt_destroy (clnt);
#endif /* DEBUG */
} 

int
main (int argc, char *argv[])
{
 if (argc < 2) {
 printf ("usage: %s server_host\n", argv[0]);
 exit (1);
 }
 host = argv[1];
 fact_prog_1 (host);
exit (0);
} 
