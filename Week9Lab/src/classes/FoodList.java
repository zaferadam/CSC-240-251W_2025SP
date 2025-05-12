package classes;

public class FoodList {

	private FoodNode firstNode;
	private int length;

	public FoodList() {
		firstNode = null;
	}

	public boolean isInList(Food findFood) {
		if (findFood == null) {
			return false;
		}
		String result = findFoodName(findFood.getName()).getName();
		return result.equals(findFood.getName());
	}
	
	public Food findFoodName(String name) {
		FoodNode search = firstNode;
		// Find the node with a matching name
		while (search != null && !search.food.getName().equalsIgnoreCase(name)) {
			search = search.next;
		}
		if (search==null) {
			return null;
		}
		return search.food;
	}
	
	public Food findFoodIndex(int index) {
		FoodNode current = firstNode;
		while (current != null && current.getIndex() != index) {
			current = current.next;
		}
		if (current == null) {
			return null;
		}
		return current.food;
	}

	public void add(Food food) {
		FoodNode node = new FoodNode(food);
		FoodNode current;

		if (firstNode == null) {
			firstNode = node;
			firstNode.setIndex(0);
		} else {
			current = firstNode;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
			node.prev = current;
			node.setIndex(current.getIndex()+1);
		}
		length++;
	}

	public void remove(Food removeFood) {
		FoodNode search = firstNode;
		String removeName = removeFood.getName();

		// Find the node with a matching name
		while (search != null && !search.food.getName().equalsIgnoreCase(removeName)) {
			search = search.next;
		}

		if (search == null) {
			return; // Not found
		}

		// Unlink the node
		if (search.prev != null) {
			search.prev.next = search.next;
		} else {
			// Removing the head node
			firstNode = search.next;
		}

		if (search.next != null) {
			search.next.prev = search.prev;
		}

		length--;

		// Reindex all nodes starting from the removed node's next
		FoodNode current = (search.next != null) ? search.next : null;
		while (current != null) {
			current.setIndex(current.getIndex() - 1);
			current = current.next;
		}
	}
	
	public void removeByIndex(int index) {
		if (index < 0 || index >= length) return;

		FoodNode current = firstNode;
		while (current != null && current.getIndex() != index) {
			current = current.next;
		}

		if (current != null) {
			remove(current.food);
		}
	}



	@Override
	public String toString() {
		String output = "";
		FoodNode current = firstNode;
		while (current != null) {
			output += current.food + "\n";
			current = current.next;
		}
		return output;
	}
	
	public int length() {
		return length;
	}

	private class FoodNode {

		public Food food;
		public FoodNode next, prev;
		public int index;

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public FoodNode(Food food) {
			this.food = food;
			next = null;
			prev = null;
		}
		
		

	}
}
