#include <iostream>
#include "Digraph.h"
#include "Assignations.h"

int main() {
  std::cout << "Hello World!\n";
  Assignations a = Assignations();
  float p = 1.2F;
  a.readFile(4, p);

  return 0;
}