#include <iostream>
#include "inch.h"

int main() {
    Inch in, last_in, sum;

    while (std::cin.good()) {
        std::cout << "\n\nEnter Inch (whole numerator/denominator): ";
        std::cin >> in;

        sum = sum + in;

        std::cout << "\nYou entered: " << in << std::endl;
        
        if (in == last_in) {
            std::cout << "The same length as last time." << std::endl;
        }
        if (in != last_in) {
            std::cout << "NOT the same length as last time." << std::endl;
        }
        if (in > last_in) {
            std::cout << "Bigger lenth than last time." << std::endl;
        }
        if (in >= last_in) {
            std::cout << "Bigger or same length as last time." << std::endl;
        }
        if (in < last_in) {
            std::cout << "Smaller lenth than last time." << std::endl;
        }
        if (in <= last_in) {
            std::cout << "Smaller or same length as last time." << std::endl;
        }

        std::cout << "Sum so far is: " << sum << std::endl;

        last_in = in;
    }

    return 0;
}