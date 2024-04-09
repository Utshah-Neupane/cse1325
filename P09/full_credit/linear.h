#ifndef LINEAR_H
#define LINEAR_H

#include "polynomial.h"

class Linear : public Polynomial {
public:
    Linear(const std::vector<double>& coefficients);
    virtual ~Linear();

    std::vector<double> solve() const override;
};

#endif // LINEAR_H
