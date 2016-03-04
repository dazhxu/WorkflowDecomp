package buaa.xyz.graph2tree;

import java.util.ArrayList;
import java.util.Arrays;

public class WFGraph {
	
	private int[] vertexList; // Set of vertexes
	private int[][] adjMatrix; //Adjacency matrix
	private ArrayList<Integer[]> paths = new ArrayList<Integer[]>();
	private int sourceVertex;
	private int destVertex;
	
	/*
	 * initialize the vertex and adjacency matrix of workflow graph
	 */
	public WFGraph(int n){
		
		this.vertexList = new int[n];
		for(int i=0;i<n;i++){
			this.vertexList[i] = i;
		}
		adjMatrix = new int[n][n];
		//for(int i=0;i<n;i++){
		//	for(int j=0;j<n;j++)
		//		this.adjMatrix[i][j] = 0;
		//}
		this.sourceVertex = findSourceVertex(this.adjMatrix);
		this.destVertex = findDestVertex(this.adjMatrix);
		findAllPaths();
	}


	/*
	 * initialize workflow graph using a 1-d array and a 2-d array 
	 */
	public WFGraph(int[] vertex, int[][] matrix){
		this.vertexList = vertex;
		this.adjMatrix = matrix;
		this.sourceVertex = findSourceVertex(this.adjMatrix);
		this.destVertex = findDestVertex(this.adjMatrix);
		findAllPaths();
	}
	
	/*
	 * find the source vertex of the graph
	 */
	private int findSourceVertex(int[][] matrix) {
		// TODO Auto-generated method stub
		for(int j=0;j<matrix.length;j++){
			boolean flag = true;
			for(int i=0;i<matrix.length;i++){
				if(matrix[i][j] > 0){
					flag = false;
					break;
				}
			}
			if(flag){
				return j;
			}
		}
		return 0;
	}
	
	/*
	 * find the destination vertex of the graph
	 */
	private int findDestVertex(int[][] matrix) {
		// TODO Auto-generated method stub
		for(int i=0;i<matrix.length;i++){
			boolean flag = true;
			for(int j=0;j<matrix.length;j++){
				if(matrix[i][j] > 0){
					flag = false;
					break;
				}
			}
			if(flag){
				return i;
			}
		}
		return 0;
	}
	
	/*
	 * get the source vertex of graph
	 */
	public int getSourceVertex() {
		return this.sourceVertex;
	}
	
	/*
	 * get the destination vertex of graph
	 */
	public int getDestVertex() {
		return this.destVertex;
	}
	
	/*
	 * get the value of matrix[s][o]
	 */
	public int getValue(int s, int o){
		return this.adjMatrix[s][o];
	}
	
	/*
	 * get all paths
	 */
	public ArrayList<Integer[]> getPaths(){
		return paths;
	}
	
	/*
	 * find all paths of the graph using DFS
	 */
	public void findAllPaths(){
		ArrayList<Integer> temp1d = new ArrayList<Integer>();
		int sVertex = getSourceVertex();		
		DFS(sVertex, temp1d);		
	}
	
	/*
	 * find the path using depth-first searching
	 */
	private void DFS(int vertex, ArrayList<Integer> temp) {
		// TODO Auto-generated method stub
		temp.add(vertex);
		if(vertex == this.destVertex){
			this.paths.add(temp.toArray(new Integer[temp.size()]));
			//System.out.println(temp);
			temp.remove(temp.size()-1);
			return ;
		}
		for(int i=0;i<this.vertexList.length;i++)
		{
			if(adjMatrix[vertex][i] > 0){
				DFS(i, temp);				
			}			
		}
		temp.remove(temp.size()-1);
	}


	/*
	 * print the vertex and adjacency matrix of the workflow graph
	 */
	public void printGraph(){
		System.out.println("The vertex of workflow graph:" + Arrays.toString(this.vertexList));
		System.out.println("The adjacency matrix is: ");
		for(int i=0;i<this.vertexList.length;i++){
			System.out.println(Arrays.toString(this.adjMatrix[i]));
		}
	}
	
	/*
	 * print all paths of the graph
	 */
	public void printPaths() {
		System.out.println("The paths is :");
		for(int i=0;i<paths.size();i++){
			System.out.println(Arrays.toString(paths.get(i)));
		}
		System.out.println("Path end!");
	}
	
	public static void main(String[] args) {
		int[] vertext = new int[11];
		for(int i=0;i<vertext.length;i++){
			vertext[i] = i;
		}
		/*int[][] matrix = new int[11][11];
		for(int i=0;i<matrix.length;i++){
				for(int j=0;j<matrix.length;j++)
					matrix[i][j] = i;
		}
		*/
		
		int[][] matrix = {
				{0,1,0,0,0,0,0,0,0,0,0},
				{0,0,2,2,0,0,0,0,0,0,0},
				{0,0,0,0,0,2,2,0,0,0,0},
				{0,0,0,0,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,2,0,1,0,0},
				{0,0,0,0,0,0,0,4,0,0,0},
				{0,0,0,0,0,0,0,4,0,0,0},
				{0,0,0,0,0,0,0,0,0,4,0},
				{0,0,0,0,0,0,0,0,0,4,0},
				{0,0,0,0,0,0,0,0,0,0,1},
				{0,0,0,0,0,0,0,0,0,0,0},
		};
		
		WFGraph wfGraph = new WFGraph(vertext, matrix);
		//wfGraph.printGraph();
		System.out.println("The source vertex is " + (wfGraph.getSourceVertex()+1));
		System.out.println("The source vertex is " + (wfGraph.getDestVertex()+1));
		wfGraph.printPaths();
	}
}


