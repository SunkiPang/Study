#include "Stack.h"
#include <iostream>
#include <stdlib.h>

// Constructor
// (Having the same name as the class itself; has no return nor the return type)
Stack::Stack(int init_max_size){
  // TODO: Complete this function
   top = -1;
   max_size = init_max_size;
   stack = (Element*)malloc(sizeof(Element));
  // If there is a malloc(), there should be a matching free() to release the memory block
  // Where to put in free()? --> destructor!
}

// Destructor
// (the name starts with ~; has no return nor the return type)
Stack::~Stack(){
  // TODO: Complete this function
   if(stack != NULL){
      free(stack);
   }
   stack = NULL;
  // If the constructor has a malloc(),
  // there has to be a matching free() in the destructor!
}


// Push
void Stack::Push(Element item){
  // TODO: Complete this function
   if(IsFullS() == 1){
      std::cout << "FULL" << std::endl;
   }
   else
      stack[++top] = item;
}

// Pop
Element Stack::Pop(){
  // TODO: Complete this function
   if(IsEmptyS() == 1){
      std::cout << "Empty" << std::endl;
			return (Element)0;
   }
   else
      return stack[top--];
}

// IsEmpty?
// The 'const' modifier indicates that
// this function would not change any values of the member variables
bool Stack::IsEmptyS() const{
  // TODO: Complete this function
   if (top == -1)
      return 1;
   else
      return 0;

  // Test if top == -1: if yes, (top == -1) would be true, hence IsEmptyS() returns true
  //                    if no, IsEmptyS() returns false
}

// IsFull?
bool Stack::IsFullS() const{
  // TODO: Complete this function
   if(top == max_size -1)
      return 1;
   else
      return 0;


  // Test if top == max_size-1:
  //   if yes, (top == max_size-1) would be true,
  //           which means that 'top' is currently at the end of the internal Element array
  //           and there is no more room; hence IsFullS() returns true
  //   if no, 'top' does not reach the end of the Element array yet; hence IsFullS() returns false
}



// Accessor/mutator -- routine task!
int Stack::get_top() const{
  // TODO: Complete this function
  return top;
}

int Stack::get_max_size() const{
  // TODO: Complete this function
  return max_size;
}

// a utility function that visualizes the internal data representation (Element array)
// for an education purpose
void Stack::visualize(){
  std::cout << "(top=" << top << ") [";
  for(int i = 0; i <= top; i++){
    std::cout << stack[i] << " ";
  }
  std::cout << "]" << std::endl;
}
