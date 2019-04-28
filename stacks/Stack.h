#ifndef _STACK_H_
#define _STACK_H_

#include "Element.h"

class Stack{
  private:
    int top;  // telling where's the current stack top
    int max_size; // max capacity
    Element *stack; // it is going to have an Element-type array as the internal data representation

  public:
    Stack(int);  // constructor
    ~Stack(); // destructor

    void Push(Element item);  // Stack operation - Push
    Element Pop();            // Stack operation - Pop
    bool IsEmptyS() const;    // Stack operation - IsEmptyS
    bool IsFullS() const;    // Stack operation - IsFullS

    // a utility function that visualizes the internal data representation (Element array)
    // for an education purpose
    void visualize();

    // Accessors/Mutators
    // -- We can "mechanically" write the accessors and mutators as below
    //    However, we are not going to enable all as some of these getters and setters
    //    may ruin the operations of Stack, and let us not guarantee the correctness of data structure.
    //    So we only allow get_top() and get_max_size() functions.

    int get_top() const;
    int get_max_size() const;



    // void set_top(int);
    // void set_max_size(int);
    // Element* get_stack() const;
    // void set_stack(int Element*);

};

#endif
