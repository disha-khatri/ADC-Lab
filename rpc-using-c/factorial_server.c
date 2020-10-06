#include "factorial.h"
int *
factorial_1_svc(S *argp, struct svc_req *rqstp)
{
 static int result;
 int ans=1;
 int i;
 for(i=1; i<=(argp->a); i++){
 ans=ans*i;
 }
 result=ans;
 printf("%d ! = %d\n", (argp->a),ans);
 return &result;
} 