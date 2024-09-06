public class MyLinkedList {
    private Node head;
    
    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
    
    public void add(int data, int index){
        Node newNode = new Node(data);
        if(index ==0){  
            addFirst(data);
        } else {
            Node temp = head;
            for(int i = 0; i < index-1; i++){
                temp = temp.next;
            }
            Node nextNode = temp.next;
            temp.next = newNode; 
            newNode.next = nextNode;  
        }
    }
  
    public int length(){
        int i = 1;
        Node temp = head;    
        if(temp == null){
            return 0;
        } else {
            while(temp.next != null){
                temp = temp.next;
                i++;
            } 
            return i;
        }
    }
    
    public void display(int length){
        Node temp = head;
        if(length == 1){
            System.out.println(temp.getData());
        } else if(length == 0){
            System.out.println("Không còn note nào");
        } else {
            System.out.print(temp.getData() + " ");
            do{
                temp = temp.next;
                System.out.print(temp.getData() + " ");
            } while(temp.next != null);
        }
        System.out.println();
    }
    
    public void deleteFirst(){
        if(head != null){
            head = head.next;
        }
    }
    
    public void deleteLast(){
        if(head == null)
            return;
        // nếu linked list chỉ có 1 node
        if(head.next == null){
            deleteFirst();
        }
        Node temp = head; // tìm ra node cuối cùng để xóa
        Node previous = null; // ghi lại node đứng trước temp
        while(temp.next != null){
            previous = temp; // previous = 4
            temp = temp.next; //temp = 5
        }
        previous.next = null;
    }
    
    public void delete(int index){
        if(index == 0){
            deleteFirst();
            return;
        } else if(index == length()-1){
            deleteLast();
            return;
        } else {
            Node preNodeDelete = head; // tìm ra node tại vị trí index muốn xóa
            for(int i = 1; i <= index; i++){
                preNodeDelete = preNodeDelete.next;
            }
            preNodeDelete.next = preNodeDelete.next.next;
        }
    }
    
    

    public boolean search(int data){
        if(head == null){
            return false;
        }
        Node temp = head;
        /*
            temp = null: sử dụng khi muốn cầm tất cả các node trong linkedlist đen ra xử lí
                         cơ bản là sẽ chạy từ node đầu tiên đến node cuối cùng
            temp.next = null: sử dụng khi cần tìm ra node cuối cùng và gán nó vào temp
        */
        
        while(temp != null){
                if(temp.getData() == data)
                    return true;
        }
        return false;
    }
    
    
    public Node searchAtPosition(int index){
        if(index < 0|| index >= length())
            return null;
        Node temp = head;
        for(int i = 0; i< index; i++){
            temp = temp.next;
        }
        return temp;
    }


    // btvn buổi 3
    public void deleteUsingWhile(int index){
        if(index == 0){
            deleteFirst();
            return;
        } else if(index == length()-1){
            deleteLast();
            return;
        } else {
            Node temp = head;
            int count = 1;
            while(count < index -1){
                temp = temp.next;
                count++;
            }
            temp.next = temp.next.next;
        }
    }

    public void sort(int length) {
        if (head == null || head.next == null) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            Node current = head;  
            Node prev = null;     
            for (int j = 0; j < length - i - 1; j++) {
                Node next = current.next;
                if (current.getData() > next.getData()) {
                    if (prev == null) {   
                        head = next;
                    } else {
                        prev.next = next;
                    }
                    current.next = next.next;
                    next.next = current;
                    prev = next; // hoán đổi xong next sẽ nằm trước current -> prev = next
                } else {
                    prev = current;
                    current = next;
                }
            }
        }
    }
    

    public static void main(String[] args) {
        MyLinkedList LinkedList = new MyLinkedList();
        LinkedList.addFirst(1);
        LinkedList.addFirst(2);
        LinkedList.addFirst(3);
        LinkedList.addLast(5);
        LinkedList.addLast(6);
        LinkedList.addLast(7);
        
        System.out.println("Chiều dài node:");
        System.out.println(LinkedList.length());
        System.out.println("Hiển thị node:");
        LinkedList.display(LinkedList.length());
        
        LinkedList.deleteFirst();
        System.out.println("----TEST DELETE----");//
        System.out.println("Chiều dài node:");
        System.out.println(LinkedList.length());
        System.out.println("Hiển thị node:");
        LinkedList.display(LinkedList.length());

        System.out.println("----TEST DELETE POSITION----");
        LinkedList.deleteUsingWhile(3);
        LinkedList.display(LinkedList.length());

        System.out.println("----TEST SORT----");
        LinkedList.sort(LinkedList.length());
        LinkedList.display(LinkedList.length());
    }
}