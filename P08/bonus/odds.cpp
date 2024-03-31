#include <iostream>
#include <vector>
#include <string>

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

	std::cout << "\n\nOdd lengths" <<std::endl;
	for (const auto& s: odds){ 
		std::cout << s << std::endl;
	}


	std::cout << "\n\n\nEven lengths" <<std::endl;
	for (const auto& s: *evens){ 
		std::cout << s << std::endl;
	}

	delete evens;  //freeing memory for heap vector
	return 0;

}

