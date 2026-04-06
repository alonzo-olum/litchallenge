// Use ES6 features
let selection_sort = (array) => {
	for (let i = 0; i < array.length; i++) {
		let lowestIndex = i;
		for (let j = i + 1; j < array.length; j++) {
			if (array[j] < array[lowestIndex]) {
				lowestIndex = j;
			}
		}
		if (lowestIndex != i) {
			let temp = array[i];
			array[i] = array[lowestIndex];
			array[lowestIndex] = temp;
		}
	}
	return array;
}

let arr = [5,2,4,1,6,8];
console.log(selection_sort(arr))
