
function selectionSort(array) {
	for (var i = 0; i < array.length; i++) {
		var lowestIndex = i;
		for (var j = i + 1; j < array.length; j++) {
			if (array[j] < array[lowestIndex]) {
				lowestIndex = j;
			}
		}
		if (lowestIndex != i) {
			var temp = array[i];
			array[i] = array[lowestIndex];
			array[lowestIndex] = temp;
		}
	}
	return array;
}

var arr = [5,2,4,1,6,8];
console.log(selectionSort(arr))
