#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <random>

int main(int argc, char* argv[]){

	std::vector<std::string> odds; //stack
	std::vector<std::string>* evens = new std::vector<std::string>(); //heap

	for (int i = 1; i < argc; i++){
		std::string arg = argv[i];

		if ((arg.size() % 2) == 0){
			evens->push_back(arg);
		}
		else{
			odds.push_back(arg);
		}
	}


	std::sort(odds.begin(), odds.end()); //sorting odd vectors

	std::random_device rd; //shuffling even vectors
	std::mt19937 g(rd());  //random number enginee based on Mersenne Twister algorithm
	std::shuffle(evens->begin(), evens->end(),g);



	std::cout << "\n\nOdd lengths (Sorted)" <<std::endl;
	for (const auto& s: odds){ 
		std::cout << s << std::endl;
	}


	std::cout << "\n\n\nEven lengths (Shuffled)" <<std::endl;
	for (const auto& s: *evens){ 
		std::cout << s << std::endl;
	}

	delete evens;  //freeing memory for heap vector
	return 0;

}

