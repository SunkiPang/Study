#include "Queue.h"
#include <iostream>
#include <stdlib.h>

// Constructor
// (Having the same name as the class itself; has no return nor the return type)
Queue::Queue(int init_max_size){
  // TODO: Complete this function
	front = rear = 0;
	max_size = init_max_size;
	queue = (Element*)malloc(sizeof(Element) *max_size);
}


// Destructor
// (the name starts with ~; has no return nor the return type)
Queue::~Queue(){
  // TODO: Complete this function
  if(queue != NULL)
  	free(queue);
  queue = NULL;
}


// Enqueue
void Queue::Enqueue(Element item){
  // TODO: Complete this function
  if(IsFullQ())
  	std::cout << "Queue is full" << std::endl;
  else{
  	rear = (rear+1)%max_size;
  	queue[rear] = item;
  }

}

// Dequeue
Element Queue::Dequeue(){
  // TODO: Complete this function
  if(IsEmptyQ()){
  	std::cout << "Queue is empty" << std::endl;
  	return (Element)0;
  }
  else{
  	front = (front+1)%max_size;
  	return queue[front];
  }
}


// IsEmpty?
bool Queue::IsEmptyQ() const{
  // TODO: Complete this function
  return (front == rear);
}

// IsFull?
bool Queue::IsFullQ() const{
  // TODO: Complete this function
  return ((rear + 1)%max_size == front);
}







// Accessors/Mutators
int Queue::get_front() const{
  // TODO: Complete this function
  return front;
}

int Queue::get_rear() const{
  // TODO: Complete this function
  return rear;
}

int Queue::get_max_size() const{
  // TODO: Complete this function
  return max_size;
}


// a utility function that visualizes the internal data representation (Element array)
// for an education purpose
void Queue::visualize(){
  std::cout << "(front=" << front << "; rear=" << rear << ") [";

  if(front <= rear){
    for(int i = front+1; i <= rear; i++){
      std::cout << queue[i] << " ";
    }
  }else{
    // if(front > rear)
    for(int i = front+1; i < max_size; i++){
      std::cout << queue[i] << " ";
    }

    for(int i = 0; i <= rear; i++){
      std::cout << queue[i] << " ";
    }
  }
  std::cout << "]" << std::endl;
}
