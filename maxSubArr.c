#include<stdio.h>
#define MAX(a,b) ((a)<(b)?(b):(a))

int maxSubArr(int* num, int size){

	int maxSum=num[0];
	int currSum=num[0];
	for(int index=1;index<size;index++){
		currSum=MAX(currSum+num[index],num[index]);
		maxSum=MAX(currSum,maxSum);
	}
	return maxSum;
}
int _size(num)
	int num[];
{
	int i=0;
	while(num[i]!='\0')
		++i;
	return i-1;
}

main(){
	int num[]={-2,1,-3,1,4,1,5,-4,-5};
	printf("%d is maxSum of SubArray",maxSubArr(num,_size(num)));
	//printf("%d is size of SubArray",_size(num));
}
