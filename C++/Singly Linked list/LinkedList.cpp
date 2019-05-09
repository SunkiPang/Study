#include "LinkedList.h"
#include <iostream>

// Constructor LinkedList
// - simply initiates head as NULL
LinkedList::LinkedList(){
  // Creating an emmpty linked list
  head = NULL;
}


// IsEmpty function
// - if head is NULL, then the list is empty
bool LinkedList::IsEmptyL(){
  if(head == NULL) return true;
  return false;
}


// Insert at tail
// - Insert a new item at the end of the list
void LinkedList::Insert_at_tail(Element new_item){
  // prepare a new list_node
  list_node *new_node = new list_node();
  new_node->data = new_item;
  new_node->link = NULL;  // link is always NULL because, it is the node at the end of the list

  // insert the new list_node to the list
  if(head == NULL){
    // if the list is currently empty, set head = new_node
    head = new_node;
  }else{
    // if the list has at least one element, traverse to the end of the list, and insert the item at the end of the list
    list_node *curr, *prev;
    for(curr = head; curr != NULL; prev = curr, curr = curr->link);
    prev->link = new_node;
  }
}


// Delete the first node that has the same value as item from the list
void LinkedList::Delete(Element item_to_delete){
  list_node *prev, *curr = head;
  while(curr && curr->data != item_to_delete){
    prev = curr;
    curr = curr->link;
  }

  if(curr){
    if(curr == head) head = curr->link;
    else prev->link = curr->link;

    delete curr;
  }
}


// Print out all elements in the list
void LinkedList::Traverse(){
  list_node *curr;
  for(curr = head; curr != NULL; curr = curr->link)
    std::cout << curr->data << " ";
  std::cout << std::endl;
}


// Size()
int LinkedList::Size(){
  int n;
  list_node *curr;
  for(curr = head, n = 0; curr != NULL; curr = curr->link, n++);
  return n;
}


// Delete the first node that has the same value as item from the list
void LinkedList::Delete_all(Element item_to_delete){
  // TODO: ** Complete this function **
	list_node *prev, *curr = head;
	while(curr != NULL){
	    if(curr->data == item_to_delete){
	    	if(curr == head) {
	    		head = curr->link;
	    	}
	    	else{
	    		prev->link = curr->link;
	    	}
	    	delete curr;
	    }
	    else{
			prev = curr;
	    }
		curr = curr->link;
	}
}//end-of-Delete_all()
