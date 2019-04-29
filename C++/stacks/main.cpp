#include <iostream>
#include "Stack.h"

using namespace std;

int main() {
  std::cout << "========================\n";
  std::cout << "==== Stack Examples ====\n";
  std::cout << "========================\n";

  cout << endl << "*********************************************" << endl;
  cout << endl << "** Example 1: Stack s1 as a local variable **" << endl;
  cout << endl << "*********************************************" << endl;

  /**** Stack Example 1 ****/
  // Instantiate a stack object (create a stack variable)
  // s1 is allocated statically
  Stack s1 = Stack(10);

  // adding 1, 2, and 3 to stack s1, and visualize the stack
  cout << "# Pushing (adding) 1, 2, and 3 to stack s1" << endl;
  s1.Push(1);
  s1.visualize();
  s1.Push(2);
  s1.visualize();
  s1.Push(3);
  s1.visualize();

  // removing the lastest two elements (3 and 2) from stack s1, and visualize the stack
  cout << "# Popping (removing) lastest two elements from stack s1" << endl;
  s1.Pop();
  s1.visualize();
  s1.Pop();
  s1.visualize();

  // adding 4, and 5 to stack s1, and visualize the stack
  cout << "# Pushing 4, and 5 to stack s1" << endl;
  s1.Push(4);
  s1.visualize();
  s1.Push(5);
  s1.visualize();

  // IsFull or IsEmpty?
  cout << "# Is s1 full or Is s1 empty?" << endl;
  cout << "(s1) IsFullS()=" << s1.IsFullS() << endl;
  cout << "(s1) IsEmptyS()=" << s1.IsEmptyS() << endl;

  cout << "# Popping (removing) lastest four elements from stack s1" << endl;
  s1.Pop();
  s1.visualize();
  s1.Pop();
  s1.visualize();
  s1.Pop();
  s1.visualize();
  s1.Pop();
  s1.visualize();

  // IsFull or IsEmpty?
  cout << "# Is s1 full or Is s1 empty?" << endl;
  cout << "(s1) IsFullS()=" << s1.IsFullS() << endl;
  cout << "(s1) IsEmptyS()=" << s1.IsEmptyS() << endl;



  /**** Stack Example 2 ****/
  cout << endl;
  cout << endl << "********************************************************************" << endl;
  cout << endl << "** Example 2: Stack s2 as a heap (dynamically allocated) variable **" << endl;
  cout << endl << "********************************************************************" << endl;


  // 1) Allocate s2 using the 'new' operator (as a dynamically allocated variable)
  //    Set s2's max_size to 3
  // TODO: Instantiate a stack object, named "s2".

  Stack *s2 = new Stack(3);

  // 2) Push 1, 2, 3, 4, 5 to stack s2 (You may ignore messages "Stack is full")
  cout << "# Pushing (adding) 1, 2, 3, 4, and 5 to stack s2" << endl;
  // TODO: push 1, 2, 3, 4, and 5.
  s2->Push(1);
  s2->Push(2);
  s2->Push(3);
  s2->Push(4);
  s2->Push(5);



  // 3) Visualize the stack by invoking visualize() of s2
  s2->visualize();


  // 4) Test s2: IsFull or IsEmpty?
  cout << "# Is s2 full or Is s2 empty?" << endl;
  cout << "(s2) IsFullS()=" << s2->IsFullS() << endl;
  cout << "(s2) IsEmptyS()=" << s2->IsEmptyS() << endl;


  // 5) Pop the one element from s2 (I.e., pop one element out)
  cout << "# Popping (removing) the lastest element from stack s2" << endl;
  // TODO: Pop the one element from s2
  s2->Pop();

  // 6) Visualize the stack by invoking visualize() of s2
  s2->visualize();


  // Make sure it is off from the memory when the task is done
  delete s2;

}
