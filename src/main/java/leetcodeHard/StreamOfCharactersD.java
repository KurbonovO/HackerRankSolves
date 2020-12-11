package leetcodeHard;

import java.util.LinkedList;
import java.util.Queue;

import java.util.LinkedList;
import java.util.Queue;

import java.util.LinkedList;
import java.util.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class StreamOfCharactersD {

	class Node {
		Node[] next = new Node[26];
		boolean ending;
		Node fail;
		String data;
	}

	Node root = new Node();

	void add(String str) {
		Node cur = root;
		for (int i = 0; i < str.length(); i++) {
			int c = str.charAt(i) - 'a';
			if (cur.next[c] == null)
				cur.next[c] = new Node();
			cur = cur.next[c];
		}
		cur.ending = true;
		cur.data = str;
	}

	void build() {
		Queue<Node> queue = new LinkedList();
		for (int i = 0; i < 26; i++) {
			if (root.next[i] != null) {
				queue.offer(root.next[i]);
				root.next[i].fail = root;
			}
		}
		while (queue.size() > 0) {
			Node p = queue.poll();
			for (int i = 0; i < 26; i++) {
				if (p.next[i] != null) {
					Node pc = p.next[i];// p's child
					Node q = p.fail;
					while (q != null) {
						Node qc = q.next[i];// q's child
						if (qc != null) {
							pc.fail = qc;
							break;
						} else {
							q = q.fail;
						}
					}
					if (pc.fail == null) {
						pc.fail = root;
					}
					queue.offer(pc);
				}
			}
		}
	}

	public void StreamChecker(String[] words) {
        for (String word : words) {
            add(word);
        }
        build();
    }

	Node p = root;

	public boolean query(char letter) {
		int c = letter - 'a';
		while (p.next[c] == null && p != root) {
			p = p.fail;
		}
		p = p.next[c];
		if (p == null)
			p = root;
		Node tmp = p;
		while (tmp != root) {
			if (tmp.ending) {
				return true;
			}
			tmp = tmp.fail;
		}
		return false;
	}

}
