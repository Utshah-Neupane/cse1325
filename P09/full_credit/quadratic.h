#ifndef QUADRATIC_H
#define QUADRATIC_H

#include "polynomial.h"

class Quadratic : public Polynomial {
public:
    Quadratic(const std::vector<double>& coefficients);
    virtual ~Quadratic();

    std::vector<double> solve() const override;
};

#endif // QUADRATIC_H
