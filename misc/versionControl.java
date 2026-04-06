class versionControl{
	
	int firstVersion(int n){
		int left=1;
		int right=n;
		while(left<right){
			int mid=left+(right-left)/2;
			if(isbadVersion(mid)){
				right=mid;
			}else{
				left=mid+1;
			}
		}
		return left;
	}
	boolean isbadVersion(int n){
		return ( n > n-1 ) && ( n-1 < n );
	}

	public static void main (String args[]){
		int versios=8; 
		versionControl versionCtrl=new versionControl();
		System.out.println("bad version: "+versionCtrl.firstVersion(versios));
	}
}
