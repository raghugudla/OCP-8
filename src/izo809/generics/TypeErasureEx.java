package izo809.generics;

public class TypeErasureEx {

    public static void main(String[] args) {
        MyNode mn = new MyNode(5);
        Node n = mn;            // A raw type - compiler throws an unchecked warning
        n.setData("Hello");
        Integer x = mn.data;
    }

    public static class Node<T> {

        public T data;

        public Node(T data) {
            this.data = data;
        }

        public void setData(T data) {
            System.out.println("Node.setData");
            this.data = data;
        }
    }

    public static class MyNode extends Node<Integer> {
        public MyNode(Integer data) {
            super(data);
        }

        public void setData(Integer data) {
            System.out.println("MyNode.setData");
            super.setData(data);
        }
    }
}
