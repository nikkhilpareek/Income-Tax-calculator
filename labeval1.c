#include <stdio.h>
int main(){
    int num, sum1=0, sum2=0;
    printf("enter a five digit number");
    scanf("%d", &num);
    while (num!=0){
        int n=num%10;
        num/=10;
        if (n%2==0){
            sum1+=n;
        } else { sum2+=n;}
}
printf("sum of all odd integers is%d", sum2);
printf("sum of all even integers is %d", sum1);
return 0;
}