// Andela Javascript Interview
//
const input=['a1','a2','a3','a4','a5','a6','a7','a8']
let add=4
let minus=3
output=[]

// Iterate input list performing computation
// output = ['a1', 'a5', 'a2', 'a6', 'a3',
// 'a7', 'a4', 'a8']
input.map((item,index) => {
	if(index==0){
		 output.push(item)
	}else if(index%2!=0){
		output.push('a'+(parseInt(output[index-1].substr(1))+add))
	}else{
		output.push('a'+(parseInt(output[index-1].substr(1))-minus))
	}
})
console.log(output)
