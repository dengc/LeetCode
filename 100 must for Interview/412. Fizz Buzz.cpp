//412. Fizz Buzz
//else if, %

class Solution {
public:
    vector<string> fizzBuzz(int n) {
        vector<string> res;
        for(int i = 0; i < n; i++){
            int pos = i + 1;
            if(pos % 3 == 0 && pos % 5 == 0){
                res.push_back("FizzBuzz");
            }else if(pos % 3 == 0){
                res.push_back("Fizz");
            }else if(pos % 5 == 0){
                res.push_back("Buzz");
            }else{
                res.push_back(to_string(pos));
            }
        }
        return res;
    }
};