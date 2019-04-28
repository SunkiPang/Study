#include <iostream>
#include "Queue.h"

using namespace std;

int main() {
  std::cout << "========================\n";
  std::cout << "==== Queue Examples ====\n";
  std::cout << "========================\n";

  cout << endl << "********************************************************************" << endl;
  cout << endl << "** Example 1: Queuq q1 as a heap (dynamically allocated) variable **" << endl;
  cout << endl << "********************************************************************" << endl;

  /**** Queue Example 1 ****/
  // Instantiate a head object (create a heap variable)
  // q1 is allocated dynamically
  cout << "q1 of capacity 10, as a heap instance (i.e., class object)" << endl;
  Queue *q1 = new Queue(10);

  // adding 1, 2, and 3 to queue s1, and visualize the queue
  cout << "# Enqueuing (adding) 1, 2, and 3 to queue q1" << endl;
  q1->Enqueue(1);
  q1->visualize();
  q1->Enqueue(2);
  q1->visualize();
  q1->Enqueue(3);
  q1->visualize();

  // // removing the lastest two elements (3 and 2) from queue q1, and visualize the queue
  cout << "# Dequeuing (removing) earliest two elements from queue q1" << endl;
  q1->Dequeue();
  q1->visualize();
  q1->Dequeue();
  q1->visualize();

  // adding 4, and 5 to queue q1, and visualize the queue
  cout << "# Enqueuing 4, and 5 to queue q1" << endl;
  q1->Enqueue(4);
  q1->visualize();
  q1->Enqueue(5);
  q1->visualize();

  // IsFull or IsEmpty?
  cout << "# Is q1 full or Is q1 empty?" << endl;
  cout << "(q1) IsFullQ()=" << q1->IsFullQ() << endl;
  cout << "(q1) IsEmptyQ()=" << q1->IsEmptyQ() << endl;

  // cout << "# Dequeuing (removing) lastest four elements from queue q1" << endl;
  q1->Dequeue();
  q1->visualize();
  q1->Dequeue();
  q1->visualize();
  q1->Dequeue();
  q1->visualize();
  q1->Dequeue();
  q1->visualize();

  // IsFull or IsEmpty?
  cout << "# Is s1 full or Is s1 empty?" << endl;
  cout << "(q1) IsFullQ()=" << q1->IsFullQ() << endl;
  cout << "(q1) IsEmptyQ()=" << q1->IsEmptyQ() << endl;

  // Make sure it is off from the memory when the task is done
  delete q1;



  /**** Queue Example 2 ****/
  cout << endl;
  cout << endl << "*********************************************" << endl;
  cout << endl << "** Example 2: Queue q2 as a local variable **" << endl;
  cout << endl << "*********************************************" << endl;

  // 1) Allocate q2 using as a local variable
  //    Set q2's max_size to 3
  cout << "q2 of capacity 3, as a local instance (i.e., class object)" << endl;
  // TODO: Declare a Queue variable q2 as a local variable. Its capacity is 3.
  Queue q2 = Queue(3);

  // 2) Enqueue 1, 2, 3, 4, 5 to queue q2 (You may ignore messages "Queue is full")
  cout << "# Enqueuing (adding) 1, 2, 3, 4, and 5 to queue q2" << endl;
  // TODO: Enqueue 1, 2, 3, 4, and 5 to queue q2. You may see messages like "Queue is full".
  q2.Enqueue(1);
  q2.Enqueue(2);
  q2.Enqueue(3);
  q2.Enqueue(4);
  q2.Enqueue(5);

  // 3) Visualize the queue by invoking visualize() of q2
  q2.visualize();


  // 4) Test s2: IsFull or IsEmpty?
  cout << "# Is q2 full or Is q2 empty?" << endl;
  cout << "(q2) IsFullQ()=" << q2.IsFullQ() << endl;
  cout << "(q2) IsEmptyQ()=" << q2.IsEmptyQ() << endl;


  // 5) Dequeue the next element from q2 (I.e., dequeue one element out)
  cout << "# Dequeuing (removing) the next element from queue q2" << endl;
  // TODO: Dequeue one element from q2.
  q2.Dequeue();

  // 6) Visualize the queue by invoking visualize() of s2
  q2.visualize();


  // 7) Enqueue 6, and 7
  cout << "# Enqueuing (adding) 6 and 7 to queue q2" << endl;
  // TODO: Enqueue 6 and 7 to queue q2. You may see messages like "Queue is full".
	q2.Enqueue(6);
	q2.Enqueue(7);

  // 8) Visualize the queue by invoking visualize() of s2
  q2.visualize();

}
