package Chapter4;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;


class Tuple{
    public String dependency;
    public String actualNode;
    public Tuple(String dependency,String actualNode){
        this.dependency = dependency;
        this.actualNode = actualNode;
    }
}

public class BuildOrder4_7 {

    public static HashMap<String,LinkedList<String>> buildGraph(LinkedList<String> listProjects,LinkedList<Tuple> listDependencies){

        HashMap <String, LinkedList<String>> graph = new  <String, LinkedList<String>> HashMap();

        for(String node : listProjects){
            graph.put(node,new LinkedList<String>());
        }

        for(Tuple tuple : listDependencies){
            if(!graph.get(tuple.actualNode).contains(tuple.dependency))
                graph.get(tuple.actualNode).add(tuple.dependency);
        }
        return graph;
    }

    public static LinkedList<String> buildOrder(HashMap<String,LinkedList<String>> graph){
        LinkedList<String> buildOrderQueue  = new LinkedList<String>();
        LinkedList<String> nodes = new LinkedList<String>(graph.keySet());

        int nodesSize = nodes.size();

        for(int x  = 0; x < nodesSize; x++){

            for(String node : nodes){
                if(graph.containsKey(node) && graph.get(node).size() == 0){
                    buildOrderQueue.add(node);
                    graph.remove(node);

                    for(String nodeTwo : nodes){
                        if(graph.containsKey(nodeTwo) && graph.get(nodeTwo).contains(node)){
                            graph.get(nodeTwo).remove(node);
                        }
                    }
                }
            }
        }

        if(buildOrderQueue.size() != nodes.size()){
            System.out.println("Error");
            return null;
        }

        System.out.println(buildOrderQueue);
        return buildOrderQueue;
    }

    public static void main(String args[]){
        LinkedList<String> projects = new <String> LinkedList();
        String[] projectsArray = {"a","b","c","d","e","f"};
        projects.addAll(Arrays.asList(projectsArray));

        LinkedList<Tuple> dependencies = new <Tuple> LinkedList();
        Tuple[] dependenciesArray = {new Tuple("a","d"),
                                     new Tuple("f","b"),
                                     new Tuple("b","d"),
                                     new Tuple("f","a"),
                                     new Tuple("d","c"),};

        dependencies.addAll(Arrays.asList(dependenciesArray));
        HashMap<String,LinkedList<String>> bGraph = buildGraph(projects,dependencies);
        buildOrder(bGraph);
    }
}
