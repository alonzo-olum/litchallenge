
function hasDuplicateValue(array) {
	var existingValues = {};
	for(var i=0;i<array.length;i++) {
		if(existingValues[array[i]] === undefined) {
			existingValues[array[i]] = 1;
		} else {
			return true;
		}
	}
		return false;
}
var duplicateArray = [3, 2, 7, 0, 1, 4, 5, 8, 9, 1]
console.log(hasDuplicateValue(duplicateArray))
