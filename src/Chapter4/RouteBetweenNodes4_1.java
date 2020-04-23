package Chapter4;

import java.util.*;

public class RouteBetweenNodes4_1 {

    //Breadth First Search
    public static boolean routeBetweenNodes(HashMap <String,ArrayList<String>> graph,String nodeA,String nodeB){

        if(!graph.containsKey(nodeA)) {
            return false;
        }

        if(!graph.containsKey(nodeB)) {
            return false;
        }

        ArrayList visitedNodes = new <String> ArrayList();
        ArrayList nodesToVisit = new <String> ArrayList();

        visitedNodes.add(nodeA);
        nodesToVisit.addAll(graph.get(nodeA));

        while(nodesToVisit.size() > 0){
            String visitedNode = nodesToVisit.remove(0).toString();

            if(visitedNode == nodeB){
                return true;
            }

            if(!visitedNodes.contains(visitedNode))
                visitedNodes.add(visitedNode);

            List visitedNodesTemp = graph.get(visitedNode);

            for(Object node : visitedNodesTemp){
                String key = (String)node;
                if(!visitedNodes.contains(key)){
                    nodesToVisit.add(key);
                }
            }
        }
        return false;
    }

    public static void main(String args[]){
        HashMap graph = new <String, ArrayList<String>>HashMap();
        graph.put("a", Arrays.asList(new String[]{"c"}));
        graph.put("b", Arrays.asList(new String[]{"c","e"}));
        graph.put("c", Arrays.asList(new String[]{"a","b","d","e"}));
        graph.put("d", Arrays.asList(new String[]{"c"}));
        graph.put("e", Arrays.asList(new String[]{"c","b"}));
        graph.put("f", Arrays.asList(new String[]{}));

        System.out.println(routeBetweenNodes(graph,"z","e"));
        System.out.println(routeBetweenNodes(graph,"a","z"));
        System.out.println(routeBetweenNodes(graph,"a","e"));
        System.out.println(routeBetweenNodes(graph,"a","f"));
    }
}
