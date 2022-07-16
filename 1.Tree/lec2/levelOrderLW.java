import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  static class LOPair {
    Node node;
    int vl;

    LOPair(Node node, int vl) {
      this.node = node;
      this.vl = vl;
    }
  }

  public static void levelOrderLineWise(Node node) {
    Queue<LOPair> qu = new LinkedList<>();
    qu.add(new LOPair(node, 1));

    int cl = 1; // current level

    while (qu.size() > 0) {
      LOPair pair = qu.remove();
      if (pair.vl > cl) {
        System.out.println(); // pair.vl > cl mtlb agr hum next level pr hn toh
        cl = pair.vl; // cl ko update krdo with pair.vl ke sth
      }
      System.out.print(pair.node.data + " "); // agr level same h toh print krdo

      // childs add kradoo ab

      if (pair.node.left != null) {
        LOPair leftPair = new LOPair(pair.node.left, pair.vl + 1);
        qu.add(leftPair);
      }
      if (pair.node.right != null) {
        LOPair rightPair = new LOPair(pair.node.right, pair.vl + 1);
        qu.add(rightPair);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    levelOrderLineWise(root);
  }

}