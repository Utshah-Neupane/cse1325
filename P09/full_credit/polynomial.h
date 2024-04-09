#ifndef POLYNOMIAL_H
#define POLYNOMIAL_H

#include <vector>

class Polynomial {
protected:
    std::vector<double> _coefficients;

public:
    Polynomial(const std::vector<double>& coefficients);
    virtual ~Polynomial();

    virtual std::vector<double> solve() const = 0;  // Returns a vector of solutions
};

#endif // POLYNOMIAL_H



