public class LinkedList {

    // head: reference variable to the first node of the list
    private LLnode head;

    // CONSTRUCTORS
    public LinkedList() {
        head = null;
    }

    /* Below are MANY methods that are used on Linked Lists.
	 * 
	 * Examples:
	 * search, insert, delete, isEmpty, sumNodes, and many more
     */
    //
    // boolean | isEmpty()
    //
    public boolean isEmpty() {
        return head == null;
    }

    //
    // boolean | search(int)
    //
    public boolean search(int data) {
        return search(head, data);
    }
    //
    // boolean | search(LLnode, int)
    //

    private boolean search(LLnode p, int data) {
        LLnode helpPtr = p;
        while (helpPtr != null) {
            if (helpPtr.getData() == data) {
                return true;
            }
            helpPtr = helpPtr.getNext();
        }
        return false;
    }

    //
    // boolean | search(int)
    //
    public LLnode findNode(int data) {
        return findNode(head, data);
    }
    //
    // boolean | search(LLnode, int)
    //

    private LLnode findNode(LLnode p, int data) {
        LLnode helpPtr = p;
        while (helpPtr != null) {
            if (helpPtr.getData() == data) {
                return helpPtr;
            }
            helpPtr = helpPtr.getNext();
        }
        return null;
    }

    //
    // void | PrintList()
    //PRINT ALL NODE
    public void PrintList() {
        PrintList(head);
    }
    //
    // void | PrintList(LLnode)
    //

    private void PrintList(LLnode head) {
        // We need to traverse...so we need a help ptr
        LLnode helpPtr = head;
        // Traverse to correct insertion point
        while (helpPtr != null) {
            // Print the data value of the node
            System.out.print(helpPtr.getData() + ", ");
            // Step one node over
            helpPtr = helpPtr.getNext();
        }
        System.out.println();
    }

    //
    // void | PrintList()
    //
    public void ModifyAllNodes() {
        ModifyAllNodes(head);
    }
    //
    // void | PrintList(LLnode)
    //

    private void ModifyAllNodes(LLnode head) {
        // We need to traverse...so we need a help ptr
        LLnode helpPtr = head;
        // Traverse to correct insertion point
        while (helpPtr != null) {
            // We add 10 to the data value of each node
            helpPtr.setData(helpPtr.getData() + 10);
            // Step one node over
            helpPtr = helpPtr.getNext();
        }
    }

    //
    // int | sumNodes()
    //
    public int sumNodes() {
        return sumNodes(head);
    }
    //
    // int | sumNodes(BSTnode)
    //

    private int sumNodes(LLnode head) {
        // We need to traverse...so we need a help ptr
        LLnode helpPtr = head;
        int sum = 0; // counter
        // Traverse to correct insertion point
        while (helpPtr != null) {
            // Increase sum
            sum += helpPtr.getData();
            // Step one node over
            helpPtr = helpPtr.getNext();
        }
        return sum;
    }

    //
    // void | insert(int)
    //
    public void insert(int data) {
        head = insert(head, data);
    }
    //
    // LLnode | insert(LLnode, value)
    //

    private LLnode insert(LLnode head, int data) {
        // IF there is no list, newNode will be the first node, so just return it
        if (head == null || head.getData() > data) {
            head = new LLnode(data, head);
            return head;
        } // ELSE, we have a list. Insert the new node at the correct location
        else {
            // We need to traverse to the correct insertion location...so we need a help ptr
            LLnode helpPtr = head;
            // Traverse to correct insertion point
            while (helpPtr.getNext() != null) {
                if (helpPtr.getNext().getData() > data) {
                    break; // we found our spot and should break out of the while loop
                }
                helpPtr = helpPtr.getNext();
            }
            // Now make the new node. Set its next to point to the successor node.
            // And then make the predecessor node point to the new node
            LLnode newNode = new LLnode(data, helpPtr.getNext());
            helpPtr.setNext(newNode);
        }
        // Return head
        return head;
    }

    //
    // void | delete(int)
    //
    public void delete(int data) {
        head = delete(head, data);
    }
    //
    // LLnode | delete(LLnode, value)
    //

    private LLnode delete(LLnode head, int data) {
        // We can only delete if the list has nodes (is not empty)
        if (!isEmpty()) {
            // IF the first node (at the head) has the data value we are wanting to delete
            // we found it. Delete by skipping the node and making head point to the next node.
            if (head.getData() == data) {
                head = head.getNext();
            } // ELSE, the data is perhaps somewhere else in the list...so we must traverse and look for it
            else {
                // We need to traverse to find the data we want to delete...so we need a help ptr
                LLnode helpPtr = head;
                // Traverse to correct deletion point
                while (helpPtr.getNext() != null) {
                    if (helpPtr.getNext().getData() == data) {
                        helpPtr.setNext(helpPtr.getNext().getNext());
                        break; // we deleted the value and should break out of the while loop
                    }
                    helpPtr = helpPtr.getNext();
                }
            }
            // return the possibly updated head of the list
            return head;
        }
        return head;
    }

    public int FindLargest() {
        return FindLargest(head);
    }

    private int FindLargest(LLnode head) {
        LLnode helpPtr = head;
        int largest = head.getData();
        while (helpPtr != null) {
            if (helpPtr.getData() > largest) {
                largest = helpPtr.getData();
            }
            helpPtr = helpPtr.getNext();
        }
        return largest;
    }

    public int Data2ndLastNode() {
        return Data2ndLastNode(head);
    }

    private int Data2ndLastNode(LLnode head) {
        LLnode helpPtr = head;
        while (helpPtr.getNext().getNext() != null) {
            helpPtr = helpPtr.getNext();

        }
        return helpPtr.getData();
    }

    public int countNodes() {
        return countNodes(head);
    }

    private int countNodes(LLnode head) {
        LLnode helpPtr = head;
        int count = 0;
        while (helpPtr != null) {
            count++;
            helpPtr = helpPtr.getNext();
        }
        return count;
    }

    public void PrintEvenNodes() {
        PrintEvenNodes(head);
    }

    private void PrintEvenNodes(LLnode head) {
        LLnode helpPtr = head;
        while (helpPtr != null) {
            if (helpPtr.getData() % 2 == 0) {
                System.out.print(helpPtr.getData() + ", ");
            }
            helpPtr = helpPtr.getNext();
        }
        System.out.println();
    }

    public void swapFirstLast() {
        swapFirstLast(head);
    }

    private void swapFirstLast(LLnode head) {
        LLnode first = head;
        LLnode helpPtr = head;
        while (helpPtr.getNext() != null) {
            helpPtr = helpPtr.getNext();
        }
        int temp;
        int firsdata = first.getData();
        int lastdata = helpPtr.getData();
        temp = firsdata;
        firsdata = lastdata;
        lastdata = temp;

        first.setData(firsdata);
        helpPtr.setData(lastdata);

        System.out.println("the first and last nodes have been swaped seccesfully ");
    }

    public void deleteNodeAfter(int data) {
        deleteNodeAfter(head, data);
    }

    private void deleteNodeAfter(LLnode head, int data) {
        LLnode helpPtr = head;
        while (helpPtr != null) {
            if ((helpPtr.getNext() == null) & helpPtr.getData() == data) {
                System.out.println("No node can be deleted after this node as it is the last node in the list");
                break;
            } else if (helpPtr.getData() == data) {
                helpPtr.setNext(helpPtr.getNext().getNext());
                System.out.println("The node after " + data + " has been deleted");
                break;
            } else if ((helpPtr.getNext() == null) & helpPtr.getData() != data) {
                System.out.println("The Data does not exist in the linked list");
            }
            helpPtr = helpPtr.getNext();
        }

    }

    public void swapNodes() {
        swapNodes(head, 1);
    }

    public void swapNodes(int k) {
        swapNodes(head, k);
    }

  public static LLnode swapNodes(LLnode head, int k) {

 // Write your code here...
	LLnode countrptr = head;
	LLnode ptr = head;
	LLnode ptr2 = head;
	LLnode prev2 = null;
	LLnode prev = null;
	LLnode temp = null;
        int count = 0;
        
	for (int i = 0; countrptr != null; i++) {
		countrptr = countrptr.next;
		count++;
	}
//        if(length==0){return head;}
//else {
        for (int i = 0; i < k-1; i++) {
		prev = ptr;
		ptr = ptr.next;
	}
	for (int i = 0; i < count - k; i++) {
		prev2= ptr2;
		ptr2 = ptr2.next;
	}
	if (k > count) {
            return head;
	}
//	if (prev != null) {
//        	prev.next = ptr2;
//	} else {
//        	head = ptr2;
//	}
//	if (prev2 != null) {
//        	prev2.next = ptr;
//	} else {
//            head = ptr;
//	}
        prev.next = ptr2;
        prev2.next = ptr;
        temp = ptr.next;
	ptr.next = ptr2.next;
	ptr2.next = temp;
// }
return head;
  }
  
  
  
   public void sort()
    { sort(head);
    }
  
    public static LLnode sort(LLnode head)
    {
		
        // Write your code here...
        LLnode countrptr = head;
        int count = 0;
        for (int i = 0; countrptr != null; i++) {
            countrptr = countrptr.next;
            count++;
        }
		
        LLnode ptr =head ;
        if(ptr == null || ptr.next== null){
            return head;
        }
	for(int i =0; i<count; i++){
            if(ptr.data > ptr.next.data){
            //swapping
                ptr.next.prev = ptr.prev;
                ptr.prev = ptr.next;
                ptr.next.next = ptr;
                ptr.next = ptr.next.next;
                ptr.next.prev = ptr;                    
            }
            else if(ptr.data <ptr.next.data){
                ptr = ptr.next;
            } 
        }
    return head;
    }

    public static LLnode push(LLnode head, int key)
    {
        LLnode node = new LLnode(key);
        node.next = head;
 
        // change `prev` of the existing head node to point to the new node
        if (head != null) {
            head.prev = node;
        }
 
        // return new head node
        return node;
    }
    
}
