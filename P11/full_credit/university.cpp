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

std::istream& operator>>(std::istream& is, University& university) {
    std::getline(is >> std::ws, university._name);
    is >> university._enrollment;
    university.validate();
    return is;
}

std::ostream& operator<<(std::ostream& os, const University& university) {
    os << university._name << " has an enrollment of " << university._enrollment;
    return os;
}