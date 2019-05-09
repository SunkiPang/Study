#include <iostream>
#include "LinkedList.h"

using namespace std;

int main(void){
  
  /*** Instantiating a linked list ***/
  LinkedList *linkedlist = new LinkedList();
  cout << "[msg: a linked list is created]" << endl;

  /*** Inserting elements at tail (at the end) ***/
  // linkedlist = 1 -> 3 -> 8 -> 3 -> 0 -> 6 -> 9 -> 9 -> 3
  linkedlist->Insert_at_tail(1);
  linkedlist->Insert_at_tail(3);
  linkedlist->Insert_at_tail(8);
  linkedlist->Insert_at_tail(3);
  linkedlist->Insert_at_tail(0);
  linkedlist->Insert_at_tail(6);
  linkedlist->Insert_at_tail(9);
  linkedlist->Insert_at_tail(9);
  linkedlist->Insert_at_tail(3);

  cout << "\n=> linkedlist->Traverse(): ";
  linkedlist->Traverse();


  /*** Deleting elements ***/
  // delete all 3's
  cout << "\n[msg: deleting all the occurrences of 3 from the linked list]" << endl;
  linkedlist->Delete_all(3);

  cout << "\n=> Traverse(): ";
  linkedlist->Traverse();

  // delete all 1's
  cout << "\n[msg: deleting all the occurrences of 1 from the linked list]" << endl;
  linkedlist->Delete_all(1);

  cout << "\n=> Traverse(): ";
  linkedlist->Traverse();

  // delete all 9's
  cout << "\n[msg: deleting all the occurrences of 9 from the linked list]" << endl;
  linkedlist->Delete_all(9);

  cout << "\n=> Traverse(): ";
  linkedlist->Traverse();

  return 0;
}
