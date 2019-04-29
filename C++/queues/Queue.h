#ifndef _QUEUE_H_
#define _QUEUE_H_

#include "Element.h"

class Queue{
  private:
    int front, rear;  // telling where's the current queue front and rear
    int max_size;     // max capacity
    Element *queue;   // an Element-type array as the internal data representation

  public:
    Queue(int);  // constructor
    ~Queue(); // destructor

    void Enqueue(Element item);  // Queue operation - Enqueue
    Element Dequeue();            // Queue operation - Dequeue
    bool IsEmptyQ() const;        // Queue operation - IsEmptyS
    bool IsFullQ() const;         // Queue operation - IsFullS

    // a utility function that visualizes the internal data representation (Element array)
    // for an education purpose
    void visualize();

    // Accessors/Mutators
    int get_front() const;
    int get_rear() const;
    int get_max_size() const;



    //-- We are not going to write functions below as they may ruin
    //   the correct operation of our queue
    //
    // void set_front(int);
    // void set_rear(int);
    // void set_max_size(int);
    // Element* get_queue() const;
    // void set_queue(int Element*);
};

#endif
