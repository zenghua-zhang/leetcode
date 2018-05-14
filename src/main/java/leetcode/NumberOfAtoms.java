package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class NumberOfAtoms {

  public String countOfAtoms(String formula) {
    Node root = new Node();
    LinkedList<Node> stack = new LinkedList<>();
    stack.push(root);

    Queue<Character> chars = new LinkedList<>();
    for (char c : formula.toCharArray()) {
      chars.add(c);
    }

    parse(chars, stack);

    return parseMap(stack.pop());
  }

  protected void parse(Queue<Character> queue, LinkedList<Node> stack) {
    while (!queue.isEmpty()) {
      if (queue.peek() != '(') {
        boolean shouldPop = addNodesToParent(stack.peek(), queue);
        if (shouldPop) {
          int mult = getDigit(queue);
          stack.pop().setMult(mult);
        }
      } else {
        queue.poll();
        Node node = new Node();
        stack.peek().addChild(node);
        stack.push(node);
        parse(queue, stack);
      }
    }


  }

  protected boolean addNodesToParent(Node parent, Queue<Character> queue) {
    while (!queue.isEmpty() && queue.peek() != '(') {
      if (queue.peek() == ')') {
        queue.poll();
        return true;
      }
      String atom = getAtom(queue);
      Integer mult = getDigit(queue);
      parent.addChild(new Node(atom, mult));
    }

    return false;
  }

  protected String getAtom(Queue<Character> queue) {
    StringBuilder sb = new StringBuilder();
    if (!Character.isUpperCase(queue.peek())) {
      return "";
    }
    sb.append(queue.poll());
    while (!queue.isEmpty()) {
      char c = queue.peek();
      if (!Character.isLowerCase(c)) {
        break;
      }
      sb.append(c);
      queue.poll();
    }

    return sb.toString();
  }


  protected Integer getDigit(Queue<Character> queue) {
    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
      char c = queue.peek();
      if (!Character.isDigit(c)) {
        break;
      }
      sb.append(c);
      queue.poll();
    }
    try {
      return Integer.valueOf(sb.toString());
    } catch (NumberFormatException e) {
      return 1;
    }
  }

  protected String parseMap(Node node) {
    Map<String, Integer> map = node.getAtoms();
    List<String> keys = new ArrayList<>(map.keySet());
    Collections.sort(keys);
    StringBuilder sb = new StringBuilder();
    for (String key : keys) {
      sb.append(key);
      if (map.get(key) > 1) {
        sb.append(map.get(key));
      }
    }

    return sb.toString();
  }


  class Node {

    private String atom;

    private Integer mult;

    private List<Node> children;

    Node() {
      this("");
    }

    Node(String atom) {
      this(atom, 1);
    }

    Node(String atom, Integer mult) {
      this.atom = atom;
      this.mult = mult;
    }

    void setMult(Integer mult) {
      this.mult = mult;
    }

    void addChild(Node node) {
      if (children == null) {
        children = new ArrayList<>();
      }
      children.add(node);
    }

    private Map<String, Integer> getAtoms() {
      Map<String, Integer> map = new HashMap<>();
      if (!atom.equals("")) {
        map.put(atom, mult);
        return map;
      }
      if (children == null) {
        return map;
      }
      for (Node node : children) {
        Map<String, Integer> sub = node.getAtoms();
        for (Map.Entry<String, Integer> entry : sub.entrySet()) {
          String key = entry.getKey();
          Integer value = entry.getValue() * mult;
          if (map.containsKey(key)) {
            value += map.get(key);
          }
          map.put(key, value);
        }
      }
      return map;
    }
  }
}
