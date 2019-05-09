#ifndef _LINKEDLIST_H_
#define _LINKEDLIST_H_

#include "Element.h"
// type definition for a node
typedef struct t_list_node{
  Element data;
  struct t_list_node *link;
} list_node;


// class definition for a linked list
class LinkedList{
  private:
    list_node *head;

  public:
    LinkedList();
    void Insert_at_tail(Element);
    void Delete(Element);
    bool IsEmptyL();
    void Traverse();
    int Size();

    void Delete_all(Element);
};

#endif
