#include "university.h"

University::University(const std::string& name, int enrollment)
    : _name(name), _enrollment(enrollment) {
    validate();
}

const std::string& University::name() const {
    return _name;
}

int University::enrollment() const {
    return _enrollment;
}

void University::validate() {
    if (_enrollment < 0) {
        throw std::invalid_argument("University enrollment cannot be negative");
    }
    if (_enrollment > 0 && _name.length() == 0) {
        throw std::invalid_argument("University cannot be anonymous");
    }
}

std::istream& operator>>(std::istream& ist, University& reading) {
    std::getline(ist >> std::ws, reading._name);
    ist >> reading._enrollment;
    reading.validate();
    return ist;
}

std::ostream& operator<<(std::ostream& ist, const University& reading) {
    ist << reading._name << " has an enrollment of " << reading._enrollment;
    return ist;
}
