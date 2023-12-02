import java.util.LinkedList;
import java.util.Queue;

public class GraphLL {
    int numberV;
    LinkedList<Integer> list[];


    public GraphLL(int v) {
        numberV = v;
        list = new LinkedList[v];
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList();
        }
    }

    public void addEdge(int v1, int v2) {
        list[v1].add(v2);
        list[v2].add(v1);
    }

    public void removeEdge(int v1, int v2) {
        for (int i = 0; i < list[v1].size(); i++) {
            if (list[v1].get(i) == v2) {
                list[v1].remove(i);
            }
        }
        for (int i = 0; i < list[v2].size(); i++) {
            if (list[v2].get(i) == v1) {
                list[v2].remove(i);
            }
        }
    }

    public void findAdj(int v) {
        System.out.println(v + " : ");
        for (int i = 0; i < list[i].size(); i++) {
            System.out.print(list[v].get(i));
        }
    }
    public void print(){
        System.out.println("Graph:");
        for (int i = 0; i < list.length; i++) {
            System.out.println(i+" ");
            for (int j = 0; j < list[i].size(); j++) {
                System.out.print(list[i].get(j)+" ");
            }
            System.out.println();
        }
    }
    public void BFS(int s){
        boolean visited[]=new boolean[numberV];
        Queue<Integer> queue=new LinkedList<>();
        visited[s]=true;
        queue.add(s);
        int tmp;
        while (queue.size()!=0){
            s=queue.poll();
            System.out.println(s+" ");
            for (int i = 0; i < list[s].size(); i++) {
                tmp=list[s].get(i);
                if (!visited[tmp]){
                    visited[tmp]=true;
                    queue.add(tmp);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphLL g1=new GraphLL(6);
        g1.addEdge(0,2);
        g1.addEdge(0,3);
        g1.addEdge(0,5);
        g1.addEdge(1,5);
        g1.addEdge(2,3);
        g1.addEdge(3,4);
        g1.BFS(3);
    }
}
