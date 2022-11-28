package demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ListIterator;
import java.util.Random;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class PerformanceComparator {

	private ArrayList array;

	private LinkedList linkedList;

	private Random random = new Random();

	private long beginTime;

	private long endTime;

	public PerformanceComparator() {}

	public void stage3(int n, int target) {
		array = new ArrayList();
		fillCollection(array, n);
		array = new ArrayList(new HashSet(array));

		Set set = new HashSet();
		beginTime = System.currentTimeMillis();
		twoSum(array, set, target);
		endTime = System.currentTimeMillis();
		printTime("HashSet", endTime - beginTime);

		List arrayList = new ArrayList();
		beginTime = System.currentTimeMillis();
		twoSum(array, arrayList, target);
		endTime = System.currentTimeMillis();
		printTime("ArrayList", endTime - beginTime);
	}

	private void twoSum(ArrayList array, Collection collection, int target) {
		int con = 0;

		for (int i = 0; i < array.size(); i++) {
			int complement = target - (int) array.get(i);
			if (collection.contains(complement)) { // Key line O(1) for Set and O(n) for Array.
				con++;
			}
			collection.add(array.get(i));
		}
		System.out.println("Two sums founded: " + con);
	}

	public void stage25(int n, int k) {
		array = new ArrayList();
		linkedList = new LinkedList();

		beginTime = System.currentTimeMillis();
		apply25(array, n, k);
		endTime = System.currentTimeMillis();
		printTime("Array", endTime - beginTime);

		beginTime = System.currentTimeMillis();
		apply25(linkedList, n, k);
		endTime = System.currentTimeMillis();
		printTime("LinkedList", endTime - beginTime);
	}

	private void apply25(List list, int n, int k) {
		fillCollection(list, n);

		ListIterator iterator = list.listIterator();
		while (iterator.hasNext()) {
			int element = (int) iterator.next();
			if (k > 0 && element % 2 == 0) {
				iterator.remove();
				k--;
			}
		}
	}

	public void stage2(int n, int k) {
		array = new ArrayList();
		linkedList = new LinkedList();

		beginTime = System.currentTimeMillis();
		apply2(array, n, k);
		endTime = System.currentTimeMillis();
		printTime("Array", endTime - beginTime);

		beginTime = System.currentTimeMillis();
		apply2(linkedList, n, k);
		endTime = System.currentTimeMillis();
		printTime("LinkedList", endTime - beginTime);
	}

	private void apply2(List list, int n, int k) {
		fillCollection(list, n);
		simulateAccessInList(list, k / 5);
		simulateInsertInList(list, k / 2);
		simulateDeleteInList(list, k / 2);
	}

	public void stage1(int n, int k) {
		array = new ArrayList();
		linkedList = new LinkedList();

		beginTime = System.currentTimeMillis();
		apply1(array, n, k);
		endTime = System.currentTimeMillis();
		printTime("Array", endTime - beginTime);

		beginTime = System.currentTimeMillis();
		apply1(linkedList, n, k);
		endTime = System.currentTimeMillis();
		printTime("LinkedList", endTime - beginTime);
	}

	private void apply1(List list, int n, int k) {
		fillCollection(list, n);
		simulateAccessInList(list, k);
		simulateInsertInList(list, k / 10);
		simulateDeleteInList(list, k / 10);
	}

	private void print(Object object) throws JsonProcessingException {
		String prettyObject;
		try {
			ObjectMapper mapper = new ObjectMapper();
			prettyObject = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
		}
		catch (JsonProcessingException e) {
			prettyObject = object.toString();
		}
		System.out.println(prettyObject);
	}

	private void printTime(String name, long time) {
		System.out.println(name + " performance.");
		long minutes = time / 60000;
		long seconds = time % 60000 / 1000;
		long milliseconds = time % 1000;
		System.out.println("    Time: " + String.valueOf(minutes) + "m. " + String.valueOf(seconds) + "s. " +
				String.valueOf(milliseconds) + "ms.");
	}

	private void fillCollection(Collection collection, int n) {
		for (int i = 0; i < n; i++) {
			collection.add(random.nextInt(n));
		}
	}

	private void simulateAccessInList(List list, int k) {
		Random random = new Random();
		int n = list.size();
		for (int i = 0; i < k; i++) {
			list.get(random.nextInt(n));
		}
	}

	private void simulateInsertInList(List list, int k) {
		Random random = new Random();
		int n = list.size();
		int dummyElement = 1;
		for (int i = 0; i < k; i++) {
			list.add(random.nextInt(n), dummyElement);
		}
	}

	private void simulateDeleteInList(List list, int k) {
		Random random = new Random();
		int n = list.size();
		for (int i = 0; i < k; i++) {
			list.remove(random.nextInt(n));
			n--;
		}
	}

}
