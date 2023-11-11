import java.util.*;

class NewNode{
int data  ;
NewNode right , left;
NewNode(int b){
    data=b;
    right=null;
    left=null;
}
}




class buildtree{

//level wise traversing 
public void levelorder(){

    if(root==null){
        return ;
    }
    Queue<NewNode> q = new LinkedList<>();
    q.add(root);
    q.add(null);
System.out.println("printint in level wise order ");
    while(!q.isEmpty()){
    NewNode current=q.remove();
    if(current==null){
        System.out.println();
        if(q.isEmpty()){
            break;
        }
        else{
            q.add(null);;
        }
    }
    else{
        System.out.print("   "+current.data);
        if(current.left!=null){
            q.add(current.left);
        }
        if(current.right!=null){
      q.add(current.right);
        }
    }
    }


}




//adding neeew nodes or building a tree
 NewNode root=null;
    NewNode addnode(NewNode root,int value ){
        if(root==null){
         System.out.println("added as an rooot");    
            return new NewNode(value );
        }
        if(root.data<value ){
           System.out.println(" added as an right");
            root.right=addnode(root.right, value);
        }
        if(root.data>value ){
            System.out.println("added inn left");
            root.left=addnode(root.left, value);
        }
        return root;
    }
    public void add(int value) {

        root = addnode(root, value);
  
    }


//printing tree


void printtree(NewNode root){
    if(root== null){
        return;
    }
    else{
        System.out.println(root.data);
        printtree(root.left);
    printtree(root.right);
    }
}
void p(){
    printtree(root);
}





//searching an element in tree



public void s(int value){
    System.out.println(searching(root,value));
}
boolean searching(NewNode root,int value ){
    if(root ==null){
        return false;
    }
    if(root.data==value){
        return true;
    }
    if(value>root.data){
        return searching(root.right, value);
    }

    
    if(value<root.data){
        return searching(root.left, value);
    }
    return false;
}


//counting the nodes 
public int countnodes(NewNode root){
    if(root==null){
        return 0;
    }
    int l=countnodes(root.left);
    int r=countnodes(root.right);
    return l+r+1;
}
void c(){
    System.out.println("number of nodes "+countnodes(root));
}


    public static void main(String [] args ){
    buildtree a = new buildtree();
    a.add(5);        
    a.add(4);
    a.add(3);
    a.add(9);
    a.add(8);
    a.add(10);

    a.p();
//a.s(89);
a.c();
a.levelorder();

    }
}