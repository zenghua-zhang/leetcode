package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParsingABooleanExpression {

  public static void main(String[] args) {
    ParsingABooleanExpression test = new ParsingABooleanExpression();
    test.parseBoolExpr("|(&(t,f,t),!(t))");
  }

  public boolean parseBoolExpr(String expression) {

    if (expression.length() == 1) {
      return expression.charAt(0) == 't';
    }

    LinkedList<BooleanGroup> groups = new LinkedList<>();
    groups.push(new BooleanGroup('e'));

    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);
      if (c == '(' || c == ',') {
        continue;
      }

      if (c == '&' || c == '|' || c == '!') {
        BooleanGroup group = new BooleanGroup(c);
        groups.push(group);
      }

      if (c == 't' || c == 'f') {
        BooleanNode node = new BooleanNode(c);
        groups.peek().children.add(node);
      }

      if (c == ')') {
        BooleanGroup group = groups.pop();
        groups.peek().children.add(group);
      }
    }

    return traverse(groups.peek().children.get(0));
  }

  private boolean traverse(BooleanExp exp) {
    if (BooleanNode.class.isAssignableFrom(exp.getClass())) {
      BooleanNode node = (BooleanNode) exp;
      return node.v;
    }

    BooleanGroup group = (BooleanGroup) exp;
    if (group.type == ExpType.And) {
      return group.children.stream().allMatch(this::traverse);
    }
    if (group.type == ExpType.Or) {
      return group.children.stream().anyMatch(this::traverse);
    }

    return !traverse(group.children.get(0));
  }


  private class BooleanNode implements BooleanExp {

    private final boolean v;

    private BooleanNode(char c) {
      v = c == 't';
    }
  }

  private class BooleanGroup implements BooleanExp {

    private final ExpType type;

    private List<BooleanExp> children;

    public BooleanGroup(char c) {
      if (c == '&') {
        this.type = ExpType.And;
      } else if (c == '|') {
        this.type = ExpType.Or;
      } else if (c == '!') {
        this.type = ExpType.Not;
      } else {
        this.type = ExpType.Empty;
      }
      this.children = new ArrayList<>();
    }
  }

  private enum ExpType {
    And, Or, Not, Empty
  }

  private interface BooleanExp {

  }


}
