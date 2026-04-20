public class LLnode {
     int data;
     LLnode next;
     LLnode prev;
    
    // CONSTRUCTORS
    public LLnode() {
        data = 0;
        next = null;
        prev = null;
    }
    
    public LLnode(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
    
    public LLnode(int data, LLnode next) {
        this.data = data;
        this.next = next;
    }
    
    LLnode(int data, LLnode prev, LLnode next) { this.data = data; this.prev = prev; this.next = next; }

    // ACCESSORS
    public int getData() {
        return data;
    }

    public LLnode getNext() {
        return next;
    }

    // MUTATORS
    public void setData(int data) {
        this.data = data;
    }

    public void setNext(LLnode next) {
        this.next = next;
    }
}
