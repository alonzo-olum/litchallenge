
// input sequence: ['a1','a2','a3','a4','a5','a6','a7','a8']
function output_sequence(sequence) {
	let tag = 'a';
	let incrValue = 3;
	let decrValue = 1;

	let output = [];

	sequence.map((item, index) => {
		// index is 0, item does not change
		if (index==0) {
			output.push(item);
		// index is odd
		} else if (index%2!=0) {
			output.push(tag+(parseInt(sequence[index].substr(1))+incrValue));
			incrValue--;
		// index is even
		} else {
			output.push(tag+(parseInt(sequence[index].substr(1))-decrValue));
			decrValue++;
		}
	});
	return output;
}

// main block
let input = ['a1','a2','a3','a4','a5','a6','a7','a8']
console.log(output_sequence(input));
