package buaa.xyz.graph2tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreeNode implements Serializable {
	private int parentId;
	private int selfId;
	private int comType;
	protected String nodeName;
	protected TreeNode parentNode;
	protected List<TreeNode> childList;
	
	public TreeNode(){
		//TODO
		initChildList();
	}
	
	public TreeNode(int id){
		//TODO
		this.selfId = id;
		initChildList();
	}
	
	public TreeNode(TreeNode parentNode){
		//TODO
		this.parentNode = parentNode;
		initChildList();
	}

	
	/*
	 * initialize childlist
	 */
	public void initChildList(){
		//TODO
		if(childList == null){
			childList = new ArrayList<TreeNode>();
		}
	}
	
	/*
	 * if this node is a leaf node, return true
	 * else return false
	 */
	public boolean isLeaf(){
		//TODO
		
		if(childList == null){
			return true;
		} else {
			if(childList.isEmpty()){
				return true;
			} else {
				return false;
			}
		}
	}
	
	public void deleteNode() {
		//TODO
		TreeNode parentNode = this.getParentNode();
		int id = this.getSelfId();
		
		
	}
	
	public void addChildNode(TreeNode node){
		//TODO
	}
	
	public void deleteChildNode(int childId){
		//TODO
	}
	
	public List<TreeNode> getChildList(){
		//TODO
		return childList;
	}
	

	public void setChildList(List<TreeNode> childList) {  
		this.childList = childList;  
	}  


	
	public List<TreeNode> getElders() {
		//TODO
		return childList;
	}
	 
	public List<TreeNode> getJuniors() {		
		//TODO
		return childList;
	}
	
	public boolean insertJuniorNode(TreeNode treeNode){
		//TODO
		return true;
	}
	
	public TreeNode findTreeNodeById(int id){
		//TODO
		return null;
	}
	
	//traverse a tree by level
	public void traverse(){
		//TODO
	}
	
	public int getSelfId(){
		return selfId;
	}
	
	public void setSelfId(int selfId){
		this.selfId = selfId;
	}
	
	public int getPatentId(){
		return parentId;
	}
	
	public void setParentId(int patentId){
		this.parentId = patentId;
	}
	
	public TreeNode getParentNode(){
		return parentNode;
	}
	
	public void setParentNode(TreeNode parentNode){
		this.parentNode = parentNode;
	}
	
	public String getNodeName(){
		return nodeName;
	}
	
	public void setNodeName(String nodeName){
		this.nodeName = nodeName;
	}
	
	public int getComType(){
		return comType;
	}
	
	public void setComType(int comType){
		this.comType = comType;
	}
	
}
