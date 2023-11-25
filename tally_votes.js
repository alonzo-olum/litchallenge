function tallyVotes(votes) {
	var tally = {};
	for (var i=0;i<votes.length;i++) {
		if (tally[votes[i]]) {
			tally[votes[i]]++;
		} else {
			tally[votes[i]] = 1;
		}
	}
	return tally;
}

// main program entry block
var candidates = ["thomas anderson", "john adams",
		"billy joy", "thomas anderson", "chris langan",
		"robert oppenheimer", "chris langan", "billy joy",
		"bill gates", "antonio brown", "robert oppenheimer"]
console.log(tallyVotes(candidates));
