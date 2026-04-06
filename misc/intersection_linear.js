function intersection(firstArray, secondArray) {
	var results = [];
	for(var i=0;i<firstArray.length;i++) {
		for(var j=0;j<secondArray.length;j++) {
			if (firstArray[i] == secondArray[j]) {
				results.push(firstArray[i])
					break;
			}
		}
	}
	return results
}

vectorA = [3, 5, 1, 8, 0]
vectorB = [6, 2, 9, 1, 8]
console.log(intersection(vectorA, vectorB))
