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
