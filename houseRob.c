#include<stdio.h>
#define MAX(a,b) ((a)<(b)?(b):(a))

int rob(ints,size)
	int ints[];
	int size;
{
	int evens=0,odds=0;
	for(int i=0;i<size;++i){
		if(i==0)
			evens+=ints[i];
		else
		if(ints[i]%2!=0)
			odds+=ints[i];
		else
			evens+=ints[i];
	}
	return MAX(evens,odds);
}

int size(ints)
	int ints[];
{
	int i=0;
	while(ints[i]!='\0' )
		++i;
	return i-1;
}

main(){
	int ints[]={1,2,3,1};
	printf("optimal amount is %d\n", rob(ints,size(ints)));
	//printf("optimal size is %d\n", size(ints));
}
