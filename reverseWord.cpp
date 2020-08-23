
class Solution {
	public:
		void reverseWords(vector<char>& s){
			//reverse the whole string
			reverse(s.begin(), s.end());

			int n = s.size();
			int index=0;

			for(int start=0;start<n;++start) {
				if(s[start] != ' ') {
					if(index!=0) s[index++]=' ';

					int end=start;
					while(end < n && s[end] != ' ')
						s[index++]=s[end++];
					reverse(s.begin()+index - (end - start),
							s.begin() + index);
					start=end;
				}
			}
		}
}
