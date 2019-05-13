public class ListNode {
	private String data;
	private ListNode link;
	public ListNode (){
		link = null;
		data = null;
	}
	public ListNode (String newData, ListNode linkValue){
		data = newData;
		link = linkValue;
	}
	public void setData (String newData) {
		data = newData;
	}
	public String getData () {
		return data;
	}
	public void setLink (ListNode newLink) {
		link = newLink;
	}
	public ListNode getLink () {
		return link;
	}
}

public class StringLinkedList{
	private ListNode head;
	public StringLinkedList(){
		head = null;
	}

	public void showList(){
		ListNode position = head;
		while (position != null){
			System.out.println(position.getData());
			position = position.getLink();
		}
	}

	public int length(){
		int count = 0;
		ListNode position = head;
		while (position != null){
			count++;
			position = position.getLink();
		}
		return count;
	}

	public void addANodeToStart(String addData){
		head = new ListNode(addData, head);
	}

	public void deleteHeadNode(){
		if(head != null)
			head = head.getLink();
		else{
			System.out.println("Deleting from an empty list.");
			System.exit(0);
		}
	}

	public boolean onList(String target){
		return find(target) != null;
	}

	private ListNode find(String target){
		boolean found = false;
		ListNode position = head;
		while ((position != null) && !found){
			String dataAtPosition =
			position.getData();
			if (dataAtPosition.equals(target))
			found = true; else
			position = position.getLink();
		}
		return position;
	}
}


public class Main {
	public static void main(String[] args) {
		StringLinkedList list = new StringLinkedList (); list.addANodeToStart ("One"); list.addANodeToStart ("Two"); list.addANodeToStart ("Three");
		System.out.println ("List has " + list.length () + " entries.");
		list.showList ();
		if (list.onList ("Three"))
			System.out.println ("Three is on list.");
		else
			System.out.println ("Three is NOT on list.");

		list.deleteHeadNode (); // Deleting Three
		if (list.onList ("Three"))
			System.out.println ("Three is on list.");
		else
			System.out.println ("Three is NOT on list.");

		list.deleteHeadNode (); // Deleting Two
		list.deleteHeadNode (); // Deleting One
		System.out.println ("Start of list:");
		list.showList ();
		System.out.println ("End of list.");
	}
}
