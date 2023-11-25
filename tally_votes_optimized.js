var votes = {};
function tallyVotes(candidate) {
	if (votes[candidate]) {
		votes[candidate]++;
	} else {
		votes[candidate] = 1;
	}
}

function countVotes() {
	return votes;
}
// Main program entry
var candidates = ["thomas anderson", "john adams",
		"billy joy", "thomas anderson", "chris langan",
		"robert oppenheimer", "chris langan", "billy joy",
		"bill gates", "antonio brown", "robert oppenheimer"];
for (var i=0; i < candidates.length; i++) tallyVotes(candidates[i]);
console.log(countVotes());
