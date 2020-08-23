
class maxSubArr{

	public maxSubArr(){

	}
	public int maxSubArr(int nums[]){
		int maxSum=nums[0];
		int currSum=0;
		for(int num:nums){
			if((currSum+num)> num){
				currSum+=num;
			}else{
				currSum=num;
			}
			if(currSum>maxSum)
				maxSum=currSum;
		}
		return maxSum;
	}

	public static void main(String args[]){
		int num[]={-2,1,-3,1,4,1,5,-4,-5};
		maxSubArr max = new maxSubArr();
		System.out.println(max.maxSubArr(num) +" is maxSum of SubArray");
	}
}
